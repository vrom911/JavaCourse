package intro.JavaHW4.expr;

public abstract class UnaryMinus<T extends Number> extends UnaryOperation<T>{
    public UnaryMinus(TripleOperation<T> a) {
        super(a);
    }
}
