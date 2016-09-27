package qin.oa.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import qin.javaee65.core.Objects;
import qin.oa.hibernate.dao.SoftwareOpenWaysDAO;
import qin.oa.hibernate.dao.SoftwareTypeDAO;
import qin.oa.hibernate.domain.SoftOpenWays;
import qin.oa.hibernate.domain.SoftType;
import qin.oa.hibernate.domain.Software;
import qin.oa.hibernate.service.SoftwareOpenWaysService;
import qin.oa.hibernate.service.SoftwareService;
import qin.oa.hibernate.service.SoftwareTypeService;

import java.util.Date;

import static qin.oa.hibernate.HibernateBasePath.log4jPath;

@SuppressWarnings("all")
public class SaveSoftType
{
    Objects objects = new Objects(log4jPath);
    Session session = objects.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();

    @Test
    public void makesoftservice()
    {
        String filePath = "D:\\idea15ProjectLocation\\JavaEE67BaseTools\\prj\\src\\main\\qin\\oa\\hibernate\\service";
        String servicePackage = "qin.oa.hibernate.service";
        String poPackage = "qin.oa.hibernate.domain";
        objects.makeService(filePath, "SoftwareService.java", servicePackage, poPackage, Software.class, "SoftwareService", String.class);
    }

    @Test
    public void makeSoftOpenWaysService() throws Exception
    {
        String filePath = "D:\\idea15ProjectLocation\\JavaEE67BaseTools\\prj\\src\\main\\qin\\oa\\hibernate\\service";
        String servicePackage = "qin.oa.hibernate.service";
        String poPackage = "qin.oa.hibernate.domain";
        objects.makeService(filePath, "SoftwareOpenWaysService.java", servicePackage, poPackage, SoftOpenWays.class, "SoftwareOpenWaysService", Integer.class);
    }

    @Test
    public void makeSoftOpenWaysServiceImpl() throws Exception
    {
        String filePath = "D:\\idea15ProjectLocation\\JavaEE67BaseTools\\prj\\src\\main\\qin\\oa\\hibernate\\service\\impl";
        String servicePackage = "qin.oa.hibernate.service.impl";
        String poPackage = "qin.oa.hibernate.domain";
        objects.makeServiceImpl(filePath, "SoftOpenWaysServiceImpl.java", servicePackage, poPackage,
                                SoftOpenWays.class, "SoftOpenWaysService", Integer.class, "softOpenWaysService65",
                                SoftwareOpenWaysService.class, SoftwareOpenWaysDAO.class.getSimpleName());
    }

    @Test
    public void makeSoftTypeService() throws Exception
    {
        String filePath = "D:\\idea15ProjectLocation\\JavaEE67BaseTools\\prj\\src\\main\\qin\\oa\\hibernate\\service";
        String servicePackage = "qin.oa.hibernate.service";
        String poPackage = "qin.oa.hibernate.domain";
        objects.makeService(filePath, "SoftwareTypeService.java", servicePackage,
                            poPackage, SoftType.class, "SoftwareTypeService", Integer.class);
    }

    @Test
    public void makeSoftTypeServiceImpl() throws Exception
    {
        String filePath = "D:\\idea15ProjectLocation\\JavaEE67BaseTools\\prj\\src\\main\\qin\\oa\\hibernate\\service\\impl";
        String servicePackage = "qin.oa.hibernate.service.impl";
        String poPackage = "qin.oa.hibernate.domain";
        objects.makeServiceImpl(filePath, "SoftwareTypeServiceImpl.java", servicePackage, poPackage,
                                SoftType.class, "SoftwareTypeService", Integer.class, "softTypeService65",
                                SoftwareTypeService.class, SoftwareTypeDAO.class.getSimpleName());
    }

    @Test
    public void saveSoftImpl()
    {
        String filePath = "D:\\idea15ProjectLocation\\JavaEE67BaseTools\\prj\\src\\main\\qin\\oa\\hibernate\\service\\impl\\SoftwareServiceImpl.java";
        String servicePackage = "qin.oa.hibernate.service";
        String poPackage = "qin.oa.hibernate.domain";
        objects.makeServiceImpl(filePath, "SoftwareServiceImpl.java", servicePackage + ".impl", poPackage, Software.class, "SoftwareService", String.class, "softwareServiceImpl65", SoftwareService.class, "SoftwareDAO");
    }

    @Test
    public void save1()
    {
        String[] softType = new String[]
                  {
                            "常规", "音乐", "图片", "视频", "未知程序", "应用程序", "安装程序",
                            "Windows补丁", "Windows更新程序", "种子文件", "命令行"
                  };

        for (int i = 0; i < softType.length; i++)
        {
            SoftType s = new SoftType();
            s.setSoft_type_name(softType[i]);

            session.save(s);
        }

        transaction.commit();
    }

    @Test
    public void datagridTest()
    {
        String url = "basePath + \"/soft/searchAll.com";
        String[] columns_field = new String[]{"soft_id", "soft_name", "soft_description", "soft_isHidden", "soft_createTime", "soft_type", "soft_location", "soft_size", "soft_openWays"};
        String[] column_title = new String[]{"编号", "名称", "描述", "是否隐藏", "创建时间", "类型", "位置", "大小", "打开方式"};
        Integer[] column_width = new Integer[]{100, 200, 300, 100, 200, 200, 200, 200, 300};
        objects.superInfo(objects.printDataGrid("软件详细信息", "tb_software", url, 1024, 768, true, true, columns_field, column_title, column_width));
    }

    @Test
    public void sqlMake()
    {
    }

    @Test
    public void daoSaveSoftTest() throws Exception
    {
        Software soft = new Software();
        soft.setSoft_name("asdfsdfdfsa");
        soft.setSoft_description("sadffsdafsd");
        soft.setSoft_isHidden(false);
        soft.setSoft_createTime(new Date());
        soft.setSoft_type(session.get(SoftType.class, 5));
        soft.setSoft_location("asdfasdf");
        soft.setSoft_size("54235345MB");
        soft.setSoft_openWays(session.get(SoftOpenWays.class, 2));

        session.save(soft);
        transaction.commit();
    }
}





















