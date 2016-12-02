package JavaHW4.expr;

public abstract class Multiply<T extends Number> extends BinaryOperation<T> {
    public Multiply(TripleOperation<T> a, TripleOperation<T> b) {
        super(a, b);
    }
}
