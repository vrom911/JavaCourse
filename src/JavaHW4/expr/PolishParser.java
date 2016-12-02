package JavaHW4.expr;

import JavaHW4.exceptions.MissingBraceException;
import JavaHW4.exceptions.WrongExpressionException;

import java.util.Stack;

public class PolishParser<T extends Number> {
    private String originalExp;
    private Token curToken = new Token(TokenType.EPS, "$");
    private int curPos;
    private OperationFabric<T> creator;

    public PolishParser(String exp, OperationFabric<T> creator) {
        this.originalExp = "(" + exp + ")";
        this.curPos = 0;
        this.creator = creator;
    }

    public TripleOperation<T> parse() throws WrongExpressionException {
        TripleOperation<T> result = null;
        Stack<Token> polishExp = makePolish();
        Stack<TripleOperation<T>> resStack = new Stack<>();
        System.out.println(polishExp);
        for (Token t : polishExp) {
            if (!(t.token == TokenType.CONST || t.token == TokenType.VAR)) {
                TripleOperation<T> right = resStack.pop();
                if (t.token == TokenType.UNARY_MINUS) {
                    result = creator.createdUnaryMinus(right);
                } else if (t.token == TokenType.UNARY_FUNC) {
                    if (t.value.equals("abs")) {
                        result = creator.createdAbs(right);
                    } else if (t.value.equals("sqrt")) {
                        result = creator.createdSqrt(right);
                    }
                } else {
                    TripleOperation<T> left = resStack.pop();
                    switch (t.token) {
                        case PLUS:
                            result = creator.createdAdd(left, right);
                            break;
                        case MINUS:
                            result = creator.createdSubtract(left, right);
                            break;
                        case MULT:
                            result = creator.createdMultiply(left, right);
                            break;
                        case DIV:
                            result = creator.createdDivide(left, right);
                            break;
                        case POW:
                            result = creator.createdPower(left, right);
                            break;
                    }
                }
                resStack.push(result);
            } else {
                resStack.push(makeConstOrVar(t));
            }

        }
        return resStack.pop();
    }

    private Stack<Token> makePolish() {
        Stack<Token> output = new Stack<>();
        Stack<Token> operators = new Stack<>();
        curToken = getToken();
        while (curToken.token != TokenType.EPS) {
            if (curToken.token == TokenType.CONST || curToken.token == TokenType.VAR) {
                output.push(curToken);
            } else if (curToken.token == TokenType.PLUS || curToken.token == TokenType.MINUS
                    || curToken.token == TokenType.MULT || curToken.token == TokenType.DIV
                    || curToken.token == TokenType.POW || curToken.token == TokenType.UNARY_MINUS
                    || curToken.token == TokenType.UNARY_FUNC) {
                if(!operators.isEmpty()) {
                    if (operators.peek().priority >= curToken.priority ) {
                        operators.push(curToken);
                    } else {

                        Token t = operators.peek();
                        while (t.token != TokenType.OPEN_BR) {
                            output.push(t);
                            operators.pop();
                            t = operators.peek();
                        }
                        operators.push(curToken);
                    }
                } else {
                    operators.push(curToken);
                }
            } else if (curToken.token == TokenType.OPEN_BR) {
                operators.push(curToken);
            } else if (curToken.token == TokenType.CLOSE_BR) {
                if (!operators.isEmpty()) {
                    Token t = operators.pop();
                    while (t.token != TokenType.OPEN_BR) {
                        output.push(t);
                        if (!operators.isEmpty()) {
                            t = operators.pop();
                        } else {
                             throw new MissingBraceException();
                        }
                    }
                } else {
                    throw new MissingBraceException();
                }
            }
            curToken = getToken();
        }
        while (!operators.isEmpty()) {
            Token p = operators.pop();
            if (p.token != TokenType.OPEN_BR) {
                output.push(operators.pop());
            } else {
                throw new WrongExpressionException();
            }

        }
        return output;
    }

    private Token getToken() {
        Token prevToken = curToken;
        if (curPos < originalExp.length()) {
            if ( Character.isSpaceChar(originalExp.charAt(curPos))) {
                curPos++;
                return getToken();
            }

            int beginPos = curPos;
            // figure out if it's number | var | func
            while (curPos < originalExp.length()) {
                if (!(Character.isLetterOrDigit(originalExp.charAt(curPos)) || originalExp.charAt(curPos) == '.')) {
                    break;
                }
                curPos++;
            }
            //that means we have the number
            if (curPos > beginPos) {
                String val = originalExp.substring(beginPos, curPos);
                if (val.equals("x") || val.equals("y") || val.equals("z")) {
                    curToken = new Token(TokenType.VAR, val);
                } else if (val.equals("abs") || val.equals("sqrt")) {
                    curToken = new Token(TokenType.UNARY_FUNC, val);
                } else if (isNumber(val)) {
                    curToken = new Token(TokenType.CONST, originalExp.substring(beginPos, curPos));
                } else {
                    throw new WrongExpressionException();
                }
            } else {
                TokenType curOper;
                switch (originalExp.charAt(curPos)) {
                    case '+':
                        curOper = TokenType.PLUS;
                        break;
                    case '-':
                        if (prevToken.token == TokenType.CLOSE_BR ||
                                prevToken.token == TokenType.VAR ||
                                prevToken.token == TokenType.CONST) {
                            curOper = TokenType.MINUS;
                        } else {
                            curOper = TokenType.UNARY_MINUS;
                        }
                        break;
                    case '*':
                        curOper = TokenType.MULT;
                        break;
                    case '/':
                        curOper = TokenType.DIV;
                        break;
                    case '(':
                        curOper = TokenType.OPEN_BR;
                        break;
                    case ')':
                        curOper = TokenType.CLOSE_BR;
                        break;
                    case '^':
                        curOper = TokenType.POW;
                        break;
                    default:
                        curOper = TokenType.EPS;
                        break;
                }
                curToken = new Token(curOper, Character.toString(originalExp.charAt(curPos)));
                curPos++;
            }
            return curToken;
        }
        return new Token(TokenType.EPS, "$");
    }

    private TripleOperation<T> makeConstOrVar(Token t) {
        return (t.token == TokenType.CONST) ?
                creator.createdConst(t.value) :
                creator.createdVariable(t.value);
    }

    private static boolean isNumber(String s) {
//        Pattern p = Pattern.compile("\\d+(\\.\\d+)?");
        return s.matches("\\d+(\\.\\d+)?");
//        for (char c : s.toCharArray()) {
//            if (!(Character.isDigit(c) || c == '.')) {
//                return false;
//            }
//        }
//        return true;
    }
}
