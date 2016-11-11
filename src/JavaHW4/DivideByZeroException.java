package JavaHW4;

/**
 * Created by vrom911 on 11/8/16.
 */
class DivideByZeroException extends ExpressionException{

    DivideByZeroException() {
        ERROR_MESSAGE = "Can not divide by zero!";
    }

}
