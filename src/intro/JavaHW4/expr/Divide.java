package intro.JavaHW4.expr;

public abstract class Divide<T extends Number> extends BinaryOperation<T> {
    public Divide(TripleOperation<T> a, TripleOperation<T> b) {
        super(a, b);
    }
}
