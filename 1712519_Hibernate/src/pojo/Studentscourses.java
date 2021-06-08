package pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.util.Objects;

@Entity
@IdClass(StudentscoursesPK.class)
public class Studentscourses {
    private  StudentscoursesPK studentscoursesPK;

    public Studentscourses(StudentscoursesPK studentscoursesPK) {
        this.studentscoursesPK = studentscoursesPK;
    }
    public Studentscourses() {
    }
    public void setStudentscoursesPK(StudentscoursesPK studentscoursesPK) {
        this.studentscoursesPK = studentscoursesPK;
    }
    public StudentscoursesPK getStudentscoursesPK() {
        return studentscoursesPK;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Studentscourses)) return false;
        Studentscourses that = (Studentscourses) o;
        return Objects.equals(getStudentscoursesPK(), that.getStudentscoursesPK());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getStudentscoursesPK());
    }
    @Override
    public String toString() {
        return "Studentscourses{" +
                "studentscoursesPK=" + studentscoursesPK.toString() +
                '}';
    }
}
