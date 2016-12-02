package intro.JavaHW4.exceptions;

public abstract class ExpressionException extends RuntimeException {
    String ERROR_MESSAGE;

    public ExpressionException() {
        this.ERROR_MESSAGE = "Some Error";
    }

    public ExpressionException(String message) {
        super(message);
    }

    public String getMessage() {
        return ERROR_MESSAGE;
    }
}
