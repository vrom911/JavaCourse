package JavaHW4.integer;

import JavaHW4.expr.*;
import JavaHW4.expr.Abs;
import JavaHW4.expr.Divide;
import JavaHW4.expr.UnaryMinus;

public class IntegerOperationFabric implements OperationFabric<Integer> {
    @Override
    public Add<Integer> createdAdd(TripleOperation<Integer> a, TripleOperation<Integer> b) {
        return new IntegerAdd(a, b);
    }

    @Override
    public Subtract<Integer> createdSubtract(TripleOperation<Integer> a, TripleOperation<Integer> b) {
        return new IntegerSubtract(a, b);
    }

    @Override
    public Multiply<Integer> createdMultiply(TripleOperation<Integer> a, TripleOperation<Integer> b) {
        return new IntegerMultiply(a, b);
    }

    @Override
    public Divide<Integer> createdDivide(TripleOperation<Integer> a, TripleOperation<Integer> b) {
        return new IntegerDivide(a, b);
    }

    @Override
    public Power<Integer> createdPower(TripleOperation<Integer> a, TripleOperation<Integer> b) {
        return new IntegerPower(a, b);
    }

    @Override
    public Abs<Integer> createdAbs(TripleOperation<Integer> a) {
        return new IntegerAbs(a);
    }

    @Override
    public Sqrt<Integer> createdSqrt(TripleOperation<Integer> a) {
        return new IntegerSqrt(a);
    }
    @Override
    public UnaryMinus<Integer> createdUnaryMinus(TripleOperation<Integer> a) {
        return new IntegerUnaryMinus(a);
    }

    @Override
    public Variable<Integer> createdVariable(String name) {
        return new Variable<>(name);
    }

    @Override
    public Const<Integer> createdConst(String c) {
        return new IntegerConst(c);
    }
}