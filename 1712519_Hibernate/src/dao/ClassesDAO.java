package dao;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;
import pojo.Classes;
import util.HibernateUtil;

import java.util.List;

public class ClassesDAO {
    public static List<Classes> getAllClasses(){
        List<Classes> listAllClasses=null;
        Session ss= HibernateUtil.getSessionFactory().openSession();
        try{
            String hbl="select c from Classes as c";
            Query q=ss.createQuery(hbl);
            listAllClasses=q.list();
        }
        catch(Exception e){
            System.out.println("Exception in ClassesDAO: "+e.getMessage());
        }
        finally {
            ss.close();
        }
        return listAllClasses;
    }
}
