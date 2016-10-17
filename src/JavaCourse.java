/**
 * Created by vrom911 on 10/17/16.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import JavaHW1.*;

public class JavaCourse {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java JavaCourse x \n where x - number of the hometask");
            return;
        }
        int taskNum = Integer.parseInt(args[0]);
        if (taskNum == 1) {
            Scanner sc = new Scanner(System.in);
            if (sc.hasNext()) {
//                File f = new File("JavaHW1/" + sc.toString());
                JavaHW1.solveHW1(sc.next());
            }
        }
    }

}
