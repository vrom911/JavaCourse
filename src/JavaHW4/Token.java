package JavaHW4;

/**
 * Created by vrom911 on 11/13/16.
 */
class Token {

    static final int EPS = 0;
    static final int PLUS = 1;
    static final int MINUS = 2;
    static final int MULT = 3;
    static final int DIV = 4;
    static final int OPEN_BR = 5;
    static final int CLOSE_BR = 6;
    static final int CONST = 7;
    static final int VAR = 8;
    static final int UNARY_MINUS = 9;
    static final int POW = 10;
    static final int FUNC = 11;
    static final int UNARY_FUNC = 12;

    final int token;
    final String value;
    final int priority;

    Token(int tok, String val) {
        token = tok;
        value = val;
        priority = (tok == UNARY_MINUS || tok == UNARY_FUNC) ? 0 :
                (tok == MULT || tok == DIV) ? 1 :
                        (tok == PLUS || tok == MINUS) ? 2 :
                                (tok == Token.POW) ? 3 :
                                        (tok == OPEN_BR) ? 4 : -1;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
