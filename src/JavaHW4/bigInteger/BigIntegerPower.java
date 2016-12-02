package JavaHW4.bigInteger;

import JavaHW4.exceptions.OverFlowException;
import JavaHW4.exceptions.WrongExpressionException;
import JavaHW4.expr.Power;
import JavaHW4.expr.TripleOperation;

import java.math.BigInteger;

public class BigIntegerPower extends Power<BigInteger> {
    public BigIntegerPower(TripleOperation<BigInteger> a, TripleOperation<BigInteger> b) {
        super(a, b);
    }

    public BigInteger calc(BigInteger x, BigInteger y) throws OverFlowException {
        if (y.compareTo(BigInteger.ZERO) == -1) {
            throw new WrongExpressionException("Negative power");
        }
        if (y.equals(BigInteger.ZERO)) {
            if (x.equals(BigInteger.ZERO)) {
                throw new WrongExpressionException("0^0 !!! Be careful.");
            }
            return BigInteger.ONE;
        }
        if (y.remainder(new BigInteger(String.valueOf(2))).equals(BigInteger.ZERO)) {
            BigInteger res = calc(x, y.divide(new BigInteger(String.valueOf(2))));
            return res.multiply(res);
        } else {
            return x.multiply(calc(x, y.subtract(BigInteger.ONE)));
        }
    }
}
