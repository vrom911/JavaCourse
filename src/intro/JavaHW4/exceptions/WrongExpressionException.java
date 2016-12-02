package intro.JavaHW4.exceptions;

public class WrongExpressionException extends ExpressionException{

    public WrongExpressionException() {
        ERROR_MESSAGE = "Wrong Input Expression";
    }
    public WrongExpressionException(String s) {
        ERROR_MESSAGE = s;
    }
}