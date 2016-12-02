package intro.JavaHW4.bigInteger;

import intro.JavaHW4.exceptions.OverFlowException;
import intro.JavaHW4.expr.Subtract;
import intro.JavaHW4.expr.TripleOperation;

import java.math.BigInteger;

public class BigIntegerSubtract extends Subtract<BigInteger> {
    BigIntegerSubtract(TripleOperation<BigInteger> a, TripleOperation<BigInteger> b) {
        super(a, b);
    }

    protected BigInteger calc(BigInteger x, BigInteger y) throws OverFlowException {
        return x.subtract(y);
    }
}
