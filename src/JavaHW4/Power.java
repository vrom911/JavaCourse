package JavaHW4;

/**
 * Created by vrom911 on 11/13/16.
 */
class Power extends BinaryOperation {

    Power(TripleOperation a, TripleOperation b) {
        super(a, b);
    }

    public Integer calc(Integer x, Integer y) throws OverFlowException {
        if (y < 0) {
            throw new WrongExpressionException("Negative power");
        }
        if (y == 0) {
            if (x == 0) {
                throw new WrongExpressionException("0^0 !!! Be careful.");
            }
            return 1;
        }
        if (y % 2 == 0) {
            int res = calc(x, y / 2);
            return res * res;
        } else {
            return x * calc(x, y - 1);
        }
    }
}
