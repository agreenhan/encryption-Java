package com.example.encryptionjava.pojo;

import com.example.encryptionjava.common.constant.HttpStates;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 通用结果返回类
 * @Author: jht
 * @DATE: 2023/1/27 14:58
 */
@Data
public class Result<T> {
    private Integer code;
    private String message;
    private Map<String, Object> data = new HashMap<>();

    private Result() {
    }

    public static Result success() {
        Result result = new Result();
        result.setCode(HttpStates.SUCCESS.getCode());
        result.setMessage(HttpStates.SUCCESS.getMessage());
        return result;
    }

    public static Result failed() {
        Result result = new Result();
        result.setCode(HttpStates.FAILED.getCode());
        result.setMessage(HttpStates.FAILED.getMessage());
        return result;
    }

    public Result message(String message) {
        this.setMessage(message);
        return this;
    }

    public Result code(Integer code) {
        this.setCode(code);
        return this;
    }

    public Result data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    public Result data(Map<String, Object> map) {
        this.setData(map);
        return this;
    }
}
