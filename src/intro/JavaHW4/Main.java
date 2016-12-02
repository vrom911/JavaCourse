package intro.JavaHW4;

import intro.JavaHW4.exceptions.DivideByZeroException;
import intro.JavaHW4.exceptions.OverFlowException;
import intro.JavaHW4.exceptions.WrongExpressionException;
import intro.JavaHW4.expr.TripleOperation;

public class Main {

    public static void main(String[] args) {
        if (args.length < 4) {
            System.out.println("Enter the value as the argument: java JavaHW4 type x y z");
            return;
        }
        String type = args[0];
        Operation parser;
        Number val[];
        switch (type) {
            case "-i":
                parser = new IntegerOperation();
                TripleOperation<Integer> tr;
                break;
            case "-d":
                parser = new DoubleOperation();
                break;
            case "-b":
                parser = new BigIntegerOperation();
                break;
            default:
                System.out.println("Enter the value as the argument: java JavaHW4 type x y z");
                return;
        }
        try {
            val = parser.makeValArray(args);
            System.out.println(parser.createExpr("x + 3 + 2").evaluate(val[0], val[1], val[2]));
        } catch (NumberFormatException e) {
            System.out.println("Wrong command line input");
        } catch (DivideByZeroException | OverFlowException | WrongExpressionException e) {
            System.out.println(e.getMessage());
        }
    }
}
