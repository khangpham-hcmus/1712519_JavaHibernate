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

    @Column(name = "SemesterYear", nullable = false, length = 4)
    @Id
    public String getSemesterYear() {
        return semesterYear;
    }

    public void setSemesterYear(String semesterYear) {
        this.semesterYear = semesterYear;
    }

    @Column(name = "SemesterName", nullable = false, length = 3)
    @Id
    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    @Column(name = "SubjectID", nullable = false, length = 10)
    @Id
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
    public int hashCode() {
        return Objects.hash(studentId, classId, semesterYear, semesterName, subjectId);
    }
}
