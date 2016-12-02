package JavaHW4.expr;

public interface TripleOperation<T extends Number> {
    T evaluate(T x, T y, T z);
}
