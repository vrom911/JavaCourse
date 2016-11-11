package JavaHW4;

/**
 * Created by vrom911 on 10/31/16.
 */
class Multiply extends BinaryOperation {
    Multiply(TripleOperation a, TripleOperation b) {
        super(a, b);
    }

    protected Integer calc(Integer x, Integer y) throws OverFlowException {
        long c = (long) x * y;
        checkOverflow(c);
        return (x * y);
    }
}
