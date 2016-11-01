package JavaHW4;

/**
 * Created by vrom911 on 10/31/16.
 */
public class Const implements Operation {
    public Integer c;

    public Const(Integer c) {
        this.c = c;
    }

    public Integer evaluate(Integer o) {
        return c;
    }
}
