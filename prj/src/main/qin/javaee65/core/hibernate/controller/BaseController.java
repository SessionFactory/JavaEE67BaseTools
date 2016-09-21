package qin.javaee65.core.hibernate.controller;

import org.springframework.web.servlet.ModelAndView;
import qin.javaee65.core.hibernate.SuperEntity65;

import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("all")
public class BaseController<E extends SuperEntity65> implements HibernateBaseController65<E>
{
    private static final long serialVersionUID = -3027225765572019271L;

    /**
     * 控制层是否运行成功
     */
    protected boolean actionFlag = false;

    //region 实现父类方法

    /**
     * 返回列表页面
     *
     * @param entity   实体类
     * @param response 回复
     * @return 列表页面
     */
    @Override
    public ModelAndView list(E entity, HttpServletResponse response)
    {
        return null;
    }

    /**
     * 返回新增页面
     *
     * @param entity   实体类
     * @param response 回复
     * @return 新增页面
     */
    @Override
    public ModelAndView add(E entity, HttpServletResponse response)
    {
        return null;
    }

    /**
     * 返回更新页面
     *
     * @param entity   实体类
     * @param response 回复
     * @return 更新页面
     */
    @Override
    public ModelAndView edit(E entity, HttpServletResponse response)
    {
        return null;
    }

    /**
     * 返回删除页面
     *
     * @param entity   实体类
     * @param response 回复
     * @return 删除页面
     */
    @Override
    public ModelAndView delete(E entity, HttpServletResponse response)
    {
        return null;
    }
    //endregion
}