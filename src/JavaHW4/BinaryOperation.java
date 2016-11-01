package JavaHW4;

/**
 * Created by vrom911 on 11/1/16.
 */
public abstract class BinaryOperation implements Operation{
    public Operation a;
    public Operation b;
    protected abstract Integer calc(Integer x, Integer y);

    public BinaryOperation(Operation a, Operation b) {
        this.a = a;
        this.b = b;
    }

    public Integer evaluate(Integer val) {
        return calc(a.evaluate(val), b.evaluate(val));
    }
}
