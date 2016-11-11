package JavaHW4;

/**
 * Created by vrom911 on 10/31/16.
 */
class Divide extends BinaryOperation {
    Divide(TripleOperation a, TripleOperation b) {
        super(a, b);
    }

    protected Integer calc(Integer x, Integer y) throws DivideByZeroException, OverFlowException {
        if (y == 0) {
            throw new DivideByZeroException();
        }
        long c = (long) x / y;
        checkOverflow(c);
        return (x / y);
    }
}
