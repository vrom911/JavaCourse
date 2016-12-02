package intro.JavaHW4.bigInteger;

import intro.JavaHW4.expr.Const;

import java.math.BigInteger;

public class BigIntegerConst extends Const<BigInteger> {
    public BigIntegerConst(String c) {
        super(c);
    }

    public BigInteger calc() {
        return new BigInteger(c);
    }

}
