package qin.oa.hibernate.domain;

import qin.javaee65.core.hibernate.SuperEntity65;

import java.util.Date;

/**
 * 软件实体类
 *
 * @author qinzhengying
 * @since 1.6
 */
@SuppressWarnings("all")
public class Software implements SuperEntity65<String>
{
    private static final long serialVersionUID = -6072068513361923913L;

    //region 构造函数
    public Software()
    {

    }

    /**
     * @param soft_name        名称
     * @param soft_description 描述
     * @param soft_isHidden    是否隐藏
     * @param soft_createTime  创建时间
     * @param soft_type        类型
     * @param soft_location    位置
     * @param soft_size        大小
     * @param soft_openWays    打开方式
     */
    public Software
    (
              String soft_name, String soft_description, boolean soft_isHidden, Date soft_createTime,
              SoftType soft_type, String soft_location, String soft_size, SoftOpenWays soft_openWays
    )
    {
        this.soft_name = soft_name;
        this.soft_description = soft_description;
        this.soft_isHidden = soft_isHidden;
        this.soft_createTime = soft_createTime;
        this.soft_type = soft_type;
        this.soft_location = soft_location;
        this.soft_size = soft_size;
        this.soft_openWays = soft_openWays;
    }
    //endregion

    //region 主键
    private String id;

    @Override
    public String getId()
    {
        return id;
    }

    @Override
    public void setId(String id)
    {
        this.id = id;
    }
    //endregion

    //region 软件名称
    /**
     * 软件名称
     */
    private String soft_name;

    public String getSoft_name()
    {
        return soft_name;
    }

    public void setSoft_name(String soft_name)
    {
        this.soft_name = soft_name;
    }

    //endregion

    //region 软件描述
    /**
     * 软件描述
     */
    private String soft_description;

    public String getSoft_description()
    {
        return soft_description;
    }

    public void setSoft_description(String soft_description)
    {
        this.soft_description = soft_description;
    }

    //endregion

    //region 软件是否隐藏
    /**
     * 软件是否隐藏
     */
    private boolean soft_isHidden;

    public boolean isSoft_isHidden()
    {
        return soft_isHidden;
    }

    public void setSoft_isHidden(boolean soft_isHidden)
    {
        this.soft_isHidden = soft_isHidden;
    }
    //endregion

    //region 软件创建日期
    /**
     * 软件创建日期
     */
    private Date soft_createTime;

    public Date getSoft_createTime()
    {
        return soft_createTime;
    }

    public void setSoft_createTime(Date soft_createTime)
    {
        this.soft_createTime = soft_createTime;
    }
    //endregion

    //region 软件类型
    /**
     * 软件类型
     */
    private SoftType soft_type;

    public SoftType getSoft_type()
    {
        return soft_type;
    }

    public void setSoft_type(SoftType soft_type)
    {
        this.soft_type = soft_type;
    }
    //endregion

    //region 软件位置
    /**
     * 软件位置
     */
    private String soft_location;

    public String getSoft_location()
    {
        return soft_location;
    }

    public void setSoft_location(String soft_location)
    {
        this.soft_location = soft_location;
    }
    //endregion

    //region 软件大小
    /**
     * 软件大小
     */
    private String soft_size;

    public String getSoft_size()
    {
        return soft_size;
    }

    public void setSoft_size(String soft_size)
    {
        this.soft_size = soft_size;
    }
    //endregion

    //region 软件打开方式
    /**
     * 软件打开方式
     */
    private SoftOpenWays soft_openWays;

    public SoftOpenWays getSoft_openWays()
    {
        return soft_openWays;
    }

    public void setSoft_openWays(SoftOpenWays soft_openWays)
    {
        this.soft_openWays = soft_openWays;
    }
    //endregion

    //region 接收从界面传递过来的值

    //region 是否隐藏
    /**
     * 是否隐藏
     */
    private String soft_isHidden2;

    public String getSoft_isHidden2()
    {
        return soft_isHidden2;
    }

    public void setSoft_isHidden2(String soft_isHidden2)
    {
        this.soft_isHidden2 = soft_isHidden2;
    }
    //endregion

    //region 创建时间
    /**
     * 创建时间
     */
    private String soft_createTime2;

    public String getSoft_createTime2()
    {
        return soft_createTime2;
    }

    public void setSoft_createTime2(String soft_createTime2)
    {
        this.soft_createTime2 = soft_createTime2;
    }
    //endregion

    //region 创建时间结束日期
    private String soft_createTime3;

    public String getSoft_createTime3()
    {
        return soft_createTime3;
    }

    public void setSoft_createTime3(String soft_createTime3)
    {
        this.soft_createTime3 = soft_createTime3;
    }
    //endregion

    //region 软件类型
    /**
     * 软件类型
     */
    private String soft_type2;

    public String getSoft_type2()
    {
        return soft_type2;
    }

    public void setSoft_type2(String soft_type2)
    {
        this.soft_type2 = soft_type2;
    }
    //endregion

    //region 软件打开方式
    /**
     * 软件打开方式
     */
    private String soft_openWays2;

    public String getSoft_openWays2()
    {
        return soft_openWays2;
    }

    public void setSoft_openWays2(String soft_openWays2)
    {
        this.soft_openWays2 = soft_openWays2;
    }
    //endregion

    //endregion
}





















