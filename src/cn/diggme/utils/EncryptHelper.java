package cn.diggme.utils;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


/**
 * AES Encryption Helper
 *
 * @author Benny
 * @modified 2017-11-08
 * @copyright develop@diggme.cn
 * @lisence MIT
 */
public class EncryptHelper {

    /**
     * Encrypt
     *
     * @param key   String secret key
     * @param value String origin plain text
     * @return String base64 encryption data
     */
    public static String encrypt(String key, String value) {
        try {
            fixSecureWarning();

            IvParameterSpec iv = new IvParameterSpec(new byte[16]);
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CFB/NoPadding");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
            byte[] encrypted = cipher.doFinal(value.getBytes());

            revertSecureWarning();
            return Base64.encodeBase64String(encrypted);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * Decrypt
     *
     * @param key       String secret key
     * @param encrypted String base64 encryption data
     * @return String decrypted plain text
     */
    public static String decrypt(String key, String encrypted) {
        try {
            fixSecureWarning();

            IvParameterSpec iv = new IvParameterSpec(new byte[16]);
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CFB/NoPadding");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

            byte[] original = cipher.doFinal(Base64.decodeBase64(encrypted));

            revertSecureWarning();
            return new String(original);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    /**
     * Cipher class by default not allow encryption with a encrypt key size of more than 128 bits
     * Using reflection class to change the default setting on runtime
     */
    public static void fixSecureWarning() {
        java.lang.reflect.Field field = null;
        try {
            field = Class.forName("javax.crypto.JceSecurity").getDeclaredField("isRestricted");
            field.setAccessible(true);
            field.set(null, Boolean.FALSE);
        } catch (NoSuchFieldException | ClassNotFoundException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * For preventing more secure problems
     * Revert the default setting after invoke encrypt / decrypt methods
     */
    public static void revertSecureWarning() {
        java.lang.reflect.Field field = null;
        try {
            field = Class.forName("javax.crypto.JceSecurity").getDeclaredField("isRestricted");
            field.setAccessible(true);
            field.set(null, Boolean.TRUE);
        } catch (NoSuchFieldException | ClassNotFoundException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
