package pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(CoursesPK.class)
public class Courses {
    private String semesterYear;
    private String semesterName;
    private String subjectId;
    private String classId;
    private String theoryTeacher;
    private String dayOfWeek;
    private Integer shift;
    private Integer maxSlot;

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

    @Id
    @Column(name = "SubjectID", nullable = false, length = 10)
    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    @Id
    @Column(name = "ClassID", nullable = false, length = 10)
    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    @Basic
    @Column(name = "TheoryTeacher", nullable = true, length = 50)
    public String getTheoryTeacher() {
        return theoryTeacher;
    }

    public void setTheoryTeacher(String theoryTeacher) {
        this.theoryTeacher = theoryTeacher;
    }

    @Basic
    @Column(name = "DayOfWeek", nullable = true, length = 10)
    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    @Basic
    @Column(name = "Shift", nullable = true)
    public Integer getShift() {
        return shift;
    }

    public void setShift(Integer shift) {
        this.shift = shift;
    }

    @Basic
    @Column(name = "MaxSlot", nullable = true)
    public Integer getMaxSlot() {
        return maxSlot;
    }

    public void setMaxSlot(Integer maxSlot) {
        this.maxSlot = maxSlot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Courses courses = (Courses) o;
        return Objects.equals(semesterYear, courses.semesterYear) && Objects.equals(semesterName, courses.semesterName) && Objects.equals(subjectId, courses.subjectId) && Objects.equals(classId, courses.classId) && Objects.equals(theoryTeacher, courses.theoryTeacher) && Objects.equals(dayOfWeek, courses.dayOfWeek) && Objects.equals(shift, courses.shift) && Objects.equals(maxSlot, courses.maxSlot);
    }

    @Override
    public int hashCode() {
        return Objects.hash(semesterYear, semesterName, subjectId, classId, theoryTeacher, dayOfWeek, shift, maxSlot);
    }

    @Override
    public String toString() {
        return "Courses{" +
                "semesterYear='" + semesterYear + '\'' +
                ", semesterName='" + semesterName + '\'' +
                ", subjectId='" + subjectId + '\'' +
                ", classId='" + classId + '\'' +
                ", theoryTeacher='" + theoryTeacher + '\'' +
                ", dayOfWeek='" + dayOfWeek + '\'' +
                ", shift=" + shift +
                ", maxSlot=" + maxSlot +
                '}';
    }
}
