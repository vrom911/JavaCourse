package JavaHW4.expr;

public abstract class Subtract<T extends Number> extends BinaryOperation<T>{
    protected Subtract(TripleOperation<T> a, TripleOperation<T> b) {
        super(a, b);
    }
}
