/*
此接口使用方法如下:
class MyString implements ClassSupport<StringBuilder>
{
    @Override
    public Class<StringBuilder> getEntityClass()
    {
        //获取的是StringBuilder类实例
        return StringBuilder.class;
    }
}
*/
package qin.javaee65.core;

/**
 * 实体类 类 类型支持接口<br>
 *
 * @since 1.6
 */
@SuppressWarnings("all")
public interface ClassSupport<T> extends JavaEE6BaseSupport
{
    //region 获取任意实体类 类 类型

    /**
     * 获取任意实体类 类 类型
     *
     * @return 已获取到的实体类
     */
    Class<T> getEntityClass();
    //endregion
}