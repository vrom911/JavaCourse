package JavaHW4;

/**
 * Created by vrom911 on 10/31/16.
 */
public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Enter the value as the argument: java JavaHW4 value");
            return;
        }
        Integer val = Integer.parseInt(args[0]);
        System.out.println(new Add(
                new Subtract(
                        new Multiply(
                                new Variable("x"),
                                new Variable("x")
                        ),
                        new Multiply(new Variable("x"), new Const(3))
                ),
                new Const(4)
        ).evaluate(val));
    }
}
