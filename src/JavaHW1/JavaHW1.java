package JavaHW1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by vrom911 on 10/17/16.
 */
public class JavaHW1 {

    public  static void solveHW1(String f) {
        try (BufferedReader inputBuf = new BufferedReader(new FileReader(new File("JavaHW1/" + f)))){
            System.out.println("hmm");
            MessageDigest md = MessageDigest.getInstance("MD5");
            String fileName;
            while ((fileName = inputBuf.readLine()) != null && fileName.length() != 0) {

                System.out.println(calcFileMD5(md, "JavaHW1/" + fileName));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static String calcFileMD5(MessageDigest md, String fPath) {
        Path path = Paths.get(fPath);
        byte[] fileBArray = new byte[0];
        try {
            fileBArray = Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(fileBArray);
        // hashing the file content converted to bytecode
        byte[] mdbytes = md.digest(fileBArray);
        // convert to hex before returning
        return javax.xml.bind.DatatypeConverter.printHexBinary(mdbytes);
    }
}
