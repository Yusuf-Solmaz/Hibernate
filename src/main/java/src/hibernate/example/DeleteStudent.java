package src.hibernate.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import src.hibernate.example.entity.Student;

public class DeleteStudent {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            /*session.beginTransaction();

            Student deletedStudent = session.get(Student.class,2);
            session.delete(deletedStudent);

            session.getTransaction().commit();*/


            //Deleting with Queries
            Session session1 = factory.getCurrentSession();
            session1.beginTransaction();

            session1.createQuery("delete from Student where id=3 ").executeUpdate();
            session1.getTransaction().commit();
        }
        finally {
            factory.close();
        }
    }
}
