package JavaHW4.integer;

import JavaHW4.expr.Abs;
import JavaHW4.expr.TripleOperation;

public class IntegerAbs extends Abs<Integer> {
    public IntegerAbs(TripleOperation<Integer> a) {
        super(a);
    }

    public Integer calc(Integer x) {
        return (x >= 0) ? x : -x;
    }
}
