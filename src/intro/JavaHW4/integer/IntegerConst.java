package intro.JavaHW4.integer;

import intro.JavaHW4.expr.Const;

public class IntegerConst<T extends Number> extends Const<Integer> {
    public IntegerConst(String c) {
        super(c);
    }

    public Integer calc() {
        return Integer.parseInt(c);
    }
}
