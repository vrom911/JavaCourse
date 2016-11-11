package JavaHW4;

/**
 * Created by vrom911 on 10/31/16.
 */
public class Main {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Enter the value as the argument: java JavaHW4 x y z");
            return;
        }
        Integer val[] = new Integer[3];
        for (int i = 0; i < 3; i++) {
            val[i] = Integer.parseInt(args[i]);
        }

//        System.out.println(
//                new Add(new Add(new Variable("x"), new Variable("y")), new Variable("z")).evaluate(val[0], val[1], val[2])
//        );
//        System.out.println(new Add(
//                new Subtract(
//                        new Multiply(
//                                new Variable("x"),
//                                new Variable("x")
//                        ),
//                        new Multiply(new Variable("x"), new Const(3))
//                ),
//                new Const(4)
//        ).evaluate(val[0], val[1], val[2]));

        TripleOperation expr = new ExpressionParser(" 1000000*x*x*x*x*x/(x-1)").expression();
        try {
            Integer result = expr.evaluate(val[0], val[1], val[2]);
            System.out.println(result);

        } catch (DivideByZeroException | OverFlowException e) {
        System.out.println(e.getMessage());
        }

    }
}
