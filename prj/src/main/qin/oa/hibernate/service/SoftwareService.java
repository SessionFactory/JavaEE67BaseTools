package qin.oa.hibernate.service;

import qin.javaee65.core.hibernate.service.JavaEE65ServiceSupport;
import qin.javaee65.exceptions.JavaEE6Exception;
import qin.oa.hibernate.domain.Software;

import java.util.List;
import java.util.Map;

/**
 * 软件服务层接口
 *
 * @author qinzhengying
 * @since 1.6
 */
@SuppressWarnings("all")
public interface SoftwareService extends JavaEE65ServiceSupport<Software, String>
{
    //region 查询所有软件信息
    List<?> searchAll();
    //endregion

    //region String类型的查询结果

    /**
     * 如果查询成功返回success否则返回failed
     *
     * @param entity 需要查询的实体
     * @return 信息
     * @throws JavaEE6Exception 抛出大异常
     */
    String findByEntity(Software entity) throws JavaEE6Exception;
    //endregion

    //region Map返回类型查询结果
    Map<String, List> findByEntityMap(Software entity) throws JavaEE6Exception;
    //endregion

    //region 拼接html datagrid
    StringBuilder appendSearchSoftHTML(Map<String, List> msg);
    //endregion
}