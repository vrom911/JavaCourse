package JavaHW4.bigInteger;

import JavaHW4.exceptions.OverFlowException;
import JavaHW4.expr.Add;
import JavaHW4.expr.TripleOperation;

import java.math.BigInteger;

public class BigIntegerAdd extends Add<BigInteger> {

    public BigIntegerAdd(TripleOperation<BigInteger> a, TripleOperation<BigInteger> b) {
        super(a, b);
    }

    protected BigInteger calc(BigInteger x, BigInteger y) throws OverFlowException {
        return x.add(y);
    }
}
