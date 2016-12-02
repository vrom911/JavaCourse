package JavaHW4.doublePack;

import JavaHW4.expr.Const;

public class DoubleConst extends Const<Double> {
    public DoubleConst(String c) {
        super(c);
    }

    public Double calc() {
        return Double.parseDouble(c);
    }
}
