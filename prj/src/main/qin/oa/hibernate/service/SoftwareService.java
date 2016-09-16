package qin.oa.hibernate.service;

import qin.javaee65.core.hibernate.service.JavaEE65ServiceSupport;
import qin.oa.hibernate.domain.Software;

import java.util.List;

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
}