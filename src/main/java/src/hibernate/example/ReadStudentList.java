package src.hibernate.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import src.hibernate.example.entity.Student;

import java.util.List;

public class ReadStudentList {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();


        try {
            session.beginTransaction();
            List<Student> students = session.createQuery("from Student where firstName='Yusuf'").list();
            for(Student elements : students){
                System.out.println(elements);
            }

            session.getTransaction().commit();

        }
        finally {
            factory.close();
        }


    }
}
