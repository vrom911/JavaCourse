package JavaHW4;

/**
 * Created by vrom911 on 11/1/16.
 */
public abstract class BinaryOperation implements Operation{
    public Operation a;
    public Operation b;

    public BinaryOperation(){

    };

    public BinaryOperation(Operation a, Operation b) {
        this.a = a;
        this.b = b;
    }
}
