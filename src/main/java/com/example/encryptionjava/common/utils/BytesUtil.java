package com.example.encryptionjava.common.utils;

import cn.hutool.core.util.HexUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: byte数组转化为十六进制
 * @Author: jht
 * @DATE: 2023/1/28 16:10
 */
public class BytesUtil {
    /**
     * @Description: 将byte数组转化为十六进制字符串表示
     * @Author: jht
     * @Date: 2023/1/28 16:15
     * @Return:
     */
    public static String formBytesToHex(byte[] resultBytes) {
        StringBuilder builder = new StringBuilder();
        for (byte resultByte : resultBytes) {
            if (Integer.toHexString(0xFF & resultByte).length() == 1) {
                builder.append("0").append(Integer.toHexString(0xFF & resultByte));
            } else {
                builder.append(Integer.toHexString(0xFF & resultByte));
            }
        }
        return builder.toString();
    }

    /**
     * @Description: 用于128位密钥的格式验证
     * @Author: jht
     * @Date: 2023/1/28 16:38
     * @Return: true通过验证 false未通过
     */
    public static Boolean verifyKey(String key) {
        if (key == null || key.length() != 32) {
            return false;
        }
        key = key.toLowerCase();
        char[] chars = key.toCharArray();
        for (char aChar : chars) {
            if (aChar < 48 || aChar > 102) {
                return false;
            }
            if (aChar >= 58 && aChar <= 96) {
                return false;
            }
        }
        return true;
    }

    /**
     * @Description: 将十六进制字符串转换成byte数组
     * @Author: jht
     * @Date: 2023/1/28 19:30
     * @Return:
     */
    public static byte[] formHexToBytes(String key) {
        if (!verifyKey(key)) {
            return null;
        }
        byte[] bytes = new byte[key.length() / 2];
        char[] chars = key.toCharArray();
        for (int i = 0; i < chars.length; i = i + 2) {
            int high = Integer.parseInt(String.valueOf(chars[i]), 16);
            int low = Integer.parseInt(String.valueOf(chars[i + 1]), 16);
            bytes[i / 2] = (byte) (high * 16 + low);
        }
        return bytes;
    }
}
