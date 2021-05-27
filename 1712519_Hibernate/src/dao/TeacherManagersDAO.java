package dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import pojo.Teachermanagers;
import util.HibernateUtil;

import java.util.List;

public class TeacherManagersDAO {
    public static List<Teachermanagers> getAllTeacherManagers(){
        Session ss= HibernateUtil.getSessionFactory().openSession();
        List<Teachermanagers> listTeacherManagers=null;
        try{
            String hql="select tc from Teachermanagers as tc";
            Query q=ss.createQuery(hql);
            listTeacherManagers=q.list();
        }
        catch (Exception e){
            System.out.println("Exception in TeacherManagerDAO: "+e.getMessage());
        }
        finally {
            ss.close();
        }
        return listTeacherManagers;
    }
}
