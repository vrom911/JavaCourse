package intro.JavaHW4.exceptions;

public class OverFlowException extends ExpressionException{
    public OverFlowException() {
        ERROR_MESSAGE = "Overflow";
    }
}
