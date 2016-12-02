package intro.JavaHW4.bigInteger;

import intro.JavaHW4.exceptions.DivideByZeroException;
import intro.JavaHW4.exceptions.OverFlowException;
import intro.JavaHW4.expr.Divide;
import intro.JavaHW4.expr.TripleOperation;

import java.math.BigInteger;

public class BigIntegerDivide extends Divide<BigInteger> {
    public BigIntegerDivide(TripleOperation<BigInteger> a, TripleOperation<BigInteger> b) {
        super(a, b);
    }

    protected BigInteger calc(BigInteger x, BigInteger y) throws DivideByZeroException, OverFlowException {
        if (y.equals(0)) {
            throw new DivideByZeroException();
        }
        return x.divide(y);
    }
}
