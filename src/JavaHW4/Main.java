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
        try {
            System.out.println(new PolishParser("2^3 ").parse().evaluate(val[0], val[1], val[2]));
        } catch (DivideByZeroException | OverFlowException | WrongExpressionException e) {
            System.out.println(e.getMessage());
        }
    }
}
