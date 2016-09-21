package qin.oa.hibernate.service;

import qin.javaee65.core.hibernate.service.JavaEE65ServiceSupport;
import qin.oa.hibernate.domain.SoftType;

import java.util.List;

/**
 * 软件类型服务层接口
 *
 * @author qinzhengying
 * @since 1.6
 */
@SuppressWarnings("all")
public interface SoftwareTypeService extends JavaEE65ServiceSupport<SoftType, Integer>
{
    List<String> findSoftTypeNames();
}