package JavaHW4;

import java.util.Stack;

/**
 * Created by vrom911 on 11/13/16.
 */
class PolishParser {
    private String originalExp;
    private Token curToken = new Token(Token.EPS, "$");
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
            if (!(t.token == Token.CONST || t.token == Token.VAR)) {
                TripleOperation right = resStack.pop();
                if (t.token == Token.UNARY_MINUS) {
                    result = new UnaryMinus(right);
                } else if (t.token == Token.UNARY_FUNC) {
                    if (t.value.equals("abs")) {
                        result = new Abs(right);
                    } else if (t.value.equals("sqrt")) {
                        result = new Sqrt(right);
                    }
                } else {
                    TripleOperation left = resStack.pop();
                    switch (t.token) {
                        case Token.PLUS:
                            result = new Add(left, right);
                            break;
                        case Token.MINUS:
                            result = new Subtract(left, right);
                            break;
                        case Token.MULT:
                            result = new Multiply(left, right);
                            break;
                        case Token.DIV:
                            result = new Divide(left, right);
                            break;
                        case Token.POW:
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
        while (curToken.token != Token.EPS) {
            if (curToken.token == Token.CONST || curToken.token == Token.VAR) {
                output.push(curToken);
            } else if (curToken.token == Token.PLUS || curToken.token == Token.MINUS
                    || curToken.token == Token.MULT || curToken.token == Token.DIV
                    || curToken.token == Token.POW || curToken.token == Token.UNARY_MINUS
                    || curToken.token == Token.UNARY_FUNC) {
                if(!operators.isEmpty()) {
                    if (operators.peek().priority >= curToken.priority ) {
                        operators.push(curToken);
                    } else {

                        Token t = operators.peek();
                        while (t.token != Token.OPEN_BR) {
                            output.push(t);
                            operators.pop();
                            t = operators.peek();
                        }
                        operators.push(curToken);
                    }
                } else {
                    operators.push(curToken);
                }
            } else if (curToken.token == Token.OPEN_BR) {
                operators.push(curToken);
            } else if (curToken.token == Token.CLOSE_BR) {
                if (!operators.isEmpty()) {
                    Token t = operators.pop();
                    while (t.token != Token.OPEN_BR) {
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
            if (p.token != Token.OPEN_BR) {
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
                    curToken = new Token(Token.VAR, val);
                } else if (val.equals("abs") || val.equals("sqrt")) {
                    curToken = new Token(Token.UNARY_FUNC, val);
                } else if (isDigit(val)) {
                    curToken = new Token(Token.CONST, originalExp.substring(beginPos, curPos));
                } else {
                    throw new WrongExpressionException();
                }
            } else {
                int curOper;
                switch (originalExp.charAt(curPos)) {
                    case '+':
                        curOper = Token.PLUS;
                        break;
                    case '-':
                        if (prevToken.token == Token.CLOSE_BR ||
                                prevToken.token == Token.VAR ||
                                prevToken.token == Token.CONST) {
                            curOper = Token.MINUS;
                        } else {
                            curOper = Token.UNARY_MINUS;
                        }
                        break;
                    case '*':
                        curOper = Token.MULT;
                        break;
                    case '/':
                        curOper = Token.DIV;
                        break;
                    case '(':
                        curOper = Token.OPEN_BR;
                        break;
                    case ')':
                        curOper = Token.CLOSE_BR;
                        break;
                    case '^':
                        curOper = Token.POW;
                        break;
                    default:
                        curOper = Token.EPS;
                        break;
                }
                curToken = new Token(curOper, Character.toString(originalExp.charAt(curPos)));
                curPos++;
            }
            return curToken;
        }
        return new Token(Token.EPS, "$");
    }

    private TripleOperation makeConstOrVar(Token t) {
        return (t.token == Token.CONST) ?
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
