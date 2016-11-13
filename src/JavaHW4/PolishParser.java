package JavaHW4;

import java.util.Stack;

/**
 * Created by vrom911 on 11/13/16.
 */
class PolishParser {
    private String originalExp;
    private Token curToken = new Token(TokenType.EPS, "$");
    private int curPos;

    PolishParser(String exp) {
        originalExp = "(" + exp + ")";
        curPos = 0;
    }

    TripleOperation parse() throws WrongExpressionException {
        TripleOperation result = null;
        Stack<Token> polishExp = makePolish();
        Stack<TripleOperation> resStack = new Stack<>();
        System.out.println(polishExp);
        for (Token t : polishExp) {
            if (!(t.token == TokenType.CONST || t.token == TokenType.VAR)) {
                TripleOperation right = resStack.pop();
                if (t.token == TokenType.UNARY_MINUS) {
                    result = new UnaryMinus(right);
                } else if (t.token == TokenType.UNARY_FUNC) {
                    if (t.value.equals("abs")) {
                        result = new Abs(right);
                    } else if (t.value.equals("sqrt")) {
                        result = new Sqrt(right);
                    }
                } else {
                    TripleOperation left = resStack.pop();
                    switch (t.token) {
                        case PLUS:
                            result = new Add(left, right);
                            break;
                        case MINUS:
                            result = new Subtract(left, right);
                            break;
                        case MULT:
                            result = new Multiply(left, right);
                            break;
                        case DIV:
                            result = new Divide(left, right);
                            break;
                        case POW:
                            result = new Power(left, right);
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
                if (!Character.isLetterOrDigit(originalExp.charAt(curPos))) {
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
                } else if (isDigit(val)) {
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

    private TripleOperation makeConstOrVar(Token t) {
        return (t.token == TokenType.CONST) ?
                new Const(Integer.parseInt(t.value)) :
                new Variable(t.value);
    }
    private static boolean isDigit(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
