package JavaHW4;

/**
 * Created by vrom911 on 10/31/16.
 */
public class Variable extends UnaryOperation {
    public Object name;
    public Variable(Object name) {
        this.name = name;
    }
    public Integer evaluate(Integer o) {
        return o;
    }
}
