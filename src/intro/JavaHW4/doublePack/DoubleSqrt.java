package intro.JavaHW4.doublePack;

import intro.JavaHW4.exceptions.WrongExpressionException;
import intro.JavaHW4.expr.Sqrt;
import intro.JavaHW4.expr.TripleOperation;

public class DoubleSqrt extends Sqrt<Double> {
    public DoubleSqrt(TripleOperation<Double> a) {
        super(a);
    }

    public Double calc(Double x) {
        if (x >= 0) {
            return Math.sqrt(x);
        } else {
            throw new WrongExpressionException("Negative sqrt try");
        }
    }
}
