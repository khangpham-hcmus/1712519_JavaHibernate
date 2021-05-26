package pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.util.Objects;

@Entity
@IdClass(StudentscoursesPK.class)
public class Studentscourses {
    private String studentId;
    private String classId;
    private String semesterYear;
    private String semesterName;
    private String subjectId;

    @Id
    @Column(name = "StudentID", nullable = false, length = 10)
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Id
    @Column(name = "ClassID", nullable = false, length = 10)
    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Studentscourses that = (Studentscourses) o;
        return Objects.equals(studentId, that.studentId) && Objects.equals(classId, that.classId) && Objects.equals(semesterYear, that.semesterYear) && Objects.equals(semesterName, that.semesterName) && Objects.equals(subjectId, that.subjectId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, classId, semesterYear, semesterName, subjectId);
    }
}
