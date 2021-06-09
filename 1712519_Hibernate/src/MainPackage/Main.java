package MainPackage;

import dao.*;
import pojo.*;

import javax.swing.text.Style;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try
        {
            Studentscourses st=new Studentscourses();
            StudentscoursesPK studentscoursesPK=new StudentscoursesPK();
            studentscoursesPK.setClassIdRegistrated("17CTT4");
            studentscoursesPK.setStudentIdRegistrated("1712519");
            studentscoursesPK.setSubjectIdCourse("CSC10003");
            studentscoursesPK.setClassIdCourse("17CTT1");
            studentscoursesPK.setSemesterNameCourse("hk1");
            studentscoursesPK.setSemesterYearCourse("2019");
            st.setStudentscoursesPrimarykey(studentscoursesPK);
            System.out.println(StudentsCoursesDAO.GetStudentCourse(st));
            boolean b=StudentsCoursesDAO.DeleteStudentCourse(st);
            System.out.println(b);
        }
        catch (Exception e){
            System.out.println("Exception in main: "+e.toString());
        }
    }
}
