package com.example.encryptionjava.controller;

import com.example.encryptionjava.common.utils.AESUtil;
import com.example.encryptionjava.common.utils.BytesUtil;
import com.example.encryptionjava.pojo.Result;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * @Description: AES加密与解密控制层
 * @Author: jht
 * @DATE: 2023/1/27 19:31
 */
@RestController
@RequestMapping("/aes")
@CrossOrigin
public class AESController {
    /**
     * @Description: 获取随机128位密钥
     * @Author: jht
     * @Date: 2023/1/28 16:47
     * @Return:
     */
    @RequestMapping(value = "/getAESKey", method = RequestMethod.GET)
    public Result getAESKey() throws Exception {
        byte[] aesKey = AESUtil.initKey();
        String key = BytesUtil.formBytesToHex(aesKey);
        return Result.success().data("key", key);
    }

    /**
     * @Description: AES加密
     * @Author: jht
     * @Date: 2023/1/28 19:48
     * @Return:
     */
    @RequestMapping(value = "/encryption", method = RequestMethod.POST)
    public Result encryption(String key, String source) throws Exception {
        // 用户未输入密钥则随机生成
        if (key == null) {
            byte[] aesKey = AESUtil.initKey();
            key = BytesUtil.formBytesToHex(aesKey);
        }
        // 验证密钥是否合法
        if (!BytesUtil.verifyKey(key)) {
            return Result.failed().message("请输入合法的密钥！");
        }
        byte[] aesKey = BytesUtil.formHexToBytes(key);
        // AES加密
        byte[] cipher = AESUtil.encryptAES(source.getBytes(), aesKey);
        String outcome = BytesUtil.formBytesToHex(cipher);
        return Result.success().data("outcome", outcome).data("key", key);
    }

    /**
     * @Description: AES解密
     * @Author: jht
     * @Date: 2023/1/28 19:48
     * @Return:
     */
    @RequestMapping(value = "/deciphering", method = RequestMethod.POST)
    public Result deciphering(String key, String source) {
        // 验证密钥是否合法
        if (!BytesUtil.verifyKey(key)) {
            return Result.failed().message("请输入合法的密钥！");
        }
        //解密
        byte[] plain;
        byte[] sourceBytes = BytesUtil.formHexToBytes(source);
        byte[] keyBytes = BytesUtil.formHexToBytes(key);
        try {
            plain = AESUtil.decryptAES(sourceBytes, keyBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failed().message("解密失败，请确认密钥于密文无误！");
        }
        return Result.success().data("outcome", new String(plain));
    }
}
