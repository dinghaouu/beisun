package com.beisun.dinghao.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by DingHao on 2017/7/11.
 */
public class UserModel {
    @Getter
    @Setter
    public String id;

    @Getter
    @Setter
    public String userName;

    @Getter
    @Setter
    public String password;

    @Getter
    @Setter
    public String registrydate;

    @Getter
    @Setter
    public String status;

    @Getter
    @Setter
    public String salt;

    /**
     * 密码盐
     * @return
     */
    public String getCredentialsSalt(){
        return this.userName+this.salt;
    }
}
