package pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class StudentsPK implements Serializable {
    private String studentId;
    private String classId;

    @Column(name = "StudentID", nullable = false, length = 10)
    @Id
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Column(name = "ClassID", nullable = false, length = 10)
    @Id
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
        StudentsPK that = (StudentsPK) o;
        return Objects.equals(studentId, that.studentId) && Objects.equals(classId, that.classId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, classId);
    }
}
