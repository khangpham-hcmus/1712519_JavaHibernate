package dao;
import org.hibernate.Session;
import org.hibernate.query.Query;
import pojo.Accounts;
import util.HibernateUtil;
import java.util.List;
//------------------------------------------------------------
public class AccountsDAO {
    //get all Accounts
    private static List<Accounts> getAllAccounts(){
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
    //check Login
    public static boolean Login(String _username_,String _password_,Integer _type_){
        boolean flag=false;
        Session ss=HibernateUtil.getSessionFactory().openSession();
        List<Accounts> listAccountsLogin=getAllAccounts();
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
