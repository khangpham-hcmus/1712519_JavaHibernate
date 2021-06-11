package MainPackage;

import dao.*;
import pojo.*;

import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) {
        try
        {
            Courses khoahoc=CoursesDAO.GetCourse("2019","hk1","CSC10009","17CTT1");
            System.out.println(khoahoc);
            boolean b=CoursesDAO.DeleteCourse(khoahoc);
            System.out.println(b);
        }
        catch (Exception e){
            System.out.println("Exception in main: "+e.toString());
        }
    }
}
