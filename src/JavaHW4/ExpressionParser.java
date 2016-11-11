package JavaHW4;

/**
 * Created by vrom911 on 11/2/16.
 * All expressions have next structure:
 * Exp = Sum +(-) Sum...
 * Sum = Mult *(/) Mult...
 * Mult = const || Exp
 * for counting that using
 *      tryExp() - for Exp
 *      trySum() - for Sum
 *      tryMult() - for Mult
 *
 * E -> E + E | E - E | E * E | E / E | n | (E) | -E
 *
 * E -> T + E | T - E
 * T -> F * E | F / E
 * F -> n | (E) | -E
 *
 * E -> T E'
 * E' -> +E | -E
 * T -> F T'
 * T' -> *E | /E
 * F -> n | (E) | -E
 */
class ExpressionParser {
    /** Expression itself */
    private String originalExp;
    /** number of current position in the expression */
    private int curPos = 0;
    /** kind of the current operation */
    private int curOper = -1;
    private int prevOper = -1;
    /** value of constants or name of variable */
    private String curVal;
    /** codes of states:
     * 0 :'+'
     * 1 :'-'
     * 2 :'*'
     * 3 :'/'
     * 4 :'c'
     * 5 :'x'
     * 6 :'('
     * 7 :')' */

    ExpressionParser(String exp) {
        originalExp = "(" + exp.replace(" ", "") + ")";
        curPos = 0;
    }

    TripleOperation expression() {
        TripleOperation result;
        // need to read first element
        readNext();
        // result of whole statement
        result = tryExpr();
        return result;
    }

    private TripleOperation tryExpr() {
        TripleOperation res = trySum();
        // while it's '+' or '-'
        while (curOper == 0 || curOper == 1) {
            int saveOper = curOper;
            readNext();
            res = (saveOper == 0) ? new Add(res, trySum()) : new Subtract(res, trySum());
        }
        return res;
    }

    private TripleOperation trySum() {
        TripleOperation res = tryMult();
        // while it's '*' or '/'
        while (curOper == 2 || curOper == 3) {
            int saveOper = curOper;
            readNext();
            res = (saveOper == 2) ? new Multiply(res, tryMult()) : new Divide(res, tryMult());
        }
        return res;

    }

    private TripleOperation tryMult() {
        TripleOperation res = null;
        switch (curOper) {
            // const
            case 4:
//                if (prevOper == 1) {
//                    curVal = '-' + curVal;
//                }
                res = new Const(Integer.parseInt(curVal));
                readNext();
                break;
            // variable
            case 5:
                res = new Variable(curVal);
                readNext();
                break;
            // open brace
            case 6:
                readNext();
                res = tryExpr();
                //needs to be closed
                if (curOper == 7) {
                    readNext();
                } else {
                    System.out.println("That's bad, there is no closing bracket");
                }

                break;
            case 7:
                System.out.println("wrong close");
                break;
//            case 1:
//                readNext();
//                res = tryMult();
//                break;
            default:
                System.out.println("Wrong expr");
                System.exit(0);

        }

        return res;
    }

    private int readNext() {
        prevOper = curOper;
        while (curPos < originalExp.length()) {
            int beginPos = curPos;
            // figure out if it's number
            while (curPos < originalExp.length()) {
                if (!Character.isDigit(originalExp.charAt(curPos))) {
                    break;
                }
                curPos++;
            }
            //that means we have the number
            if (curPos > beginPos) {
                curVal = originalExp.substring(beginPos, curPos);
                curOper = 4;
            } else {
                    switch (originalExp.charAt(curPos)) {
                        case '+':
                            curOper = 0;
                            break;
                        case '-':
                            curOper = 1;
                            break;
                        case '*':
                            curOper = 2;
                            break;
                        case '/':
                            curOper = 3;
                            break;
                        case '(':
                            curOper = 6;
                            break;
                        case ')':
                            curOper = 7;
                            break;
                        default:
                            curOper = 5;
                            curVal = Character.toString(originalExp.charAt(curPos));
                            break;
                    }
                    curPos++;
                }
//            System.out.println(originalExp.charAt(curPos - 1) + " : " + curOper + " pos " + curPos + " val = " + curVal);
            return curOper;
            }
        return -1;
    }
}
