package org.xiangkui;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.xiangkui.day02.Staff;

public class HibernateUtils {
    public static final Configuration cfg;
    public static final SessionFactory sf;

    static{
        cfg = new Configuration().configure();
        sf = cfg.buildSessionFactory();
    }

    public static Session openSession(){
        return sf.openSession();
    }

    public static Session getSession(){
        return sf.getCurrentSession();
    }

    public static void exec(ExecInterface execInterface){
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        execInterface.exec(session);
        transaction.commit();
    }

}
