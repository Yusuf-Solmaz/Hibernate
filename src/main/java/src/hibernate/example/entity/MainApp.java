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

        try{
            session.beginTransaction();

            Teacher teacher = new Teacher("Yusuf Mücahit","Solmaz");
            TeacherDetail teacherDetail = new TeacherDetail("Biology","BIM250");
            teacher.setTeacherDetail(teacherDetail);

            session.save(teacher);
            session.getTransaction().commit();
        }
        finally{

        factory.close();
        }
    }

}