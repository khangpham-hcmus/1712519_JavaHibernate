package pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(StudentsPK.class)
public class Students {
    private String studentId;
    private String classId;
    private String studentName;
    private String gender;
    private String userName;
    //------------------------------
    private Students _account_;
    public Students get_account_() {
        return _account_;
    }
    public void set_account_(Students _otherAccount__) {
        this._account_ = _otherAccount__;
    }

    private Classes _class_;

    public Classes get_class_() {
        return _class_;
    }

    public void set_class_(Classes _class_) {
        this._class_ = _class_;
    }
    //------------------------------


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

    @Basic
    @Column(name = "StudentName", nullable = true, length = 50)
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Basic
    @Column(name = "Gender", nullable = true, length = 6)
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "UserName", nullable = true, length = 50)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Students students = (Students) o;
        return Objects.equals(studentId, students.studentId) && Objects.equals(classId, students.classId) && Objects.equals(studentName, students.studentName) && Objects.equals(gender, students.gender) && Objects.equals(userName, students.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, classId, studentName, gender, userName);
    }

    @Override
    public String toString() {
        return "Students{" +
                "studentId='" + studentId + '\'' +
                ", classId='" + classId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", gender='" + gender + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
