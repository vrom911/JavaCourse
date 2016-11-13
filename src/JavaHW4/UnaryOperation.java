package JavaHW4;

/**
 * Created by vrom911 on 11/13/16.
 */
abstract class UnaryOperation implements TripleOperation {
    private TripleOperation a;
    protected abstract Integer calc(Integer x);

    UnaryOperation(TripleOperation a) {
        this.a = a;
    }
    public Integer evaluate(Integer x, Integer y, Integer z) throws ExpressionException {
        return calc(a.evaluate(x, y, z));
    }
}
