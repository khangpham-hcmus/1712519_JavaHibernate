package dao;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pojo.Classes;
import util.HibernateUtil;

import java.util.List;

public class ClassesDAO {
    public static Classes GetClass(String ClassID)
    {
        Classes classes=null;
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=null;
        try{
            transaction=session.beginTransaction();
            classes=(Classes) session.get(Classes.class,ClassID);
            transaction.commit();
        }
        catch (Exception e)
        {
            System.out.println("Exc in ClassDAO: "+e.getMessage());
            classes=null;
        }
        finally {

        }
        return classes;
    }
    public static List<Classes> GetListClasses()
    {
        List<Classes> listAllClasses=null;
        Session ss= HibernateUtil.getSessionFactory().openSession();
        try{
            String hbl="from Classes";
            Query q=ss.createQuery(hbl);
            listAllClasses=q.list();
        }
        catch(Exception e){
            System.out.println("Exception in ClassesDAO: "+e.getMessage());
            listAllClasses=null;
        }
        finally {
            ss.close();
        }
        return listAllClasses;
    }
    public static boolean AddClass(String classID)
    {
        boolean checkAdd=false;
        Classes classes=ClassesDAO.GetClass(classID);
        if(classes==null)
        {
            Session session=HibernateUtil.getSessionFactory().openSession();
            Transaction transaction=null;
            try {
                transaction=session.beginTransaction();
                Classes lophoc=new Classes(classID);
                session.save(lophoc);
                transaction.commit();
                checkAdd=true;
            }
            catch (Exception exception)
            {
                checkAdd=false;
                System.out.println("Exc in ClassDAO: "+exception.getMessage());
            }
            finally {
                if(session!=null)
                    session.close();
            }
        }
        else
            checkAdd=false;
        return  checkAdd;
    }

}
