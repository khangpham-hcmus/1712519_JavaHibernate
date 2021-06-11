package pojo;

import dao.SemestersDAO;

import javax.persistence.Entity;
import javax.persistence.IdClass;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@IdClass(SemestersPK.class)
public class Semesters implements Serializable {
    SemestersPK semestersPrimarykey;
    private String dayBegin;
    private String dayEnd;
    private Set<Courses> courses =new HashSet<Courses>(0);
    private  String currentSemester;
    public Set<Courses> getCourses() {
        return courses;
    }

    public void setCourses(Set<Courses> courses) {
        this.courses = courses;
    }

    public Semesters() {
    }

    public Semesters(String year,String name,String daybegin,String dayend,String current)
    {
        semestersPrimarykey=new SemestersPK(year,name);
        this.dayBegin=daybegin;
        this.dayEnd=dayend;
        if(current.equals("0")||current.equals("1"))
        {
            this.currentSemester=current;
        }
        else
            this.currentSemester="0";
    }

    public SemestersPK getSemestersPrimarykey() {
        return semestersPrimarykey;
    }

    public void setSemestersPrimarykey(SemestersPK semestersPrimarykey) {
        this.semestersPrimarykey = semestersPrimarykey;
    }

    public String getDayBegin() {
        return dayBegin;
    }

    public void setDayBegin(String dayBegin) {
        this.dayBegin = dayBegin;
    }

    public String getDayEnd() {
        return dayEnd;
    }

    public void setDayEnd(String dayEnd) {
        this.dayEnd = dayEnd;
    }

    public String getCurrentSemester() {
        return currentSemester;
    }

    public void setCurrentSemester(String current) {
        if(current.equals("0")||current.equals("1"))
        {
            this.currentSemester=current;
        }
        else
            this.currentSemester="0";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Semesters)) return false;
        Semesters semesters = (Semesters) o;
        return Objects.equals(getSemestersPrimarykey(), semesters.getSemestersPrimarykey()) && Objects.equals(getDayBegin(), semesters.getDayBegin()) && Objects.equals(getDayEnd(), semesters.getDayEnd()) && Objects.equals(getCourses(), semesters.getCourses()) && Objects.equals(getCurrentSemester(), semesters.getCurrentSemester());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSemestersPrimarykey(), getDayBegin(), getDayEnd(), getCourses(), getCurrentSemester());
    }

    @Override
    public String toString() {
        return "Semesters{" +
                 semestersPrimarykey +
                ", dayBegin='" + dayBegin + '\'' +
                ", dayEnd='" + dayEnd + '\'' +
                '}';
    }
    public String getYear(){return this.semestersPrimarykey.getSemesterYear();}
    public String getName(){return this.semestersPrimarykey.getSemesterName();}

}
