package pojo;

import java.io.Serializable;
import java.util.Objects;

public class StudentscoursesPK implements Serializable {
    private String studentIdRegistrated;
    private String classIdRegistrated;
    private String semesterYearCourse;
    private String semesterNameCourse;
    private String subjectIdCourse;
    private String classIdCourse;

    public StudentscoursesPK() {
    }

    public String getStudentIdRegistrated() {
        return studentIdRegistrated;
    }

    public void setStudentIdRegistrated(String studentIdRegistrated) {
        this.studentIdRegistrated = studentIdRegistrated;
    }

    public String getClassIdRegistrated() {
        return classIdRegistrated;
    }

    public void setClassIdRegistrated(String classIdRegistrated) {
        this.classIdRegistrated = classIdRegistrated;
    }

    public String getSemesterYearCourse() {
        return semesterYearCourse;
    }

    public void setSemesterYearCourse(String semesterYearCourse) {
        this.semesterYearCourse = semesterYearCourse;
    }

    public String getSemesterNameCourse() {
        return semesterNameCourse;
    }

    public void setSemesterNameCourse(String semesterNameCourse) {
        this.semesterNameCourse = semesterNameCourse;
    }

    public String getSubjectIdCourse() {
        return subjectIdCourse;
    }

    public void setSubjectIdCourse(String subjectIdCourse) {
        this.subjectIdCourse = subjectIdCourse;
    }

    public String getClassIdCourse() {
        return classIdCourse;
    }

    public void setClassIdCourse(String classIdCourse) {
        this.classIdCourse = classIdCourse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentscoursesPK)) return false;
        StudentscoursesPK that = (StudentscoursesPK) o;
        return Objects.equals(getStudentIdRegistrated(), that.getStudentIdRegistrated()) && Objects.equals(getClassIdRegistrated(), that.getClassIdRegistrated()) && Objects.equals(getSemesterYearCourse(), that.getSemesterYearCourse()) && Objects.equals(getSemesterNameCourse(), that.getSemesterNameCourse()) && Objects.equals(getSubjectIdCourse(), that.getSubjectIdCourse()) && Objects.equals(getClassIdCourse(), that.getClassIdCourse());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStudentIdRegistrated(), getClassIdRegistrated(), getSemesterYearCourse(), getSemesterNameCourse(), getSubjectIdCourse(), getClassIdCourse());
    }

    @Override
    public String toString() {
        return "StudentscoursesPK{" +
                "studentIdRegistrated='" + studentIdRegistrated + '\'' +
                ", classIdRegistrated='" + classIdRegistrated + '\'' +
                ", semesterYearCourse='" + semesterYearCourse + '\'' +
                ", semesterNameCourse='" + semesterNameCourse + '\'' +
                ", subjectIdCourse='" + subjectIdCourse + '\'' +
                ", classIdCourse='" + classIdCourse + '\'' +
                '}';
    }
}
