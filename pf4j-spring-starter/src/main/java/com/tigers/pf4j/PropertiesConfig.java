package com.tigers.pf4j;

/**
 * {@code PropertiesConfig}
 * 通过可配置的管理寻找插件。
 * @author Tigers Leung
 * @version 1.0
 * @since 1.0
 */
public interface PropertiesConfig {

    /**
     * 获取插件的地址
     * @return 返回地址路径
     */
    String getPath() ;

    /**
     * 是否启用插件，这里先这么写吧，其实应该有一个 插件的 上下文。
     * @return true 表示启用插件，false 表示插件没有被启用
     */
    boolean isEnable () ;
}
