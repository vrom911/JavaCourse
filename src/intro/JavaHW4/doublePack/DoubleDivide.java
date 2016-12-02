package intro.JavaHW4.doublePack;

import intro.JavaHW4.exceptions.DivideByZeroException;
import intro.JavaHW4.exceptions.OverFlowException;
import intro.JavaHW4.expr.Divide;
import intro.JavaHW4.expr.TripleOperation;

public class DoubleDivide extends Divide<Double> {
    public DoubleDivide(TripleOperation<Double> a, TripleOperation<Double> b) {
        super(a, b);
    }

    protected Double calc(Double x, Double y) throws DivideByZeroException, OverFlowException {
        if (y == 0) {
            throw new DivideByZeroException();
        }
        return x / y;
    }
}
