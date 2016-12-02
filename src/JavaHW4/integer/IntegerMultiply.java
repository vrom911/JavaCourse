package JavaHW4.integer;

import JavaHW4.exceptions.OverFlowException;
import JavaHW4.expr.*;

public class IntegerMultiply extends Multiply<Integer> {
    IntegerMultiply(TripleOperation<Integer> a, TripleOperation<Integer> b) {
        super(a, b);
    }

    protected Integer calc(Integer x, Integer y) throws OverFlowException {
        long c = (long) x * y;
        checkOverflow(c);
        return x * y;
    }
}
