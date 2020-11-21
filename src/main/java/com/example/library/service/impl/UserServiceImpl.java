package com.example.library.service.impl;

import com.example.library.common.ServerResponse;
import com.example.library.dao.UserMapper;
import com.example.library.pojo.User;
import com.example.library.service.IUserService;
import com.example.library.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public ServerResponse login(String account, String password) {
        User user = userMapper.selectUserByAccount(account);
        if(user!=null) {
            return ServerResponse.createBySuccess(user);
        }
        return ServerResponse.createByErrorMessage("查不到此用户");
    }

    @Override
    public ServerResponse register(UserVO userVO) {
        return null;
    }

    @Override
    public User login(String account) {
        User user = userMapper.selectUserByAccount(account);
        if(user!=null){
            return user;
        }
        return null;
    }
}
