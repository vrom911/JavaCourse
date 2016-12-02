package JavaHW4.doublePack;

import JavaHW4.exceptions.OverFlowException;
import JavaHW4.expr.Multiply;
import JavaHW4.expr.TripleOperation;

public class DoubleMultiply extends Multiply<Double> {
    DoubleMultiply(TripleOperation<Double> a, TripleOperation<Double> b) {
        super(a, b);
    }

    protected Double calc(Double x, Double y) throws OverFlowException {
//        long c = (long) x * y;
//        checkOverflow(c);
        return x * y;
    }
}
