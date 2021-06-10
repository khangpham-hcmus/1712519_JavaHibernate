package pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Classes {
    private String classId;
    //----------------------------------------------
    private Set<Courses> courses=new HashSet<Courses>(0);
    private Set<Students> students=new HashSet<Students>(0);

    public Classes() {
    }

    public Classes(String classId) {
        this.classId = classId;
    }
    //--------------------------------------------------------

    public Set<Courses> getCourses() {
        return courses;
    }

    public void setCourses(Set<Courses> courses) {
        this.courses = courses;
    }

    public Set<Students> getStudents() {
        return students;
    }

    public void setStudents(Set<Students> students) {
        this.students = students;
    }

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
