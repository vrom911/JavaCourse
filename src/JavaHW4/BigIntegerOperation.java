package JavaHW4;

import JavaHW4.bigInteger.BigIntegerOperationFabric;
import JavaHW4.expr.PolishParser;
import JavaHW4.expr.TripleOperation;

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
