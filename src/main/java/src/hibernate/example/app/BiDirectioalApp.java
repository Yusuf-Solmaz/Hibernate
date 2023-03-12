package src.hibernate.example.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import src.hibernate.example.entity.Course;
import src.hibernate.example.entity.Teacher;
import src.hibernate.example.entity.TeacherDetail;

public class BiDirectioalApp {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .addAnnotatedClass(Teacher.class)
                .addAnnotatedClass(TeacherDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            Teacher teacher = session.get(Teacher.class, 5);
            System.out.println("Teacher: "+teacher);
            //System.out.println("Teacher Courses : "+teacher.getCourses());

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
