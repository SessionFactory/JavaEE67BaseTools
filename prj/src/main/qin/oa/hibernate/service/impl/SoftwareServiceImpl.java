package qin.oa.hibernate.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import qin.javaee65.core.hibernate.service.impl.JavaEE65ServiceSupportImpl;
import qin.javaee65.exceptions.JavaEE6Exception;
import qin.oa.hibernate.dao.SoftwareDAO;
import qin.oa.hibernate.domain.Software;
import qin.oa.hibernate.service.SoftwareService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 软件服务层(打开方式)实现
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
        return entityDAO.findByEntity(entity, elements);
    }

    //region 查询所有软件信息
    @Override
    public List<?> searchAll()
    {
        return entityDAO.searchAll();
    }
    //endregion

    //region String类型的查询结果

    /**
     * 如果查询成功返回success否则返回failed
     *
     * @param entity 需要查询的实体
     * @return 信息
     * @throws JavaEE6Exception 抛出大异常
     */
    @Override
    public String findByEntity(Software entity) throws JavaEE6Exception
    {
        //使用泛型(jdk5新特性)
        List<Object> list = (List<Object>) findByEntity(entity, 0);

        if (list.size() > 0)
        {
            return str_SUCCESS;
        }
        else
        {
            return "empty";
        }
    }
    //endregion

    //region Map返回类型查询结果

    /**
     * Map返回类型查询结果
     *
     * @param entity 实体类
     * @return 将是否成功或失败结果放入key, 将查询结果放进list
     * @throws JavaEE6Exception
     */
    @Override
    public Map<String, List> findByEntityMap(Software entity) throws JavaEE6Exception
    {
        Map<String, List> m = new HashMap<String, List>();

        m.put(findByEntity(entity), findByEntity(entity, 0));

        return m;
    }
    //endregion

    //region 拼接html datagrid
    @Override
    public StringBuilder appendSearchSoftHTML(Map<String, List> msg)
    {
        /*
            如果是成功则刷新datagrid(成功的前提是保证查询成功有记录时才往表中添数据)
            成功还有两个条件:map的value的size大于0和_value集合size值大于0
            如果map的value的size值大于0则表示查询成功新建的list集合中肯定有值
        */
        List<Object[]> softList = msg.get(msg.keySet().iterator().next());

        //将list写进table并且当成html代码输出
        StringBuilder htmlSoftTable = new StringBuilder()
                  .append("               <thead>\n")
                  .append("                <tr>\n")
                  .append("                    <th data-options=\"field:'SOFT_ID', width: 100\">编号</th>\n")
                  .append("                    <th data-options=\"field:'SOFT_NAME', width: 300\">名称</th>\n")
                  .append("                    <th data-options=\"field:'SOFT_DESCRIPTION', width: 400\">描述</th>\n")
                  .append("                    <th data-options=\"field:'SOFT_ISHIDDEN', width: 100\">是否隐藏</th>\n")
                  .append("                    <th data-options=\"field:'SOFT_CREATETIME', width: 200\">创建时间</th>\n")
                  .append("                    <th data-options=\"field:'SOFT_LOCATION', width: 200\">位置</th>\n")
                  .append("                    <th data-options=\"field:'SOFT_SIZE', width: 200\">大小</th>\n")
                  .append("                    <th data-options=\"field:'SOFT_OPENWAYS', width: 300\">打开方式</th>\n")
                  .append("                    <th data-options=\"field:'SOFT_TYPE_NAME', width: 300\">软件类型</th>\n")
                  .append("                </tr>\n")
                  .append("                </thead>\n")
                  .append("                <tbody>\n");

        for (Iterator<Object[]> objIt = softList.iterator(); objIt.hasNext(); )
        {
            Object[] objs = objIt.next();

            htmlSoftTable.append("                <tr>\n")
                      //SOFT_ID
                      .append("                    <td>").append(objs[0]).append("</td>\n")
                      //SOFT_NAME
                      .append("                    <td>").append(objs[1]).append("</td>\n")
                      //SOFT_DESCRIPTION
                      .append("                    <td>").append(objs[2]).append("</td>\n")
                      //SOFT_ISHIDDEN
                      .append("                    <td>").append(objs[3]).append("</td>\n")
                      //SOFT_CREATETIME
                      .append("                    <td>").append(objs[4]).append("</td>\n")
                      //SOFT_LOCATION
                      .append("                    <td>").append(objs[5]).append("</td>\n")
                      //SOFT_SIZE
                      .append("                    <td>").append(objs[6]).append("</td>\n")
                      //SOFT_OPENWAYS
                      .append("                    <td>").append(objs[7]).append("</td>\n")
                      //SOFT_TYPE_NAME
                      .append("                    <td>").append(objs[8]).append("</td>\n")
                      .append("                </tr>\n");
        }

        htmlSoftTable.append("                </tbody>");

        return htmlSoftTable;
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
        return entityDAO.saveSoft(vo);
    }
    //endregion

    //region 删除软件信息

    @Override
    public String doDelete(String names) throws JavaEE6Exception
    {
        return entityDAO.doDelete(names);
    }

    //endregion
}

//region 注释
//StringBuilder htmlSoftTable = new StringBuilder()
//                  .append("               <thead>\n")
//                  .append("                <tr>\n")
//                  .append("                    <th data-options=\"field:'SOFT_ID', width: 100\">编号</th>\n")
//                  .append("                    <th data-options=\"field:'SOFT_NAME', width: 300\">名称</th>\n")
//                  .append("                    <th data-options=\"field:'SOFT_DESCRIPTION', width: 400\">描述</th>\n")
//                  .append("                    <th data-options=\"field:'SOFT_ISHIDDEN', width: 100\">是否隐藏</th>\n")
//                  .append("                    <th data-options=\"field:'SOFT_CREATETIME', width: 200\">创建时间</th>\n")
//                  .append("                    <th data-options=\"field:'SOFT_LOCATION', width: 200\">位置</th>\n")
//                  .append("                    <th data-options=\"field:'SOFT_SIZE', width: 200\">大小</th>\n")
//                  .append("                    <th data-options=\"field:'SOFT_OPENWAYS', width: 300\">打开方式</th>\n")
//                  .append("                    <th data-options=\"field:'SOFT_TYPE_NAME', width: 300\">软件类型</th>\n")
//                  .append("                </tr>\n")
//                  .append("                </thead>\n")
//                  .append("                <tbody>\n");
//
//        for (Iterator<Object[]> objIt = softList.iterator(); objIt.hasNext(); )
//        {
//            Object[] objs = objIt.next();
//
//            htmlSoftTable.append("                <tr>\n")
//                      //SOFT_ID
//                      .append("                    <td>").append(objs[0]).append("</td>\n")
//                      //SOFT_NAME
//                      .append("                    <td>").append(objs[1]).append("</td>\n")
//                      //SOFT_DESCRIPTION
//                      .append("                    <td>").append(objs[2]).append("</td>\n")
//                      //SOFT_ISHIDDEN
//                      .append("                    <td>").append(objs[3]).append("</td>\n")
//                      //SOFT_CREATETIME
//                      .append("                    <td>").append(objs[4]).append("</td>\n")
//                      //SOFT_LOCATION
//                      .append("                    <td>").append(objs[5]).append("</td>\n")
//                      //SOFT_SIZE
//                      .append("                    <td>").append(objs[6]).append("</td>\n")
//                      //SOFT_OPENWAYS
//                      .append("                    <td>").append(objs[7]).append("</td>\n")
//                      //SOFT_TYPE_NAME
//                      .append("                    <td>").append(objs[8]).append("</td>\n")
//                      .append("                </tr>\n");
//        }
//
//        htmlSoftTable.append("                </tbody>");
//
//        return htmlSoftTable;
//endregion















