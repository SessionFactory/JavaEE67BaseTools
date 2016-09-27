package qin.oa.hibernate.dao.impl;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import qin.javaee65.core.hibernate.dao.impl.JavaEE65DAOSupportImpl;
import qin.javaee65.exceptions.JavaEE6Exception;
import qin.javaee65.exceptions.ObjectNotFoundException6;
import qin.oa.hibernate.dao.SoftwareDAO;
import qin.oa.hibernate.domain.SoftOpenWays;
import qin.oa.hibernate.domain.SoftType;
import qin.oa.hibernate.domain.Software;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static qin.oa.hibernate.HibernateBasePath.log4jPath;
import static qin.oa.hibernate.HibernateBasePath.qinObj;

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
        //region sqlQuery
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
        //endregion
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
        String result = "";
        Map<List<String>, Software> map = null;
        Software soft = new Software();
        boolean daoFlag = false;

        try
        {
            map = checkVO(vo);

            //如果接受的消息值全部为success则执行保存并且将success传到后台
            //Set<List<String>> keySet = map.keySet();

            //遍历key值(分开写比较直观)
            for (Iterator<List<String>> keyIt = map.keySet().iterator(); keyIt.hasNext(); )
            {
                List<String> messages = keyIt.next();
                //在key中查找消息值不为success的语句
                for (int i = 0; i < messages.size(); i++)
                {
                    String ajaxMsg = messages.get(i);
                    if (ajaxMsg != str_SUCCESS)
                    {
                        //qinObj.superInfo(ajaxMsg);
                        //并且赋值给ajax传送到前台
                        result = ajaxMsg;
                        //程序终止运行
                        break;
                    }
                    else
                    {
                        //获取value
                        soft = map.get(messages);
                        //如果没有错误则将success赋给ajax
                        result = str_SUCCESS;
                        daoFlag = true;
                    }
                }
            }

            //region 执行保存
            if (daoFlag)
            {
                int orclIsHidden = 0;
                //是隐藏
                if (soft.isSoft_isHidden())
                {
                    orclIsHidden = 1;
                }
                else
                {
                    orclIsHidden = 0;
                }

                //只有当所有条件为正确的时候才能执行保存
                String queryString = new StringBuilder()
                          .append("INSERT INTO QIN_SOFTWARE6\n")
                          .append("(\n")
                          .append("  SOFT_ID, SOFT_NAME, SOFT_DESCRIPTION,\n")
                          .append("  SOFT_ISHIDDEN, SOFT_CREATETIME, SOFT_LOCATION,\n")
                          .append("  SOFT_SIZE, SOFT_TYPE, SOFT_OPENWAYS,\n")
                          .append("  SOFT_TYPE_SOFT_ID)\n")
                          .append("VALUES\n")
                          .append("  (\n")
                          .append("    ")
                          .append(soft.getId())
                          .append(", '")
                          .append(soft.getSoft_name())
                          .append("', '")
                          .append(soft.getSoft_description())
                          .append("',\n")
                          .append("    ")
                          .append(orclIsHidden)
                          .append(", TO_DATE('")
                          .append(vo.getSoft_createTime2().trim())
                          .append("', 'YYYY-MM-DD'),\n")
                          .append("    '")
                          .append(soft.getSoft_location())
                          .append("', '")
                          .append(soft.getSoft_size())
                          .append("', ")
                          .append(getSoftTypeId(vo.getSoft_type2().trim()))
                          .append(", ")
                          .append(getSoftOpenWaysId(vo.getSoft_openWays2().trim()))
                          .append(", ")
                          .append(getSoftTypeId(vo.getSoft_type2().trim()))
                          .append("\n")
                          .append("  )").toString();

                getSession().createSQLQuery(queryString).executeUpdate();
            }
            //endregion
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }

        return result;
    }

    //region 判断从界面接收的字段是否符合必备条件

    /**
     * 判断从界面接收的字段是否符合必备条件
     *
     * @param vo 软件实体类
     * @return 返回Map集合其中key是String集合用来记录消息值, 成功为success, 失败则存入失败信息<br>
     * value值是软件实体类将正确的字段存入软件实体类中
     * @throws ParseException 日期转换异常
     */
    private Map<List<String>, Software> checkVO(Software vo) throws ParseException
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

        Software soft = new Software();

        //region 检验软件名称(如果检验成功返回success, 否则返回失败)

        //region 软件名称
        //1.软件名称不能为空!(如果为空则停止校验不往下执行了)
        //或者长度只为1
        if (soft_name.length() == 0 || soft_name.length() == 1)
        {
            messages.add("请输入正确的软件名称!长度必须在2个字符以上!比如:eclipse, 谷歌浏览器, IE");
        }
        else
        {
            //还需要做其他的检验(如果别的检验全部通过再给message赋值为成功)
            //2.必须以英文和中文开头, 不能以数字开头
            //截取软件名称第一个字符
            String startSoftName = soft_name.substring(0, 1);
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
                //软件名称不能重复!
                if
                          (
                          getSession()
                                    .createQuery
                                              (
                                                        new StringBuilder()
                                                                  .append("from Software s where s.soft_name = '")
                                                                  .append(soft_name)
                                                                  .append("'")
                                                                  .toString()
                                              )
                                    .list().size() > 0
                          )
                {
                    messages.add(soft_name + "在表中已存在!请填写别的软件名称!");
                }
                else
                {
                    messages.add(str_SUCCESS);
                    soft.setSoft_name(soft_name);
                }
            }
        }
        //endregion

        //region 软件描述
        if (soft_description.length() > 3000)
        {
            messages.add("软件描述长度不能超过3000个字!");
        }
        else
        {
            messages.add(str_SUCCESS);
            soft.setSoft_description(soft_description);
        }
        //endregion

        //region 软件位置
        if (soft_location.length() == 0)
        {
            messages.add("软件位置不能为空!");
        }
        else
        {
            //截取第一个字符
            String startSoftLocation = soft_location.substring(0, 1);
            //以英文开头
            boolean loc_isStartWithEnglish = startSoftLocation.matches("[A-Za-z]");

            if (!loc_isStartWithEnglish || startSoftLocation.matches("[0-9]"))
            {
                messages.add("软件位置只能以英文开头!");
            }
            else
            {
                messages.add(str_SUCCESS);
                soft.setSoft_location(soft_location);
            }
        }
        //endregion

        //region 软件大小
        if (soft_size.length() == 0)
        {
            messages.add("软件大小不能为空!");
        }
        else
        {
            if (soft_size.length() > 90 || !soft_size.matches("[0-9]*"))
            {
                messages.add("软件大小不能超过90个字符并且必须全部是数字!");
            }
            else
            {
                messages.add(str_SUCCESS);
                soft.setSoft_size(soft_size + "MB");
            }
        }

        //endregion

        //endregion

        //region 软件是否隐藏
        if (soft_isHidden.equals("1"))
        {
            vo.setSoft_isHidden(true);
        }
        if (soft_isHidden.equals("0"))
        {
            vo.setSoft_isHidden(false);
        }
        soft.setSoft_isHidden(vo.isSoft_isHidden());
        //endregion

        //创建时间
        //时间不能为空
        if (soft_createTime.length() == 0)
        {
            messages.add("软件创建时间不能为空!");
        }
        else
        {
            messages.add(str_SUCCESS);
            soft.setSoft_createTime(new SimpleDateFormat("yyyy-MM-dd").parse(soft_createTime));
        }
        //类型
        //获取类型主键
        Integer softTypeId = getSoftTypeId(soft_type);
        soft.setSoft_type(getSession().get(SoftType.class, softTypeId));

        //打开方式
        //获取打开方式主键
        Integer softOpenWaysId = getSoftOpenWaysId(soft_openWays);
        soft.setSoft_openWays(getSession().get(SoftOpenWays.class, softOpenWaysId));

        //设置主键值
        soft.setId
                  (
                            (Integer) getSession()
                                      .createQuery("select max(s.id) from Software s")
                                      .list().get(0) + 1
                  );

        result.put(messages, soft);

        return result;
    }

    /**
     * 获取软件打开方式主键
     *
     * @param soft_openWays
     * @return
     */
    private Integer getSoftOpenWaysId(String soft_openWays)
    {
        return (Integer) getSession()
                  .createQuery
                            (
                                      new StringBuilder()
                                                .append("select so.id from SoftOpenWays so where so.soft_openWays='")
                                                .append(soft_openWays)
                                                .append("'").toString()
                            )
                  .list()
                  .get(0);
    }

    /**
     * 获取软件类型主键
     *
     * @param soft_type
     * @return
     */
    private Integer getSoftTypeId(String soft_type)
    {
        return (Integer) getSession()
                  .createQuery
                            (
                                      new StringBuilder()
                                                .append("select st.id from SoftType st where st.soft_type_name= '")
                                                .append(soft_type)
                                                .append("' ").toString()
                            )
                  .list()
                  .get(0);
    }
    //endregion

    //endregion

    //region 删除软件信息

    @Override
    public String doDelete(String names) throws JavaEE6Exception
    {
        String result = str_SUCCESS;

        System.out.println(names);

        if (names.length() == 0)
        {
            result = str_FAILED;
            throw new ObjectNotFoundException6("要删除的软件名称为空!");
        }

        String delQueryString = "DELETE FROM QIN_SOFTWARE6\n" +
                  "WHERE SOFT_NAME\n" +
                  "      IN (" + names.substring(0, names.length() - 1) + ")";

        getSession().createSQLQuery(delQueryString).executeUpdate();

        return result;
    }

    //endregion

}




























