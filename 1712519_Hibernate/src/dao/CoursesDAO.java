package dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import pojo.Courses;
import util.HibernateUtil;

import java.util.List;

public class CoursesDAO {
    public static  List<Courses> getAllCourses() {
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
}
