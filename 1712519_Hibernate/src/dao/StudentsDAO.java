package dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import pojo.Students;
import util.HibernateUtil;

import java.util.List;

public class StudentsDAO {
    public  static  List<Students> getAllStudents(){
        List<Students> listAllStudents=null;
        Session ss= HibernateUtil.getSessionFactory().openSession();
        try{
            String qr="select st from Students as st";
            Query q=ss.createQuery(qr);
            listAllStudents=q.list();
        }
        catch (Exception e){
            System.out.println("Exception in StudentsDAO: "+e.getMessage());
        }
        finally {
            ss.close();
        }
        return listAllStudents;
    }
}
