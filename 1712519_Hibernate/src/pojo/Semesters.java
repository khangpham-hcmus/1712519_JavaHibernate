package pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(SemestersPK.class)
public class Semesters {
    private String semesterYear;
    private String semesterName;
    private String dayBegin;
    private String dayEnd;

    @Id
    @Column(name = "SemesterYear", nullable = false, length = 4)
    public String getSemesterYear() {
        return semesterYear;
    }

    public void setSemesterYear(String semesterYear) {
        this.semesterYear = semesterYear;
    }

    @Id
    @Column(name = "SemesterName", nullable = false, length = 3)
    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    @Basic
    @Column(name = "DayBegin", nullable = true, length = 10)
    public String getDayBegin() {
        return dayBegin;
    }

    public void setDayBegin(String dayBegin) {
        this.dayBegin = dayBegin;
    }

    @Basic
    @Column(name = "DayEnd", nullable = true, length = 10)
    public String getDayEnd() {
        return dayEnd;
    }

    public void setDayEnd(String dayEnd) {
        this.dayEnd = dayEnd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Semesters semesters = (Semesters) o;
        return Objects.equals(semesterYear, semesters.semesterYear) && Objects.equals(semesterName, semesters.semesterName) && Objects.equals(dayBegin, semesters.dayBegin) && Objects.equals(dayEnd, semesters.dayEnd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(semesterYear, semesterName, dayBegin, dayEnd);
    }
}
