package com.tigers.pf4j.config;

import com.tigers.pf4j.LoginService;
import org.pf4j.PluginManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * {@code BeanConfig}
 * 这里直接从 {@link PluginManager} 中拿，
 * 当然如果要动态加载，还需要一些更上层的封装了，暂时没有想到
 * 很好的办法。
 * @author Tigers Leung
 * @version 1.0
 * @since 1.0
 */
@Configuration
public class BeanConfig {

    @Resource
    private PluginManager pluginManager ;

    /**
     * 直接从 PluginManager 里面拿。
     * {@link com.tigers.pf4j.PluginManagerAdapter}
     * @return 返回 LoginService 的对应扩展。
     */
    @Bean
    public LoginService loginService ()
    {
        LoginService loginService = pluginManager.getExtensions(LoginService.class, "userService").get(0) ;
        return loginService ;
    }
}
