package intro.JavaHW4.integer;

import intro.JavaHW4.exceptions.OverFlowException;
import intro.JavaHW4.exceptions.WrongExpressionException;
import intro.JavaHW4.expr.Power;
import intro.JavaHW4.expr.TripleOperation;

public class IntegerPower extends Power<Integer> {
    public IntegerPower(TripleOperation<Integer> a, TripleOperation<Integer> b) {
        super(a, b);
    }

    public Integer calc(Integer x, Integer y) throws OverFlowException {
        if (y < 0) {
            throw new WrongExpressionException("Negative power");
        }
        if (y == 0) {
            if (x == 0) {
                throw new WrongExpressionException("0^0 !!! Be careful.");
            }
            return 1;
        }
        if (y % 2 == 0) {
            int res = calc(x, y / 2);
            return res * res;
        } else {
            return x * calc(x, y - 1);
        }
    }
}
