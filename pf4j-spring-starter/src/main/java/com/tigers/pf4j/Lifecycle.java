package com.tigers.pf4j;

/**
 * {@code Lifecycle}
 * 插件的生命周期:
 * 在插件启动前你需要实现对应的 {@link #beforeBegin()} 方法，通常在这里先清洗插件，做一些保险判断操作。
 * 在插件启动的时候你需要实现对应的 {@link #begin()} 方法，通常在这里就是对插件内部的一些数据做初始化操作。
 * 插件关闭前：{@link #beforeEnd()}。
 * 插件 '料理后事' : {@link #ended()}。
 * @author Tigers Leung
 * @version 1.0
 * @since 1.0
 */
public interface Lifecycle {

    /**
     * 插件启动前
     */
    void beforeBegin () ;

    /**
     * 启动的时候
     */
    void begin () ;

    /**
     * 结束前
     */
    void beforeEnd () ;

    /**
     * 料理后事
     */
    void ended () ;
}
