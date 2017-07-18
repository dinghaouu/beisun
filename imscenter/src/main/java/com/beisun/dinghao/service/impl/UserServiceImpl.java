package com.beisun.dinghao.service.impl;

import com.beisun.dinghao.mapper.UserMapper;
import com.beisun.dinghao.model.UserModel;
import com.beisun.dinghao.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by DingHao on 2017/7/11.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    private static final Logger log = LogManager.getLogger(UserService.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserModel queryUserByName(String userName) {
        log.info("查询用户登录信息");
        return userMapper.queryUserByName(userName);
    }

    @Override
    public Set<String> queryRolesByName(String userName) {
        log.info("查询用户授权信息");
        return userMapper.queryRolesByName(userName);
    }
}
