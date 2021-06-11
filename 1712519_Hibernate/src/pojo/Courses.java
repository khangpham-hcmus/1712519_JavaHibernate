package pojo;

import javax.naming.ldap.PagedResultsControl;
import javax.persistence.Entity;
import javax.persistence.IdClass;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@IdClass(CoursesPK.class)
public class Courses implements java.io.Serializable {
    //----------------------------
    private String theoryTeacher;
    private String dayOfWeek;
    private Integer shift;
    private Integer maxSlot;
    private String room;
    private CoursesPK CoursePK;
    //-------------------------------------------
    private Set<Studentscourses> studentscoursesSet=new HashSet<Studentscourses>(0);

    public Set<Studentscourses> getStudentscoursesSet() {
        return studentscoursesSet;
    }

    public void setStudentscoursesSet(Set<Studentscourses> studentscoursesSet) {
        this.studentscoursesSet = studentscoursesSet;
    }

    //-----------------------------------------
    private Classes classes;

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    //----------------------------------------------

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    //------------------------------------------
    private Semesters semester;

    public Semesters getSemester() {
        return semester;
    }

    public void setSemester(Semesters semester) {
        this.semester = semester;
    }

    //-----------------------------------------
    private Subjects subject;

    public Subjects getSubject() {
        return subject;
    }

    public void setSubject(Subjects subject) {
        this.subject = subject;
    }
    //----------------------------------------------
    //---constructor:

    public Courses(String theoryTeacher, String dayOfWeek, Integer shift, Integer maxSlot, CoursesPK coursePK) {
        this.theoryTeacher = theoryTeacher;
        this.dayOfWeek = dayOfWeek;
        this.shift = shift;
        this.maxSlot = maxSlot;
        CoursePK = coursePK;
    }
    public Courses()
    {

    }
    //--getter setter
    public String getTheoryTeacher() {
        return theoryTeacher;
    }

    public void setTheoryTeacher(String theoryTeacher) {
        this.theoryTeacher = theoryTeacher;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Integer getShift() {
        return shift;
    }

    public void setShift(Integer shift) {
        this.shift = shift;
    }

    public Integer getMaxSlot() {
        return maxSlot;
    }

    public void setMaxSlot(Integer maxSlot) {
        this.maxSlot = maxSlot;
    }

    public CoursesPK getCoursePK() {
        return CoursePK;
    }

    public void setCoursePK(CoursesPK coursePK) {
        CoursePK = coursePK;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Courses)) return false;
        Courses courses = (Courses) o;
        return Objects.equals(getTheoryTeacher(), courses.getTheoryTeacher()) && Objects.equals(getDayOfWeek(), courses.getDayOfWeek()) && Objects.equals(getShift(), courses.getShift()) && Objects.equals(getMaxSlot(), courses.getMaxSlot()) && Objects.equals(getRoom(), courses.getRoom()) && Objects.equals(getCoursePK(), courses.getCoursePK());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTheoryTeacher(), getDayOfWeek(), getShift(), getMaxSlot(), getRoom(), getCoursePK());
    }

    @Override
    public String toString() {
        return "Courses{" + CoursePK +", "+
                "theoryTeacher='" + theoryTeacher + '\'' +
                ", dayOfWeek='" + dayOfWeek + '\'' +
                ", shift=" + this.getTimeStringShift(shift) +
                ", maxSlot=" + maxSlot +
                ", room=" + room +
                '}';
    }
    public String getTimeStringShift(int shift)
    {
        switch (shift)
        {
            case 1: return "7h30-9h30";
            case 2: return "9h30-11h30";
            case 3: return "13h30-15h30";
            default: return "15h30-17h30";
        }
    }
    public String getSemesterYearCourse(){return this.getCoursePK().getSemesterYear();}
    public String getSemesterNameCourse(){return this.getCoursePK().getSemesterName();}
    public String getSubjectIdCourse(){return this.getCoursePK().getSubjectId();}
    public String getClassIdCourse(){return  this.getCoursePK().getClassId();}


}
