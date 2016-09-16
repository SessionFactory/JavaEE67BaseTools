/*
         至于怎么使用这个输出类呢?
         可以先在数据访问层接口中实现JavaEE65PrintSupport接口
         然后由数据访问层子类调用
     */
//region 代码示例
//===========================代码示例===========================
//interface BaseDAO extends qin.javaee65.core.JavaEE65PrintSupport
//{
//    //增删改查等方法
//}
//
//class BaseDAOImpl implements BaseDAO
//{
//    private String fileLocation;
//
//    private JavaEE65BasePrint jprint = new JavaEE65BasePrint(fileLocation);
//
//    /**
//     * 获取log4j配置文件路径
//     *
//     * @return 已获取文件路径
//     */
//    @Override
//    public String getLog4jLocations()
//    {
//        return jprint.getFileLocation();
//    }
//
//    /**
//     * 获取我的日志类
//     *
//     * @return 获取到的日志
//     */
//    @Override
//    public Logger getMyLogger()
//    {
//        return Logger.getLogger(BaseDAO.class);
//    }
//
//    @Override
//    public String getFileLocation()
//    {
//        return fileLocation;
//    }
//
//    /**
//     * 这些方法留给子类去调用
//     *
//     * @param fileLocation
//     */
//    @Override
//    public void setFileLocation(String fileLocation)
//    {
//        this.fileLocation = fileLocation;
//    }
//}
//===========================代码示例===========================
//endregion
package qin.javaee65.core;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Iterator;

/**
 * JavaEE6输出类支持
 *
 * @author qinzhengying
 * @since 1.6
 */
@SuppressWarnings("all")
public class JavaEE65BasePrint implements JavaEE65PrintSupport
{
    private static final long serialVersionUID = 5738947937680721007L;

    //region 私有化构造函数
    private JavaEE65BasePrint()
    {

    }
    //endregion

    //region 初始化路径变量
    private String fileLocation;

    @Override
    public String getFileLocation()
    {
        return fileLocation;
    }

    @Override
    public void setFileLocation(String fileLocation)
    {
        this.fileLocation = fileLocation;
    }

    public JavaEE65BasePrint(String fileLocation)
    {
        this.fileLocation = fileLocation;
    }
    //endregion

    //region 获取路径以及获取其日志类

    /**
     * 获取log4j配置文件路径
     *
     * @return 已获取文件路径
     */
    @Override
    public String getLog4jLocations()
    {
        return fileLocation;
    }

    /**
     * 获取我的日志类
     *
     * @return 获取到的日志
     */
    @Override
    public Logger getMyLogger()
    {
        return Logger.getLogger(JavaEE65BasePrint.class);
    }
    //endregion

    //region 输出功能

    //region 普通输出方法

    /**
     * 普通输出方法
     *
     * @param messages 任意想要输出的对象
     */
    public void custInfo(Object... messages)
    {
        for (int i = 0; i < messages.length; i++)
        {
            System.out.println("普通输出功能:" + messages[i] + "----------------------");
        }
    }
    //endregion

    //region 普通输出数组方法

    /**
     * 普通输出数组方法
     *
     * @param messages 任意想要输出的对象
     */
    public StringBuilder infoArray(Object... messages)
    {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < messages.length; i++)
        {
            result.append(messages[i] + "----------------------");
        }

        return result;
    }
    //endregion

    //region 输出任意信息

    /**
     * 输出任意信息<br>
     * 模拟<code>System.out.println();</code>
     *
     * @param messages 任意想要输出的参数
     */
    public void info(Object... messages)
    {
        for (int i = 0; i < messages.length; i++)
        {
            getMyLogger().info(messages[i] + "=====================");
        }
    }
    //endregion

    //region 打印任意类型集合

    /**
     * 打印任意类型集合
     *
     * @param tCollection
     */
    public <T> void printCollections(Collection<T>... tCollection)
    {
        for (int i = 0; i < tCollection.length; i++)
        {
            for (Iterator<T> it = tCollection[i].iterator(); it.hasNext(); )
            {
                superInfo(it.next() + str_equals);
            }
        }
    }
    //endregion

    //region 输出任意异常信息

    /**
     * 输出任意异常信息
     *
     * @param ex 所有异常
     */
    public void infoE(Exception ex)
    {
        superInfo("your exception is[" + ex + "]");
    }
    //endregion

    //region 超级输出方法

    /**
     * 超级输出方法
     *
     * @param messages 任意想要输出的对象
     */
    public void superInfo(Object... messages)
    {
        File file = new File(getLog4jLocations());

        if (!file.exists())
        {
            System.out.println(c_start + "log4j.properties配置文件不存在" + c_end);
            custInfo(messages);
        }
        else
        {
            //如果存在判断其内容是否为全注释
            try
            {
                //使用流来读取文件
                BufferedReader reader = new BufferedReader
                          (
                                    new InputStreamReader
                                              (
                                                        new FileInputStream(file), "utf-8"
                                              )
                          );

                String r = "";

                //读取文件中的所有内容
                for (String line = ""; (line = reader.readLine()) != null; )
                {
                    r += line + "\n";
                }

                if (r.contains("#log4j."))
                {
                    //如果log4j中是注解则使用普通注释
                    for (int i = 0; i < messages.length; i++)
                    {
                        custInfo(c_start + "" + messages[i] + c_end);
                    }
                }
                else
                {
                    for (int i = 0; i < messages.length; i++)
                    {
                        //如果log4j中没有注解则使用配置文件中的方式来打印
                        info(c_start + "" + messages[i] + c_end);
                    }
                }
            }
            catch (IOException e)
            {
                //Auto-generated catch block
                System.out.println(c_start + "" + e + c_end);
            }
        }
    }
    //endregion

    //endregion
}