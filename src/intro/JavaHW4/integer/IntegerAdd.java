package intro.JavaHW4.integer;

import intro.JavaHW4.expr.Add;
import intro.JavaHW4.exceptions.OverFlowException;
import intro.JavaHW4.expr.TripleOperation;

public class IntegerAdd extends Add<Integer> {

    public IntegerAdd(TripleOperation<Integer> a, TripleOperation<Integer> b) {
        super(a, b);
    }

    protected Integer calc(Integer x, Integer y) throws OverFlowException {
        long c = (long) x + y;
        checkOverflow(c);
        return x + y;
    }
}
