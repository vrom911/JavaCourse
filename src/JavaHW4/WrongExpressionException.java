package JavaHW4;

/**
 * Created by vrom911 on 11/13/16.
 */
class WrongExpressionException extends ExpressionException{

    WrongExpressionException() {
        ERROR_MESSAGE = "Wrong Input Expression";
    }
    WrongExpressionException(String s) {
        ERROR_MESSAGE = s;
    }
}