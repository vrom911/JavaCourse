package JavaHW4;

/**
 * Created by vrom911 on 11/1/16.
 */
abstract class BinaryOperation implements TripleOperation{
    private TripleOperation a;
    private TripleOperation b;
    protected abstract Integer calc(Integer x, Integer y) throws DivideByZeroException, OverFlowException;

    BinaryOperation(TripleOperation a, TripleOperation b) {
        this.a = a;
        this.b = b;
    }

    public Integer evaluate(Integer x, Integer y, Integer z) throws ExpressionException {
        return calc(a.evaluate(x, y, z), b.evaluate(x, y, z));
    }

    void checkOverflow(long c) throws OverFlowException{
        if (c < Integer.MIN_VALUE || c > Integer.MAX_VALUE) {
            System.out.println("I know");
            throw new OverFlowException();
        }
    }
}
