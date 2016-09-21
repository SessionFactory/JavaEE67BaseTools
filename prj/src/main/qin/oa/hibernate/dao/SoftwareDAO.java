package qin.oa.hibernate.dao;

import qin.javaee65.core.hibernate.dao.JavaEE65DAOSupport;
import qin.oa.hibernate.domain.Software;

import java.util.List;

/**
 * 软件数据访问层
 *
 * @author qinzhengying
 * @since 1.6
 */
@SuppressWarnings("all")
public interface SoftwareDAO extends JavaEE65DAOSupport<Software, String>
{
    /**
     * 获取软件实体类
     *
     * @return
     */
    @Override
    Class<Software> getEntityClass();

    /**
     * 根据软件信息模糊查询
     *
     * @param entity   软件实体类
     * @param elements 其他元素
     * @param <E>
     * @return
     */
    @Override
    <E> List<?> findByEntity(Software entity, E elements);

    //region 查询所有软件信息

    /**
     * 查询所有软件信息
     *
     * @return 查询结果集合
     */
    List<?> searchAll();
    //endregion

}