package intro.JavaHW4.bigInteger;

import intro.JavaHW4.expr.Abs;
import intro.JavaHW4.expr.TripleOperation;

import java.math.BigInteger;

public class BigIntegerAbs extends Abs<BigInteger> {
    public BigIntegerAbs(TripleOperation<BigInteger> a) {
        super(a);
    }

    public BigInteger calc(BigInteger x) {
        return x.abs();
    }
}
