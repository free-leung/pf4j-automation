package com.tigers.pf4j.config;

import com.tigers.pf4j.LoginService;
import org.pf4j.PluginManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * {@code BeanConfig}
 *
 * @author Tigers Leung
 * @version 1.0
 * @since 1.0
 */
@Configuration
public class BeanConfig {

    @Resource
    private PluginManager pluginManager ;

    @Bean
    public LoginService loginService ()
    {
        LoginService loginService = pluginManager.getExtensions(LoginService.class, "userService").get(0) ;
        return loginService ;
    }
}
