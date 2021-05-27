package MainPackage;

import dao.AccountsDAO;
import dao.SemestersDAO;
import dao.SubjectsDAO;
import dao.TeacherManagersDAO;
import pojo.Accounts;
import pojo.Semesters;
import pojo.Subjects;
import pojo.Teachermanagers;

import java.util.List;

public class Main {
    public static void main(String[] args) {
	// write your code here
        try{
            List<Semesters> rs= SemestersDAO.getAllSemesters();
            for(Semesters e:rs){
                System.out.println(e.toString());
            }
        }
        catch (Exception e){
            System.out.println("Exception in main: "+e.getMessage());
        }
    }
}
