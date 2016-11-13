package JavaHW4;

import java.util.EnumMap;

/**
 * Created by vrom911 on 11/13/16.
 */
class Token {
    static final EnumMap<TokenType, Integer> priorities = new EnumMap<TokenType, Integer>(TokenType.class){{
        put(TokenType.EPS, -1);
        put(TokenType.PLUS, 2);
        put(TokenType.MINUS, 2);
        put(TokenType.MULT, 1);
        put(TokenType.DIV, 1);
        put(TokenType.OPEN_BR, 4);
        put(TokenType.CLOSE_BR, -1);
        put(TokenType.CONST, -1);
        put(TokenType.VAR, -1);
        put(TokenType.UNARY_MINUS, 0);
        put(TokenType.POW, 3);
        put(TokenType.FUNC, -1);
        put(TokenType.UNARY_FUNC, 0);
    }};

    final TokenType token;
    final String value;
    final int priority;

    Token(TokenType token, String value) {
        this.token = token;
        this.value = value;
        this.priority = priorities.get(token);
    }

    @Override
    public String toString() {
        return this.value;
    }
}
