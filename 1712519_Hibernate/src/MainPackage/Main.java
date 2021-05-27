package MainPackage;

import dao.*;
import pojo.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
	// write your code here
        try{
            List<Studentscourses> rs=StudentsCoursesDAO.getAllStudentsCourses();
            for(Studentscourses e:rs){
                System.out.println(e.toString());
            }
        }
        catch (Exception e){
            System.out.println("Exception in main: "+e.getMessage());
        }
    }
}
