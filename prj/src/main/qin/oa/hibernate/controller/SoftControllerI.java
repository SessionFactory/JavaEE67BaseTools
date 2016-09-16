package qin.oa.hibernate.controller;

import org.springframework.web.servlet.ModelAndView;
import qin.javaee65.core.hibernate.controller.HibernateBaseController65;
import qin.oa.hibernate.domain.Software;

/**
 * 软件服务层接口
 *
 * @author qinzhengying
 * @since 1.6
 */
@SuppressWarnings("all")
public interface SoftControllerI extends HibernateBaseController65<Software>
{
    //region 返回主页面

    /**
     * 返回主页面
     *
     * @return 主页面路径
     */
    ModelAndView doMainView();
    //endregion
}
