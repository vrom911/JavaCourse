package JavaHW4.bigInteger;

import JavaHW4.expr.Abs;
import JavaHW4.expr.TripleOperation;

import java.math.BigInteger;

public class BigIntegerAbs extends Abs<BigInteger> {
    public BigIntegerAbs(TripleOperation<BigInteger> a) {
        super(a);
    }

    public BigInteger calc(BigInteger x) {
        return x.abs();
    }
}
