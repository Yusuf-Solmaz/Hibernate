package src.hibernate.example.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import src.hibernate.example.entity.Course;
import src.hibernate.example.entity.Teacher;
import src.hibernate.example.entity.TeacherDetail;

import java.util.ArrayList;
import java.util.List;

public class OneToManyApp {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .addAnnotatedClass(Teacher.class)
                .addAnnotatedClass(TeacherDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            session.beginTransaction();
            Teacher teacher = session.get(Teacher.class,5);
            Course course1 = new Course("A");
            Course course2 = new Course("B");
            Course course3 = new Course("C");

            teacher.add(course1);
            teacher.add(course2);

            // Instead of add method that we created
            List<Course> courses = new ArrayList<>();
            courses.add(course3);
            course3.setTeacher(teacher);



            session.save(course1);
            session.save(course2);
            session.save(course3);

            session.getTransaction().commit();
        }
        finally {
            session.close();
            factory.close();
        }
    }
}
