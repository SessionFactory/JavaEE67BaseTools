package qin.javaee65.core;

import org.hibernate.SessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import qin.javaee65.exceptions.IdNotSerializableException6;
import qin.javaee65.exceptions.JavaEE6Exception;

import javax.servlet.ServletResponse;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import static java.util.Collections.EMPTY_LIST;
import static java.util.UUID.randomUUID;

/**
 * 由于此项目使用的是jdk1.6所以此类是模拟jdk1.7中的Objects的功能
 *
 * @author qinzhengying
 * @since 1.6
 */
@SuppressWarnings("all")
public class Objects extends JavaEE65BasePrint
{
    private final long serialVersionUID = -822207947738237834L;

    //region 使用自己的配置文件路径
    public Objects(String fileLocation)
    {
        super(fileLocation);
    }
    //endregion

    //region copy from jdk1.7

    //region equals

    /**
     * Returns {@code true} if the arguments are equal to each other
     * and {@code false} otherwise.
     * Consequently, if both arguments are {@code null}, {@code true}
     * is returned and if exactly one argument is {@code null}, {@code
     * false} is returned.  Otherwise, equality is determined by using
     * the {@link Object#equals equals} method of the first
     * argument.
     *
     * @param a an object
     * @param b an object to be compared with {@code a} for equality
     * @return {@code true} if the arguments are equal to each other
     * and {@code false} otherwise
     * @see Object#equals(Object)
     */
    public boolean equals(Object a, Object b)
    {
        return (a == b) || (a != null && a.equals(b));
    }
    //endregion

    //region hashCode

    /**
     * Returns the hash code of a non-{@code null} argument and 0 for
     * a {@code null} argument.
     *
     * @param o an object
     * @return the hash code of a non-{@code null} argument and 0 for
     * a {@code null} argument
     * @see Object#hashCode
     */
    public int hashCode(Object o)
    {
        return o != null ? o.hashCode() : 0;
    }
    //endregion

    //region hash

    /**
     * Generates a hash code for a sequence of input values. The hash
     * code is generated as if all the input values were placed into an
     * array, and that array were hashed by calling {@link
     * Arrays#hashCode(Object[])}.
     * <p>
     * <p>This method is useful for implementing {@link
     * Object#hashCode()} on objects containing multiple fields. For
     * example, if an object that has three fields, {@code x}, {@code
     * y}, and {@code z}, one could write:
     * <p>
     * <blockquote><pre>
     * &#064;Override public int hashCode() {
     *     return Objects.hash(x, y, z);
     * }
     * </pre></blockquote>
     * <p>
     * <b>Warning: When a single object reference is supplied, the returned
     * value does not equal the hash code of that object reference.</b> This
     * value can be computed by calling {@link #hashCode(Object)}.
     *
     * @param values the values to be hashed
     * @return a hash value of the sequence of input values
     * @see Arrays#hashCode(Object[])
     * @see List#hashCode
     */
    public int hash(Object... values)
    {
        return Arrays.hashCode(values);
    }
    //endregion

    //region toString

    /**
     * Returns the result of calling {@code toString} for a non-{@code
     * null} argument and {@code "null"} for a {@code null} argument.
     *
     * @param o an object
     * @return the result of calling {@code toString} for a non-{@code
     * null} argument and {@code "null"} for a {@code null} argument
     * @see Object#toString
     * @see String#valueOf(Object)
     */
    public String toString(Object o)
    {
        return String.valueOf(o);
    }
    //endregion

    //region String toString(Object o, String nullDefault)

    /**
     * Returns the result of calling {@code toString} on the first
     * argument if the first argument is not {@code null} and returns
     * the second argument otherwise.
     *
     * @param o           an object
     * @param nullDefault string to return if the first argument is
     *                    {@code null}
     * @return the result of calling {@code toString} on the first
     * argument if it is not {@code null} and the second argument
     * otherwise.
     * @see Objects#toString(Object)
     */
    public String toString(Object o, String nullDefault)
    {
        return (o != null) ? o.toString() : nullDefault;
    }
    //endregion

    //region compare

    /**
     * Returns 0 if the arguments are identical and {@code
     * c.compare(a, b)} otherwise.
     * Consequently, if both arguments are {@code null} 0
     * is returned.
     * <p>
     * <p>Note that if one of the arguments is {@code null}, a {@code
     * NullPointerException} may or may not be thrown depending on
     * what ordering policy, if any, the {@link Comparator Comparator}
     * chooses to have for {@code null} values.
     *
     * @param <T> the type of the objects being compared
     * @param a   an object
     * @param b   an object to be compared with {@code a}
     * @param c   the {@code Comparator} to compare the first two arguments
     * @return 0 if the arguments are identical and {@code
     * c.compare(a, b)} otherwise.
     * @see Comparable
     * @see Comparator
     */
    public <T> int compare(T a, T b, Comparator<? super T> c)
    {
        return (a == b) ? 0 : c.compare(a, b);
    }
    //endregion

    //region requireNonNull

    /**
     * Checks that the specified object reference is not {@code null}. This
     * method is designed primarily for doing parameter validation in methods
     * and constructors, as demonstrated below:
     * <blockquote><pre>
     * public Foo(Bar bar) {
     *     this.bar = Objects.requireNonNull(bar);
     * }
     * </pre></blockquote>
     *
     * @param obj the object reference to check for nullity
     * @param <T> the type of the reference
     * @return {@code obj} if not {@code null}
     * @throws NullPointerException if {@code obj} is {@code null}
     */
    public <T> T requireNonNull(T obj)
    {
        if (obj == null)
        {
            throw new NullPointerException();
        }
        return obj;
    }
    //endregion

    //region requireNonNull

    /**
     * Checks that the specified object reference is not {@code null} and
     * throws a customized {@link NullPointerException} if it is. This method
     * is designed primarily for doing parameter validation in methods and
     * constructors with multiple parameters, as demonstrated below:
     * <blockquote><pre>
     * public Foo(Bar bar, Baz baz) {
     *     this.bar = Objects.requireNonNull(bar, "bar must not be null");
     *     this.baz = Objects.requireNonNull(baz, "baz must not be null");
     * }
     * </pre></blockquote>
     *
     * @param obj     the object reference to check for nullity
     * @param message detail message to be used in the event that a {@code
     *                NullPointerException} is thrown
     * @param <T>     the type of the reference
     * @return {@code obj} if not {@code null}
     * @throws NullPointerException if {@code obj} is {@code null}
     */
    public <T> T requireNonNull(T obj, String message)
    {
        if (obj == null)
        {
            throw new NullPointerException(message);
        }
        return obj;
    }
    //endregion

    //endregion

    //region 工具类

    //region 检测程序是否成功运行

    /**
     * 检测程序是否成功运行
     *
     * @param flag 控制层标记
     */
    public final void doCheck(boolean flag)
    {
        if (flag)
        {
            superInfo("程序运行成功");
        }
        else
        {
            superInfo("程序运行失败");
        }
    }
    //endregion

    //region 生成从前台传值到后台接收值代码

    /**
     * 生成从前台传值到后台接收值代码
     *
     * @param preStr         预先定义的变量
     * @param parameterNames 参数值
     */
    public final void doRequestCode(String[] preStr, String[] parameterNames)
    {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < preStr.length; i++)
        {
            sb.append("String ")
                      .append(preStr[i])
                      .append(" = null;")
                      .append("\n");
        }

        sb.append("\n");

        for (int i = 0; i < preStr.length; i++)
        {
            sb.append(preStr[i])
                      .append(" = request.getParameter(\"")
                      .append(parameterNames[i])
                      .append("\").trim();")
                      .append("\n");
        }

        sb.append("\n");

        superInfo(sb.toString());
    }
    //endregion

    //region 检测给定的字符串是否为空

    /**
     * 检测给定的字符串是否为空
     *
     * @param inputName    需要检测的字符串
     * @param exceptionMsg 异常信息
     * @throws JavaEE6Exception 需要抛出异常
     */
    public final void isNULL(String[] inputName, String[] exceptionMsg) throws JavaEE6Exception
    {
        for (int i = 0; i < inputName.length; i++)
        {
            if (inputName[i] == "" || inputName[i] == null)
            {
                throw new JavaEE6Exception(exceptionMsg[i]);
            }
        }
    }
    //endregion

    //region 定义常用变量
    /**
     * 成功
     */
    public final String success = "success";

    /**
     * 失败
     */
    public final String failed = "failed";

    /**
     * 空集合
     */
    public final List empty = EMPTY_LIST;
    //endregion

    //region 判断主键是否为Serializable类型

    /**
     * 判断主键是否为Serializable类型
     *
     * @param id 任意类型主键
     * @return 如果是Serializable返回true, 否则返回false
     */
    public final boolean checkId(Object id) throws IdNotSerializableException6
    {
        if (id instanceof Serializable)
        {
            return true;
        }
        else
        {
            throw new IdNotSerializableException6("主键类型不是Serializable类型!");
        }
    }
    //endregion

    //region 检查实体类是否为空

    /**
     * 检查实体类是否为空
     *
     * @param tClass 任意实体类
     * @param <T>    任意参数实体类
     * @return 不为空返回true, 否则抛出异常
     * @throws ClassNotFoundException 类不存在抛出异常
     */
    public final <T> boolean checkClass(Class<T> tClass) throws ClassNotFoundException
    {
        if (tClass == null)
        {
            throw new ClassNotFoundException("实体类为空!");
        }
        else
        {
            return true;
        }
    }
    //endregion

    //region 检测实体对象是否为空

    /**
     * 检测实体对象是否为空
     *
     * @param object 需要被检测的对象
     * @return 不为空返回true, 为空返回false
     */
    public final boolean checkObject(Object object)
    {
        if (object == null)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    //endregion

    //region returnJson

    /**
     * 前台Action层返回数据
     *
     * @param baseStr
     * @param response
     */
    public void returnJson(String baseStr, ServletResponse response)
    {
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = null;
        //捕获异常和finally块是IO标准代码的编写方式
        try
        {
            out = response.getWriter();
            out.print(baseStr);
            out.flush();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (out != null)
            {
                out.close();
            }
        }
    }
    //endregion

    //region since20160811

    //region 输出需要保存或更新的实体类信息

    /**
     * 拼接保存信息字符串
     *
     * @param entity     任意实体
     * @param operations 操作
     * @param <T>        任意类型
     * @return 已拼接的字符串信息
     */
    private static final <T> StringBuilder appendEntity(T entity, String operations)
    {
        return new StringBuilder()
                  .append(operations)
                  .append("的实体信息为:")
                  .append(c_start)
                  .append(entity)
                  .append(c_end);
    }

    /**
     * 输出需要保存或更新的实体类信息
     *
     * @param entity                 任意实体
     * @param doSaveOrUpdateOrDelete 新增, 删除, 更新
     * @param <T>                    任意类型
     */
    public final <T> void printEntity(T entity, String doSaveOrUpdateOrDelete)
    {
        //参数为保存
        if (doSaveOrUpdateOrDelete == str_save)
        {
            superInfo(appendEntity(entity, "保存"));
        }
        //参数为更新
        else if (doSaveOrUpdateOrDelete == str_update)
        {
            superInfo(appendEntity(entity, "更新"));
        }
        //参数为删除
        else if (doSaveOrUpdateOrDelete == str_delete)
        {
            superInfo(appendEntity(entity, "删除"));
        }
    }
    //endregion

    //region 拼接字符串

    /**
     * 拼接字符串
     *
     * @param arrays 数组
     * @return 已拼接的字符串
     */
    public final StringBuilder doAppendArrays(Object[] arrays)
    {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arrays.length; i++)
        {
            sb.append(arrays[i]).append("\t");
        }

        return sb;
    }
    //endregion

    //endregion

    //region since20160823

    //region 转换时间

    /**
     * 转换时间
     *
     * @param year  年
     * @param month 月
     * @param days  日
     * @return
     */
    public final Date getTime(int year, int month, int days)
    {
        Calendar c = Calendar.getInstance();
        c.set(year, month, days);
        return c.getTime();
    }
    //endregion

    //region 获取随机字符串

    /**
     * 获取随机字符串
     *
     * @return 已获取的随机字符串
     */
    public String getRandomString()
    {
        return randomUUID().toString();
    }
    //endregion

    //endregion

    //region easyui工具库

    //region 自动生成easyui-datagrid代码

    /**
     * 生成easyui-datagrid的网页代码
     *
     * @param table_id      表格id
     * @param url           需要执行的url
     * @param width         表格宽度
     * @param height        表格高度
     * @param is_rownumbers 是否要显示行号
     * @param is_pagination 是否要启用分页
     * @param column_field  列名
     * @param column_title  列标题
     * @param column_width  列宽
     */
    public String printDataGrid
    (
              String table_title, String table_id, String url, Integer width, Integer height,
              boolean is_rownumbers, boolean is_pagination, String[] column_field,
              String[] column_title, Integer[] column_width
    )
    {
        //标准的datagrid设置:
        StringBuilder sb = new StringBuilder();

        sb.append("$('#")
                  .append(table_id)
                  .append("').datagrid\n")
                  .append("(\n")
                  .append("    {\n")
                  .append("        title: '" + table_title + "',\n")
                  .append("        url: '" + url + "',\n")
                  .append("        rownumbers: ")
                  .append(is_rownumbers)
                  .append(",\n").append("        width: ")
                  .append(width)
                  .append(",\n")
                  .append("        height: ")
                  .append(height)
                  .append(",\n")
                  .append("        pagination: ")
                  .append(is_pagination)
                  .append(",\n")
                  .append("        columns://\n")
                  .append("            [\n")
                  .append("                [\n");

        for (int i = 0; i < column_field.length; i++)
        {
            sb.append("                    {field: '")
                      .append(column_field[i])
                      .append("', title: '")
                      .append(column_title[i])
                      .append("', width: ")
                      .append(column_width[i])
                      .append(", align: 'center'},\n");
        }

        sb.append("                ]\n")
                  .append("            ]\n")
                  .append("    }\n")
                  .append(")");

        return sb.toString();
    }
    //endregion

    //region 自动生成easyui-dialog代码

    /**
     * 自动生成easyui-dialog代码
     *
     * @param dialog_id       对话框标识符
     * @param dialog_title    对话框标题
     * @param dialog_width    对话框宽度
     * @param dialog_height   对话框高度
     * @param dialog_closable 对话框在加载时是否是默认关闭的
     * @param dialog_closed   对话框是否关闭
     * @param dialog_modal    对话框在打开时是否可以做其他的操作
     * @return
     */
    public String printDialog
    (
              String dialog_id, String dialog_title, Integer dialog_width,
              Integer dialog_height, boolean dialog_closable, boolean dialog_closed,
              boolean dialog_modal
    )
    {
        return new StringBuilder()
                  .append("$('#")
                  .append(dialog_id)
                  .append("').dialog\n")
                  .append("                (\n")
                  .append("                        {\n")
                  .append("                            title: '")
                  .append(dialog_title)
                  .append("',\n")
                  .append("                            width: ")
                  .append(dialog_width)
                  .append(",\n")
                  .append("                            height: ")
                  .append(dialog_height)
                  .append(",\n")
                  .append("                            closable: ")
                  .append(dialog_closable)
                  .append(",\n")
                  .append("                            closed: ")
                  .append(dialog_closed)
                  .append(",\n")
                  .append("                            modal: ")
                  .append(dialog_modal)
                  .append("\n")
                  .append("                        }\n")
                  .append("                )").toString();
    }
    //endregion

    //endregion

    //region spring tools

    /**
     * 获取我的Session工厂
     *
     * @return*
     */
    public SessionFactory getSessionFactory()
    {
        return (SessionFactory) new ClassPathXmlApplicationContext("applicationContext.xml")
                  .getBean("sessionFactory");
    }
    //endregion

    //endregion

    //region 将Service接口和服务层实现类写入对应的包

    /**
     * 实现服务层接口代码
     *
     * @param filePath       文件路径
     * @param fileName       文件名称
     * @param servicePackage 需要生成在哪个服务层包
     * @param poPackage      实体类报名
     * @param poClass        实体类
     * @param serviceName    服务层类名
     * @param pkClass        主键类型
     */
    public void makeService
    (
              String filePath, String fileName, String servicePackage, String poPackage,
              Class poClass, String serviceName, Class pkClass
    )
    {
        try
        {
            String _service = "package " + servicePackage + ";\n" +
                      "\n" +
                      //为了方便导入全部实体类
                      "import " + poPackage + ".*;\n" +
                      //由于今后的项目都使用此jar包所以默认引用此服务层
                      "import qin.javaee65.core.hibernate.service.JavaEE65ServiceSupport;\n" +
                      "\n" +
                      "/**\n" +
                      " * 服务层接口\n" +
                      " *\n" +
                      " * @author qinzhengying\n" +
                      " * @since 1.6\n" +
                      " */\n" +
                      "@SuppressWarnings(\"all\")\n" +
                      "public interface " + serviceName + " extends JavaEE65ServiceSupport<" +
                      poClass.getSimpleName() + ", " + pkClass.getSimpleName() + ">\n" +
                      "{\n" +
                      "}";

            //将服务层接口写进文件
            FileWriter fw_service = new FileWriter(new File(filePath + fileName));
            fw_service.write(_service);
            fw_service.flush();
        }
        catch (Exception ex)
        {
            superInfo("生成服务层代码失败" + ex);
        }
    }

    /**
     * 服务层实现代码实现
     *
     * @param filePath        文件路径
     * @param fileName        文件名称
     * @param servicePackage  服务层包
     * @param poPackage       实体类包
     * @param poClass         实体类
     * @param serviceName     服务层名称
     * @param pkClass         主键类型
     * @param annotServicName <code>@Service</code>注释中定义的bean名称
     * @param interService    需要实现的服务层接口名称
     * @param daoName         需要调用的数据访问层名称
     */
    public void makeServiceImpl
    (
              String filePath, String fileName, String servicePackage, String poPackage,
              Class poClass, String serviceName, Class pkClass, String annotServicName,
              Class interService, String daoName
    )
    {
        try
        {
            String _service = "package " + servicePackage + ";\n" +
                      "\n" +
                      "import org.springframework.stereotype.Service;\n" +
                      "import org.springframework.transaction.annotation.Transactional;\n" +
                      "import qin.oa.hibernate.dao.*;\n" +
                      "import qin.oa.hibernate.domain.*;\n" +
                      "import qin.oa.hibernate.service.*;\n" +
                      "import qin.javaee65.core.hibernate.dao.*;\n" +
                      "import qin.javaee65.core.hibernate.service.impl.*;\n" +
                      "\n" +
                      "import javax.annotation.Resource;\n" +
                      "import java.util.*;\n" +
                      "\n" +
                      "/**\n" +
                      " * 服务层实现\n" +
                      " *\n" +
                      " * @author qinzhengying\n" +
                      " * @since 1.6\n" +
                      " */\n" +
                      "@Service(value = \"" + annotServicName + "\")\n" +
                      "@Transactional\n" +
                      "@SuppressWarnings(\"all\")\n" +
                      "public class " + serviceName + "Impl\n" +
                      "          extends JavaEE65ServiceSupportImpl<" + poClass.getSimpleName() + ", " + pkClass.getSimpleName() + ">\n" +
                      "          implements " + interService.getSimpleName() + "\n" +
                      "{\n" +
                      "    private static final long serialVersionUID = -4145137112145426735L;\n" +
                      "\n" +
                      "    private " + daoName + " entityDAO;\n" +
                      "\n" +
                      "    @Override\n" +
                      "    public " + daoName + " getDAO()\n" +
                      "    {\n" +
                      "        return entityDAO;\n" +
                      "    }\n" +
                      "\n" +
                      "    @Resource\n" +
                      "    public void setUserDAO(" + daoName + " entityDAO)\n" +
                      "    {\n" +
                      "        this.entityDAO = entityDAO;\n" +
                      "    }\n" +
                      "\n" +
                      "    /**\n" +
                      "     * 根据实体类以及其他信息进行查询\n" +
                      "     *\n" +
                      "     * @param entity   指定实体类\n" +
                      "     * @param elements 其他元素\n" +
                      "     * @return 返回查询结果集合\n" +
                      "     */\n" +
                      "    @Override\n" +
                      "    public <E> List<?> findByEntity(" + poClass.getSimpleName() + " entity, E elements)\n" +
                      "    {\n" +
                      "        return empty;\n" +
                      "    }\n" +
                      "}";

            //将服务层接口写进文件
            FileWriter fw_service = new FileWriter(new File(filePath + fileName));
            fw_service.write(_service);
            fw_service.flush();
        }
        catch (Exception ex)
        {
            superInfo("生成服务层代码失败" + ex);
        }
    }
    //endregion

    //region 6.5新特性

    /**
     * 拼接html下拉框
     *
     * @param names 集合
     * @return 拼接结果
     */
    public StringBuilder appendSelect(List<String> names)
    {
        StringBuilder sb = new StringBuilder();
        int index = 0;

        for (Iterator<String> it = names.iterator(); it.hasNext(); index++)
        {
            //换行
            sb.append("<option value=\"" + index + "\">");
            sb.append(it.next()).append("</option>");
        }
        return sb;
    }
    //endregion

}





















