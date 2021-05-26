package pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class SemestersPK implements Serializable {
    private String semesterYear;
    private String semesterName;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SemestersPK that = (SemestersPK) o;
        return Objects.equals(semesterYear, that.semesterYear) && Objects.equals(semesterName, that.semesterName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(semesterYear, semesterName);
    }
}
