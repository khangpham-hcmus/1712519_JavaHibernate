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

    @Override
    public String toString() {
        return
                "semesterYear='" + semesterYear + '\'' +
                ", semesterName='" + semesterName + '\'' +
                ", subjectId='" + subjectId + '\'' +
                ", classId='" + classId + '\'' +
                '}';
    }
}
