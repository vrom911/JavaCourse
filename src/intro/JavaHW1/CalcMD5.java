package intro.JavaHW1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class CalcMD5 {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java JavaCourse input.txt");
            return;
        }
        solveHW1(args[0]);
    }

    public static void solveHW1(String f) {
        try (BufferedReader inputBuf = new BufferedReader(new FileReader(new File("JavaHW1/" + f)))){
            MessageDigest md = MessageDigest.getInstance("MD5");
            String fileName;
            while ((fileName = inputBuf.readLine()) != null && fileName.length() != 0) {

                System.out.println(calcFileMD5(md, "JavaHW1/" + fileName));
            }
        } catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
        }
    }
    private static String calcFileMD5(MessageDigest md, String fPath) throws IOException {
        // hashing the file content converted to bytecode
        byte[] mdbytes = md.digest(Files.readAllBytes(Paths.get(fPath)));
        // convert to hex before returning
        return javax.xml.bind.DatatypeConverter.printHexBinary(mdbytes);
    }
}
