package src.hibernate.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import src.hibernate.example.entity.Student;

public class ReadStudent {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            // New Session

            Session session1 = factory.getCurrentSession();
            session1.beginTransaction();

            Student student = session1.get(Student.class, 2);
            System.out.println(student);

            // commit transaction
            session1.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}