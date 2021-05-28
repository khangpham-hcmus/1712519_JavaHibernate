package dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import pojo.Accounts;
import util.HibernateUtil;

import java.util.List;

public class AccountsDAO {
    //get all Accounts
    public static List<Accounts> getAllAccounts(){
        //open session
        Session ss= HibernateUtil.getSessionFactory().openSession();
        List<Accounts> listAccounts=null;
        try{
            //Query statement:
            final String hbl="select ac from Accounts as ac where ac.typeOfAccount=1";
            Query q=ss.createQuery(hbl);
            //Get result set:
            listAccounts=q.list();
        }
        catch (Exception e){
            System.out.println("Exception in AccountDAO: "+e.getMessage());
        }
        finally {
            ss.close();
        }
        return listAccounts;
    }

    //check Login
    public static boolean Login(String _username_,String _password_,int _type_){
        boolean flag=false;
        Session ss=HibernateUtil.getSessionFactory().openSession();
        List<Accounts> listAccountsLogin=null;
        try{
            String hbl="select a from Accounts as a where a.userName="+_username_+" and a.pass="+_password_+" and a.typeOfAccount="+_type_;
            Query q=ss.createQuery(hbl);
            listAccountsLogin=q.list();
            if(listAccountsLogin.size()==0)
                flag=false;
            else{
                flag=true;
            }

        }
        catch (Exception e){
            System.out.println("Can not login! "+e.getMessage());
         }

        return flag;
    }
}
