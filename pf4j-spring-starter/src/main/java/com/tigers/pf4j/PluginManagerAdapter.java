package com.tigers.pf4j;


import org.pf4j.PluginManager;

/**
 * {@code PluginManagerAdapter}
 * 插件的管理者。为什么已经有了对应的 PluginManager {@link org.pf4j.PluginManager} 还需要一个管理中心呢？
 * 简单来说是为了方便扩展。
 * @author Tigers Leung
 * @version 1.0
 * @since 1.0
 */
public interface PluginManagerAdapter extends PluginManager {

    /**
     * 根据插件 id 注册插件到插件管理中。
     * 这里的注册必须要被扫描到，否则将会注册失败。
     * 详情可以参见: {@link org.pf4j.PluginManager#startPlugin(String)}。
     * 插件必须要先被加载才能被启动！
     * @param id 插件id
     */
    void registe (String id) ;

    /**
     * 根据插件id移除对应的插件
     * @param id 对应的插件id
     */
    void remove (String id) ;
}
