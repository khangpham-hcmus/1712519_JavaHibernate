package dao;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pojo.Accounts;
import pojo.Students;
import pojo.Teachermanagers;
import util.HibernateUtil;

import java.util.List;
//------------------------------------------------------------
public class AccountsDAO {
    //-------------------------------------------------------
    //GET_ACCOUNT_THROUGH_USERNAME_TYPE
    public static Accounts GET_ACCOUNT_THROUGH_USERNAME_TYPE(String _username_,Integer typeofAccount) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        Accounts _account_=null;
        try{
            _account_=(Accounts) session.load(Accounts.class,_username_);
            if(typeofAccount==1){
                Hibernate.initialize((Teachermanagers)_account_.get_teachermanager_());
            }
            else if(typeofAccount==2){
                Hibernate.initialize((Students)_account_.get_student_());
            }
        }
        catch (Exception exception){
            session.close();
            return null;
        }
        finally {
            if(session!=null)
                session.close();
        }
        return  _account_;
    }
    //UPDATE_PASSWORD:
    public static boolean UPDATE_PASSWORD(String _username_,String _newPassword_){
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=null;
        boolean checkUpdate=false;
        try{
            transaction=session.beginTransaction();
            Accounts _account_=session.load(Accounts.class,_username_);
            _account_.setPass(_newPassword_);
            transaction.commit();
        }
        catch (Exception exception)
        {
            transaction.rollback();
            checkUpdate=false;
            System.out.println("Exception in AccountDAO: "+exception.getMessage());
        }
        finally {
            if(session!=null)
                session.close();
        }


        return checkUpdate;
    }
    //RESET_PASSWORD:
    public static boolean RESET_PASSWORD(String _username_, Integer _typeofAccount_){
        boolean checkReset=false;
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=null;
        try{
            transaction=session.beginTransaction();
            Accounts _account_=session.load(Accounts.class,_username_);
            _account_.setPass(_username_);
            transaction.commit();
        }
        catch (Exception exception){
            transaction.rollback();
            System.out.println("Exception in AccountsDAO: "+exception.getMessage());
        }
        finally {
            if(session!=null)
                session.close();
        }
        return checkReset;
    }
    //check Login
    public static boolean Login(String _username_,String _password_,Integer _type_){
        boolean flag=false;
        Session ss=HibernateUtil.getSessionFactory().openSession();
        List<Accounts> listAccountsLogin=null;//getAllAccounts();
        try{
            if(listAccountsLogin.size()!=0) {
                for(Accounts e:listAccountsLogin){
                    if(e.getTypeOfAccount()==_type_&&e.getUserName().equals(_username_)&&e.getPass().equals(_password_))
                        return true;
                }
                return false;
            }
            else{
                return false;
            }
        }
        catch (Exception e){
            System.out.println("Can not login! "+e.getMessage());
        }

        return flag;
    }
    //UPDATE_INFORMATION:
    public static boolean UPDATE_INFORMATION_FOR_ACCOUNT(String _username_,Integer _type_,String _newName_){
        boolean checkUPDATE=false;
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=null;
        Accounts _account_=null;
        Teachermanagers _teacheraccount_=null;
        Students _studentaccount_=null;
        try{
            transaction=session.beginTransaction();
            _account_=session.load(Accounts.class,_username_);
            if(_type_==1){
                _teacheraccount_=_account_.get_teachermanager_();
                _teacheraccount_.setTeacherManagerName(_newName_);
            }
            else if(_type_==2){
                _studentaccount_=_account_.get_student_();
                _studentaccount_.setStudentName(_newName_);
            }
            transaction.commit();
        }
        catch (Exception e){
            checkUPDATE=false;
            transaction.rollback();
            System.out.println("Exception in AccountDAO: "+e.getMessage());
        }
        finally {
            if(session!=null)
                session.close();
        }
        return checkUPDATE;
    }
    //ADD_TEACHERMANAGER_ACCOUNT:
    public static boolean ADD_TEACHERMANAGER_ACCOUNT(String fullname) {
        Accounts existingAccount=AccountsDAO.GET_ACCOUNT_THROUGH_USERNAME_TYPE(fullname,1);
        boolean check=true;
        Session ss=null;
        Transaction tx=null;
        if(existingAccount==null)
        {
            Session session=HibernateUtil.getSessionFactory().openSession();
            Transaction transaction=null;
            try{
                transaction=session.beginTransaction();
                Accounts acc=new Accounts(fullname,fullname,1);
                session.save((acc));
                transaction.commit();
                ss=HibernateUtil.getSessionFactory().openSession();
                tx=ss.beginTransaction();
                Teachermanagers tc=new Teachermanagers(fullname,fullname,fullname);
                ss.save(tc);
                tx.commit();
            }catch (Exception e){
                transaction.rollback();
                tx.rollback();
                check=false;
            } finally {
                if(session!=null)
                    session.close();
                if(ss!=null)
                    ss.close();
            }
        }
        else
            return false;
        return  check;
    }
    //DELETE ACCOUNT
    public static  boolean DELETE_ACCOUNT(String username)
    {
        try{
            Session session=HibernateUtil.getSessionFactory().openSession();
            Transaction transaction=null;

            transaction=session.beginTransaction();

            String hql1 ="delete from pojo.Teachermanagers as a where a.userName=:name";
            Query q1=session.createQuery(hql1);
            q1.setParameter("name",username);
            q1.executeUpdate();

            String hql2="delete from pojo.Accounts as tc where tc.userName=:name";
            session.createQuery(hql2).setParameter("name", username).executeUpdate();

            transaction.commit();
        }
        catch (Exception e)
        {
            System.out.println("Exception DeleteAccountDAO: "+e.getMessage());
            return false;
        }
        return true;
    }
}
