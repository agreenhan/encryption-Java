package com.example.encryptionjava.VO;

import lombok.Data;

/**
 * @Description:
 * @Author: jht
 * @DATE: 2023/1/27 19:30
 */
@Data
public class EncryptionVO {
    private String key;
    private String plainText;
    private String cipherText;
}
