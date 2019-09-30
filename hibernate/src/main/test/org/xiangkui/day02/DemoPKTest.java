package org.xiangkui.day02;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;
import org.xiangkui.ExecInterface;
import org.xiangkui.HibernateUtils;

class DemoPKTest {
    @Test
    public void demo1(){
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();

        //start
        Staff staff = new Staff();//瞬时态
        staff.setFirstName("Xk");
        staff.setLastName("Guo");
        session.save(staff);//持久态
        //end
        transaction.commit();
        session.close();
        System.out.println(staff);//游离态
    }

    @Test
    public void demo2(){
        HibernateUtils.exec((session)->{
            Staff staff = new Staff();
            staff.setFirstName("Xk");
            staff.setLastName("Guo");
            session.save(staff);
        });
    }

    @Test
    public void demo3(){
        HibernateUtils.exec((session)->{
            Staff staff = session.get(Staff.class,"402881f36d80a16a016d80a16c5f0000");
            staff.setFirstName("Xk__");
            staff.setLastName("GuoX");
//            session.update(staff);
        });
    }
}