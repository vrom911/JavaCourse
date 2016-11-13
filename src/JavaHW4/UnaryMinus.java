package JavaHW4;

/**
 * Created by vrom911 on 11/13/16.
 */
class UnaryMinus extends UnaryOperation {
    private TripleOperation a;

    UnaryMinus(TripleOperation a) {
        super(a);
    }

    public Integer calc(Integer x) {
        return - x;
    }
}
