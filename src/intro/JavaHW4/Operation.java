package intro.JavaHW4;

import intro.JavaHW4.expr.TripleOperation;

public interface Operation<T extends Number> {
    TripleOperation<T> createExpr(String exp);
    T[] makeValArray(String[] args);
}
