package MainPackage;

import dao.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.*;

import java.util.List;
import java.util.Optional;
import swingUI.*;
import util.HibernateUtil;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        try
        {
            Teachermanagers teachermanagers=TeacherManagersDAO.SEARCH_INFORMATION("giaovux");
            System.out.println(teachermanagers.toString());
        }
        catch (Exception e){
            System.out.println("Exception in main: "+e);
        }
    }
}
