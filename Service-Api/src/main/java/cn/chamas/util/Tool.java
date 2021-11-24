package cn.chamas.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Tool {
    public static Boolean isEmpty(String arg){
        Boolean result = false;
        if (arg.isEmpty() ||  arg == null || "null".equals(arg) || "undefined".equals(arg))
            result = true;
        return result;
    }
    public static String md5Encrypt(String arg){
        String result;
        try {
            byte[] secretBytes = MessageDigest.getInstance("md5").digest(
                    arg.getBytes());
            result = new BigInteger(1, secretBytes).toString(16);
            for (int i = 0; i < 32 - result.length(); i++)
                result = "0" + result;
        } catch (NoSuchAlgorithmException e) {
            result = null;
        }
        return result;
    }
}
