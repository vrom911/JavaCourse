package intro.JavaHW4.exceptions;

public class MissingBraceException extends ExpressionException {
    public MissingBraceException() {
        ERROR_MESSAGE = "Missing Brace";
    }
}
