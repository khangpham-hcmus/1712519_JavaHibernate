package pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.util.Objects;

@Entity
@IdClass(StudentscoursesPK.class)
public class Studentscourses {
    private StudentscoursesPK studentscoursesPrimarykey;
    //----------------------------------------------------
    public Studentscourses(Students hocsinh,Courses khoahoc)
    {
        studentscoursesPrimarykey=new StudentscoursesPK();
        this.studentscoursesPrimarykey.setStudentIdRegistrated(hocsinh.getStudentsPK().getStudentId());
        this.studentscoursesPrimarykey.setClassIdRegistrated(hocsinh.getStudentsPK().getClassId());
        this.studentscoursesPrimarykey.setSemesterYearCourse(khoahoc.getCoursePK().getSemesterYear());
        this.studentscoursesPrimarykey.setSemesterNameCourse(khoahoc.getCoursePK().getSemesterName());
        this.studentscoursesPrimarykey.setSubjectIdCourse(khoahoc.getCoursePK().getSubjectId());
        this.studentscoursesPrimarykey.setClassIdCourse(khoahoc.getCoursePK().getClassId());
    }
    //----------------------------------------------
    private Courses course;

    public Courses getCourse() {
        return course;
    }

    public void setCourse(Courses course) {
        this.course = course;
    }

    //---------------------------------------------
    private Students student;

    public Students getStudent() {
        return student;
    }

    public void setStudent(Students student) {
        this.student = student;
    }
    //-----------------------------------------------

    public StudentscoursesPK getStudentscoursesPrimarykey() {
        return studentscoursesPrimarykey;
    }
    public void setStudentscoursesPrimarykey(StudentscoursesPK studentscoursesPrimarykey) {
        this.studentscoursesPrimarykey = studentscoursesPrimarykey;
    }

    public Studentscourses(StudentscoursesPK studentscoursesPrimarykey) {
        this.studentscoursesPrimarykey = studentscoursesPrimarykey;
    }

    public Studentscourses() {
    }

    @Override
    public String toString() {
        return studentscoursesPrimarykey.toString();
    }
}
