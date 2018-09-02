package com.xxb;

import com.xxb.utils.MpGenerator;

/**
 * @Author: Mr.Chen
 * @Date: 2018/7/4 10:03
 */
public class GeneratorApplication {
    public static void main(String[] args) {
        final String SAVE_PATH = "D:\\code\\";
        MpGenerator.generator("com/xxb", SAVE_PATH);
    }
}
