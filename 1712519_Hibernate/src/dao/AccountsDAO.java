package dao;
import org.hibernate.Session;
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
    private static List<Accounts> GET_LIST_ACCOUNTS_IN_SYSTEM(){
        //
        Session ss=HibernateUtil.getSessionFactory().openSession();
        final String HQL="from Accounts";
        List<Accounts> _list_=null;
        try{
            Query q=ss.createQuery(HQL);
            _list_=q.list();
        }
        catch (Exception e){
            System.out.println("Exception in AccountsDAO: "+e);
        }
        finally {
            if(ss!=null){
                ss.close();
            }
        }
        return _list_;
    }
    //cau1: getInformation of account:
    public static List<String> GET_INFORMATION_OF_ACCOUNT(String _username_){
        List<String > info=null;
        List<Accounts> _list_=null;
        Session ss=HibernateUtil.getSessionFactory().openSession();
        try{
            final String HQL="select ac from Accounts as ac where ac.userName=:name";
            System.out.println(HQL);
            Query q=ss.createQuery(HQL);
            q.setParameter("name",_username_);
            //_list_=AccountsDAO.GET_LIST_ACCOUNTS_IN_SYSTEM();
            _list_=q.list();
            if(_list_.size()!=0)
            {
                info=new ArrayList<>();
                info.add(_list_.get(0).getUserName());
                info.add(_list_.get(0).getPass());
                Integer type=_list_.get(0).getTypeOfAccount();
                info.add(type.toString());
            }
        }
        catch (Exception e){
            System.out.println("Exception in AccountsDAO: "+e);
        }
        finally {
            if(ss!=null){
                ss.close();
            }
        }
        return info;
    }

    //GET TEACHERMANAGER:
    public static Accounts GET_INFORMATION_OF_ACCOUNT____(String username, Integer _type_){
        Session ss=HibernateUtil.getSessionFactory().openSession();
        Accounts ac=null;
        try{
            String hql="from Accounts ac where userName=:name and ac.typeOfAccount=: type";
            Query q=ss.createQuery(hql);
            q.setParameter("name",username);
            q.setParameter("type" ,_type_) ;
            List<Accounts> l=q.list();
            System.out.println(l.get(0).toString());
            if(_type_==2){
                Students s=l.get(0).get_student_();
                if(s==null){
                    System.out.println("nullpointer");
                }
                else{
                System.out.println(s.toString());
                }
            }

        }
        catch (Exception e){

        }
        finally {
            if(ss!=null){
                ss.close();
            }
        }
        return ac;
    }

    //-----------------------------------------------------------------------------------------

    //cau3: change the password:

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
