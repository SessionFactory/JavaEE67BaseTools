package qin.javaee65.core.hibernate.service;

import qin.javaee65.core.JavaEE6BaseSupport;
import qin.javaee65.core.hibernate.dao.JavaEE65DAOSupport;
import qin.javaee65.exceptions.CollectionsNULLException6;
import qin.javaee65.exceptions.JavaEE6Exception;
import qin.javaee65.exceptions.ObjectNotFoundException6;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * JavaEE6最顶层服务层抽取
 *
 * @param <T>  任意实体类
 * @param <ID> 主键类型
 * @author qinzhengying
 * @since 1.6
 */
@SuppressWarnings("all")
public interface JavaEE65ServiceSupport<T, ID extends Serializable> extends JavaEE6BaseSupport
{
    //region 获取父级数据访问层
    JavaEE65DAOSupport getDAO();
    //endregion

    //region 增

    /**
     * 新增记录
     *
     * @param entity 需要保存的实体类
     * @return 返回任意类型
     * @throws ObjectNotFoundException6 实体不存在抛出异常<br>
     *                                  检测实体是否为空可以使用<code>Objects.checkClass()实现</code>
     */
    Serializable superSave(T entity) throws ObjectNotFoundException6;
    //endregion

    //region 删

    /**
     * 根据实体删除记录
     *
     * @param entity 需要删除的实体
     * @throws ObjectNotFoundException6 实体不存在抛出异常<br>
     *                                  检测实体是否为空可以使用<code>Objects.checkClass()实现</code>
     */
    void superDelete(T entity) throws ObjectNotFoundException6;

    /**
     * 删除所有实体
     *
     * @param entities 实体集合
     * @throws CollectionsNULLException6 如果集合为空则抛出集合为空异常
     */
    void superDeleteAll(Collection<?> entities) throws CollectionsNULLException6;
    //endregion

    //region 改

    /**
     * 修改实体
     *
     * @param entity 需要修改的实体类
     * @throws ObjectNotFoundException6 实体不存在抛出异常<br>
     *                                  检测实体是否为空可以使用<code>Objects.checkClass()实现</code>
     */
    void superUpdate(T entity) throws ObjectNotFoundException6;
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
    List<?> superFindByNamedParam(String queryString, String[] paramNames, Object[] values)
              throws JavaEE6Exception;

    /**
     * 查询全部记录
     *
     * @return 查询结果集合
     */
    List<T> findAll();

    /**
     * 根据实体类以及其他信息进行查询
     *
     * @param entity   指定实体类
     * @param elements 其他元素
     * @param <E>      任意类型
     * @return 返回查询结果集合
     */
    <E> List<?> findByEntity(T entity, E elements) throws JavaEE6Exception;

    //endregion
}












