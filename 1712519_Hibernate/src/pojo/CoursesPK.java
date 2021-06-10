package pojo;

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
        if (!(o instanceof CoursesPK)) return false;
        CoursesPK coursesPK = (CoursesPK) o;
        return Objects.equals(getSemesterYear(), coursesPK.getSemesterYear()) && Objects.equals(getSemesterName(), coursesPK.getSemesterName()) && Objects.equals(getSubjectId(), coursesPK.getSubjectId()) && Objects.equals(getClassId(), coursesPK.getClassId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSemesterYear(), getSemesterName(), getSubjectId(), getClassId());
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
