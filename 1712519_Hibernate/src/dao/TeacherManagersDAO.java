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
    //GET_LIST_ALL_TEACHERMANAGERS:
    public static List<Teachermanagers> GET_LIST_TEACHERMANAGERS(){
        List<Teachermanagers> LIST_TEACHERMANAGERS=null;
        Session ss=HibernateUtil.getSessionFactory().openSession();
        try{
            String hql="from Teachermanagers as tc";
            Query q=ss.createQuery(hql);
            LIST_TEACHERMANAGERS=q.list();
        }
        catch (Exception e){
            System.out.println("Exception in TEACHERMANAGERSDAO: "+e.getMessage());
        }
        finally {
            if(ss!=null){
                ss.close();
            }
        }
        return LIST_TEACHERMANAGERS;
    }
    //SEARCH INFORMATION OF TEACHERMANAGER:
    public static Teachermanagers SEARCH_INFORMATION(String _username_){
        Session session=HibernateUtil.getSessionFactory().openSession();
        Teachermanagers _teachermanagerAccount_=null;
        try{
            String hql="from Teachermanagers as t where  t.userName=:name";
            Query q=session.createQuery(hql);
            q.setParameter("name",_username_);
            _teachermanagerAccount_=(Teachermanagers) q.list().get(0);
        }
        catch (Exception e){
            System.out.println("Exception in TeachermanagerDAO: "+e.getMessage());
        }
        finally {
            if(session!=null)
                session.close();
        }
        return _teachermanagerAccount_;
    }
}