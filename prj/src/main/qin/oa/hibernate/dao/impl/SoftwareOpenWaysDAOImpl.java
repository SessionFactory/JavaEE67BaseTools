package qin.oa.hibernate.dao.impl;

import org.springframework.stereotype.Repository;
import qin.javaee65.core.hibernate.dao.impl.JavaEE65DAOSupportImpl;
import qin.oa.hibernate.dao.SoftwareOpenWaysDAO;
import qin.oa.hibernate.domain.SoftOpenWays;

import java.util.List;

import static qin.oa.hibernate.HibernateBasePath.log4jPath;

@Repository(value = "softwareOpenWaysDAO65")
@SuppressWarnings("all")
public class SoftwareOpenWaysDAOImpl
          extends JavaEE65DAOSupportImpl<SoftOpenWays, Integer>
          implements SoftwareOpenWaysDAO
{
    private static final long serialVersionUID = 6980588353835315285L;

    //region 获取log4j配置文件路径
    @Override
    public String getLog4jLocations()
    {
        return log4jPath;
    }
    //endregion

    //region 获取实体类
    @Override
    public Class<SoftOpenWays> getEntityClass()
    {
        return SoftOpenWays.class;
    }
    //endregion

    //region 获取软件打开方式名称

    @Override
    public List<String> findOpenWaysNames()
    {
        //language=hql
        return appendNames("select s.soft_openWays from SoftOpenWays s");
    }

    //endregion
}

//region 注释
//List<String> result = new ArrayList<String>();
//
//    //查询软件打开方式名称
//    List searchList = getSessionFactory()
//              .openSession()
//              .createQuery("select s.soft_openWays from SoftOpenWays s")
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