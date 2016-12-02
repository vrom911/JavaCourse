package intro.JavaHW4.expr;

public abstract class Sqrt<T extends Number> extends UnaryOperation<T> {
    public Sqrt(TripleOperation<T> a) {
        super(a);
    }
}
