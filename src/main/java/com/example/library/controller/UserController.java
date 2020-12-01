package com.example.library.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.library.common.ServerResponse;
import com.example.library.service.IUserService;
import com.example.library.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService userService;

    /*@RequestMapping(value = "/login",method = RequestMethod.POST)
    public ServerResponse login(@RequestBody UserVO userVO){
        String account = userVO.getAccount();
        String password = userVO.getPassword();
        return userService.login(account,password);
    }

     */
     @PostMapping("/login")
    public ServerResponse login(@RequestBody JSONObject jsonObject){
         String account = jsonObject.getString("account");
         String password = jsonObject.getString("password");
         return userService.login(account,password);
     }

    @GetMapping("/getList")
    public ServerResponse getList(){
         return userService.getUserList();
    }

    @GetMapping("/resetPasswordByUserId")
    public ServerResponse resetPassword(Integer userId){
        return userService.resetPassword(userId);
    }

    @GetMapping("/removeByUserId")
    public ServerResponse removeUserById(Integer userId){
         return userService.removeUserById(userId);
    }

}
