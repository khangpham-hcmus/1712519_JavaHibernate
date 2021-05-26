package pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class CoursesPK implements Serializable {
    private String semesterYear;
    private String semesterName;
    private String subjectId;
    private String classId;

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

    @Column(name = "ClassID", nullable = false, length = 10)
    @Id
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
        CoursesPK coursesPK = (CoursesPK) o;
        return Objects.equals(semesterYear, coursesPK.semesterYear) && Objects.equals(semesterName, coursesPK.semesterName) && Objects.equals(subjectId, coursesPK.subjectId) && Objects.equals(classId, coursesPK.classId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(semesterYear, semesterName, subjectId, classId);
    }
}
