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
            Semesters  hocki=new Semesters("2020","hk2","","","0");
            boolean b=SemestersDAO.DeleteSemester(hocki);
            System.out.println(b);
        }
        catch (Exception e){
            System.out.println("Exception in main: "+e.toString());
        }
    }
}
