package com.tigers.pf4j;

import org.pf4j.ExtensionPoint;

/**
 * {@code LoginService}
 * 登陆服务
 * @author Tigers Leung
 * @version 1.0
 * @since 1.0
 */
public interface LoginService extends ExtensionPoint {

    /**
     * 对应的登陆
     * @param username 用户名登陆
     * @param password 用户密码
     */
    UserContext login (String username, String password) ;
}
