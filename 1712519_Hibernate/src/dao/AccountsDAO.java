package dao;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pojo.Accounts;
import pojo.Students;
import pojo.Teachermanagers;
import util.HibernateUtil;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;
//------------------------------------------------------------
public class AccountsDAO {
    //-------------------------------------------------------

    //GET_ACCOUNT_THROUGH_USERNAME_TYPE
    public static Accounts GET_ACCOUNT_THROUGH_USERNAME_TYPE(String _username_,Integer _TypeOfAccount_){
        Accounts ac=null;
        Session ss=HibernateUtil.getSessionFactory().openSession();
        try{
            String hql="from Accounts as ac where ac.userName=:name and ac.typeOfAccount=:type";
            Query q=ss.createQuery(hql);
            q.setParameter("name",_username_);
            q.setParameter("type",_TypeOfAccount_);
            ac= (Accounts) q.list().get(0);
        }catch (Exception exc){
            System.out.println("Exception in AccountsDAO: "+exc.getMessage());
        }
        finally {
            if(ss!=null){
                ss.close();
            }
        }
        return ac;
    }
    //UPDATE_PASSWORD:
    public static boolean UPDATE_PASSWORD(String _username_,String newpass){
        Session ss=HibernateUtil.getSessionFactory().openSession();
        boolean checkupdate=false;
        Transaction tx=null;
        try{
            tx=ss.beginTransaction();
            String hql="update Accounts set Pass=:passnew where UserName=:username ";
            Query q=ss.createSQLQuery(hql);
            q.setParameter("passnew",newpass);
            q.setParameter("username",_username_);
            Integer i=q.executeUpdate();
            tx.commit();
            if(i!=0)
                checkupdate=true;
            else
                checkupdate=false;
            System.out.println(checkupdate);
        }
        catch (Exception e){
            System.out.println("Exception in AccountsDAO: "+e.getMessage());
        }
        finally {
            if(ss!=null)
                ss.close();
        }
        return checkupdate;
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
}
