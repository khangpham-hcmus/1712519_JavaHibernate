package pojo;

import java.io.Serializable;
import java.util.Objects;

public class SemestersPK implements Serializable {
    private String semesterYear;
    private String semesterName;

    public SemestersPK(String semesterYear, String semesterName) {
        this.semesterYear = semesterYear;
        this.semesterName = semesterName;
    }

    public SemestersPK() {
    }

    public String getSemesterYear() {
        return semesterYear;
    }

    public void setSemesterYear(String semesterYear) {
        this.semesterYear = semesterYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SemestersPK)) return false;
        SemestersPK that = (SemestersPK) o;
        return Objects.equals(getSemesterYear(), that.getSemesterYear()) && Objects.equals(getSemesterName(), that.getSemesterName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSemesterYear(), getSemesterName());
    }

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    @Override
    public String toString() {
        return "[" +
                "semesterYear='" + semesterYear + '\'' +
                ", semesterName='" + semesterName + '\'' +
                ']';
    }
}
