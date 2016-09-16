package qin.oa.hibernate.domain;

import qin.javaee65.core.hibernate.SuperEntity65;

import java.util.HashSet;
import java.util.Set;

/**
 * 软件打开方式
 *
 * @author qinzhengying
 * @since 1.6
 */
public class SoftOpenWays implements SuperEntity65<Integer>
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

    //region 打开方式
    private String soft_openWays;

    public String getSoft_openWays()
    {
        return soft_openWays;
    }

    public void setSoft_openWays(String soft_openWays)
    {
        this.soft_openWays = soft_openWays;
    }
    //endregion
}