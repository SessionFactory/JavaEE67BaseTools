package qin.oa.hibernate.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import qin.javaee65.core.hibernate.service.impl.JavaEE65ServiceSupportImpl;
import qin.oa.hibernate.dao.SoftwareOpenWaysDAO;
import qin.oa.hibernate.domain.SoftOpenWays;
import qin.oa.hibernate.service.SoftwareOpenWaysService;

import javax.annotation.Resource;
import java.util.List;

/**
 * 服务层实现
 *
 * @author qinzhengying
 * @since 1.6
 */
@Service(value = "softwareOpenWaysService65")
@Transactional
@SuppressWarnings("all")
public class SoftwareOpenWaysServiceImpl
          extends JavaEE65ServiceSupportImpl<SoftOpenWays, Integer>
          implements SoftwareOpenWaysService
{
    private static final long serialVersionUID = -4145137112145426735L;

    private SoftwareOpenWaysDAO entityDAO;

    @Override
    public SoftwareOpenWaysDAO getDAO()
    {
        return entityDAO;
    }

    @Resource
    public void setUserDAO(SoftwareOpenWaysDAO entityDAO)
    {
        this.entityDAO = entityDAO;
    }

    /**
     * 根据实体类以及其他信息进行查询
     *
     * @param entity   指定实体类
     * @param elements 其他元素
     * @return 返回查询结果集合
     */
    @Override
    public <E> List<?> findByEntity(SoftOpenWays entity, E elements)
    {
        return empty;
    }

    @Override
    public List<String> findOpenWaysNames()
    {
        return entityDAO.findOpenWaysNames();
    }
}