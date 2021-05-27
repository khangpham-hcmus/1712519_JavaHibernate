package dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import pojo.Studentscourses;
import util.HibernateUtil;

import java.util.List;

public class StudentsCoursesDAO {
    public static List<Studentscourses> getAllStudentsCourses(){
        List<Studentscourses> listAllStudentsCourse=null;
        //open session:
        Session ss= HibernateUtil.getSessionFactory().openSession();
        try{
            String hql="select sc from Studentscourses as sc";
            Query q=ss.createQuery(hql);
            listAllStudentsCourse=q.list();
        }
        catch (Exception e){
            System.out.println("Exception in StudentsCoursesDAO: "+e.getMessage());
        }
        finally {
            if(ss!=null)
                ss.close();
        }
        return listAllStudentsCourse;
    }
}
