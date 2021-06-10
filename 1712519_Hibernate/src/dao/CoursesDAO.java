package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pojo.Courses;
import pojo.CoursesPK;
import util.HibernateUtil;

import java.util.List;

public class CoursesDAO {
    public static  List<Courses> GetListCourses()
    {
        List<Courses> danhsachKhoahoc=null;
        Session session=HibernateUtil.getSessionFactory().openSession();
        try{
            String hql ="from Courses";
            Query q=session.createQuery(hql);
            danhsachKhoahoc= (List<Courses>) q.list();
        }
        catch (Exception e)
        {
            System.out.println("Exception in CourseDAO: "+e.getMessage());
        }
        finally {
            if (session!=null)
                session.close();
        }
        return danhsachKhoahoc;
    }
    public static Courses GetCourse(String semesterYear,String semesterName,String subjectID,String classId)
    {
        CoursesPK coursesPK=new CoursesPK(semesterYear,semesterName,subjectID,classId);
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=null;
        Courses khoahoc=null;
        try {
            transaction=session.beginTransaction();
            khoahoc=session.get(Courses.class,coursesPK);
            transaction.commit();
        }
        catch (Exception e)
        {
            System.out.println("Exception in coursesDAO getCourse method: "+e.getMessage());
            khoahoc=null;
        }
        finally {
            if(session!=null)
                session.close();
        }
        return khoahoc;
    }

}
