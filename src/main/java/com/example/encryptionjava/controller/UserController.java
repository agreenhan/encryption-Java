package com.example.encryptionjava.controller;

import com.example.encryptionjava.VO.UserVO;
import com.example.encryptionjava.pojo.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description:
 * @Author: jht
 * @DATE: 2023/1/27 14:52
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(){
        return Result.success().data("token","admin");
    }

    //info
    @GetMapping("info")
    public Result info(){
        return Result.success().data("roles","[admin]").data("name","admin").data("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
    }
}
