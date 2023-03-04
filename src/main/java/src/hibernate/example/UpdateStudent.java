package src.hibernate.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import src.hibernate.example.entity.Student;

public class UpdateStudent {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{

            session.beginTransaction();
            int id = 2;

            Student updatedStudent = session.get(Student.class,id);
            updatedStudent.setFirstName("Ali");

            session.getTransaction().commit();

            Session session1 = factory.getCurrentSession();
            session1.beginTransaction();

            session1.createQuery("update Student set email='new@hotmail.com' where firstName='Mücahit'").executeUpdate();
            session1.getTransaction().commit();


        }
        finally {
            factory.close();
        }
    }
}
