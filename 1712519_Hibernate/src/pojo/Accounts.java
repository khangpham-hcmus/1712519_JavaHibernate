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
    //----------------------------------------------
    private Students _student_;

    public Accounts(String userName__, String password__, int type__) {
        this.userName=userName__;
        this.pass=password__;
        this.typeOfAccount=type__;
    }

    public Accounts() {
        userName="";
        pass="";
        typeOfAccount=1;
    }


    public Students get_student_() {
        return _student_;
    }
    public void set_student_(Students _student__)
    {
        this._student_ = _student__;
    }
    //--------------------------------------------------------------------------
    private Teachermanagers _teachermanager_;
    public Teachermanagers get_teachermanager_() {
        return _teachermanager_;
    }
    public void set_teachermanager_(Teachermanagers _teachermanager_) {
        this._teachermanager_ = _teachermanager_;
    }
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
