package advanced.homework1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class RecursiveWalk {

    private static final String noFileHash = "00000000000000000000000000000000";

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
                try {
                    File f = new File(line);
                    recursiveWalk(f, w, md);
                } catch (NoSuchFileException e) {
                    w.println(noFileHash + " " + line);
                }
            }
        } catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void recursiveWalk(File f, PrintWriter w, MessageDigest md) throws NullPointerException, IOException {
        Files.walk(Paths.get(f.getPath()))
                .filter(Files::isRegularFile)
                .forEach(y -> hashFile(y, w, md));
    }

    private static void hashFile(Path p, PrintWriter w, MessageDigest md) {
        File f = new File(String.valueOf(p));
        try {
            w.println(calcMd5(f, md) + " " + f.getPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String calcMd5(File f, MessageDigest md) throws IOException {
        // hashing the file content converted to bytecode
        byte[] mdBytes = md.digest(Files.readAllBytes(f.toPath()));
        // convert to hex before returning
        return javax.xml.bind.DatatypeConverter.printHexBinary(mdBytes);
    }

}
