package qin.javaee65.core;

import org.apache.log4j.Logger;

/**
 * JavaEE6最基础接口:(输出支持类)
 *
 * @author qinzhengying
 * @since 1.6(6.5)
 */
@SuppressWarnings("all")
public interface JavaEE65PrintSupport extends JavaEE6BaseSupport
{
    //region 获取log4j配置文件路径

    /**
     * 获取log4j配置文件路径
     *
     * @return 已获取文件路径
     */
    String getLog4jLocations();
    //endregion

    //region 获取我的日志类

    /**
     * 获取我的日志类
     *
     * @return 获取到的日志
     */
    Logger getMyLogger();
    //endregion

    //region 获取和设置我的log4j配置文件路径
    String getFileLocation();

    void setFileLocation(String fileLocation);
    //endregion
}
