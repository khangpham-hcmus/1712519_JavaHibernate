package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pojo.Accounts;
import pojo.Students;
import util.HibernateUtil;

import java.util.List;

public class StudentsDAO {
    public  static  List<Students> GetListStudents()
    {
        List<Students> listAllStudents=null;
        Session ss= HibernateUtil.getSessionFactory().openSession();
        try{
            String qr="from Students";
            Query q=ss.createQuery(qr);
            listAllStudents=q.list();
        }
        catch (Exception e){
            System.out.println("Exception in StudentsDAO: "+e.getMessage());
        }
        finally {
            if(ss!=null)
                ss.close();
        }
        return listAllStudents;
    }
    public static Students GetStudent(String studentId)
    {
        Session session=HibernateUtil.getSessionFactory().openSession();
        Students hocsinh=null;
        try{
            Transaction transaction=session.beginTransaction();
            String hql="select s from Students as s where s.studentsPK.studentId=:studentID";
            Query q=session.createQuery(hql);
            q.setParameter("studentID",studentId);

            hocsinh=(Students) q.list().get(0);
            transaction.commit();

        }
        catch (Exception e)
        {
            hocsinh=null;
        }
        return hocsinh;
    }
    public static boolean ResetPasswordStudent(String studentId)
    {
        boolean check=false;
        Accounts accounts=AccountsDAO.GetAccount(studentId);
        if(accounts==null)
            check=false;
        else
        {
            Session session=HibernateUtil.getSessionFactory().openSession();
            Transaction transaction=null;
            try{
                transaction=session.beginTransaction();
                accounts.setPass(studentId);
                session.saveOrUpdate(accounts);
                transaction.commit();
                check=true;
            }
            catch (Exception e)
            {
                System.out.println("Exception in StudentDAO resetpass method: "+e.getMessage());
                check=false;
            }
            finally {
                if(session!=null)
                    session.close();
            }
        }
        return check;
    }
    public static boolean UpdatePasswordStudent(String studentId,String newPassword)
    {
        boolean check=false;
        Accounts accounts=AccountsDAO.GetAccount(studentId);
        if(accounts==null)
            check=false;
        else
        {
            Session session=HibernateUtil.getSessionFactory().openSession();
            Transaction transaction=null;
            try{
                transaction=session.beginTransaction();
                accounts.setPass(newPassword);
                session.saveOrUpdate(accounts);
                transaction.commit();
                check=true;
            }
            catch (Exception e)
            {
                System.out.println("Exception in StudentDAO resetpass method: "+e.getMessage());
                check=false;
            }
            finally {
                if(session!=null)
                    session.close();
            }
        }
        return check;
    }
    public static boolean UpdateInformationStudent(String studentId,String newName)
    {
        boolean checkUpdate=false;
        Students hocsinh=StudentsDAO.GetStudent(studentId);
        if(hocsinh==null)
            checkUpdate=false;
        else{
            Session session=HibernateUtil.getSessionFactory().openSession();
            Transaction transaction=null;
            try {
                transaction=session.beginTransaction();
                String hql="update from Students as st set st.studentName=:name where st.studentsPK.studentId=:ID";
                Query q=session.createQuery(hql);
                q.setParameter("name",newName);
                q.setParameter("ID",studentId);
                q.executeUpdate();
                transaction.commit();
                checkUpdate=true;
            }
            catch (Exception exception)
            {
                System.out.println(exception.getMessage());
            }
            finally {
                if(session!=null)
                    session.close();
            }
        }
        return  checkUpdate;
    }
    public static boolean AddStudent(Students student)
    {
        boolean checkAdd=false;
        Students hocsinhMoi=StudentsDAO.GetStudent(student.getStudentsPK().getStudentId());
        if(hocsinhMoi!=null)
            checkAdd=false;
        else
        {
            hocsinhMoi=student;
            String studentID=hocsinhMoi.getStudentsPK().getStudentId();
            Session session=HibernateUtil.getSessionFactory().openSession();
            Transaction transaction=null;
            try{
                transaction=session.beginTransaction();
                Accounts acc=new Accounts(studentID,studentID,2);
                acc.setStudent(hocsinhMoi);
                session.save(acc);
                transaction.commit();
                checkAdd=true;
            }catch (Exception exception)
            {
                System.out.println("Exception in StudentsDAO add method: "+exception.getMessage());
                checkAdd=false;
            }
            finally {
                if(session!=null)
                    session.close();
            }
        }
        return checkAdd;
    }
}
