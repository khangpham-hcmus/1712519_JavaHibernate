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
    private Accounts account;
    //---------------------------------------------

    public Accounts getAccount() {
        return account;
    }

    public void setAccount(Accounts account) {
        this.account = account;
    }


    //--------------------------------------------

    public Teachermanagers(String teacherManagerId, String teacherManagerName) {
        this.teacherManagerId = teacherManagerId;
        this.teacherManagerName = teacherManagerName;
    }
    public Teachermanagers(){}

    //--------------------------------------------
    public String getTeacherManagerId() {
        return teacherManagerId;
    }

    public void setTeacherManagerId(String teacherManagerId) {
        this.teacherManagerId = teacherManagerId;
    }

    public String getTeacherManagerName() {
        return teacherManagerName;
    }

    public void setTeacherManagerName(String teacherManagerName) {
        this.teacherManagerName = teacherManagerName;
    }

    @Override
    public String toString() {
        return "Teachermanagers{" +
                "teacherManagerId='" + teacherManagerId + '\'' +
                ", teacherManagerName='" + teacherManagerName +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Teachermanagers)) return false;
        Teachermanagers that = (Teachermanagers) o;
        return Objects.equals(getTeacherManagerId(), that.getTeacherManagerId()) && Objects.equals(getTeacherManagerName(), that.getTeacherManagerName()) && Objects.equals(getAccount(), that.getAccount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTeacherManagerId(), getTeacherManagerName(), getAccount());
    }
}
