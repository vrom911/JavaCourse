package intro.JavaHW4.bigInteger;

import intro.JavaHW4.expr.*;

import java.math.BigInteger;

public class BigIntegerOperationFabric implements OperationFabric<BigInteger> {
    @Override
    public Add<BigInteger> createdAdd(TripleOperation<BigInteger> a, TripleOperation<BigInteger> b) {
        return new BigIntegerAdd(a, b);
    }

    @Override
    public Subtract<BigInteger> createdSubtract(TripleOperation<BigInteger> a, TripleOperation<BigInteger> b) {
        return new BigIntegerSubtract(a, b);
    }

    @Override
    public Multiply<BigInteger> createdMultiply(TripleOperation<BigInteger> a, TripleOperation<BigInteger> b) {
        return new BigIntegerMultiply(a, b);
    }

    @Override
    public Divide<BigInteger> createdDivide(TripleOperation<BigInteger> a, TripleOperation<BigInteger> b) {
        return new BigIntegerDivide(a, b);
    }

    @Override
    public Power<BigInteger> createdPower(TripleOperation<BigInteger> a, TripleOperation<BigInteger> b) {
        return new BigIntegerPower(a, b);
    }

    @Override
    public Abs<BigInteger> createdAbs(TripleOperation<BigInteger> a) {
        return new BigIntegerAbs(a);
    }

    @Override
    public Sqrt<BigInteger> createdSqrt(TripleOperation<BigInteger> a) {
        return new BigIntegerSqrt(a);
    }
    @Override
    public UnaryMinus<BigInteger> createdUnaryMinus(TripleOperation<BigInteger> a) {
        return new BigIntegerUnaryMinus(a);
    }

    @Override
    public Variable<BigInteger> createdVariable(String name) {
        return new Variable<>(name);
    }

    @Override
    public Const<BigInteger> createdConst(String c) {
        return new BigIntegerConst(c);
    }
}