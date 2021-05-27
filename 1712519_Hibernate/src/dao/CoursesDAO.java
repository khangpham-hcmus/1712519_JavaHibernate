package dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import pojo.Courses;
import util.HibernateUtil;

import java.util.List;

public class CoursesDAO {
    public static  List<Courses> getAllCourses(){
        //open session factory:
        List<Courses> listAllCourses=null;
        Session ss= HibernateUtil.getSessionFactory().openSession();
        try{
            String querystatement="select cs from Courses as cs";
            Query q=ss.createQuery(querystatement);
            listAllCourses=q.list();
        }
        catch (Exception e){
            System.out.println("Exception in CoursesDAO: "+e.getMessage());
        }
        finally {
            if(ss!=null){
                ss.close();
            }
        }

        return listAllCourses;
    }
}
