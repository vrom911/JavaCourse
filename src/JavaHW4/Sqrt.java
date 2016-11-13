package JavaHW4;

/**
 * Created by vrom911 on 11/13/16.
 */
class Sqrt extends UnaryOperation {

    Sqrt(TripleOperation a) {
        super(a);
    }

    public Integer calc(Integer x) {
        if (x >= 0) {
            for (int i = 0; i <= x; i++) {
                if (i * i == x) {
                    return i;
                }
                if (i * i > x) {
                    return i - 1;
                }
            }
        } else {
            throw new WrongExpressionException("Negative sqrt try");
        }
        return 0;
    }
}
