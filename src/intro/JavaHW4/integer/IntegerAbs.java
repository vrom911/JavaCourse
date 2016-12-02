package intro.JavaHW4.integer;

import intro.JavaHW4.expr.Abs;
import intro.JavaHW4.expr.TripleOperation;

public class IntegerAbs extends Abs<Integer> {
    public IntegerAbs(TripleOperation<Integer> a) {
        super(a);
    }

    public Integer calc(Integer x) {
        return (x >= 0) ? x : -x;
    }
}
