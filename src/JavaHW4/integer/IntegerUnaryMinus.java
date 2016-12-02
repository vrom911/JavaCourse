package JavaHW4.integer;

import JavaHW4.expr.*;

public class IntegerUnaryMinus extends JavaHW4.expr.UnaryMinus<Integer>{
    public IntegerUnaryMinus(TripleOperation<Integer> a) {
        super(a);
    }

    public Integer calc(Integer x) {
        return - x;
    }
}
