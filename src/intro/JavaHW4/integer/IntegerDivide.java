package intro.JavaHW4.integer;

import intro.JavaHW4.exceptions.DivideByZeroException;
import intro.JavaHW4.exceptions.OverFlowException;
import intro.JavaHW4.expr.Divide;
import intro.JavaHW4.expr.TripleOperation;

public class IntegerDivide extends Divide<Integer> {
    public IntegerDivide(TripleOperation<Integer> a, TripleOperation<Integer> b) {
        super(a, b);
    }

    protected Integer calc(Integer x, Integer y) throws DivideByZeroException, OverFlowException {
        if (y == 0) {
            throw new DivideByZeroException();
        }
        return x / y;
    }
}
