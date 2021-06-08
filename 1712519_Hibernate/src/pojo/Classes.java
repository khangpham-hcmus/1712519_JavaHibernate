package pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Classes {
    private String classId;
    //----------------------------------------------
    private Students student;
    private Courses course;

    //----------------------------------------------
    public Courses getCourse() {
        return course;
    }

    public void setCourse(Courses course) {
        this.course = course;
    }

    //-------------------------------------------------------
    public Students getStudent() {
        return student;
    }

    public void setStudent(Students student) {
        this.student = student;
    }
    //--------------------------------------------------------

    @Id
    @Column(name = "ClassID", nullable = false, length = 10)
    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Classes classes = (Classes) o;
        return Objects.equals(classId, classes.classId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classId);
    }

    @Override
    public String toString() {
        return "Classes{" +
                "classId='" + classId + '\'' +
                '}';
    }
}
