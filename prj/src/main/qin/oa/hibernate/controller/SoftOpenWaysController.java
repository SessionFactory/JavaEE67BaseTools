package qin.oa.hibernate.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import qin.javaee65.core.hibernate.controller.BaseController;
import qin.oa.hibernate.domain.SoftOpenWays;
import qin.oa.hibernate.service.SoftwareOpenWaysService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static qin.oa.hibernate.HibernateBasePath.objects;

/**
 * 软件打开方式控制层
 *
 * @author qinzhengying
 * @since 1.6
 */
@Controller(value = "softOpenWaysController65")
@Scope("prototype")
@RequestMapping(value = "/softOpenWays")
@SuppressWarnings("all")
public class SoftOpenWaysController
          extends BaseController<SoftOpenWays>
          implements SoftOpenWaysControllerI
{
    private static final long serialVersionUID = -2951639127480800571L;

    //region 注入软件打开方式服务层
    /**
     * 注入软件打开方式服务层
     */
    private SoftwareOpenWaysService softOpenWaysService;

    public SoftwareOpenWaysService getSoftOpenWaysService()
    {
        return softOpenWaysService;
    }

    @Resource
    public void setSoftOpenWaysService(SoftwareOpenWaysService softOpenWaysService)
    {
        this.softOpenWaysService = softOpenWaysService;
    }
    //endregion

    //region 查询所有软件打开方式的名称
    @RequestMapping(value = "/searchNames")
    //@ResponseBody
    public void searchNames(HttpServletResponse response)
    {
        List<String> names = softOpenWaysService.findOpenWaysNames();

        objects.returnJson(objects.appendSelect(names).toString(), response);
    }
    //endregion
}

//region 注释
   /*
        StringBuilder sb = new StringBuilder();
        int index = 0;

        for (Iterator<String> it = names.iterator(); it.hasNext(); index++)
        {
            //换行
            sb.append("<option value=\"" + index + "\">");
            sb.append(it.next()).append("</option>");
        }
        */
//endregion












