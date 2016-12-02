package intro.JavaHW4.exceptions;


public class DivideByZeroException extends ExpressionException {

    public DivideByZeroException() {
        ERROR_MESSAGE = "Can not divide by zero!";
    }

}
