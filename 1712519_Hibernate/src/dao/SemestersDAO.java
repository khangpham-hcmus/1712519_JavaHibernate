package dao;

import antlr.preprocessor.Hierarchy;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pojo.Courses;
import pojo.Semesters;
import pojo.SemestersPK;
import util.HibernateUtil;

import java.util.List;
import java.util.Set;

public class SemestersDAO {
    public  static List<Semesters> GetListSemesters()
    {
        List<Semesters> listAllSemester=null;
        Session ss= HibernateUtil.getSessionFactory().openSession();
        try{
            String hbl="select sm from Semesters as sm";
            Query q=ss.createQuery(hbl);
            listAllSemester=q.list();
        }
        catch (Exception e){
            System.out.println("Exception in SemesterDAO: "+e.getMessage());
            listAllSemester=null;
        }
        return listAllSemester;
    }
    public static Semesters GetSemester(SemestersPK hocki)
    {
        Semesters semesters=null;
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=null;
        try
        {
            transaction=session.beginTransaction();
            semesters=session.get(Semesters.class,hocki);
            transaction.commit();
        }
        catch (Exception e)
        {
            System.out.println("Exception in SemesterDAO getSemester: "+e.getMessage());
        }
        finally {
            if (session!=null)
                session.close();
        }
        return semesters;
    }
    public static boolean AddSemester(Semesters hockimoi)
    {
        boolean check=false;
        Semesters semester=SemestersDAO.GetSemester(hockimoi.getSemestersPrimarykey());
        if(semester!=null)
            return false;//hoc ki da ton tai.
        Session session= HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=null;
        try{
            transaction=session.beginTransaction();
            session.save(hockimoi);
            transaction.commit();
            check=true;
            if(hockimoi.getCurrentSemester().equals("1"))
                SemestersDAO.SetCurrentSemesterTrue(hockimoi);

        }
        catch (Exception e)
        {
            System.out.println("Exception in SemesterDAO addSemester method: "+e.getMessage());
        }
        finally {
            if (session!=null)
                session.close();
        }
        return check;
    }
    public static boolean SetCurrentSemesterTrue(Semesters hocki)
    {
        boolean check=false;
        Semesters semester=SemestersDAO.GetSemester(hocki.getSemestersPrimarykey());
       if(semester==null)
           check=false;
       else
       {
           Session session=HibernateUtil.getSessionFactory().openSession();
           Transaction transaction=null;
           try
           {
               transaction=session.beginTransaction();
               String hql="update from Semesters as s set s.currentSemester=:status";
               Query q=session.createQuery(hql);
               q.setParameter("status","0");
               q.executeUpdate();
               semester.setCurrentSemester("1");
               session.saveOrUpdate(semester);
               transaction.commit();
               check=true;
           }
           catch (Exception e)
           {
               System.out.println("Exception in SemesterDAO setCurrent method: "+e.getMessage());
               check=false;
           }finally {
               if(session!=null)
                   session.close();
           }
       }
        return  check;
    }
    public static boolean DeleteSemester(Semesters semester)
    {
        boolean checkDelete=false;
        Semesters hocki=SemestersDAO.GetSemester(semester.getSemestersPrimarykey());
        if (hocki==null)
            checkDelete=false;
        else
        {
            Session session=HibernateUtil.getSessionFactory().openSession();
            Transaction transaction=null;
            try{
                transaction=session.beginTransaction();
                String hql1="delete from Studentscourses as s where s.studentscoursesPrimarykey.semesterYearCourse=:year and s.studentscoursesPrimarykey.semesterNameCourse=:name";
                Query q1=session.createQuery(hql1);
                q1.setParameter("year",hocki.getSemestersPrimarykey().getSemesterYear());
                q1.setParameter("name",hocki.getSemestersPrimarykey().getSemesterName());
                q1.executeUpdate();
                String hql2="delete from Courses as c where c.coursePK.semesterYear=:year and c.coursePK.semesterName=:name";
                Query q2=session.createQuery(hql2);
                q2.setParameter("year",hocki.getSemestersPrimarykey().getSemesterYear());
                q2.setParameter("name",hocki.getSemestersPrimarykey().getSemesterName());
                q2.executeUpdate();
                String hql3="delete  from Semesters as s where s.semestersPrimarykey.semesterYear=:year and s.semestersPrimarykey.semesterName=:name";
                Query q3=session.createQuery(hql3);
                q3.setParameter("year",hocki.getSemestersPrimarykey().getSemesterYear());
                q3.setParameter("name",hocki.getSemestersPrimarykey().getSemesterName());
                q3.executeUpdate();
                transaction.commit();
                checkDelete=true;
            }
            catch (Exception e)
            {
                checkDelete=false;
                System.out.println("Exception in SemesterDAO delete semester method: "+e.getMessage());
            }
            finally {
                if(session!=null)
                {
                    session.close();
                }
            }
        }
        return  checkDelete;
    }
    public static Semesters GetCurrentSemester()
    {
        Semesters currentSemester=null;
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=null;
        try{
            transaction=session.beginTransaction();
            String hql="select s from Semesters as s where s.currentSemester=: status";
            Query q=session.createQuery(hql);
            q.setParameter("status","1");
            currentSemester=(Semesters)q.list().get(0);
            transaction.commit();
        }
        catch (Exception e)
        {
            System.out.println("Exception in SemesterDAO currentSemester method: "+e.getMessage());
            currentSemester=null;
        }
        finally {
            if(session!=null)
                session.close();
        }
        return currentSemester;
    }
    public static Set<Courses> GetOpenedCourseCurrent()
    {
        Session session=HibernateUtil.getSessionFactory().openSession();
        Set<Courses> coursesOpened=null;
        try {
            Semesters currentSemester=SemestersDAO.GetCurrentSemester();
            System.out.println(currentSemester.toString());
            coursesOpened=currentSemester.getCourses();
        }
        catch (Exception exception)
        {
            System.out.println("Exception in SemesterDAO getOpenedCourse method "+exception.getMessage());
        }

        return coursesOpened;
    }
}
