package qin.oa.hibernate.domain;

import qin.javaee65.core.hibernate.SuperEntity65;

import java.util.HashSet;
import java.util.Set;

/**
 * 软件类型
 *
 * @author qinzhengying
 * @since 1.6
 */
public class SoftType implements SuperEntity65<Integer>
{
    private static final long serialVersionUID = 1195922150129005248L;

    //region 主键
    private Integer id;

    @Override
    public Integer getId()
    {
        return id;
    }

    @Override
    public void setId(Integer id)
    {
        this.id = id;
    }
    //endregion

    //region 与软件多对一
    /**
     * 与软件多对一
     */
    private Set<Software> softwareSet = new HashSet<Software>();

    public Set<Software> getSoftwareSet()
    {
        return softwareSet;
    }

    public void setSoftwareSet(Set<Software> softwareSet)
    {
        this.softwareSet = softwareSet;
    }
    //endregion

    //region 软件类型名称
    private String soft_type_name;

    public String getSoft_type_name()
    {
        return soft_type_name;
    }

    public void setSoft_type_name(String soft_type_name)
    {
        this.soft_type_name = soft_type_name;
    }
    //endregion
}