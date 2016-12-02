package intro.JavaHW4.expr;

public abstract class Abs<T extends Number> extends UnaryOperation<T> {
    public  Abs(TripleOperation<T> a) {
        super(a);
    }
}
