package qin.javaee65.core.hibernate;

import qin.javaee65.core.JavaEE6BaseSupport;

import java.io.Serializable;

/**
 * JavaEE65超级实体类主键封装
 *
 * @param <T> 实现Serializable主键
 * @author qinzhengying
 * @since 1.6
 */
public interface SuperEntity65<T extends Serializable> extends JavaEE6BaseSupport
{
    T getId();

    void setId(T id);
}