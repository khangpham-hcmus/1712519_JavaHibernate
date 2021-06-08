package pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Subjects {
    private String subjectId;
    private String subjectName;
    private Integer creditNumber;
    //---------------------------------------
    private Set<Courses> courses=new HashSet<Courses>(0);

    public Set<Courses> getCourses() {
        return courses;
    }

    public void setCourses(Set<Courses> courses) {
        this.courses = courses;
    }

    //-------------------------------------------
    public Subjects(String subjectId, String subjectName, Integer creditNumber) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.creditNumber = creditNumber;
    }

    public Subjects() {
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Integer getCreditNumber() {
        return creditNumber;
    }

    public void setCreditNumber(Integer creditNumber) {
        this.creditNumber = creditNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subjects)) return false;
        Subjects subjects = (Subjects) o;
        return Objects.equals(getSubjectId(), subjects.getSubjectId()) && Objects.equals(getSubjectName(), subjects.getSubjectName()) && Objects.equals(getCreditNumber(), subjects.getCreditNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSubjectId(), getSubjectName(), getCreditNumber());
    }

    @Override
    public String toString() {
        return "Subjects{" +
                "subjectId='" + subjectId + '\'' +
                ", subjectName='" + subjectName + '\'' +
                ", creditNumber=" + creditNumber +
                '}';
    }
}

