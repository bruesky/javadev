package org.xiangkui;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.xiangkui.entity.Student;


public class TestHibernate {

    public static void main(String[] args){
        SessionFactory sessionFactory = new Configuration()
                                        .configure("hibernate01.cfg.xml")
                                        .addAnnotatedClass(Student.class)
                                        .buildSessionFactory();


        try {
            Session session = sessionFactory.getCurrentSession();
            System.out.println("Creating a new student...");
            Student student = new Student("Divid","Liu","dz@gmail.com");
            session.beginTransaction();
            System.out.println("Saving the student...");
            session.save(student);
            session.getTransaction().commit();

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Student temp = session.get(Student.class,student.getId());
            session.getTransaction().commit();
            System.out.println(temp);

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
//            List<Student> students = session.createQuery("from Student").list();
//            students.stream().forEach(System.out::println);
            temp = (Student) session.createQuery("from Student s where s.id=13").list().get(0);
            System.out.println(temp);
            session.getTransaction().commit();

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.createQuery("update Student set email='fff@gmail.com'").executeUpdate();
            session.getTransaction().commit();

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.createQuery("delete from Student s where s.id=5").executeUpdate();
            session.getTransaction().commit();

        }finally {
            sessionFactory.close();
        }

    }
}
