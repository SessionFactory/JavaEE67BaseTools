package qin.oa.hibernate.dao.impl;

import org.hibernate.Session;
import qin.javaee65.core.hibernate.dao.impl.JavaEE65DAOSupportImpl;
import qin.oa.hibernate.dao.SoftwareDAO;
import qin.oa.hibernate.domain.SoftOpenWays;
import qin.oa.hibernate.domain.SoftType;
import qin.oa.hibernate.domain.Software;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static qin.oa.hibernate.HibernateBasePath.log4jPath;
import static qin.oa.hibernate.HibernateBasePath.qinObj;

/**
 * 软件数据访问层实现类
 *
 * @author qinzhengying
 * @since 1.6
 */
//@Repository(value = "softwareDAO65")
@SuppressWarnings("all")
@Deprecated
public abstract class SoftwareDAOImplDes
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
                  .append("WHERE 1=1\n");
        //.append("  qs.SOFT_OPENWAYS = qso.SOFT_OPEN_ID\n")
        //.append("  AND\n")
        //.append("  qs.SOFT_TYPE = qst.SOFT_TYPE_ID\n");

        if (soft_name.length() > 0)
        {
            sqlQuery.append("AND\n  soft_name LIKE '%")
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
                  .append("  qs.SOFT_OPENWAYS = qso.SOFT_OPEN_ID\n")
                  .append("  AND\n")
                  .append("  qs.SOFT_TYPE = qst.SOFT_TYPE_ID").toString();

        result = getSessionFactory().openSession().createSQLQuery(queryString).list();

        return result;
    }
    //endregion

    //region 获取我的Session

    /**
     * 获取Session
     */
    protected final Session getSession()
    {
        return getSessionFactory().openSession();
    }
    //endregion

    //region 保存软件信息

    /**
     * 保存软件信息
     *
     * @param vo 软件实体类
     * @return
     */
    @Override
    public String saveSoft(Software vo)
    {
        try
        {
            String softName = vo.getSoft_name().trim();
            //事先定义些变量
            String soft_location = "";
            //大小
            String soft_size = "";
            //类型
            String soft_type = "";
            //打开方式
            String soft_openWays = "";

            //1.软件名称长度大于0
            if (softName.length() > 0)
            {
                //region 软件名称
                //执行剩下的判断
                //2.定义变量封装软件名称第一个字符
                //由于长度大于0了说明肯定有一个及以上字符所以截取时不会发生异常
                String startSoftName = softName.substring(0, 1);
                //3.软件开头必须以英文和中文开头
                //以中文开头
                boolean isStartWithChinese = qinObj.isChinese(startSoftName.toCharArray()[0]);
                //以英文开头
                boolean isStartWithEnglish = startSoftName.matches("[A-Za-z]");
                if (!(isStartWithChinese || isStartWithEnglish))
                {
                    return "软件名必须以中文和英文开头!例如:eclipse, 谷歌浏览器";
                }
                //4.不能以数字开头
                if (startSoftName.matches("[0-9]"))
                {
                    return "软件名称不能以数字开头!";
                }
                //5.名称长度一定要在两个字符以上
                if (softName.length() == 1)
                {
                    return "软件名称一定要大于2个字符!比如说IE, 谷歌浏览器";
                }

                //只有当软件名称输入正确时才能执行别的操作
                //所以页面其他的值在这里进行定义
                String soft_description = vo.getSoft_description().trim();
                //软件描述长度不能超过3000个字
                if (soft_description.length() > 3000)
                {
                    return "软件描述长度不能超过3000个字!";
                }
                //endregion

                //region 软件位置
                soft_location = vo.getSoft_location().trim();

                //1.软件位置不能为空!
                if (soft_location.length() > 0)
                {
                    //2.长度不能超过300个字符!
                    if (soft_location.length() > 300)
                    {
                        return "软件位置长度不能超过300个字符!";
                    }
                    //3.必须以中文或英文开头!不能以英文开头!
                    //截取第一个字符
                    String startSoftLocation = soft_location.substring(0, 1);
                    boolean loc_isStartWithChinese = qinObj.isChinese(startSoftLocation.toCharArray()[0]);
                    //以英文开头
                    boolean loc_isStartWithEnglish = startSoftLocation.matches("[A-Za-z]");
                    if (!(loc_isStartWithChinese || loc_isStartWithEnglish))
                    {
                        return "软件位置必须以中文和英文开头!";
                    }
                    //4.不能以数字开头
                    if (startSoftLocation.matches("[0-9]"))
                    {
                        return "软件位置不能以数字开头!";
                    }
                }
                else
                {
                    return "软件位置不能为空!";
                }
                //endregion

                //region 软件大小
                //1.软件大小不能为空!
                soft_size = vo.getSoft_size().trim();
                if (soft_size.length() > 0)
                {
                    //2.长度不能超过90个字符!
                    if (soft_size.length() > 90)
                    {
                        return "软件位置长度不能超过90个字符!";
                    }
                    //3.必须全部是数字!
                    if (!soft_size.matches("[0-9]*"))
                    {
                        return "软件大小必须全部是数字!";
                    }
                }
                else
                {
                    return "请输入软件位置!";
                }
                //endregion

                //实现保存
                vo.setSoft_name(softName);
                //创建时间
                vo.setSoft_createTime(new SimpleDateFormat("yyyy-MM-dd").parse(vo.getSoft_createTime2().trim()));
                //描述
                vo.setSoft_description(soft_description);
                //大小
                vo.setSoft_size(soft_size + "MB");
                //是否隐藏
                String softIsHidden = vo.getSoft_isHidden2().trim();

                int orclIsHidden = 0;

                if (softIsHidden.equals("1"))
                {
                    vo.setSoft_isHidden(true);
                    orclIsHidden = 1;
                }
                if (softIsHidden.equals("0"))
                {
                    vo.setSoft_isHidden(false);
                    orclIsHidden = 0;
                }
                //位置
                vo.setSoft_location(soft_location);
                //类型(写sql语句获取类型主键)
                soft_type = vo.getSoft_type2().trim();
                //获取类型主键
                Integer softTypeId = (Integer) getSession()
                          .createQuery("select st.id from SoftType st where st.soft_type_name= '" + soft_type + "' ")
                          .list()
                          .get(0);
                SoftType softType = getSession().get(SoftType.class, softTypeId);
                vo.setSoft_type(softType);
                //打开方式(sql实现)
                soft_openWays = vo.getSoft_openWays2().trim();
                //获取打开方式主键
                Integer softOpenWaysId = (Integer) getSession()
                          .createQuery("select so.id from SoftOpenWays so where so.soft_openWays='" + soft_openWays + "'")
                          .list()
                          .get(0);
                vo.setSoft_openWays(getSession().get(SoftOpenWays.class, softOpenWaysId));

                //获取软件实体类中最大主键值
                Integer saveSoftId = (Integer) getSession()
                          .createQuery("select max(s.id) from Software s")
                          .list().get(0) + 1;

                String addSQL = new StringBuilder()
                          .append("INSERT INTO QIN_SOFTWARE6\n")
                          .append("(\n")
                          .append("  SOFT_ID, SOFT_NAME, SOFT_DESCRIPTION,\n")
                          .append("  SOFT_ISHIDDEN, SOFT_CREATETIME, SOFT_LOCATION,\n")
                          .append("  SOFT_SIZE, SOFT_TYPE, SOFT_OPENWAYS,\n")
                          .append("  SOFT_TYPE_SOFT_ID)\n")
                          .append("VALUES\n")
                          .append("  (\n")
                          .append("    ")
                          .append(saveSoftId)
                          .append(", '")
                          .append(vo.getSoft_name())
                          .append("', '")
                          .append(vo.getSoft_description())
                          .append("',\n")
                          .append("    ")
                          .append(orclIsHidden)
                          .append(", TO_DATE('")
                          .append(vo.getSoft_createTime2().trim())
                          .append("', 'YYYY-MM-DD'),\n")
                          .append("    '")
                          .append(vo.getSoft_location())
                          .append("', '")
                          .append(vo.getSoft_size())
                          .append("', ")
                          .append(softTypeId)
                          .append(", ")
                          .append(softOpenWaysId)
                          .append(", ")
                          .append(softTypeId)
                          .append("\n")
                          .append("  )").toString();
                getSession().createSQLQuery(addSQL).executeUpdate();
            }
            else
            {
                //直接返回错误信息
                return "请输入软件名称!";
            }

            return str_SUCCESS;
        }
        catch (Exception ex)
        {
            return str_FAILED;
        }
    }
    //endregion
}

//region 注释

        /*
        //封装软件名称第一个字符
        String startSoftName = softName.substring(0, 1);

        //1.软件名称不能为空!
        if (softName.length() == 0)
        {
            qinObj.returnJson("软件名称不能为空, 请输入软件名称!", response);
        }
        //2.长度不能超过50个字符!
        if (softName.length() > 50)
        {
            qinObj.returnJson("软件名称不能超过50个字符!", response);
        }
        //3.只能以中文和英文开头!例如eclipse, IE, 谷歌浏览器等等
        //以中文开头
        boolean isStartWithChinese = qinObj.isChinese(startSoftName.toCharArray()[0]);
        //以英文开头
        boolean isStartWithEnglish = startSoftName.matches("[A-Za-z]");
        //4.不能以数字开头!
        if (!(isStartWithChinese || isStartWithEnglish))
        {
            qinObj.returnJson("软件名必须以中文和英文开头!例如:eclipse, 谷歌浏览器", response);
        }
        if (startSoftName.matches("[0-9]"))
        {
            qinObj.returnJson("软件名称不能以数字开头!", response);
        }
        //5.软件名称长度必须大于或等于2个字符
        if (softName.length() == 1)
        {
            qinObj.returnJson("软件名称必须大于2个字符!", response);
        }
        */
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


//region 注释
/*

        //m.keySet().iterator().next().iterator().next().equals(str_SUCCESS)
        Map<List<String>, Software> m = checkVO(vo);

        String ajaxMessage = "";

        //检查如果key全部为success的时候才能实现保存功能
        for (Iterator<List<String>> mKeys = m.keySet().iterator(); mKeys.hasNext(); ) {
            List<String> keyList = mKeys.next();

            for (Iterator<String> it = keyList.iterator(); it.hasNext(); ) {
                if (!it.next().equals(str_SUCCESS)) {
                    ajaxMessage = str_FAILED;
                } else {
                    ajaxMessage = str_SUCCESS;
                }
            }
        }

   private Map<List<String>, Software> checkVO(Software vo)
    {
        Map<List<String>, Software> result = new HashMap<List<String>, Software>();

        //接收界面所有值
        List<String> messages = new ArrayList<String>();
        //名称
        String soft_name = vo.getSoft_name().trim();
        //描述
        String soft_description = vo.getSoft_description().trim();
        //是否隐藏
        String soft_isHidden = vo.getSoft_isHidden2().trim();
        //创建时间
        String soft_createTime = vo.getSoft_createTime2().trim();
        //类型
        String soft_type = vo.getSoft_type2().trim();
        //位置
        String soft_location = vo.getSoft_location().trim();
        //大小
        String soft_size = vo.getSoft_size().trim();
        //打开方式
        String soft_openWays = vo.getSoft_openWays2().trim();

        //region 完成判断

        //region 软件名称
        if (soft_name.length() == 0)
        {
            messages.add("软件名称不能为空!");
        }
        else
        {
            //如果各项值都不为空则将软件设置成已截取空格的字段
            vo.setSoft_name(soft_name);
            addSuccess(messages);
        }
        if (soft_name.length() == 1)
        {
            messages.add("软件名称一定要大于2个字符!比如说IE, 谷歌浏览器");
        }
        else
        {
            vo.setSoft_name(soft_name);
            addSuccess(messages);
        }
        //定义变量封装软件名称第一个字符
        //由于长度大于0了说明肯定有一个及以上字符所以截取时不会发生异常
        String startSoftName = soft_name.substring(0, 1);
        //软件开头必须以英文和中文开头
        //以中文开头
        boolean isStartWithChinese = qinObj.isChinese(startSoftName.toCharArray()[0]);
        //以英文开头
        boolean isStartWithEnglish = startSoftName.matches("[A-Za-z]");
        if (!(isStartWithChinese || isStartWithEnglish))
        {
            messages.add("软件名必须以中文和英文开头!例如:eclipse, 谷歌浏览器");
        }
        else
        {
            vo.setSoft_name(soft_name);
            addSuccess(messages);
        }
        //不能以数字开头
        if (startSoftName.matches("[0-9]"))
        {
            messages.add("软件名称不能以数字开头!");
        }
        else
        {
            vo.setSoft_name(soft_name);
            addSuccess(messages);
        }
        //endregion

        //region 软件位置
        //endregion

        //region 软件大小
        //endregion

        //region 创建时间
        //endregion

        //endregion

        result.put(messages, vo);

        return result;
    }


 */

/*
public String saveSoft(Software vo)
    {
        try
        {
            String softName = vo.getSoft_name().trim();
            //事先定义些变量
            String soft_location = "";
            //大小
            String soft_size = "";
            //类型
            String soft_type = "";
            //打开方式
            String soft_openWays = "";

            //1.软件名称长度大于0
            if (softName.length() > 0)
            {
                //region 软件名称
                //执行剩下的判断
                //2.定义变量封装软件名称第一个字符
                //由于长度大于0了说明肯定有一个及以上字符所以截取时不会发生异常
                String startSoftName = softName.substring(0, 1);
                //3.软件开头必须以英文和中文开头
                //以中文开头
                boolean isStartWithChinese = qinObj.isChinese(startSoftName.toCharArray()[0]);
                //以英文开头
                boolean isStartWithEnglish = startSoftName.matches("[A-Za-z]");
                if (!(isStartWithChinese || isStartWithEnglish))
                {
                    return "软件名必须以中文和英文开头!例如:eclipse, 谷歌浏览器";
                }
                //4.不能以数字开头
                if (startSoftName.matches("[0-9]"))
                {
                    return "软件名称不能以数字开头!";
                }
                //5.名称长度一定要在两个字符以上
                if (softName.length() == 1)
                {
                    return "软件名称一定要大于2个字符!比如说IE, 谷歌浏览器";
                }

                //只有当软件名称输入正确时才能执行别的操作
                //所以页面其他的值在这里进行定义
                String soft_description = vo.getSoft_description().trim();
                //软件描述长度不能超过3000个字
                if (soft_description.length() > 3000)
                {
                    return "软件描述长度不能超过3000个字!";
                }
                //endregion

                //region 软件位置
                soft_location = vo.getSoft_location().trim();

                //1.软件位置不能为空!
                if (soft_location.length() > 0)
                {
                    //2.长度不能超过300个字符!
                    if (soft_location.length() > 300)
                    {
                        return "软件位置长度不能超过300个字符!";
                    }
                    //3.必须以中文或英文开头!不能以英文开头!
                    //截取第一个字符
                    String startSoftLocation = soft_location.substring(0, 1);
                    boolean loc_isStartWithChinese = qinObj.isChinese(startSoftLocation.toCharArray()[0]);
                    //以英文开头
                    boolean loc_isStartWithEnglish = startSoftLocation.matches("[A-Za-z]");
                    if (!(loc_isStartWithChinese || loc_isStartWithEnglish))
                    {
                        return "软件位置必须以中文和英文开头!";
                    }
                    //4.不能以数字开头
                    if (startSoftLocation.matches("[0-9]"))
                    {
                        return "软件位置不能以数字开头!";
                    }
                }
                else
                {
                    return "软件位置不能为空!";
                }
                //endregion

                //region 软件大小
                //1.软件大小不能为空!
                soft_size = vo.getSoft_size().trim();
                if (soft_size.length() > 0)
                {
                    //2.长度不能超过90个字符!
                    if (soft_size.length() > 90)
                    {
                        return "软件位置长度不能超过90个字符!";
                    }
                    //3.必须全部是数字!
                    if (!soft_size.matches("[0-9]*"))
                    {
                        return "软件大小必须全部是数字!";
                    }
                }
                else
                {
                    return "请输入软件位置!";
                }
                //endregion

                //实现保存
                vo.setSoft_name(softName);
                //创建时间
                vo.setSoft_createTime(new SimpleDateFormat("yyyy-MM-dd").parse(vo.getSoft_createTime2().trim()));
                //描述
                vo.setSoft_description(soft_description);
                //大小
                vo.setSoft_size(soft_size + "MB");
                //是否隐藏
                String softIsHidden = vo.getSoft_isHidden2().trim();

                int orclIsHidden = 0;

                if (softIsHidden.equals("1"))
                {
                    vo.setSoft_isHidden(true);
                    orclIsHidden = 1;
                }
                if (softIsHidden.equals("0"))
                {
                    vo.setSoft_isHidden(false);
                    orclIsHidden = 0;
                }
                //位置
                vo.setSoft_location(soft_location);
                //类型(写sql语句获取类型主键)
                soft_type = vo.getSoft_type2().trim();
                //获取类型主键
                Integer softTypeId = (Integer) getSession()
                          .createQuery("select st.id from SoftType st where st.soft_type_name= '" + soft_type + "' ")
                          .list()
                          .get(0);
                SoftType softType = getSession().get(SoftType.class, softTypeId);
                vo.setSoft_type(softType);
                //打开方式(sql实现)
                soft_openWays = vo.getSoft_openWays2().trim();
                //获取打开方式主键
                Integer softOpenWaysId = (Integer) getSession()
                          .createQuery("select so.id from SoftOpenWays so where so.soft_openWays='" + soft_openWays + "'")
                          .list()
                          .get(0);
                vo.setSoft_openWays(getSession().get(SoftOpenWays.class, softOpenWaysId));

                //获取软件实体类中最大主键值
                Integer saveSoftId = (Integer) getSession()
                          .createQuery("select max(s.id) from Software s")
                          .list().get(0) + 1;

                String addSQL = new StringBuilder()
                          .append("INSERT INTO QIN_SOFTWARE6\n")
                          .append("(\n")
                          .append("  SOFT_ID, SOFT_NAME, SOFT_DESCRIPTION,\n")
                          .append("  SOFT_ISHIDDEN, SOFT_CREATETIME, SOFT_LOCATION,\n")
                          .append("  SOFT_SIZE, SOFT_TYPE, SOFT_OPENWAYS,\n")
                          .append("  SOFT_TYPE_SOFT_ID)\n")
                          .append("VALUES\n")
                          .append("  (\n")
                          .append("    ")
                          .append(saveSoftId)
                          .append(", '")
                          .append(vo.getSoft_name())
                          .append("', '")
                          .append(vo.getSoft_description())
                          .append("',\n")
                          .append("    ")
                          .append(orclIsHidden)
                          .append(", TO_DATE('")
                          .append(vo.getSoft_createTime2().trim())
                          .append("', 'YYYY-MM-DD'),\n")
                          .append("    '")
                          .append(vo.getSoft_location())
                          .append("', '")
                          .append(vo.getSoft_size())
                          .append("', ")
                          .append(softTypeId)
                          .append(", ")
                          .append(softOpenWaysId)
                          .append(", ")
                          .append(softTypeId)
                          .append("\n")
                          .append("  )").toString();
                getSession().createSQLQuery(addSQL).executeUpdate();
            }
            else
            {
                //直接返回错误信息
                return "请输入软件名称!";
            }

            return str_SUCCESS;
        }
        catch (Exception ex)
        {
            return str_FAILED;
        }
    }
 */
//endregion














