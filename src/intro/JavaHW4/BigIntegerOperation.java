package intro.JavaHW4;

import intro.JavaHW4.bigInteger.BigIntegerOperationFabric;
import intro.JavaHW4.expr.PolishParser;
import intro.JavaHW4.expr.TripleOperation;

import java.math.BigInteger;

public class BigIntegerOperation implements Operation<BigInteger> {
    @Override
    public TripleOperation<BigInteger> createExpr(String exp) {
        return new PolishParser<>(exp, new BigIntegerOperationFabric()).parse();
    }

    @Override
    public BigInteger[] makeValArray(String[] args) {
        BigInteger val[] = new BigInteger[3];
        for (int i = 0; i < 3; i++) {
            val[i] = new BigInteger(args[i + 1]);
        }
        return val;
    }
}
