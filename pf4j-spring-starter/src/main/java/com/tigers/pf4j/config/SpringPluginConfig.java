package com.tigers.pf4j.config;

import com.tigers.pf4j.core.SpringPluginManagerAdapter;
import org.pf4j.PluginManager;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * {@code SpringPluginConfig}
 * 启动 starter 启动的配置
 * @author Tigers Leung
 * @version 1.0
 * @since 1.0
 */
@Configuration
@EnableConfigurationProperties(SpringPrefixPropertiesConfig.class)
public class SpringPluginConfig {

    /**
     * 装配管理者
     * @param springPrefixPropertiesConfig 通过配置文件信息进行自动装配
     * @return 返回一个有关 Spring 的PluginManager
     */
    @Bean
    public PluginManager pluginManager (SpringPrefixPropertiesConfig springPrefixPropertiesConfig)
    {
        Path path = Paths.get(springPrefixPropertiesConfig.getPath()) ;
        return new SpringPluginManagerAdapter(path) ;
    }
}
