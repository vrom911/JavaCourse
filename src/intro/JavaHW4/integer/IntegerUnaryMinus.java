package intro.JavaHW4.integer;

import intro.JavaHW4.expr.*;

public class IntegerUnaryMinus extends UnaryMinus<Integer>{
    public IntegerUnaryMinus(TripleOperation<Integer> a) {
        super(a);
    }

    public Integer calc(Integer x) {
        return - x;
    }
}
