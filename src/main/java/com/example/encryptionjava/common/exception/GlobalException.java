package com.example.encryptionjava.common.exception;

import com.example.encryptionjava.pojo.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description:
 * @Author: jht
 * @DATE: 2023/1/28 20:36
 */
@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(Exception.class)
    public Result exceptionHandler(HttpServletRequest request, Exception exception) {
        String message =exception.getMessage()+request.getRequestURL().toString();
        exception.printStackTrace();
        return Result.failed().message(message);
    }
}
