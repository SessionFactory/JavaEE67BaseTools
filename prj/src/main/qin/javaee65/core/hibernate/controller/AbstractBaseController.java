package qin.javaee65.core.hibernate.controller;

import qin.javaee65.core.hibernate.SuperEntity65;

@SuppressWarnings("all")
public abstract class AbstractBaseController<E extends SuperEntity65> implements HibernateBaseController65<E>
{
    private static final long serialVersionUID = -3027225765572019271L;

    /**
     * 控制层是否运行成功
     */
    protected boolean actionFlag = false;
}