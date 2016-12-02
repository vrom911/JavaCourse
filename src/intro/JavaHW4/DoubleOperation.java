package intro.JavaHW4;

import intro.JavaHW4.doublePack.DoubleOperationFabric;
import intro.JavaHW4.expr.PolishParser;
import intro.JavaHW4.expr.TripleOperation;

public class DoubleOperation implements Operation<Double> {
    @Override
    public TripleOperation<Double> createExpr(String exp) {
        return new PolishParser<>(exp, new DoubleOperationFabric()).parse();
    }

    @Override
    public Double[] makeValArray(String[] args) {
        Double val[] = new Double[3];
        for (int i = 0; i < 3; i++) {
            val[i] = Double.parseDouble(args[i + 1]);
        }
        return val;
    }
}
