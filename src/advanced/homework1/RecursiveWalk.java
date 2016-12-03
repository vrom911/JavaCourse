package advanced.homework1;

import java.io.*;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class RecursiveWalk {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Format: java RecursiveWalk <input> <output>");
            return;
        }
        File in = new File(args[0]);
        File out = new File(args[1]);
        try (
                BufferedReader r = new BufferedReader(new FileReader(in));
                PrintWriter w = new PrintWriter(new FileWriter(out))
        ) {
            MessageDigest md = MessageDigest.getInstance("md5");
            String line;
            while ((line = r.readLine()) != null) {
                File f = new File(line);
                recursiveWalk(f, w, md);
            }
        } catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void recursiveWalk(File f, PrintWriter w, MessageDigest md) throws NullPointerException, IOException {
        if (f.isDirectory()) {
            if (f.listFiles() != null) {
                for (File subf : f.listFiles()) {
                    recursiveWalk(subf, w, md);
                }
            }
        } else {
            w.println((f.exists() ? calcMd5(f, md) : "00000000000000000000000000000000") + " " + f.getPath());
        }
    }

    private static String calcMd5(File f, MessageDigest md) throws IOException {
        // hashing the file content converted to bytecode
        byte[] mdBytes = md.digest(Files.readAllBytes(f.toPath()));
        // convert to hex before returning
        return javax.xml.bind.DatatypeConverter.printHexBinary(mdBytes);
    }

}
