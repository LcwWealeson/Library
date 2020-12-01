package com.example.library.service.impl;

import com.example.library.common.ServerResponse;
import com.example.library.dao.UserMapper;
import com.example.library.pojo.User;
import com.example.library.service.IUserService;
import com.example.library.utils.MD5Util;
import com.example.library.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public ServerResponse login(String account, String password) {
        String Md5password = MD5Util.MD5(password);
        User user = userMapper.selectUserByAccount(account);
        if(user==null) {
            return ServerResponse.createByErrorMessage("查不到此用户");
        }
        else if(!Md5password.equals(user.getPassword())){
            return ServerResponse.createByErrorMessage("账户或密码错误");
        }
        user.setPassword("你看尼玛呢！");
        return ServerResponse.createBySuccessMessage("登陆成功",user);
    }

    @Override
    public ServerResponse register(UserVO userVO) {
        return null;
    }

    @Override
    public ServerResponse getUserList() {
        List<User> userList = userMapper.selectUserByTypeIs1();
        return ServerResponse.createBySuccessMessage("查询成功",userList);
    }

    @Override
    public ServerResponse resetPassword(Integer userId) {
        userMapper.resetPwdToDefault(userId,MD5Util.MD5("123"));
        return ServerResponse.createBySuccessMessage("重置密码成功，密码是：123");
    }

    @Override
    public ServerResponse removeUserById(Integer userId) {
        userMapper.removeUserById(userId);
        return ServerResponse.createBySuccessMessage("移除用户信息成功，用户id :"+userId);
    }
}
