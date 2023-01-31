package com.example.encryptionjava.controller;

import com.example.encryptionjava.common.utils.MD5Util;
import com.example.encryptionjava.pojo.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * @Description:
 * @Author: jht
 * @DATE: 2023/1/31 9:18
 */
@RestController
@RequestMapping("/md5")
@CrossOrigin
public class MD5Controller {
    @RequestMapping(value = "encryption", method = RequestMethod.POST)
    public Result encryption(String source) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        if (StringUtils.isBlank(source)) {
            return Result.failed().message("请输入正确明文！");
        }
        String outcome = MD5Util.getEncryptedPwd(source);
        return Result.success().data("outcome", outcome);
    }
}
