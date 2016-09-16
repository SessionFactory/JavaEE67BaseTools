package qin.javaee65.core.hibernate.controller;

import org.springframework.web.servlet.ModelAndView;
import qin.javaee65.core.JavaEE6BaseSupport;
import qin.javaee65.core.hibernate.SuperEntity65;

import javax.servlet.http.HttpServletResponse;

/**
 * Hibernate最基础控制层6.5
 *
 * @param <E> 任意实体类型
 * @author qinzhengying
 * @since 1.6
 */
@SuppressWarnings("all")
public interface HibernateBaseController65<E extends SuperEntity65>
          extends JavaEE6BaseSupport
{
    //region 返回页面

    /**
     * 返回列表页面
     *
     * @param entity   实体类
     * @param response 回复
     * @return 列表页面
     */
    ModelAndView list(E entity, HttpServletResponse response);

    /**
     * 返回新增页面
     *
     * @param entity   实体类
     * @param response 回复
     * @return 新增页面
     */
    ModelAndView add(E entity, HttpServletResponse response);

    /**
     * 返回更新页面
     *
     * @param entity   实体类
     * @param response 回复
     * @return 更新页面
     */
    ModelAndView edit(E entity, HttpServletResponse response);

    /**
     * 返回删除页面
     *
     * @param entity   实体类
     * @param response 回复
     * @return 删除页面
     */
    ModelAndView delete(E entity, HttpServletResponse response);
    //endregion
}
