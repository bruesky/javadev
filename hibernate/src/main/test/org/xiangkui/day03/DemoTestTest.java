package org.xiangkui.day03;

import org.junit.jupiter.api.Test;
import org.xiangkui.HibernateUtils;
import org.xiangkui.day02.Staff;

import static org.junit.jupiter.api.Assertions.*;

class DemoTestTest {
    @Test
    public void demo1(){
        HibernateUtils.exec((session)->{
            Client c1 = new Client();
            c1.setName("Zhangsan");
            Client c2 = new Client();
            c2.setName("Lisi");

            Relative r1 = new Relative();
            r1.setName("R1");
            Relative r2 = new Relative();
            r2.setName("R2");
            Relative r3 = new Relative();
            r3.setName("R3");

            r1.setClient(c1);
            r2.setClient(c1);
            r3.setClient(c2);
            c1.getRelatives().add(r1);
            c1.getRelatives().add(r2);
            c2.getRelatives().add(r3);

            session.save(r1);
            session.save(r2);
            session.save(r3);
            session.save(c1);
            session.save(c2);


        });
    }

    @Test
    public void demo2(){
        HibernateUtils.exec((session)->{
            Client c1 = new Client();
            c1.setName("Zhangsan");

            Relative r1 = new Relative();
            r1.setName("R1");
            Relative r2 = new Relative();
            r2.setName("R2");
            Relative r3 = new Relative();
            r3.setName("R3");

            r1.setClient(c1);
            r2.setClient(c1);
            c1.getRelatives().add(r1);
            c1.getRelatives().add(r2);
            session.save(c1);
        });
    }

    @Test
    public void demo3(){
        HibernateUtils.exec((session)->{
            Client c1 = new Client();
            c1.setName("Zhangsan");

            Relative r1 = new Relative();
            r1.setName("R1");
            Relative r2 = new Relative();
            r2.setName("R2");
            Relative r3 = new Relative();
            r3.setName("R3");

            r1.setClient(c1);
            c1.getRelatives().add(r2);
            c1.getRelatives().add(r3);
            session.save(r1);
        });
    }

    @Test
    public void demo4(){
        HibernateUtils.exec((session)->{
            Client client = session.get(Client.class,8);
            session.delete(client);
        });
    }

    @Test
    public void demo5(){
        HibernateUtils.exec((session)->{
            User u1 = new User();
            u1.setName("u1");
            User u2 = new User();
            u2.setName("u2");

            Role r1 = new Role();
            r1.setName("r1");
            Role r2 = new Role();
            r2.setName("r2");
            Role r3 = new Role();
            r3.setName("r3");

            u1.getRoles().add(r1);
            u1.getRoles().add(r2);
            u2.getRoles().add(r2);
            u2.getRoles().add(r3);

            r1.getUsers().add(u1);
            r2.getUsers().add(u1);

            r2.getUsers().add(u2);
            r3.getUsers().add(u2);

            session.save(u1);
            session.save(u2);

        });
    }

    @Test
    public void demo6(){//级联删除 不常用
        HibernateUtils.exec((session)->{
            User user = session.get(User.class,1);
            session.delete(user);
        });
    }

}