package src.hibernate.example.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BiDirectioalApp {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .addAnnotatedClass(Teacher.class)
                .addAnnotatedClass(TeacherDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            TeacherDetail teacherDetail = session.get(TeacherDetail.class, 1);
            System.out.println("Teacher Detail: " + teacherDetail);
            System.out.println("teacher: " + teacherDetail.getTeacher());

            session.getTransaction().commit();
        }
        finally {
            factory.close();
        }

    }
}
