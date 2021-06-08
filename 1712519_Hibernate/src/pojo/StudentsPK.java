package pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class StudentsPK implements Serializable {
    //-----------------------------------------------------------
    private String studentId;
    private String classId;
    //-------------------------------------------------------------

    public StudentsPK(String studentId, String classId) {
        this.studentId = studentId;
        this.classId = classId;
    }
    public StudentsPK() {

    }
    //------------------------------------------------------------------

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    @Override
    public String toString() {
        return  "{studentId='" + studentId + '\'' +
                ", classId='" + classId + '\'' +"}";

    }
}
