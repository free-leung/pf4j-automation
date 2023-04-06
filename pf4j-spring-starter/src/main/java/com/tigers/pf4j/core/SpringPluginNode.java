package com.tigers.pf4j.core;

import com.tigers.pf4j.Lifecycle;
import org.pf4j.Plugin;
import org.pf4j.PluginManager;
import org.pf4j.PluginWrapper;
import org.pf4j.spring.SpringPlugin;
import org.pf4j.spring.SpringPluginManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;

/**
 * {@code SpringPluginNode}
 * SpringPlugin 基础父类，所有的插件都要继承这个类，以确保你的插件可以正常的注册到 spring 容器里面。
 * 这里目前是最基础的写法，后期可能要根据一些特殊操作重写一些东西。
 * @author Tigers Leung
 * @version 1.0
 * @since 1.0
 */
public abstract class SpringPluginNode extends Plugin implements Lifecycle {

    private final static Logger logger = LoggerFactory.getLogger(SpringPlugin.class) ;

    /**
     * Spring context.
     */
    private ApplicationContext appContext ;

    /**
     * 注入一个插件 Wrapper
     * @param wrapper 传入对应的Wrapper，详情查看: {@link PluginWrapper}
     */
    public SpringPluginNode(PluginWrapper wrapper) {
        super(wrapper);
    }

    /**
     * 控制插件的生命周期，有些插件可能需要做一些特殊的启动配置，
     * 这里是对其做一些保留操作。
     * 插件的生命周期可以查看接口: {@link Lifecycle}
     */
    @Override
    public void start() {
        // 创建一个默认的 Spring Context
        if (appContext == null)
            appContext = createDefaultAppContext() ;
        logger.info("准备启动插件： ----- {}", this.getClass().getSimpleName());
        this.beforeBegin() ;
        this.begin() ;
        String pluginClass = getWrapper().getDescriptor().getPluginClass();
        if (!appContext.containsBean(pluginClass)) {
            ((DefaultListableBeanFactory) appContext.getAutowireCapableBeanFactory()).destroySingleton(pluginClass);
        }
        logger.info("插件启动完成： ----- {}", this.getClass().getSimpleName());
    }

    /**
     * 插件的停止操作，在结束前将会先后调用生命周期中 {@link #beforeEnd()} 和{@link #ended()} 方法，
     * 实现你对插件的优雅关闭操作。
     */
    @Override
    public void stop() {
        logger.info("准备关闭插件： ----- {}", this.getClass().getSimpleName());
        this.beforeEnd() ;
        this.ended() ;
        /**
         * 销毁 appContext.
         */
        if (appContext != null)
            appContext = null ;
        logger.info("优雅退出插件： ----- {}", this.getClass().getSimpleName());
    }

    @Override
    public void delete() {
        super.delete() ;
    }

    /**
     * 创建一个默认的 Spring Application Context.
     * @return 返回一个 Spring Application Context.
     */
    protected ApplicationContext createDefaultAppContext ()
    {
        PluginManager pluginManager = getWrapper().getPluginManager() ;
        if (pluginManager instanceof SpringPluginManager) {
            return ((SpringPluginManager) pluginManager).getApplicationContext();
        }
        return null ;
    }

    /**
     * 插件启动前
     */
    @Override
    public void beforeBegin() {

    }

    /**
     * 启动的时候
     */
    @Override
    public void begin() {

    }

    /**
     * 结束前
     */
    @Override
    public void beforeEnd() {

    }

    /**
     * 料理后事
     */
    @Override
    public void ended() {
        String pluginClass = getWrapper().getDescriptor().getPluginClass();
        if (appContext.containsBean(pluginClass)) {
            ((DefaultListableBeanFactory) appContext.getAutowireCapableBeanFactory()).destroySingleton(pluginClass);
        } else {
            log.debug("No plugin bean found with class '{}'", pluginClass);
        }
    }
}
