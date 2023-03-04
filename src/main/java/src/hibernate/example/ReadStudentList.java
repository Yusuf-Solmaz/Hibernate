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
            show(students);

            List<Student> studentList = session.createQuery("from Student WHERE email LIKE '%gmail.com'").list();
            show(studentList);

            List<Student> studentList1 = session.createQuery("from Student f where" + " f.firstName='Yusuf Mücahit' or f.firstName='Erkam' ").list();
            show(studentList1);

            session.getTransaction().commit();

        }
        finally {
            factory.close();
        }


    }

    public static void show(List<Student> students) {
        for(Student elements : students){
            System.out.println("\n"+elements);
        }
    }
}
