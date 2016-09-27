package qin.oa.hibernate.dao;

import qin.javaee65.core.hibernate.dao.JavaEE65DAOSupport;
import qin.javaee65.exceptions.JavaEE6Exception;
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
    //region 获取软件实体类

    /**
     * 获取软件实体类
     *
     * @return
     */
    @Override
    Class<Software> getEntityClass();
    //endregion

    //region 根据软件查询实体

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
    //endregion

    //region 查询所有软件信息

    /**
     * 查询所有软件信息
     *
     * @return 查询结果集合
     */
    List<?> searchAll();
    //endregion

    //region 保存软件信息

    /**
     * 保存软件信息
     *
     * @param vo 软件实体类
     * @return
     */
    String saveSoft(Software vo);
    //endregionr

    //region 删除软件信息

    /**根据软件名称删除软件信息
     *
     * @param names 软件名称
     * @return 如果删除成功返回true, 失败返回false
     * @throws JavaEE6Exception 如果失败抛出异常
     */
    String doDelete(String names) throws JavaEE6Exception;
    //endregion
}