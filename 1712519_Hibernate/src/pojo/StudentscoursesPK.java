package pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class StudentscoursesPK implements Serializable {
    private String studentId;
    private String classId;
    private String semesterYear;
    private String semesterName;
    private String subjectId;

    public String getStudentId() {
        return studentId;
    }
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    public String getClassId() {
        return classId;
    }
    public void setClassId(String classId) {
        this.classId = classId;
    }
    public String getSemesterYear() {
        return semesterYear;
    }
    public void setSemesterYear(String semesterYear) {
        this.semesterYear = semesterYear;
    }
    public String getSemesterName() {
        return semesterName;
    }
    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }
    public String getSubjectId() {
        return subjectId;
    }
    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentscoursesPK that = (StudentscoursesPK) o;
        return Objects.equals(studentId, that.studentId) && Objects.equals(classId, that.classId) && Objects.equals(semesterYear, that.semesterYear) && Objects.equals(semesterName, that.semesterName) && Objects.equals(subjectId, that.subjectId);
    }
    @Override
    public String toString() {
        return "StudentscoursesPK{" +
                "studentId='" + studentId + '\'' +
                ", classId='" + classId + '\'' +
                ", semesterYear='" + semesterYear + '\'' +
                ", semesterName='" + semesterName + '\'' +
                ", subjectId='" + subjectId + '\'' +
                '}';
    }
    @Override
    public int hashCode() {
        return Objects.hash(studentId, classId, semesterYear, semesterName, subjectId);
    }
}
