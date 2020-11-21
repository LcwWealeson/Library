package com.example.library.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.library.common.ServerResponse;
import com.example.library.pojo.User;
import com.example.library.service.IUserService;
import com.example.library.vo.UserVO;
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
    public JSONObject login(@RequestBody JSONObject jsonObject){
         String account = jsonObject.getString("account");
         String password = jsonObject.getString("password");
         User user = userService.login(account);
         JSONObject jsonObject1 = (JSONObject)JSONObject.toJSON(user);
         return jsonObject1;
     }


}
