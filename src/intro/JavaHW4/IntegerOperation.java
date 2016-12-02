package intro.JavaHW4;

import intro.JavaHW4.expr.PolishParser;
import intro.JavaHW4.expr.TripleOperation;
import intro.JavaHW4.integer.IntegerOperationFabric;

public class IntegerOperation implements Operation<Integer> {
    @Override
    public TripleOperation<Integer> createExpr(String exp) {
        return  new PolishParser<>(exp, new IntegerOperationFabric()).parse();
    }

    @Override
    public Integer[] makeValArray(String[] args) throws NumberFormatException {
        Integer val[] = new Integer[3];
        for (int i = 0; i < 3; i++) {
            val[i] = Integer.valueOf(args[i + 1]);
        }
        return val;
    }
}
