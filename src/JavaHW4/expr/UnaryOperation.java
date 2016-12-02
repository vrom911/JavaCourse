package JavaHW4.expr;

import JavaHW4.exceptions.ExpressionException;

public abstract class UnaryOperation<T extends Number> implements TripleOperation<T> {
    private TripleOperation<T> a;

    protected UnaryOperation() {
    }

    protected abstract T calc(T x);

    public UnaryOperation(TripleOperation<T> a) {
        this.a = a;
    }
    public T evaluate(T x, T y, T z) throws ExpressionException {
        return calc(a.evaluate(x, y, z));
    }
}
