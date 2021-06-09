package dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import pojo.Semesters;
import util.HibernateUtil;

import java.util.List;

public class SemestersDAO {
    public  static List<Semesters> GetListSemesters(){
        List<Semesters> listAllSemester=null;
        Session ss= HibernateUtil.getSessionFactory().openSession();
        try{
            String hbl="select sm from Semesters as sm";
            Query q=ss.createQuery(hbl);
            listAllSemester=q.list();
        }
        catch (Exception e){
            System.out.println("Exception in SemesterDAO: "+e.getMessage());
            listAllSemester=null;
        }
        return listAllSemester;
    }
}
