package cn.chamas.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Tool {
    public static Boolean isEmpty(Object o){
        Boolean result = false;
        if(o == null || o.toString().isEmpty() || "null".equals(o.toString()) ||
                "undefined".equals(o) || "not defined".equals(o)){
            result = true;
        }
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
