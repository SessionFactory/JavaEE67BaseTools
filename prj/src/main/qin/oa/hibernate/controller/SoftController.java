package qin.oa.hibernate.controller;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import qin.javaee65.core.hibernate.controller.BaseController;
import qin.oa.hibernate.domain.Software;
import qin.oa.hibernate.service.SoftwareService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static qin.oa.hibernate.HibernateBasePath.qinObj;

/**
 * 软件控制层实现
 *
 * @author qinzhengying
 * @since 1.6
 */
@Controller(value = "softController65")
@Scope("prototype")
@RequestMapping(value = "/soft")
@SuppressWarnings("all")
public class SoftController
          extends BaseController<Software>
          implements SoftControllerI
{
    private static final long serialVersionUID = 7491697672682096675L;

    //region 注入软件服务层
    private SoftwareService softwareService;

    public SoftwareService getSoftwareService()
    {
        return softwareService;
    }

    @Resource
    public void setSoftwareService(SoftwareService softwareService)
    {
        this.softwareService = softwareService;
    }
    //endregion

    //region 四大操作

    //region 增
    @RequestMapping(value = "/addSoft")
    public void addSoft(Software vo, HttpServletResponse response, HttpServletRequest request)
    {
        String msg = "";

        try
        {
            //实现新增功能并且页面的逻辑操作都交给数据访问层
            msg = softwareService.saveSoft(vo);

            qinObj.returnJson(msg, response);

            actionFlag = true;
        }
        catch (Exception ex)
        {
            actionFlag = false;
        }
        finally
        {
            qinObj.doCheck(actionFlag);
        }
    }
    //endregion

    //region 删
    @RequestMapping(value = "/delSoft")
    public void delSoft(HttpServletResponse response, HttpServletRequest request)
    {
        String names = "";

        try
        {
            names = request.getParameter("names");
            String ajaxMsg = softwareService.doDelete(names);

            actionFlag = true;
        }
        catch (Exception ex)
        {
            actionFlag = false;
        }
        finally
        {
            qinObj.doCheck(actionFlag);
        }
    }
    //endregion

    //region 改
    //endregion

    //region 查

    /**
     * 实现条件查询
     *
     * @param vo       软件实体类
     * @param response 回复
     * @param request  请求
     */
    @RequestMapping(value = "/searchSoft")
    public void searchSoft(Software vo, HttpServletResponse response, HttpServletRequest request)
    {
        try
        {
            //传到前台的消息值(success:function(msg){})由ajax做接收并且判断是否成功或失败
            Map<String, List> msg = softwareService.findByEntityMap(vo);

            String ajaxMsg = "";

            //get key
            for (Iterator<String> it = msg.keySet().iterator(); it.hasNext(); )
            {
                ajaxMsg = it.next();
            }

            if (ajaxMsg == str_SUCCESS)
            {
                StringBuilder htmlSoftTable = softwareService.appendSearchSoftHTML(msg);
                qinObj.returnJson(htmlSoftTable.toString(), response);
            }
            else
            {
                qinObj.returnJson("没有任何记录!", response);
            }

            actionFlag = true;
        }
        catch (Exception ex)
        {
            actionFlag = false;
        }
        finally
        {
            qinObj.doCheck(actionFlag);
        }
    }

    @RequestMapping(value = "/mySearchPage")
    public ModelAndView mySearchPage(HttpServletRequest request, StringBuilder msg)
    {
        request.setAttribute("msg", msg);

        return new ModelAndView("soft/mySearchPage");
    }

    //endregion

    //region 查询成功后刷新datagrid
    /*
    @RequestMapping(value = "/refreshGrid")
    public void refreshGrid(HttpServletResponse response, List<Object[]> softList)
    {
        try
        {
            JSONArray jsonArray = new JSONArray();
            //map
            JSONObject object;

            for (int i = 0; i < softList.size(); i++)
            {
                Object[] softObjects = softList.get(i);

                object = new JSONObject();

                object.put("soft_name", softObjects[1]);
                object.put("soft_description", softObjects[2]);
                object.put("soft_isHidden", softObjects[3]);
                object.put("soft_createTime", softObjects[4].toString());
                object.put("soft_location", softObjects[5]);
                object.put("soft_size", softObjects[6]);
                object.put("soft_openWays", softObjects[7]);
                object.put("soft_type", softObjects[8]);

                //将信息写进list
                jsonArray.add(object);
            }

            String baseStr = "{\"total\":" + softList.size() + ",\"rows\":";
            baseStr = baseStr + jsonArray.toString() + "}";
            qinObj.returnJson(baseStr, response);

            actionFlag = true;
        }
        catch (Exception ex)
        {
            //输出异常信息
            qinObj.superInfo(ex);
            actionFlag = false;
        }
        finally
        {
            qinObj.doCheck(actionFlag);
        }
    }
    */
    //endregion

    //endregion

    //region 返回主页面

    /**
     * 返回主页面
     *
     * @return 主页面路径
     */
    @RequestMapping(value = "/doMainView")
    @Override
    public ModelAndView doMainView()
    {
        return new ModelAndView("soft/doMainView");
    }
    //endregion

    //region 返回bootstrap select页面

    /**
     * 返回bootstrap select页面
     */
    @RequestMapping(value = "/bootstrapSelect")
    public ModelAndView doSelect()
    {
        return new ModelAndView("soft/bootstrapSelect");
    }
    //endregion

    //region 返回列表页面

    /**
     * 返回列表页面
     *
     * @param entity   实体类
     * @param response 回复
     * @return 列表页面
     */
    @Override
    public ModelAndView list(Software entity, HttpServletResponse response)
    {
        return null;
    }
    //endregion

    //region 返回新增页面

    /**
     * 返回新增页面
     *
     * @param entity   实体类
     * @param response 回复
     * @return 新增页面
     */
    @RequestMapping(value = "/operations/doAdd")
    @Override
    public ModelAndView add(Software entity, HttpServletResponse response)
    {
        return new ModelAndView("soft/operations/doAdd");
    }
    //endregion

    //region 返回更新页面

    /**
     * 返回更新页面
     *
     * @param entity   实体类
     * @param response 回复
     * @return 更新页面
     */
    @Override
    public ModelAndView edit(Software entity, HttpServletResponse response)
    {
        return null;
    }
    //endregion

    //region 返回删除页面

    /**
     * 返回删除页面
     *
     * @param entity   实体类
     * @param response 回复
     * @return 删除页面
     */
    @Override
    public ModelAndView delete(Software entity, HttpServletResponse response)
    {
        return null;
    }
    //endregion

    //region 查询软件所有信息

    /**
     * 查询所有信息
     *
     * @param response 回复
     */
    @RequestMapping(value = "/searchAll")
    public void searchAll(HttpServletResponse response)
    {
        //先初始化集合变量
        List<Object[]> softList = null;

        try
        {
            softList = (List<Object[]>) softwareService.searchAll();

            JSONArray jsonArray = new JSONArray();
            //map
            JSONObject object;

            for (int i = 0; i < softList.size(); i++)
            {
                Object[] objects = softList.get(i);
                String isHidden = objects[3].toString();
                String soft_isHidden = "";

                object = new JSONObject();

                //软件是否隐藏0显示否1显示是
                if (isHidden.equals("0"))
                {
                    soft_isHidden = "否";
                }
                if (isHidden.equals("1"))
                {
                    soft_isHidden = "是";
                }

                object.put("soft_name", objects[1]);
                object.put("soft_description", objects[2]);
                object.put("soft_isHidden", soft_isHidden);
                object.put("soft_createTime", objects[4].toString());
                object.put("soft_location", objects[5]);
                object.put("soft_size", objects[6]);
                object.put("soft_openWays", objects[7]);
                object.put("soft_type", objects[8]);

                //将信息写进list
                jsonArray.add(object);
            }

            String baseStr = "{\"total\":" + softList.size() + ",\"rows\":";
            baseStr = baseStr + jsonArray.toString() + "}";
            qinObj.returnJson(baseStr, response);

            actionFlag = true;
        }
        catch (Exception ex)
        {
            //输出异常信息
            qinObj.superInfo(ex);
            actionFlag = false;
        }
        finally
        {
            qinObj.doCheck(actionFlag);
        }
    }
    //endregion
}