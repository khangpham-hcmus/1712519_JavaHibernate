package pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(StudentsPK.class)
public class Students {
    StudentsPK studentsPK;
    private String studentName;
    private String gender;
    private Accounts account;
    //-------------------------------------------

    public Accounts getAccount() {
        return account;
    }

    public void setAccount(Accounts account) {
        this.account = account;
    }


    //Constructor:------------------------

    public Students(StudentsPK studentsPK, String studentName, String gender, Accounts account) {
        this.studentsPK = studentsPK;
        this.studentName = studentName;
        this.gender = gender;
        this.account = account;
    }

    public Students() {
    }
    //-------------------------------------
    //

    public StudentsPK getStudentsPK() {
        return studentsPK;
    }

    public void setStudentsPK(StudentsPK studentsPK) {
        this.studentsPK = studentsPK;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    //------------------------------------------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Students)) return false;
        Students students = (Students) o;
        return Objects.equals(getStudentsPK(), students.getStudentsPK()) && Objects.equals(getStudentName(), students.getStudentName()) && Objects.equals(getGender(), students.getGender());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStudentsPK(), getStudentName(), getGender());
    }
    //-----------------------------------------------

    @Override
    public String toString() {
        return "Students{" +
                   studentsPK.toString() +
                ", studentName='" + studentName + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }


}
