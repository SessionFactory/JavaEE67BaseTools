package qin.javaee65.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import qin.javaee65.core.Objects;
import qin.oa.hibernate.HibernateBasePath;

public class SpringTest
{
    @Test
    public void test1()
    {
        SessionFactory sessionFactory = (SessionFactory) new
                  ClassPathXmlApplicationContext("classpath:applicationContext.xml")
                  .getBean("sessionFactory");
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Objects objects = new Objects(HibernateBasePath.log4jPath);
        objects.superInfo(transaction);
    }
}