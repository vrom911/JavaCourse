package JavaHW4;

/**
 * Created by vrom911 on 11/13/16.
 */
class Power extends BinaryOperation {

    Power(TripleOperation a, TripleOperation b) {
        super(a, b);
    }

    public Integer calc(Integer x, Integer y) throws OverFlowException {
        if (y >= 0) {
            for (int i = 0; i < y; i++) {
                x *= x;
            }

            return (y == 0) ? 1 : x;
        } else {
            throw new WrongExpressionException("Negative power");
        }

    }
}
