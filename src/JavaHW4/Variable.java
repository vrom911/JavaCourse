package JavaHW4;

/**
 * Created by vrom911 on 10/31/16.
 */
public class Variable implements Operation {
    public String name;
    public Variable(String name) {
        this.name = name;
    }
    public Integer evaluate(Integer val) {
        return val;
    }
}
