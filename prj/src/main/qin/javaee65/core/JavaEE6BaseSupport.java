package qin.javaee65.core;

import java.io.Serializable;
import java.util.List;
import java.util.RandomAccess;

import static java.util.Collections.EMPTY_LIST;

/**
 * 最顶级接口(所有类都需要实现此接口)
 *
 * @author qinzhengying
 * @since 1.6
 */
@SuppressWarnings("all")
public interface JavaEE6BaseSupport extends Serializable, RandomAccess
{
    //region 定义常用变量
    /**
     * 输出分隔符
     */
    String str_equals = "=================";

    /**
     * 字符串开始符
     */
    char c_start = '[';

    /**
     * 字符串结尾符
     */
    char c_end = ']';

    /**
     * html5字体结尾符
     */
    String str_endFont = "</font>";

    /**
     * html5换行符
     */
    String str_br = "<br>";

    /**
     * 保存实体类
     */
    String str_save = "save";

    /**
     * 更新实体类
     */
    String str_update = "update";

    /**
     * 删除实体类
     */
    String str_delete = "delete";

    /**
     * 程序运行成功符号
     */
    String str_SUCCESS = "success";

    /**
     * 程序运行失败符号
     */
    String str_FAILED = "failed";

    /**
     * "的转义字符
     */
    String str_change = "\"";

    /**
     * 换行符
     */
    String str_ENDLINE = "\n";

    /**
     * 空集合
     */
    List empty = EMPTY_LIST;
    //endregion
}



















