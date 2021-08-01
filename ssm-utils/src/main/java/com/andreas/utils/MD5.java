package com.andreas.utils;

import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

/**
 * 描述：md5加密算法
 */
public class MD5 {
    public final static String md5key = "Ms2";

    /**
     * MD5方法
     *
     * @param text 明文
     * @param key  密钥
     * @return 密文
     */

    public static String md5(String text, String key) {
        // 加密后的字符串
        byte[] bytes = (text + key).getBytes(StandardCharsets.UTF_8);
        return DigestUtils.md5DigestAsHex(bytes);
    }

    /**
     * MD5验证方法
     *
     * @param text 明文
     * @param key  密钥
     * @param md5  密文
     * @return true/false
     */
    public static Boolean verify(String text, String key, String md5) {
        String s = MD5.md5(text, key);
        if (s.equalsIgnoreCase(md5)) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        String lagou = MD5.md5("123456", "zhouqian");
        System.out.println(lagou);
        Boolean verify = MD5.verify("123456", "zhouqian", "3c6dfe9217535a31d0c010844109cf34");
        System.out.println(verify);
    }
}
