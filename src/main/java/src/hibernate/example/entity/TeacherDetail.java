package src.hibernate.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "teacher_detail")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class TeacherDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "course_code")
    private String courseCode;

    @OneToOne(mappedBy = "teacherDetail",cascade = CascadeType.ALL)
    private Teacher teacher;

    public TeacherDetail (String courseName,String courseCode){
        this.courseCode=courseCode;
        this.courseName=courseName;
    }

    @Override
    public String toString() {
        return "TeacherDetail{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", courseCode='" + courseCode + '\'' +

                '}';
    }
}