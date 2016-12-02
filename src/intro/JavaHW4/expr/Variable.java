package intro.JavaHW4.expr;

public class Variable<T extends Number> implements TripleOperation<T> {
    protected String name;

    public Variable(String name) {
        this.name = name.toLowerCase();
    }

    public T evaluate(T x, T y, T z) {
        switch (name) {
            case "x":
                return x;
            case "y":
                return y;
            case "z":
                return z;
            default:
                throw new IllegalArgumentException("Only x, y or z possible, not " + name);
        }
    }
}
