package com.example.library.service;

import com.example.library.common.ServerResponse;
import com.example.library.pojo.User;
import com.example.library.vo.UserVO;
import org.springframework.stereotype.Service;


public interface IUserService {

    ServerResponse login(String account,String password);

    ServerResponse register(UserVO userVO);

    User login(String account);

}
