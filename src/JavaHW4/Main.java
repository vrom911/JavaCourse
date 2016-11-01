package JavaHW4;

/**
 * Created by vrom911 on 10/31/16.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(new Subtract(
                new Multiply(
                        new Const(2),
                        new Variable("x")
                ),
                new Const(3)
        ).evaluate(5));
    }
}
