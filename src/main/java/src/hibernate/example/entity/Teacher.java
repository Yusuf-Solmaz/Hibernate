package src.hibernate.example.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "teacher")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_detail_id")
    private TeacherDetail teacherDetail;

    @OneToMany(mappedBy = "teacher",cascade = {CascadeType.PERSIST,CascadeType.MERGE,
            CascadeType.DETACH,CascadeType.REFRESH} )
    private List<Course> courses;

    public Teacher (String firstName,String lastName){
        this.firstName=firstName;
        this.lastName=lastName;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", courses=" + courses +
                '}';
    }

    public void add(Course tempCourse){
        if (courses == null){
            courses = new ArrayList<Course>();
        }
        courses.add(tempCourse);
        tempCourse.setTeacher(this);
    }

    /*Or

    public void add(Course tempCourse,Teacher teacher){
        if (courses == null){
            courses = new ArrayList<Course>();
        }
        courses.add(tempCourse);
        tempCourse.setTeacher(teacher);
    }

    */


}