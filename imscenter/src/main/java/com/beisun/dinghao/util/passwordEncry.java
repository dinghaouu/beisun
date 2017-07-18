package com.beisun.dinghao.util;

import com.beisun.dinghao.model.UserModel;
import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * Created by DingHao on 2017/7/12.
 */
public class passwordEncry {
    private PasswordService passwordService;
    private static RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
    //指定散列算法为md5
    private String algorithmName = "MD5";
    //散列迭代次数
    private final int hashIterations = 2;

    /**
     * 用户信息进行加盐
     * @param userModel
     * @return
     */
    public UserModel encrypt(UserModel userModel){
        userModel.setSalt(randomNumberGenerator.nextBytes().toHex());
        String newPassword = new SimpleHash(
                algorithmName,
                userModel.getPassword(),
                ByteSource.Util.bytes(userModel.getCredentialsSalt()),
                hashIterations).toHex();

        userModel.setPassword(newPassword);
        return userModel;
    }

}
