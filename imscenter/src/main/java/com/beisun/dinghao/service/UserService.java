package com.beisun.dinghao.service;

import com.beisun.dinghao.model.UserModel;

import java.util.Set;

/**
 * Created by DingHao on 2017/7/11.
 */
public interface UserService {
    public UserModel queryUserByName(String userName);

    public Set<String> queryRolesByName(String userName);

}
