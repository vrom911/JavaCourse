package JavaHW4.integer;

import JavaHW4.exceptions.WrongExpressionException;
import JavaHW4.expr.Sqrt;
import JavaHW4.expr.TripleOperation;

public class IntegerSqrt extends Sqrt<Integer> {
    public IntegerSqrt(TripleOperation<Integer> a) {
        super(a);
    }

    public Integer calc(Integer x) {
        if (x >= 0) {
            for (int i = 0; i <= x; i++) {
                if (i * i == x) {
                    return i;
                }
                if (i * i > x) {
                    return i - 1;
                }
            }
        } else {
            throw new WrongExpressionException("Negative sqrt try");
        }
        return 0;
    }
}
