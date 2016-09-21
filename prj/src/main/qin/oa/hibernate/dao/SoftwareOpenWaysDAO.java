package qin.oa.hibernate.dao;

import qin.javaee65.core.hibernate.dao.JavaEE65DAOSupport;
import qin.oa.hibernate.domain.SoftOpenWays;

import java.util.List;

/**
 * 软件打开方式数据访问层
 *
 * @author qinzhengying
 * @since 1.6
 */
@SuppressWarnings("all")
public interface SoftwareOpenWaysDAO extends JavaEE65DAOSupport<SoftOpenWays, Integer>
{
    //region 获取软件实体类

    /**
     * 获取实体类
     *
     * @return 软件打开方式实体类
     */
    @Override
    Class<SoftOpenWays> getEntityClass();
    //endregion

    //region 获取软件打开方式名称

    /**
     * 获取软件打开方式名称
     *
     * @return 将名称存进集合返回
     */
    List<String> findOpenWaysNames();
    //endregion
}
