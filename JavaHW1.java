import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Find md5 hash of list of files
 * @version 1.0     15/10/2016
 * @author vrom911
 */
public class JavaHW1 {
    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.out.println("Usage: java JavaHW1 fileName.txt");
            return;
        }
        try (BufferedReader inputBuf = new BufferedReader(new FileReader(new File(args[0])))){

            MessageDigest md = MessageDigest.getInstance("MD5");

            String fileName;
            while ((fileName = inputBuf.readLine()) != null && fileName.length() != 0) {
                System.out.println(fileName);
                File f = new File(fileName);

                System.out.println(calcFileMD5(md, f));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static String calcFileMD5(MessageDigest md, File f) throws IOException {
        try (FileInputStream fis = new FileInputStream(f)) {
            byte[] fileBArray = new byte[(int) f.length()];
            fis.read(fileBArray);
            // hashing the file content converted to bytecode
            byte[] mdbytes = md.digest(fileBArray);
            // convert to hex before returning
            return javax.xml.bind.DatatypeConverter.printHexBinary(mdbytes);
        }
    }
}

