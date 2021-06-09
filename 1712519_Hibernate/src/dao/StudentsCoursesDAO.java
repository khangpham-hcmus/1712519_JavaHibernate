package dao;

import antlr.debug.TraceAdapter;
import org.hibernate.Session;
import org.hibernate.SessionEventListener;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pojo.Studentscourses;
import pojo.StudentscoursesPK;
import util.HibernateUtil;

import java.io.Serializable;
import java.util.List;

public class StudentsCoursesDAO {
    public static List<Studentscourses> GetListStudentCourses(){
        List<Studentscourses> listAllStudentsCourse=null;
        Session ss= HibernateUtil.getSessionFactory().openSession();
        try{
            String hql="from Studentscourses as sc";
            Query q=ss.createQuery(hql);
            listAllStudentsCourse=q.list();
        }
        catch (Exception e){
            System.out.println("Exception in StudentsCoursesDAO: "+e.getMessage());
            listAllStudentsCourse=null;
        }
        finally {
            if(ss!=null)
                ss.close();
        }
        return listAllStudentsCourse;
    }
    public static Studentscourses GetStudentCourse(Studentscourses khoachinh)
    {
        Session session=HibernateUtil.getSessionFactory().openSession();
        Studentscourses studentscourses=null;
        Transaction transaction=null;
        try
        {
            transaction=session.beginTransaction();
            studentscourses=session.get(Studentscourses.class, khoachinh.getStudentscoursesPrimarykey());
            transaction.commit();
        }
        catch (Exception e)
        {
            studentscourses=null;
        }
        finally {
           if (session!=null)
               session.close();
        }
        return  studentscourses;
    }
    public static boolean DeleteStudentCourse(Studentscourses studentscourses)
    {
        boolean check=false;
        studentscourses =StudentsCoursesDAO.GetStudentCourse(studentscourses);
        if(studentscourses==null)
            check=false;
        else
        {
            Session session=HibernateUtil.getSessionFactory().openSession();
            Transaction transaction=null;
            try{
                transaction=session.beginTransaction();
                session.delete(studentscourses);
                transaction.commit();
                check=true;
            }catch (Exception exception){
                System.out.println("Exception in Studentcourse: "+exception.getMessage());
                check=false;
            }finally {

            }
        }
        return check;
    }
}
