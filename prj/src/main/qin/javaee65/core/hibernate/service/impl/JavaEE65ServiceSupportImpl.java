package qin.javaee65.core.hibernate.service.impl;

import qin.javaee65.core.hibernate.service.JavaEE65ServiceSupport;
import qin.javaee65.exceptions.CollectionsNULLException6;
import qin.javaee65.exceptions.JavaEE6Exception;
import qin.javaee65.exceptions.ObjectNotFoundException6;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * JavaEE8服务层抽象实现
 *
 * @param <T>  任意实体类
 * @param <ID> 任意主键类型
 */
@SuppressWarnings("all")
public abstract class JavaEE65ServiceSupportImpl<T, ID extends Serializable>
          implements JavaEE65ServiceSupport<T, ID>
{
    private static final long serialVersionUID = 5122145276109601827L;

    //region 增

    /**
     * 新增记录
     *
     * @param entity 需要保存的实体类
     * @return 返回任意类型
     * @throws ObjectNotFoundException6 实体不存在抛出异常<br>
     *                                  检测实体是否为空可以使用<code>Objects.checkClass()实现</code>
     */
    @Override
    public Serializable superSave(T entity) throws ObjectNotFoundException6
    {
        return getDAO().superSave(entity);
    }
    //endregion

    //region 删

    /**
     * 根据实体删除记录
     *
     * @param entity 需要删除的实体
     * @throws ObjectNotFoundException6 实体不存在抛出异常<br>
     *                                  检测实体是否为空可以使用<code>Objects.checkClass()实现</code>
     */
    @Override
    public void superDelete(T entity) throws ObjectNotFoundException6
    {
        getDAO().superDelete(entity);
    }

    /**
     * 删除所有实体
     *
     * @param entities 实体集合
     * @throws CollectionsNULLException6 如果集合为空则抛出集合为空异常
     */
    @Override
    public void superDeleteAll(Collection<?> entities) throws CollectionsNULLException6
    {
        getDAO().superDeleteAll(entities);
    }
    //endregion

    //region 改

    /**
     * 修改实体
     *
     * @param entity 需要修改的实体类
     * @throws ObjectNotFoundException6 实体不存在抛出异常<br>
     *                                  检测实体是否为空可以使用<code>Objects.checkClass()实现</code>
     */
    @Override
    public void superUpdate(T entity) throws ObjectNotFoundException6
    {
        getDAO().superUpdate(entity);
    }
    //endregion

    //region 查

    /**
     * 根据hql语句中的条件查询
     *
     * @param queryString hql语句
     * @param paramNames  参数名称
     * @param values      参数值
     * @return 查询结果集合
     * @throws JavaEE6Exception 抛出大异常(如果参数值和参数名称长度不同则抛出异常)
     */
    @Override
    public List<?> superFindByNamedParam(String queryString, String[] paramNames, Object[] values)
              throws JavaEE6Exception
    {
        return getDAO().superFindByNamedParam(queryString, paramNames, values);
    }

    /**
     * 查询全部记录
     *
     * @return 查询结果集合
     */
    @Override
    public List<T> findAll()
    {
        return getDAO().findAll();
    }
    //endregion
}