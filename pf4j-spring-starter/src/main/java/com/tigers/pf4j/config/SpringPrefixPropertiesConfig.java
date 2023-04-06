package com.tigers.pf4j.config;

import com.tigers.pf4j.PropertiesConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * {@code SpringPrefixPropertiesConfig}
 * 关于 Spring 插件的配置信息。
 * 这里的 path 指的是插件的根路径，路径需要根据你在 application.yml 或者 properties 中进行配置.
 * Example about :
 * <pre>
 *     spring:
 *      pf4j:
 *       path: /xxx/xxx/
 * </pre>
 * <pre>
 *     spring:
 *      pf4j:
 *       path: /xxx/xxx/
 * </pre>
 * 额外的一些配置让你可选是否加载这个插件:
 * <pre>
 *     spring:
 *      pf4j:
 *       enabled: true
 * </pre>
 * @author Tigers Leung
 * @version 1.0
 * @since 1.0
 */
@ConfigurationProperties("spring.p4fj")
@ConditionalOnProperty(value = "spring.pf4j.enabled", havingValue = "true", matchIfMissing = true)
public class SpringPrefixPropertiesConfig implements PropertiesConfig {

    /**
     * 插件的路径
     */
    private String path ;

    /**
     * 插件是否开启
     */
    private boolean enable ;

    /**
     * set 方法
     * @param path 设置路径
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 是否启用插件？
     * @param enable true 为启用插件，false 为不启用
     */
    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    /**
     * 获取插件的地址
     *
     * @return 返回地址路径
     */
    @Override
    public String getPath() {
        return path;
    }

    /**
     * 是否启用插件，这里先这么写吧，其实应该有一个 插件的 上下文。
     *
     * @return true 表示启用插件，false 表示插件没有被启用
     */
    @Override
    public boolean isEnable() {
        return enable;
    }
}
