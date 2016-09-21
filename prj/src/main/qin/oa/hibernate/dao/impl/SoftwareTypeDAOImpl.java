package qin.oa.hibernate.dao.impl;

import org.springframework.stereotype.Repository;
import qin.javaee65.core.hibernate.dao.impl.JavaEE65DAOSupportImpl;
import qin.oa.hibernate.dao.SoftwareTypeDAO;
import qin.oa.hibernate.domain.SoftType;

import java.util.List;

import static qin.oa.hibernate.HibernateBasePath.log4jPath;

/**
 * 软件数据访问层实现类
 *
 * @author qinzhengying
 * @since 1.6
 */
@Repository(value = "softwareTypeDAO65")
@SuppressWarnings("all")
public class SoftwareTypeDAOImpl
          extends JavaEE65DAOSupportImpl<SoftType, Integer>
          implements SoftwareTypeDAO
{
    private static final long serialVersionUID = -7301050148252799067L;

    //region 获取log4j配置文件路径
    @Override
    public String getLog4jLocations()
    {
        return log4jPath;
    }
    //endregion

    //region 获取软件类型实体类
    @Override
    public Class<SoftType> getEntityClass()
    {
        return SoftType.class;
    }
    //endregion

    //region 获取软件类型所有名称

    @Override
    public List<String> findSoftTypeNames()
    {
        //language=hql
        return appendNames("select s.soft_type_name from SoftType s");
    }

    //endregion
}

//region 注释
//List<String> result = new ArrayList<String>();
//
//    //查询软件类型名称
//    List searchList = getSessionFactory()
//              .openSession()
//              .createQuery("select s.soft_type_name from SoftType s")
//              .list();
//
//        for (Iterator<String> it = searchList.iterator(); it.hasNext(); )
//          {
//          //将名称添加进集合
//          result.add(it.next());
//          }
//
//          return result;
//endregion