package dao;

import antlr.debug.TraceAdapter;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pojo.Subjects;
import util.HibernateUtil;

import java.util.List;
public class SubjectsDAO {
    //List of Subjects:
    public static List<Subjects> getAllSubjects(){
       List<Subjects> DanhSachMonHoc=null;
       Session session=HibernateUtil.getSessionFactory().openSession();
       try{
           String hql="from Subjects as sb";
           Query q= session.createQuery(hql);
           DanhSachMonHoc=q.list();
       }
       catch (Exception e) {
           DanhSachMonHoc=null;
       }
       finally {
           if(session!=null)
               session.close();
       }
       return DanhSachMonHoc;
    }
    //Search Subject
    public static Subjects GetSubject(String subjectid__)
    {
        Subjects sb=null;
        Session session=HibernateUtil.getSessionFactory().openSession();
        try{
            sb=(Subjects) session.load(Subjects.class,subjectid__);
            Hibernate.initialize((Subjects)sb);
        }
        catch (Exception e)
        {
            sb=null;
        }
        finally {
            if(session!=null)
                session.close();
        }
        return  sb;
    }
    //Add Subject
    public static boolean AddSubject(Subjects sb)
    {
        boolean checkAdd=false;
        Subjects monhoc=SubjectsDAO.GetSubject(sb.getSubjectId());
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=null;
        if(monhoc==null)
        {
            try{
                transaction =session.beginTransaction();
                session.save(sb);
                transaction.commit();
                checkAdd=true;
            }
            catch (Exception exception)
            {
                System.out.println("Exc: "+exception.getMessage());
                transaction.rollback();
                return false;
            }
            finally {
                if(session!=null)
                    session.close();
            }
        }
        else
            return false;

        return checkAdd;
    }
    //Update Subject
    public static boolean UpdateSubject(String subjectID, String NewNameOfSubject)
    {
        boolean checkUpdate=false;
        Subjects monhoc=SubjectsDAO.GetSubject(subjectID);
        if(monhoc!=null)
        {
            Session session=HibernateUtil.getSessionFactory().openSession();
            try {
                Transaction transaction = session.beginTransaction();
                monhoc.setSubjectName(NewNameOfSubject);
                session.saveOrUpdate(monhoc);
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
        else{
            return false;
        }

        return checkUpdate;
    }
    //Delete Subject
    public static  boolean DeleteSubject(String _subjectID_)
    {
        boolean checkDelete=false;
        Subjects monhoc=SubjectsDAO.GetSubject(_subjectID_);
        Session session=HibernateUtil.getSessionFactory().openSession();
        if(monhoc!=null)
        {
            try{
                //String hql1="delete from Studentscourses as s where s.c";
               // Query q1=session.createQuery(hql1);

            }
            catch (Exception e)
            {

            }
            finally {
                if(session!=null)
                    session.close();
            }
        }
        else
        {

        }


        return checkDelete;
    }
}
