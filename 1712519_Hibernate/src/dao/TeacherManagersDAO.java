package dao;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pojo.Accounts;
import pojo.Teachermanagers;
import util.HibernateUtil;
import java.util.List;

public class TeacherManagersDAO {
    public static List<Teachermanagers> GetListTeachermanager()
    {
        List<Teachermanagers> LIST_TEACHERMANAGERS=null;
        Session ss=HibernateUtil.getSessionFactory().openSession();
        try{
            String hql="from Teachermanagers as tc";
            Query q=ss.createQuery(hql);
            LIST_TEACHERMANAGERS=q.list();
        }
        catch (Exception e){
            LIST_TEACHERMANAGERS=null;
        }
        finally {
            if(ss!=null){
                ss.close();
            }
        }
        return LIST_TEACHERMANAGERS;
    }
    public static String GetInformationTeachermanager(String username)
    {
        String thongtin=null;
        Accounts ac=AccountsDAO.GetAccount(username);
        if(ac!=null&&ac.getTypeOfAccount()==1)
            thongtin=ac.toString();
        return thongtin;
    }


}