package toolbox;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class AES {

    private static final String _secKey = "abc";
    private static SecretKeySpec secretKey;

    private static void setKey(String myKey) {
        
        MessageDigest sha;

        try {

            byte[] key = myKey.getBytes(StandardCharsets.UTF_8);
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES");
        } catch (NoSuchAlgorithmException e) {

            e.printStackTrace();
        }
    }

    public static String encrypt(String str) {

        try {

            setKey(_secKey);

            // encode the string into bytes using utf-8
            byte[] utf8 = str.getBytes("UTF8");

            Cipher c = Cipher.getInstance("AES/ECB/PKCS5Padding");
            c.init(Cipher.ENCRYPT_MODE, secretKey);

            // encrypt
            byte[] enc = c.doFinal(utf8);

            // encode bytes to base64 to get a string
            //return new sun.misc.BASE64Encoder().encode(enc);

            return Base64.getUrlEncoder().encodeToString(enc);

        } catch (Exception e) {
            return null;
        }
    }

    public static String decrypt(String strToDecrypt) {
        try {

            setKey(_secKey);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getUrlDecoder().decode(strToDecrypt)));
        } catch (Exception e) {

            return null;
        }
    }
}