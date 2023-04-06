package com.tigers.pf4j;

import com.tigers.pf4j.core.SpringPluginNode;
import com.tigers.pf4j.exp.LoginException;
import org.pf4j.Extension;
import org.pf4j.PluginWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * {@code DefaultLoginService}
 * 默认的登陆服务插件
 * @author Tigers Leung
 * @version 1.0
 * @since 1.0
 */
public class DefaultUserService extends SpringPluginNode {

    private static final Logger logger = LoggerFactory.getLogger(DefaultUserService.class) ;

    private static Map<String, String> userInitMap ;

    public DefaultUserService(PluginWrapper wrapper) {
        super(wrapper);
    }


    /**
     * 开始前先保证用户初始化Map为空
     */
    @Override
    public void beforeBegin() {
        if (userInitMap != null)
        {
            userInitMap.clear() ;
            userInitMap = null ;
        }
    }

    /**
     *
     */
    @Override
    public void begin() {
        userInitMap = new HashMap<>() ;
        userInitMap.put("Leung", "123456") ;
    }

    @Extension
    public static class Login implements LoginService {
        /**
         * 对应的登陆
         *
         * @param username 用户名登陆
         * @param password 用户密码
         */
        @Override
        public UserContext login(String username, String password) {
            if (!userInitMap.containsKey(username))
                return null ;
            if (!userInitMap.get(username).equals(password))
                throw new LoginException("密码错误！");
            return UserContextFactory.defaultUserContext(username, password) ;
        }
    }
}
