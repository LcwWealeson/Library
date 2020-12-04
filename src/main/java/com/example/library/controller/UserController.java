package com.example.library.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.library.common.ServerResponse;
import com.example.library.pojo.User;
import com.example.library.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService userService;

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

    @PostMapping("/addNewUser")
    public ServerResponse addNewUser(@RequestBody JSONObject jsonObject){
        String account = jsonObject.getString("account");
        String password = jsonObject.getString("password");
        String username = jsonObject.getString("username");
        Integer type = jsonObject.getInteger("type");
        User user = new User(account,password,username,type);
        return userService.addNewUser(user);
    }

    @PostMapping("/modifyUser")
    public ServerResponse modifyUser(@RequestBody User user){
         return userService.modifyUser(user);
    }

}
