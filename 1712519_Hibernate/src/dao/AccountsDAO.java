package dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import pojo.Accounts;
import util.HibernateUtil;

import java.util.List;

public class AccountsDAO {
    public static List<Accounts> getAllAccounts(){
        //open session
        Session ss= HibernateUtil.getSessionFactory().openSession();
        List<Accounts> listAccounts=null;
        try{
            //Query statement:
            final String hbl="select ac from Accounts as ac";
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
}
