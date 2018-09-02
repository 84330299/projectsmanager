package com.xxb.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.RandomStringGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

/**
 * 数字工具类
 *
 * @author dengchao
 * @date 2018/3/26
 */
public class NumberUtil {
    /**
     * 正则 所有非数字
     */
    private static Pattern NUMBER_PATTERN = Pattern.compile("[^0-9]*");

    /**
     * 生成纯数字的随机验证码
     *
     * @param number 确定生成多少位的随机数
     * @return String 生成好的随机数
     */
    public static String verificationCodeCreate(int number) {
        Random r = new Random();
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < number; i++) {
            s.append(r.nextInt(9));
        }
        return s.toString();
    }

    /**
     * 将用逗号拼接的字符串ids转成list<Integer>
     *
     * @param ids id串
     * @return List<Integer> 数字list集合
     */
    public static List<Integer> idList(String ids) {
        String[] idArry = ids.split(",");
        List<Integer> list = new ArrayList<>();
        for (String id : idArry) {
            list.add(Integer.parseInt(id));
        }
        return list;
    }

    /**
     * 生成字符数字的随机字符
     *
     * @param number 确定生成多少位的随机数
     * @return String 生成好的随机数
     */
    public static String randomString(int number) {
        RandomStringGenerator generator = new RandomStringGenerator.Builder().withinRange('0', 'z').build();
        return generator.generate(number);
    }


    /**
     * 判断是否包含 数字
     *
     * @param str 字符串
     * @return true 纯数字 false 包含数字
     */
    public static boolean isNumeric(String str) {
        return NUMBER_PATTERN.matcher(str).matches();
    }

    /**
     * 消除请求路径的数字参数
     *
     * @param str 请求路径
     * @return 消除数字后的请求参数
     */
    public static String eliminationNumbers(String str) {
        while (!isNumeric(str)) {
            str = str.replaceAll(StringUtils.substring(str, str.lastIndexOf("/")), "");
        }
        return str;
    }

    /**
     * 生成随机数
     *
     * @param length 表示生成字符串的长度
     * @return 消除数字后的请求参数
     */
    public static String getRandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 生成指定范围的随机数
     *
     * @param min 最小值
     * @param max 最大值
     * @return float 随机数
     */
    public static double rangeRandomMumber(double min, double max) {
        double doubleBounded = min + new Random().nextDouble() * (max - min);
        //保留两位小数
        double random = (double) Math.round(doubleBounded * 100) / 100;
        return random;
    }

    /**
     * 随机生成字符串
     *
     * @param length
     *            想要生成的长度
     * @return
     */
    public static String getSaltRandomString(int length) {
        return getRandomSaltString(length, "abcdefghijklmnopqrstuvwxyz");
    }

    /**
     * 随机生成字符串
     *
     * @param length
     *            想要生成的长度
     * @param base
     *            字符集
     * @return
     */
    public static String getRandomSaltString(int length, String base) {
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

}
