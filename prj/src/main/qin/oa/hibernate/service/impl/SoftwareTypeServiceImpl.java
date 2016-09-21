package qin.oa.hibernate.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import qin.javaee65.core.hibernate.service.impl.JavaEE65ServiceSupportImpl;
import qin.oa.hibernate.dao.SoftwareTypeDAO;
import qin.oa.hibernate.domain.SoftType;
import qin.oa.hibernate.service.SoftwareTypeService;

import javax.annotation.Resource;
import java.util.List;

/**
 * 软件类型服务层实现
 *
 * @author qinzhengying
 * @since 1.6
 */
@Service(value = "softTypeService65")
@Transactional
@SuppressWarnings("all")
public class SoftwareTypeServiceImpl
          extends JavaEE65ServiceSupportImpl<SoftType, Integer>
          implements SoftwareTypeService
{
    private static final long serialVersionUID = -4145137112145426735L;

    private SoftwareTypeDAO entityDAO;

    @Override
    public SoftwareTypeDAO getDAO()
    {
        return entityDAO;
    }

    @Resource
    public void setUserDAO(SoftwareTypeDAO entityDAO)
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
    public <E> List<?> findByEntity(SoftType entity, E elements)
    {
        return empty;
    }

    //region 查找软件类型

    @Override
    public List<String> findSoftTypeNames()
    {
        return entityDAO.findSoftTypeNames();
    }

    //endregion
}