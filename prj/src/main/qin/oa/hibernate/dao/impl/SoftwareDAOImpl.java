package qin.oa.hibernate.dao.impl;

import org.springframework.stereotype.Repository;
import qin.javaee65.core.hibernate.dao.impl.JavaEE65DAOSupportImpl;
import qin.oa.hibernate.dao.SoftwareDAO;
import qin.oa.hibernate.domain.Software;

import java.util.ArrayList;
import java.util.List;

/**
 * 软件数据访问层实现类
 *
 * @author qinzhengying
 * @since 1.6
 */
@Repository(value = "softwareDAO65")
@SuppressWarnings("all")
public class SoftwareDAOImpl
          extends JavaEE65DAOSupportImpl<Software, String>
          implements SoftwareDAO
{
    private static final long serialVersionUID = -7301050148252799067L;

    //region 获取软件类
    @Override
    public Class<Software> getEntityClass()
    {
        return Software.class;
    }
    //endregion

    //region 软件模糊查询

    /**
     * 对软件信息进行模糊查询
     *
     * @param entity   指定实体类
     * @param elements 其他元素
     * @param <E>
     * @return
     */
    @Override
    public <E> List<?> findByEntity(Software entity, E elements)
    {
        return super.findByEntity(entity, elements);
    }
    //endregion

    //region 查询所有软件信息
    @Override
    public List<?> searchAll()
    {
        List<?> result = new ArrayList();

        //language=Oracle
        String queryString = "SELECT\n" +
                  "  qs.SOFT_ID          AS \"SOFT_ID\",\n" +
                  "  qs.SOFT_NAME        AS \"SOFT_NAME\",\n" +
                  "  qs.SOFT_DESCRIPTION AS \"SOFT_DESCRIPTION\",\n" +
                  "  qs.SOFT_ISHIDDEN    AS \"SOFT_ISHIDDEN\",\n" +
                  "  qs.SOFT_CREATETIME  AS \"SOFT_CREATETIME\",\n" +
                  "  qs.SOFT_LOCATION    AS \"SOFT_LOCATION\",\n" +
                  "  qs.SOFT_SIZE        AS \"SOFT_SIZE\",\n" +
                  "  qso.SOFT_OPENWAYS   AS \"SOFT_OPENWAYS\",\n" +
                  "  qst.SOFT_TYPE_NAME  AS \"SOFT_TYPE_NAME\"\n" +
                  "FROM OYJR_RZHX.QIN_SOFTWARE6 qs,\n" +
                  "  OYJR_RZHX.QIN_SOFT_OPENWAYS6 qso,\n" +
                  "  OYJR_RZHX.QIN_SOFT_TYPE6 qst\n" +
                  "WHERE\n" +
                  "  qs.SOFT_ID = qso.SOFT_OPEN_ID\n" +
                  "  AND\n" +
                  "  qs.SOFT_ID = qst.SOFT_TYPE_ID";
        result = getSessionFactory().openSession().createSQLQuery(queryString).list();

        return result;
    }
    //endregion
}





















