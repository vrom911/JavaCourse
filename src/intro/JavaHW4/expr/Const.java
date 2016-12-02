package intro.JavaHW4.expr;

public abstract class Const<T extends Number> implements TripleOperation<T> {
    public String c;
    public abstract T calc();

    public Const(String c){
        this.c = c;
    }

    public T evaluate(T x, T y, T z) {
        return calc();
    }
}
