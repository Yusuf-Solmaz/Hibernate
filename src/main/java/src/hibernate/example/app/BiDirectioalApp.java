package src.hibernate.example.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import src.hibernate.example.entity.Teacher;
import src.hibernate.example.entity.TeacherDetail;

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
        catch (Exception exception){
            exception.printStackTrace();
        }
        finally {
            session.close();
            factory.close();
        }

    }
}
