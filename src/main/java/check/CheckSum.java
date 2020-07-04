package check;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CheckSum {

    private static final String ALGORITHM = "SHA-256";

    public static String getFileChecksum(File file){

        StringBuilder sb = new StringBuilder();

        try(FileInputStream input = new FileInputStream(file)){
            MessageDigest messageDigest = MessageDigest.getInstance(ALGORITHM);
            byte[] byteArray = new byte[2048];
            int counter = 0;
            while ((counter = input.read(byteArray)) != -1) {
                messageDigest.update(byteArray, 0, counter);
            }
            byte[] fileBytes = messageDigest.digest();
            for (byte fileByte : fileBytes) {
                sb.append(Integer.toString((fileByte & 0xff) + 0x100, 16).substring(1));
            }
        }catch (IOException | NoSuchAlgorithmException io){
            io.printStackTrace();
        }
        return sb.toString();
    }

}
