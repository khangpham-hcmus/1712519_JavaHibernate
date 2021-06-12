package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pojo.Accounts;
import pojo.Students;
import pojo.StudentsPK;
import pojo.Teachermanagers;
import util.HibernateUtil;

import java.util.List;

//------------------------------------------------------------
public class AccountsDAO {
    public static Accounts GetAccount(String username)
    {
        Session session=HibernateUtil.getSessionFactory().openSession();
        Accounts acc=null;
        Transaction transaction=null;
        try{
            transaction=session.beginTransaction();
            acc=(Accounts) session.get(Accounts.class,username);
            transaction.commit();
        }
        catch (Exception e)
        {
            transaction.rollback();
            acc=null;
        }
        finally {
            if(session!=null)
                session.close();
        }
        return  acc;

    }
    public static boolean DeleteAccount(String username)
    {
        boolean checkDelete=false;
        Accounts acc=AccountsDAO.GetAccount(username);
        if(acc==null)
        {
            checkDelete=false;
        }
        else{
                Session session=HibernateUtil.getSessionFactory().openSession();
                Transaction transaction=null;
                try{
                    transaction=session.beginTransaction();
                    Object a= session.load(Accounts.class,username);
                    session.delete(a);
                    transaction.commit();
                    checkDelete=true;
                }
                catch (Exception e)
                {
                    System.out.println("Exception in Account dao delete method: "+e.getMessage());
                    transaction.rollback();
                    checkDelete=false;
                }finally {
                    if(session!=null)
                        session.close();
                }
        }
        return checkDelete;
    }
    public static boolean AddTeacherManagerAccount(String fullname)
    {
        boolean checkAdd=false;
        Accounts acc=AccountsDAO.GetAccount(fullname);
        if(acc!=null)
            checkAdd=false;
        else{
            Session session=HibernateUtil.getSessionFactory().openSession();
            Transaction transaction=null;
            try{
                transaction=session.beginTransaction();
                Accounts tk=new Accounts(fullname,fullname,1);
                Teachermanagers giaovu=new Teachermanagers(fullname,fullname);
                tk.setTeachermanager(giaovu);
                giaovu.setAccount(tk);
                session.save(tk);
                transaction.commit();
                checkAdd=true;
            }
            catch (Exception e)
            {
                System.out.println("Exception in AccountDAO add method: "+e.getMessage());
                transaction.rollback();
                checkAdd=false;
            }
            finally {
                if(session!=null)
                    session.close();
            }
        }
        return checkAdd;
    }
    public static boolean CheckLogin(String username,String password)
    {
        boolean checkLogin=false;
        try {

        Accounts ac=AccountsDAO.GetAccount(username);
        if(ac==null)
        {
            checkLogin=false;
        }
        else {
            if(password.equals(ac.getPass())==true)
                checkLogin=true;
        }
        }
        catch (Exception e)
        {
            checkLogin=false;
        }
        return checkLogin;
    }
    public  static  boolean UpdatePassword(String username,String newPassword)
    {
        boolean checkUpdate=false;
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=null;
        Accounts ac=AccountsDAO.GetAccount(username);
        if(ac==null)
            checkUpdate=false;
        else
        {
            try {
                transaction=session.beginTransaction();
                ac.setPass(newPassword);
                session.saveOrUpdate(ac);
                transaction.commit();
                checkUpdate=true;
            }
            catch (Exception e)
            {
                checkUpdate=false;
            }
            finally {
                if(session!=null)
                    session.close();
            }
        }
        return checkUpdate;
    }
    public static  boolean UpdateInformation(String username,String newName)
    {
        Accounts ac=AccountsDAO.GetAccount(username);
        boolean checkUpdate=false;
        if(ac==null)
            checkUpdate=false;
        else
        {
            Session session=HibernateUtil.getSessionFactory().openSession();
            Transaction transaction=null;
            try {

                transaction=session.beginTransaction();
                if(ac.getTypeOfAccount()==1)
                {
                    ac.getTeachermanager().setTeacherManagerName(newName);
                    session.saveOrUpdate(ac);
                }
                else if(ac.getTypeOfAccount()==2)
                {
                    ac.getStudent().setStudentName(newName);
                    session.saveOrUpdate(ac);
                }
                session.saveOrUpdate(ac);
                transaction.commit();
                checkUpdate=true;
            }
            catch (Exception exception)
            {
                System.out.println(exception.getMessage());
                transaction.rollback();
                checkUpdate=false;
            }
            finally {
                if(session!=null)
                    session.close();
            }
        }
        return checkUpdate;
    }
    public static boolean AddStudentAccount(String studentid_,String classid_,String fullName,String gender_)
    {
        boolean checkAdd=false;
        Accounts account=AccountsDAO.GetAccount(studentid_);
        if(account==null)
        {
            Session session=HibernateUtil.getSessionFactory().openSession();
            Transaction transaction=null;
            try {
                transaction=session.beginTransaction();
                account = new Accounts(studentid_, studentid_, 2);
                StudentsPK studentsPK=new StudentsPK(studentid_,classid_);
                Students students=new Students(studentsPK,fullName, gender_,null);
                account.setStudent(students);
                students.setAccount(account);
                session.save(account);
                transaction.commit();
                checkAdd=true;
            }
            catch (Exception e)
            {
                checkAdd=false;
            }
            finally {
                if(session!=null)
                    session.close();
            }

        }
        else
            checkAdd=false;

        return checkAdd;
    }
    public static String GetInformationStudent(String username)
    {
        String thongtin=null;
        Accounts ac=AccountsDAO.GetAccount(username);
        if(ac!=null&&ac.getTypeOfAccount()==2)
        {
            thongtin=ac.getStudent().toString();
        }
        return  thongtin;
    }
    public static String GetInformationTeacher(String username)
    {
        String thongtin=null;
        Accounts ac=AccountsDAO.GetAccount(username);
        if(ac!=null&&ac.getTypeOfAccount()==1)
        {
            thongtin=ac.getTeachermanager().toString();
        }
        return  thongtin;
    }
    public static boolean ResetPassword(String username)
    {
        boolean checkReset=false;
        Session session=HibernateUtil.getSessionFactory().openSession();
        Accounts ac=AccountsDAO.GetAccount(username);
        Transaction transaction=null;
        if(ac!=null)
        {
            try{
                transaction=session.beginTransaction();
                ac.setPass(ac.getUserName());
                session.saveOrUpdate(ac);
                transaction.commit();
                checkReset=true;
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());checkReset=false;
            }
            finally {
                if (session!=null)
                    session.close();
            }
        }
        return checkReset;
    }
    public  static List<Accounts> GetTeachermanagerAccount()
    {
        List<Accounts> danhsach=null;
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=null;
        try
        {
            transaction=session.beginTransaction();
            String hql="select a from Accounts as a where a.typeOfAccount=:b";
            Query query=session.createQuery(hql);
            query.setParameter("b",1);
            danhsach= (List<Accounts>) query.list();
            transaction.commit();
        }
        catch (Exception e)
        {
            System.out.println("Exception in AccountDAO: "+e.getMessage());
            danhsach=null;
        }
        finally {
            if(session!=null)
                session.close();
        }
        return danhsach;
    }

}