package JavaHW4.doublePack;

import JavaHW4.expr.TripleOperation;
import JavaHW4.expr.UnaryMinus;

public class DoubleUnaryMinus extends UnaryMinus<Double>{
    public DoubleUnaryMinus(TripleOperation<Double> a) {
        super(a);
    }

    public Double calc(Double x) {
        return - x;
    }
}
