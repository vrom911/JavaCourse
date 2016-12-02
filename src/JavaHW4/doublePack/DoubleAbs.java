package JavaHW4.doublePack;

import JavaHW4.expr.Abs;
import JavaHW4.expr.TripleOperation;

public class DoubleAbs extends Abs<Double> {
    public DoubleAbs(TripleOperation<Double> a) {
        super(a);
    }

    public Double calc(Double x) {
        return (x >= 0) ? x : -x;
    }
}
