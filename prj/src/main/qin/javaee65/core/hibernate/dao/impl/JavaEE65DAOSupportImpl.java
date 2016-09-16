package qin.javaee65.core.hibernate.dao.impl;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import qin.javaee65.core.Objects;
import qin.javaee65.core.hibernate.dao.JavaEE65DAOSupport;
import qin.javaee65.exceptions.CollectionsNULLException6;
import qin.javaee65.exceptions.JavaEE6Exception;
import qin.javaee65.exceptions.ObjectNotFoundException6;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Repository(value = "objectDAO65")
@SuppressWarnings("all")
public class JavaEE65DAOSupportImpl<T, ID extends Serializable>
          extends HibernateTemplate
          implements JavaEE65DAOSupport<T, ID>
{
    private static final long serialVersionUID = -3602792260915038679L;

    //region 注入SessionFactory

    @Resource(name = "sessionFactory")
    @Override
    public void setSessionFactory(SessionFactory sessionFactory)
    {
        super.setSessionFactory(sessionFactory);
    }
    //endregion

    //region 使用父类输出方法
    private Objects objects = new Objects(getFileLocation());
    //endregion

    //region JavaEE65DAOSupport

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
        if (objects.checkObject(entity))
        {
            //如果实体存在则执行保存并且打印保存实体信息
            objects.printEntity(entity, str_save);

            return save(entity);
        }
        else
        {
            //实体不存在抛出异常
            return new ObjectNotFoundException6("你所保存的实体为空!");
        }
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
        //检测实体对象是否为空
        if (objects.checkObject(entity))
        {
            objects.printEntity(entity, str_delete);

            delete(entity);
        }
        else
        {
            throw new ObjectNotFoundException6("删除的实体对象为空");
        }
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
        if (entities.size() <= 0)
        {
            throw new CollectionsNULLException6();
        }
        else
        {
            deleteAll(entities);
        }
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
        //检测实体对象是否为空
        if (objects.checkObject(entity))
        {
            objects.printEntity(entity, str_update);

            update(entity);
        }
        else
        {
            throw new ObjectNotFoundException6();
        }
    }
    //endregion

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
        List<?> result = findByNamedParam(queryString, paramNames, values);

        if (result.size() <= 0)
        {
            objects.superInfo("并没有查询到符合相关条件的记录");
        }

        StringBuilder sb = new StringBuilder();
        sb.append("查找方法接收sql为:[")
                  .append(queryString)
                  .append(c_end)
                  .append("接收参数名为:[")
                  .append(objects.doAppendArrays(paramNames))
                  .append(c_end)
                  .append("接收参数值为:[")
                  .append(objects.doAppendArrays(values))
                  .append(c_end);

        return result;
    }

    /**
     * 查询全部记录
     *
     * @return 查询结果集合
     */
    @Override
    public List<T> findAll()
    {
        return loadAll(getEntityClass());
    }

    /**
     * 　根据实体类以及其他信息进行查询
     *
     * @param entity   指定实体类
     * @param elements 其他元素
     * @return 返回查询结果集合
     */
    @Override
    public <E> List<?> findByEntity(T entity, E elements)
    {
        return empty;
    }
    //endregion

    //region ClassSupport

    /**
     * 获取任意实体类 类 类型
     *
     * @return 已获取到的实体类
     */
    @Override
    public Class<T> getEntityClass()
    {
        return (Class<T>) Object.class;
    }
    //endregion

    //region JavaEE65PrintSupport

    /**
     * 获取log4j配置文件路径
     *
     * @return 已获取文件路径
     */
    @Override
    public String getLog4jLocations()
    {
        return objects.getLog4jLocations();
    }

    /**
     * 获取我的日志类
     *
     * @return 获取到的日志
     */
    @Override
    public Logger getMyLogger()
    {
        return Logger.getLogger(this.getClass());
    }

    @Override
    public String getFileLocation()
    {
        return "";
    }

    @Override
    public void setFileLocation(String fileLocation)
    {
        objects.setFileLocation(fileLocation);
    }
    //endregion
}