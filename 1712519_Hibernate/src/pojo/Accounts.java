package pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Accounts {
    private String userName;
    private String pass;
    private Integer typeOfAccount;
    //---------------------------------------------------------------------------
    private Teachermanagers teachermanager;

    public Teachermanagers getTeachermanager() {
        return teachermanager;
    }

    public void setTeachermanager(Teachermanagers teachermanager) {
        this.teachermanager = teachermanager;
    }

    //----------------------------------------------------------------------------
    private Students student;

    public Students getStudent() {
        return student;
    }

    public void setStudent(Students student) {
        this.student = student;
    }

    //------------------------------------------------------------------------------
    //constructor:
    public Accounts(String userName, String pass, Integer typeOfAccount) {
        this.userName = userName;
        this.pass = pass;
        this.typeOfAccount = typeOfAccount;
    }
    public Accounts(){}
    //----------------------------------------------------
    @Id
    @Column(name = "UserName", nullable = false, length = 50)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "Pass", nullable = true, length = 50)
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Basic
    @Column(name = "TypeOfAccount", nullable = true)
    public Integer getTypeOfAccount() {
        return typeOfAccount;
    }

    public void setTypeOfAccount(Integer typeOfAccount) {
        this.typeOfAccount = typeOfAccount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accounts accounts = (Accounts) o;
        return Objects.equals(userName, accounts.userName) && Objects.equals(pass, accounts.pass) && Objects.equals(typeOfAccount, accounts.typeOfAccount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, pass, typeOfAccount);
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "userName='" + userName + '\'' +
                ", pass='" + pass + '\'' +
                ", typeOfAccount=" + typeOfAccount +
                '}';
    }
}
