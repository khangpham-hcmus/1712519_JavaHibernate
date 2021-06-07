package pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Teachermanagers {
    private String teacherManagerId;
    private String teacherManagerName;
    private String userName;
    //------------------------------------
    private Teachermanagers _account_;
    public Teachermanagers get_account_() {
        return _account_;
    }
    public void set_account_(Teachermanagers _account_) {
        this._account_ = _account_;
    }
    //full constructor:
    public Teachermanagers(String ID,String name,String usName)
    {
        this.teacherManagerId=ID;
        this.teacherManagerName=name;
        this.userName=usName;
    }
    //default constructor:
    public Teachermanagers(){
        this.teacherManagerId="";
        this.teacherManagerName="";
    }

    @Id
    @Column(name = "TeacherManagerID", nullable = false, length = 10)
    public String getTeacherManagerId() {
        return teacherManagerId;
    }

    public void setTeacherManagerId(String teacherManagerId) {
        this.teacherManagerId = teacherManagerId;
    }

    @Basic
    @Column(name = "TeacherManagerName", nullable = true, length = 50)
    public String getTeacherManagerName() {
        return teacherManagerName;
    }

    public void setTeacherManagerName(String teacherManagerName) {
        this.teacherManagerName = teacherManagerName;
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
        Teachermanagers that = (Teachermanagers) o;
        return Objects.equals(teacherManagerId, that.teacherManagerId) && Objects.equals(teacherManagerName, that.teacherManagerName) && Objects.equals(userName, that.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teacherManagerId, teacherManagerName, userName);
    }

    @Override
    public String toString() {
        return "Teachermanagers{" +
                "teacherManagerId='" + teacherManagerId + '\'' +
                ", teacherManagerName='" + teacherManagerName + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
