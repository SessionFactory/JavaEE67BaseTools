package qin.oa.hibernate.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import qin.javaee65.core.hibernate.controller.BaseController;
import qin.oa.hibernate.domain.SoftType;
import qin.oa.hibernate.service.SoftwareTypeService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static qin.oa.hibernate.HibernateBasePath.objects;

/**
 * 软件类型控制层
 *
 * @author qinzhengying
 * @since 1.6
 */
@Controller(value = "softTypeController65")
@Scope("prototype")
@RequestMapping(value = "/softType")
@SuppressWarnings("all")
public class SoftTypeController
          extends BaseController<SoftType>
          implements SoftTypeControllerI
{
    private static final long serialVersionUID = -2951639127480800571L;

    //region 注入软件类型服务层
    /**
     * 注入软件类型服务层
     */
    private SoftwareTypeService softTypeService;

    public SoftwareTypeService getSoftTypeService()
    {
        return softTypeService;
    }

    @Resource
    public void setSoftTypeService(SoftwareTypeService softTypeService)
    {
        this.softTypeService = softTypeService;
    }
    //endregion

    //region 查询所有软件类型的名称

    /**
     * 查询所有软件类型的名称
     *
     * @param response
     */
    @RequestMapping(value = "/searchNames")
    public void searchNames(HttpServletResponse response)
    {
        List<String> names = softTypeService.findSoftTypeNames();

        objects.returnJson(objects.appendSelect(names).toString(), response);
    }
    //endregion
}















