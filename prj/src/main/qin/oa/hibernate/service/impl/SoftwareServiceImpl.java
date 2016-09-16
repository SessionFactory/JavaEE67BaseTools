package qin.oa.hibernate.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import qin.javaee65.core.hibernate.service.impl.JavaEE65ServiceSupportImpl;
import qin.oa.hibernate.dao.SoftwareDAO;
import qin.oa.hibernate.domain.Software;
import qin.oa.hibernate.service.SoftwareService;

import javax.annotation.Resource;
import java.util.List;

/**
 * 软件服务层实现
 *
 * @author qinzhengying
 * @since 1.6
 */
@Service(value = "softwareServiceImpl65")
@Transactional
@SuppressWarnings("all")
public class SoftwareServiceImpl
          extends JavaEE65ServiceSupportImpl<Software, String>
          implements SoftwareService
{
    private static final long serialVersionUID = -4145137112145426735L;

    //region 注入软件服务层
    private SoftwareDAO entityDAO;

    @Override
    public SoftwareDAO getDAO()
    {
        return entityDAO;
    }

    @Resource
    public void setUserDAO(SoftwareDAO entityDAO)
    {
        this.entityDAO = entityDAO;
    }
    //endregion

    /**
     * 根据实体类以及其他信息进行查询
     *
     * @param entity   指定实体类
     * @param elements 其他元素
     * @return 返回查询结果集合
     */
    @Override
    public <E> List<?> findByEntity(Software entity, E elements)
    {
        return empty;
    }

    //region 查询所有软件信息
    @Override
    public List<?> searchAll()
    {
        return entityDAO.searchAll();
    }
    //endregion
}