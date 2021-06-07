package pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Subjects {
    private String subjectId;
    private String subjectName;
    private Integer creditNumber;

    public Subjects()
    {
        this.subjectId="";
        this.subjectName="";
        this.creditNumber=0;
    }
    public Subjects(String subjectId__,String subjectName__,Integer creditNumber__)
    {
        this.subjectId=subjectId__;
        this.subjectName=subjectName__;
        this.creditNumber=creditNumber__;
    }
    @Id
    @Column(name = "SubjectId", nullable = false, length = 10)
    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    @Basic
    @Column(name = "SubjectName", nullable = true, length = 50)
    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    @Basic
    @Column(name = "CreditNumber", nullable = true)
    public Integer getCreditNumber() {
        return creditNumber;
    }

    public void setCreditNumber(Integer creditNumber) {
        this.creditNumber = creditNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subjects subjects = (Subjects) o;
        return Objects.equals(subjectId, subjects.subjectId) && Objects.equals(subjectName, subjects.subjectName) && Objects.equals(creditNumber, subjects.creditNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectId, subjectName, creditNumber);
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
