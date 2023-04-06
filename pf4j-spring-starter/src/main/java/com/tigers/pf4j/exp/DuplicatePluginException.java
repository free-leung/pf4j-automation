package com.tigers.pf4j.exp;

/**
 * {@code DuplicatePluginException}
 * 重复注册插件异常：
 * 造成原因是因为插件的id重复导致的，建议重新定义插件的 id
 * @author Tigers Leung
 * @version 1.0
 * @since 1.0
 */
public class DuplicatePluginException extends RuntimeException {

    /**
     * 对应的异常信息
     * @param message 异常信息可自定义化
     */
    public DuplicatePluginException(String message) {
        super(message);
    }
}
