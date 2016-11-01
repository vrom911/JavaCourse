package JavaHW4;

/**
 * Created by vrom911 on 10/31/16.
 */
public class Divide extends BinaryOperation {
    public Divide (Operation a, Operation b) {
        super(a, b);
    }

    protected Integer calc(Integer x, Integer y) {
        return (x / y);
    }
}
