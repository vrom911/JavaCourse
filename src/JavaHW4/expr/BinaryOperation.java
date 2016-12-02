package JavaHW4.expr;

import JavaHW4.exceptions.DivideByZeroException;
import JavaHW4.exceptions.ExpressionException;
import JavaHW4.exceptions.OverFlowException;

public abstract class BinaryOperation<T extends Number> implements TripleOperation<T> {
    private TripleOperation<T> a;
    private TripleOperation<T> b;

    protected abstract T calc(T x, T y) throws DivideByZeroException, OverFlowException;

    BinaryOperation(TripleOperation<T> a, TripleOperation<T> b) {
        this.a = a;
        this.b = b;
    }

    public T evaluate(T x, T y, T z) throws ExpressionException {
        return calc(a.evaluate(x, y, z), b.evaluate(x, y, z));
    }

    public void checkOverflow(long c) throws OverFlowException{
        if (c < Integer.MIN_VALUE || c > Integer.MAX_VALUE) {
            throw new OverFlowException();
        }
    }
}
