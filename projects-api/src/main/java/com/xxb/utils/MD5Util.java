package com.xxb.utils;

import java.security.MessageDigest;

/**
 * @Author: Mr.Chen
 * @Date: 2018/7/9 17:59
 */
public class MD5Util {

    public static String getMD5ofStr(String origString) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] result = md5.digest(origString.getBytes());
            String origMD5 = byteArray2HexStr(result);
            return origMD5.toLowerCase();
        } catch (Exception var4) {
            var4.printStackTrace();
            return null;
        }
    }

    private static String byteArray2HexStr(byte[] bs) {
        StringBuilder sb = new StringBuilder();
        byte[] var2 = bs;
        int var3 = bs.length;

        for (int var4 = 0; var4 < var3; ++var4) {
            byte b = var2[var4];
            sb.append(byte2HexStr(b));
        }

        return sb.toString();
    }

    private static String byte2HexStr(byte b) {
        int n = b;
        if (b < 0) {
            n = b & 255;
        }

        String hexStr = Integer.toHexString(n / 16) + Integer.toHexString(n % 16);
        return hexStr.toUpperCase();
    }

    public static String getMD5ofStr(String origString, int times) {
        String md5 = getMD5ofStr(origString);

        for (int i = 0; i < times - 1; ++i) {
            md5 = getMD5ofStr(md5);
        }



        return md5;
    }

    public static boolean verifyPassword(String inputStr, String MD5Code) {
        return getMD5ofStr(inputStr).equals(MD5Code);
    }

    public static boolean verifyPassword(String inputStr, String MD5Code, int times) {
        return getMD5ofStr(inputStr, times).equals(MD5Code);
    }
}
