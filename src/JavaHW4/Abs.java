package JavaHW4;

/**
 * Created by vrom911 on 11/13/16.
 */
class Abs extends UnaryOperation {

    Abs(TripleOperation a) {
        super(a);
    }

    public Integer calc(Integer x) {
        return (x >= 0) ? x : -x;
    }
}
