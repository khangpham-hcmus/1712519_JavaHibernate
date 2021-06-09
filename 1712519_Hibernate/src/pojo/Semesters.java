package pojo;

import javax.persistence.Entity;
import javax.persistence.IdClass;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@IdClass(SemestersPK.class)
public class Semesters implements Serializable {
    SemestersPK semestersPrimarykey;
    private String dayBegin;
    private String dayEnd;
    private Set<Courses> courses =new HashSet<Courses>(0);

    public Set<Courses> getCourses() {
        return courses;
    }

    public void setCourses(Set<Courses> courses) {
        this.courses = courses;
    }

    public Semesters() {
    }

    public Semesters(SemestersPK semestersPrimarykey, String dayBegin, String dayEnd) {
        this.semestersPrimarykey = semestersPrimarykey;
        this.dayBegin = dayBegin;
        this.dayEnd = dayEnd;
    }

    public SemestersPK getSemestersPrimarykey() {
        return semestersPrimarykey;
    }

    public void setSemestersPrimarykey(SemestersPK semestersPrimarykey) {
        this.semestersPrimarykey = semestersPrimarykey;
    }

    public String getDayBegin() {
        return dayBegin;
    }

    public void setDayBegin(String dayBegin) {
        this.dayBegin = dayBegin;
    }

    public String getDayEnd() {
        return dayEnd;
    }

    public void setDayEnd(String dayEnd) {
        this.dayEnd = dayEnd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Semesters)) return false;
        Semesters semesters = (Semesters) o;
        return Objects.equals(getSemestersPrimarykey(), semesters.getSemestersPrimarykey()) && Objects.equals(getDayBegin(), semesters.getDayBegin()) && Objects.equals(getDayEnd(), semesters.getDayEnd());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSemestersPrimarykey(), getDayBegin(), getDayEnd());
    }

    @Override
    public String toString() {
        return "Semesters{" +
                "" + semestersPrimarykey +
                ", dayBegin='" + dayBegin + '\'' +
                ", dayEnd='" + dayEnd + '\'' +
                '}';
    }
}
