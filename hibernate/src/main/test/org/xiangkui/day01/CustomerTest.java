package org.xiangkui.day01;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;
import org.xiangkui.HibernateUtils;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    @Test
    // 保存客户的案例
    public void demo(){
        // 1.加载Hibernate的核心配置文件

        //Configuration configuration = new Configuration().configure();
        // 手动加载映射
         //configuration.addResource("Customer.hbm.xml");
        // 2.创建一个SessionFactory对象：类似于JDBC中连接池
        //SessionFactory sessionFactory = configuration.buildSessionFactory();
        // 3.通过SessionFactory获取到Session对象：类似于JDBC中Connection
        Session session = HibernateUtils.openSession();
//                sessionFactory.openSession();
        // 4.手动开启事务：
        Transaction transaction = session.beginTransaction();
        // 5.编写代码

        Customer customer = new Customer();
        customer.setName("Di");

        session.save(customer);

        // 6.事务提交
        transaction.commit();
        // 7.资源释放
        session.close();
        //sessionFactory.close();
    }

    @Test
    public void demo2(){
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();

        //start

        Customer customer = session.get(Customer.class,1l);
        System.out.println(customer);

        customer = session.load(Customer.class,2l);
        System.out.println(customer);
        //end

        transaction.commit();
        session.close();
    }

    @Test
    public void demo3(){
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();

        //start
//        Customer customer = new Customer();
//        customer.setId(12l);
//        customer.setName("Xxxx Gggg");
//        session.update(customer);

        Customer customer = session.get(Customer.class,1l);
        customer.setName("Kkkkk Gui");
        session.update(customer);

        //end

        transaction.commit();
        session.close();
    }

    @Test
    public void demo4(){
        Session session = HibernateUtils.openSession();

        try {
            Transaction transaction = session.beginTransaction();
            //start
//            Customer custome = new Customer();
//            custome.setId(10l);
//            session.delete(custome);
            Customer customer = session.get(Customer.class,11l);
            session.delete(customer);
            //end

            transaction.commit();
        }catch (Exception e){

        }finally {
            session.close();
        }
    }

}