package com.tigers.pf4j;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * {@code ErrLogHandler}
 * 错误日志处理者，可以将异常标准的打印的到当前的日志记录下：
 * Example:
 * <pre>
 *     ErrLogHandler.errToStr(xxException)
 * </pre>
 * @author Tigers Leung
 * @version 1.0
 * @since 1.0
 */
public class ErrLogHandler {

    public static String errToStr(Throwable e)
    {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        return sw.toString();
    }
}
