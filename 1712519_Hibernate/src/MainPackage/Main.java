package MainPackage;

import dao.ClassesDAO;
import dao.StudentsDAO;
import pojo.Classes;
import pojo.InformationOfClass;
import pojo.Students;

import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        try
        {
            Students hocsinh=new Students("17125777","17CTT1","Tran Minh Nghi","Female");
            boolean b=StudentsDAO.AddStudent(hocsinh);
            System.out.println(b);
        }
        catch (Exception e){
            System.out.println("Exception in main: "+e.toString());
        }
    }
}
