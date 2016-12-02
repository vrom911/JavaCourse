package JavaHW4.expr;

public abstract class Add<T extends Number> extends BinaryOperation<T> {
    protected Add(TripleOperation<T> a, TripleOperation<T> b) {
        super(a, b);
    }
}
