package intro.JavaHW4.bigInteger;

import intro.JavaHW4.expr.Sqrt;
import intro.JavaHW4.expr.TripleOperation;

import java.math.BigInteger;

public class BigIntegerSqrt extends Sqrt<BigInteger> {
    public BigIntegerSqrt(TripleOperation<BigInteger> a) {
        super(a);
    }

    public BigInteger calc(BigInteger x) {
//        if (x >= 0) {
//            for (int i = 0; i <= x; i++) {
//                if (i * i == x) {
//                    return i;
//                }
//                if (i * i > x) {
//                    return i - 1;
//                }
//            }
//        } else {
//            throw new WrongExpressionException("Negative sqrt try");
//        }
        return BigInteger.ONE;
    }
}
