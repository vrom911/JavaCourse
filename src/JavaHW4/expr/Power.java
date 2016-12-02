package JavaHW4.expr;

public abstract class Power<T extends Number> extends BinaryOperation<T> {
    public Power(TripleOperation<T> a, TripleOperation<T> b) {
        super(a, b);
    }
}
