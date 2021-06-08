package MainPackage;

import dao.SubjectsDAO;
import pojo.Subjects;

public class Main {
    public static void main(String[] args) {
        try
        {
            Subjects monhoc=SubjectsDAO.GetSubject("CSC10003");
            System.out.println(monhoc.toString());
        }
        catch (Exception e){
            System.out.println("Exception in main: "+e.toString());
        }
    }
}
