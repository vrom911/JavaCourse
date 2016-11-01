package JavaHW4;

import java.util.function.Function;

/**
 * Created by vrom911 on 10/31/16.
 */
public class Add extends BinaryOperation{

    public Add (Operation a, Operation b) {
        super(a, b);
    }

    protected Integer calc(Integer x, Integer y) {
        return (x + y);
    }
}
