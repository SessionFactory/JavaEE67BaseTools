package qin.oa.hibernate.dao;

import qin.javaee65.core.hibernate.dao.JavaEE65DAOSupport;
import qin.oa.hibernate.domain.SoftType;

import java.util.List;

/**
 * 软件类型数据访问层
 *
 * @author qinzhengying
 * @since 1.6
 */
@SuppressWarnings("all")
public interface SoftwareTypeDAO extends JavaEE65DAOSupport<SoftType, Integer>
{
    //region 获取实体类
    @Override
    Class<SoftType> getEntityClass();
    //endregion

    //region 获取软件类型所有名称

    /**
     * 获取软件类型所有名称
     *
     * @return 将获取到的软件类型存进集合
     * @author qinzhengying
     * @since 1.6
     */
    List<String> findSoftTypeNames();
    //endregion
}
