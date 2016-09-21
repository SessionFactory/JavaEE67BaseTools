package qin.oa.hibernate.service;

import qin.javaee65.core.hibernate.service.JavaEE65ServiceSupport;
import qin.oa.hibernate.domain.SoftOpenWays;

import java.util.List;

/**
 * 软件打开方式服务层接口
 *
 * @author qinzhengying
 * @since 1.6
 */
@SuppressWarnings("all")
public interface SoftwareOpenWaysService extends JavaEE65ServiceSupport<SoftOpenWays, Integer>
{
    List<String> findOpenWaysNames();
}