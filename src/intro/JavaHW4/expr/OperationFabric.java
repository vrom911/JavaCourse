package intro.JavaHW4.expr;

public interface OperationFabric<T extends Number> {
    Add<T> createdAdd(TripleOperation<T> a, TripleOperation<T> b);
    Subtract<T> createdSubtract(TripleOperation<T> a, TripleOperation<T> b);
    Multiply<T> createdMultiply(TripleOperation<T> a, TripleOperation<T> b);
    Divide<T> createdDivide(TripleOperation<T> a, TripleOperation<T> b);
    Power<T> createdPower(TripleOperation<T> a, TripleOperation<T> b);
    Abs<T> createdAbs(TripleOperation<T> a);
    Sqrt<T> createdSqrt(TripleOperation<T> a);
    UnaryMinus<T> createdUnaryMinus(TripleOperation<T> a);
    Variable<T> createdVariable(String name);
    Const<T> createdConst(String c);

}
