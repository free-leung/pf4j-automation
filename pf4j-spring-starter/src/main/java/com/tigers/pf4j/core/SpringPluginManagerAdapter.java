package com.tigers.pf4j.core;

import com.tigers.pf4j.PluginManagerAdapter;
import org.pf4j.PluginWrapper;
import org.pf4j.spring.SpringPluginManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * {@code SpringPluginManagerAdapter}
 * 有关 SpringPlugin 的插件管理者适配器，
 * 对原有的 SpringPluginManager 进行一些特殊扩展，
 * 这里提供了一个对应的插件容器：{@link #pluginMap}，暂时是 put 对应的 {@link PluginWrapper}，
 * 后期可以扩展一个特殊的 PluginContext 出来，降低 pf4j-spring 的使用成本。
 * @author Tigers Leung
 * @version 1.0
 * @since 1.0
 */
public class SpringPluginManagerAdapter extends SpringPluginManager implements PluginManagerAdapter {

    /**
     * 提供日志控制
     */
    private static final Logger logger = LoggerFactory.getLogger(SpringPluginManagerAdapter.class) ;

    /**
     * 内置插件存储器
     * 降低调用插件的门槛，使用适配器实现即可
     */
    private final Map<String, PluginWrapper> pluginMap = new ConcurrentHashMap<>() ;

    /**
     * 无参的构造方法
     */
    public SpringPluginManagerAdapter() {
    }

    /**
     * 根据插件路径创建插件管理者
     * @param pluginsRoots 根目录组
     */
    public SpringPluginManagerAdapter(Path... pluginsRoots) {
        super(pluginsRoots);
    }

    /**
     * 根据 List 路径创建插件管理者
     * @param pluginsRoots list类型的路径组
     */
    public SpringPluginManagerAdapter(List<Path> pluginsRoots) {
        super(pluginsRoots);
    }

    /**
     * 根据插件 id 注册插件到插件管理中。
     * 这里的注册必须要被扫描到，否则将会注册失败。
     * 详情可以参见: {@link org.pf4j.PluginManager#startPlugin(String)}。
     * 插件必须要先被加载才能被启动！
     * @param id 插件id
     */
    @Override
    public void registe(String id) {
        if (!pluginMap.containsKey(id) && this.getPlugin(id) != null) {
            pluginMap.put(id, this.getPlugin(id)) ;
            this.startPlugin(id) ;
            return ;
        }
        logger.error("Duplicate to register plugin : {}", id);
    }

    /**
     * 根据插件id移除对应的插件
     * @param id 对应的插件 id
     */
    @Override
    public void remove(String id) {
        if (!pluginMap.containsKey(id) && this.getPlugin(id) != null) {
            /**
             * 先停止，对应的插件再移除对应的插件内容
             */
            this.stopPlugin(id) ;
            this.deletePlugin(id) ;
            pluginMap.remove(id, this.getPlugin(id)) ;
            return ;
        }
        logger.error("Unknow plugin about : {}", id);
    }
}
