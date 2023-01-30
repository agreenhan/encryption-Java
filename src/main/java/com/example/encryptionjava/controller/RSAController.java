package com.example.encryptionjava.controller;

import com.example.encryptionjava.common.utils.RSAUtil;
import com.example.encryptionjava.pojo.Result;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Description:
 * @Author: jht
 * @DATE: 2023/1/28 20:31
 */
@RestController
@RequestMapping("/rsa")
@CrossOrigin
public class RSAController {
    /**
     * @Description: 随机获取RSA的公钥和私钥
     * @Author: jht
     * @Date: 2023/1/28 20:32
     * @Return:
     */
    @RequestMapping(value = "/getKey", method = RequestMethod.GET)
    public Result getKey() throws Exception {
        Map<String, Object> keyMap = RSAUtil.initKey(1024);
        // 得到公钥字符串
        String publicKeyString = RSAUtil.getPublicKeyStr(keyMap);
        // 得到私钥字符串
        String privateKeyString = RSAUtil.getPrivateKeyStr(keyMap);
        return Result.success().data("privateKey", privateKeyString).data("publicKey", publicKeyString);
    }

    /**
     * @Description: RSA加密
     * @Author: jht
     * @Date: 2023/1/28 21:15
     * @Return:
     */
    @RequestMapping(value = "/encryption", method = RequestMethod.POST)
    public Result encryption(String publicKey, String source) {
        String outcome = RSAUtil.encrypt1(source, publicKey);
        return Result.success().data("outcome", outcome);
    }

    /**
     * @Description: RSA解密
     * @Author: jht
     * @Date: 2023/1/28 21:15
     * @Return:
     */
    @RequestMapping(value = "/deciphering", method = RequestMethod.POST)
    public Result deciphering(String privateKey, String source) {
        String outcome = RSAUtil.decrypt1(source, privateKey);
        return Result.success().data("outcome", outcome);
    }
}
