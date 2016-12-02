package JavaHW4.bigInteger;

import JavaHW4.exceptions.OverFlowException;
import JavaHW4.expr.Multiply;
import JavaHW4.expr.TripleOperation;

import java.math.BigInteger;

public class BigIntegerMultiply extends Multiply<BigInteger> {
    BigIntegerMultiply(TripleOperation<BigInteger> a, TripleOperation<BigInteger> b) {
        super(a, b);
    }

    protected BigInteger calc(BigInteger x, BigInteger y) throws OverFlowException {
        return x.multiply(y);
    }
}
