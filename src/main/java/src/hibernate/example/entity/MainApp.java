package src.hibernate.example.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainApp {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .addAnnotatedClass(Teacher.class)
                .addAnnotatedClass(TeacherDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        Teacher teacher = new Teacher("Yusuf","Solmaz");
        TeacherDetail teacherDetail = new TeacherDetail("Math","BIM 326");
        teacher.setTeacherDetail(teacherDetail);

        session.beginTransaction();
        session.save(teacher);
        session.getTransaction().commit();

        factory.close();
    }
}
