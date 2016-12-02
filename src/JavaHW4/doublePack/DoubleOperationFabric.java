package JavaHW4.doublePack;

import JavaHW4.expr.*;

public class DoubleOperationFabric implements OperationFabric<Double> {
    @Override
    public Add<Double> createdAdd(TripleOperation<Double> a, TripleOperation<Double> b) {
        return new DoubleAdd(a, b);
    }

    @Override
    public Subtract<Double> createdSubtract(TripleOperation<Double> a, TripleOperation<Double> b) {
        return new DoubleSubtract(a, b);
    }

    @Override
    public Multiply<Double> createdMultiply(TripleOperation<Double> a, TripleOperation<Double> b) {
        return new DoubleMultiply(a, b);
    }

    @Override
    public Divide<Double> createdDivide(TripleOperation<Double> a, TripleOperation<Double> b) {
        return new DoubleDivide(a, b);
    }

    @Override
    public Power<Double> createdPower(TripleOperation<Double> a, TripleOperation<Double> b) {
        return new DoublePower(a, b);
    }

    @Override
    public Abs<Double> createdAbs(TripleOperation<Double> a) {
        return new DoubleAbs(a);
    }

    @Override
    public Sqrt<Double> createdSqrt(TripleOperation<Double> a) {
        return new DoubleSqrt(a);
    }

    @Override
    public UnaryMinus<Double> createdUnaryMinus(TripleOperation<Double> a) {
        return new DoubleUnaryMinus(a);
    }

    @Override
    public Variable<Double> createdVariable(String name) {
        return new Variable<>(name);
    }

    @Override
    public Const<Double> createdConst(String c) {
        return new DoubleConst(c);
    }
}