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
           boolean b =SubjectsDAO.UpdateSubject("abcd","nhap mon lap trinh");
           System.out.println(b);
        }
        catch (Exception e){
            System.out.println("Exception in main: "+e);
        }
    }
}
