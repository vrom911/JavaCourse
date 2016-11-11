package JavaHW4;

/**
 * Created by vrom911 on 10/31/16.
 */
class Const implements TripleOperation {
    private Integer c;

    Const(Integer c) {
        this.c = c;
    }

    public Integer evaluate(Integer x, Integer y, Integer z) {
        return c;
    }
}
