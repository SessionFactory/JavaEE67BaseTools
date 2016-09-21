package qin.oa.hibernate.dao.impl;

import org.springframework.stereotype.Repository;
import qin.javaee65.core.hibernate.dao.impl.JavaEE65DAOSupportImpl;
import qin.oa.hibernate.dao.SoftwareDAO;
import qin.oa.hibernate.domain.Software;

import java.util.ArrayList;
import java.util.List;

import static qin.oa.hibernate.HibernateBasePath.log4jPath;

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

    //region 获取log4j配置文件路径
    @Override
    public String getLog4jLocations()
    {
        return log4jPath;
    }
    //endregion

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
        //region 判断界面接收的值

        //名称
        String soft_name = entity.getSoft_name().trim();
        //描述
        String soft_description = entity.getSoft_description().trim();
        //是否隐藏
        String soft_ishidden = entity.getSoft_isHidden2().trim();
        //创建时间[date1到date2]
        String startDate = entity.getSoft_createTime2().trim();
        String endDate = entity.getSoft_createTime3().trim();
        //位置
        String soft_location = entity.getSoft_location().trim();
        //大小
        String soft_size = entity.getSoft_size().trim();
        //类型
        String soft_type = entity.getSoft_type2().trim();
        //打开方式
        String soft_openways = entity.getSoft_openWays2().trim();
        //endregion

        //region sqlQuery
        //StringBuilder节约内存, +号每次都会新开辟一块内存
        StringBuilder sqlQuery = new StringBuilder()
                  .append("SELECT\n")
                  .append("  qs.SOFT_ID,\n")
                  .append("  qs.SOFT_NAME,\n")
                  .append("  qs.SOFT_DESCRIPTION,\n")
                  .append("  qs.SOFT_ISHIDDEN,\n")
                  .append("  qs.SOFT_CREATETIME,\n")
                  .append("  qs.SOFT_LOCATION,\n")
                  .append("  qs.SOFT_SIZE,\n")
                  .append("  qso.SOFT_OPENWAYS,\n")
                  .append("  qst.SOFT_TYPE_NAME\n")
                  .append("FROM\n")
                  .append("  QIN_SOFTWARE6 qs,\n")
                  .append("  QIN_SOFT_OPENWAYS6 qso,\n")
                  .append("  QIN_SOFT_TYPE6 qst\n")
                  .append("WHERE\n")
                  .append("  qs.SOFT_ID = qso.SOFT_OPEN_ID\n")
                  .append("  AND\n")
                  .append("  qs.SOFT_ID = qst.SOFT_TYPE_ID");

        if (soft_name.length() > 0)
        {
            sqlQuery.append("  soft_name LIKE '%")
                      .append(soft_name)
                      .append("%'\n");
        }
        if (soft_description.length() > 0)
        {
            sqlQuery.append("  AND\n")
                      .append("  soft_description LIKE '%")
                      .append(soft_description)
                      .append("%'\n");
        }
        if (soft_ishidden.length() > 0)
        {
            int softHidden = 0;

            if (soft_ishidden == "是")
            {
                softHidden = 1;
            }
            if (soft_ishidden == "否")
            {
                softHidden = 0;
            }

            sqlQuery.append("  AND\n")
                      .append("  soft_ishidden = ")
                      .append(softHidden)
                      .append("\n");
        }
        if (startDate.length() > 0 && endDate.length() > 0)
        {
            sqlQuery.append("  AND\n")
                      .append("  soft_createtime\n")
                      .append("  BETWEEN\n")
                      .append("  to_date('")
                      .append(startDate)
                      .append("', 'yyyy-mm-dd')\n")
                      .append("  AND\n")
                      .append("  to_date('")
                      .append(endDate)
                      .append("', 'yyyy-mm-dd')\n");
        }
        if (soft_openways.length() > 0)
        {
            sqlQuery.append("  AND\n")
                      .append("  qso.SOFT_OPENWAYS = '")
                      .append(soft_openways)
                      .append("'\n");
        }
        if (soft_type.length() > 0)
        {
            sqlQuery.append("  AND\n")
                      .append("  qst.SOFT_TYPE_NAME = '")
                      .append(soft_type)
                      .append("'\n");
        }
        //endregion

        List<?> result = getSessionFactory()
                  .openSession()
                  .createSQLQuery(sqlQuery.toString())
                  .list();

        return result;
    }
    //endregion

    //region 查询所有软件信息
    @Override
    public List<?> searchAll()
    {
        List<?> result = new ArrayList();

        //language=Oracle
        String queryString = new StringBuilder()
                  .append("SELECT\n")
                  .append("  qs.SOFT_ID          AS \"SOFT_ID\",\n")
                  .append("  qs.SOFT_NAME        AS \"SOFT_NAME\",\n")
                  .append("  qs.SOFT_DESCRIPTION AS \"SOFT_DESCRIPTION\",\n")
                  .append("  qs.SOFT_ISHIDDEN    AS \"SOFT_ISHIDDEN\",\n")
                  .append("  qs.SOFT_CREATETIME  AS \"SOFT_CREATETIME\",\n")
                  .append("  qs.SOFT_LOCATION    AS \"SOFT_LOCATION\",\n")
                  .append("  qs.SOFT_SIZE        AS \"SOFT_SIZE\",\n")
                  .append("  qso.SOFT_OPENWAYS   AS \"SOFT_OPENWAYS\",\n")
                  .append("  qst.SOFT_TYPE_NAME  AS \"SOFT_TYPE_NAME\"\n")
                  .append("FROM QIN_SOFTWARE6 qs,\n")
                  .append("  QIN_SOFT_OPENWAYS6 qso,\n")
                  .append("  QIN_SOFT_TYPE6 qst\n")
                  .append("WHERE\n")
                  .append("  qs.SOFT_ID = qso.SOFT_OPEN_ID\n")
                  .append("  AND\n")
                  .append("  qs.SOFT_ID = qst.SOFT_TYPE_ID").toString();

        result = getSessionFactory().openSession().createSQLQuery(queryString).list();

        return result;
    }
    //endregion
}

//region 注释
//String queryString = "SELECT\n" +
//          "  qs.SOFT_ID          AS \"SOFT_ID\",\n" +
//          "  qs.SOFT_NAME        AS \"SOFT_NAME\",\n" +
//          "  qs.SOFT_DESCRIPTION AS \"SOFT_DESCRIPTION\",\n" +
//          "  qs.SOFT_ISHIDDEN    AS \"SOFT_ISHIDDEN\",\n" +
//          "  qs.SOFT_CREATETIME  AS \"SOFT_CREATETIME\",\n" +
//          "  qs.SOFT_LOCATION    AS \"SOFT_LOCATION\",\n" +
//          "  qs.SOFT_SIZE        AS \"SOFT_SIZE\",\n" +
//          "  qso.SOFT_OPENWAYS   AS \"SOFT_OPENWAYS\",\n" +
//          "  qst.SOFT_TYPE_NAME  AS \"SOFT_TYPE_NAME\"\n" +
//          "FROM QIN_SOFTWARE6 qs,\n" +
//          "  QIN_SOFT_OPENWAYS6 qso,\n" +
//          "  QIN_SOFT_TYPE6 qst\n" +
//          "WHERE\n" +
//          "  qs.SOFT_ID = qso.SOFT_OPEN_ID\n" +
//          "  AND\n" +
//          "  qs.SOFT_ID = qst.SOFT_TYPE_ID";
           /*
                          .append("SELECT\n")
                          .append("  soft_id,\n")
                          .append("  soft_name,\n")
                          .append("  soft_description,\n")
                          .append("  soft_ishidden,\n")
                          .append("  soft_createtime,\n")
                          .append("  soft_location,\n")
                          .append("  soft_size,\n")
                          .append("  soft_type,\n")
                          .append("  soft_openways\n")
                          .append("FROM\n")
                          .append("  qin_software6\n")
                          .append("WHERE\n")
                          .append("  1 = 1\n");

                if (soft_name.length() > 0)
                {
                    sqlQuery.append("  AND\n")
                              .append("  soft_name LIKE '%")
                              .append(soft_name)
                              .append("%'\n");
                }
                if (soft_description.length() > 0)
                {
                    sqlQuery.append("  AND\n")
                              .append("  soft_description LIKE '%")
                              .append(soft_description)
                              .append("%'\n");
                }
                if (soft_ishidden.length() > 0)
                {
                    sqlQuery.append("  AND\n")
                              .append("  soft_ishidden = 0\n");
                }
                if (startDate.length() > 0 && endDate.length() > 0)
                {
                    sqlQuery.append("  AND\n")
                              .append("  soft_createtime\n")
                              .append("  BETWEEN to_date('")
                              .append(startDate)
                              .append("', 'yyyy-mm-dd')\n")
                              .append("  AND to_date('")
                              .append(endDate)
                              .append("', 'yyyy-mm-dd')\n");
                }
                if (soft_location.length() > 0)
                {
                    sqlQuery.append("  AND\n")
                              .append("  soft_location LIKE '%")
                              .append(soft_location)
                              .append("%'\n");
                }
                if (soft_size.length() > 0)
                {
                    sqlQuery.append("  AND\n")
                              .append("  --匹配MB前面的字符\n")
                              .append("  soft_size LIKE '")
                              .append(soft_size)
                              .append("%MB'\n");
                }
                if (soft_type.length() > 0)
                {
                    sqlQuery.append("  AND\n")
                              .append("  soft_type =\n")
                              .append("  (\n")
                              .append("    SELECT SOFT_TYPE_ID\n")
                              .append("    FROM QIN_SOFT_TYPE6\n")
                              .append("    WHERE SOFT_TYPE_NAME = '")
                              .append(soft_type)
                              .append("'\n")
                              .append("  )\n");
                }
                if (soft_openways.length() > 0)
                {
                    sqlQuery.append("  AND\n")
                              .append("  soft_openways =\n")
                              .append("  (\n")
                              .append("    SELECT SOFT_OPEN_ID\n")
                              .append("    FROM QIN_SOFT_OPENWAYS6\n")
                              .append("    WHERE QIN_SOFT_OPENWAYS6.SOFT_OPENWAYS = '")
                              .append(soft_openways)
                              .append("'\n")
                              .append("  )");
                }
                */
//                  "WHERE\n" +
//                  "  qs.SOFT_ID = qso.SOFT_OPEN_ID\n" +
//                  "  AND\n" +
//                  "  qs.SOFT_ID = qst.SOFT_TYPE_ID";
                /*
                  String sqlQuery = "SELECT\n" +
                                  "  soft_id,\n" +
                                  "  soft_name,\n" +
                                  "  soft_description,\n" +
                                  "  soft_ishidden,\n" +
                                  "  soft_createtime,\n" +
                                  "  soft_location,\n" +
                                  "  soft_size,\n" +
                                  "  soft_type,\n" +
                                  "  soft_openways\n" +
                                  "FROM\n" +
                                  "  qin_software6\n" +
                                  "WHERE\n" +
                                  "  1 = 1\n";

                        if (soft_name.length() > 0)
                        {
                            sqlQuery +=
                                      "  AND\n" +
                                                "  soft_name LIKE '%" + soft_name + "%'\n";
                        }
                        if (soft_description.length() > 0)
                        {
                            sqlQuery +=
                                      "  AND\n" +
                                                "  soft_description LIKE '%" + soft_description + "%'\n";
                        }
                        if (soft_ishidden.length() > 0)
                        {
                            sqlQuery +=
                                      "  AND\n" +
                                                "  soft_ishidden = 0\n";
                        }
                        if (startDate.length() > 0 && endDate.length() > 0)
                        {
                            sqlQuery +=
                                      "  AND\n" +
                                                "  soft_createtime\n" +
                                                "  BETWEEN to_date('" + startDate + "', 'yyyy-mm-dd')\n" +
                                                "  AND to_date('" + endDate + "', 'yyyy-mm-dd')\n";
                        }
                        if (soft_location.length() > 0)
                        {
                            sqlQuery +=
                                      "  AND\n" +
                                                "  soft_location LIKE '%" + soft_location + "%'\n";
                        }
                        if (soft_size.length() > 0)
                        {
                            sqlQuery +=
                                      "  AND\n" +
                                                "  --匹配MB前面的字符\n" +
                                                "  soft_size LIKE '" + soft_size + "%MB'\n";
                        }
                        if (soft_type.length() > 0)
                        {
                            sqlQuery += "  AND\n" +
                                      "  soft_type =\n" +
                                      "  (\n" +
                                      "    SELECT SOFT_TYPE_ID\n" +
                                      "    FROM QIN_SOFT_TYPE6\n" +
                                      "    WHERE SOFT_TYPE_NAME = '" + soft_type + "'\n" +
                                      "  )\n";
                        }
                        if (soft_openways.length() > 0)
                        {
                            sqlQuery += "  AND\n" +
                                      "  soft_openways =\n" +
                                      "  (\n" +
                                      "    SELECT SOFT_OPEN_ID\n" +
                                      "    FROM QIN_SOFT_OPENWAYS6\n" +
                                      "    WHERE QIN_SOFT_OPENWAYS6.SOFT_OPENWAYS = '" + soft_openways + "'\n" +
                                      "  )";
                        }
                 */
//endregion














