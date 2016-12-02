package JavaHW4.doublePack;

import JavaHW4.exceptions.OverFlowException;
import JavaHW4.exceptions.WrongExpressionException;
import JavaHW4.expr.Power;
import JavaHW4.expr.TripleOperation;

public class DoublePower extends Power<Double> {
    public DoublePower(TripleOperation<Double> a, TripleOperation<Double> b) {
        super(a, b);
    }

    public Double calc(Double x, Double y) throws OverFlowException {
        if (y < 0) {
            throw new WrongExpressionException("Negative power");
        }
        if (y == 0) {
            if (x == 0) {
                throw new WrongExpressionException("0^0 !!! Be careful.");
            }
            return 1.0;
        }
        if (y % 2 == 0) {
            Double res = calc(x, y / 2);
            return res * res;
        } else {
            return x * calc(x, y - 1);
        }
    }
}
