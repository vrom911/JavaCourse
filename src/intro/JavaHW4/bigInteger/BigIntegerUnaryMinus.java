package intro.JavaHW4.bigInteger;

import intro.JavaHW4.expr.TripleOperation;
import intro.JavaHW4.expr.UnaryMinus;

import java.math.BigInteger;

public class BigIntegerUnaryMinus extends UnaryMinus<BigInteger>{
    public BigIntegerUnaryMinus(TripleOperation<BigInteger> a) {
        super(a);
    }

    public BigInteger calc(BigInteger x) {
        return x;
    }
}
