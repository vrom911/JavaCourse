package JavaHW4;

/**
 * Created by vrom911 on 11/8/16.
 */
abstract class ExpressionException extends RuntimeException {

    String ERROR_MESSAGE;

    ExpressionException() {
    }
    public ExpressionException(String message) {
        super(message);
    }

    public String getMessage() {
        return ERROR_MESSAGE;
    }

}
