package dao;

import antlr.debug.TraceAdapter;
import org.hibernate.Session;
import org.hibernate.SessionEventListener;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pojo.*;
import util.HibernateUtil;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class StudentsCoursesDAO {
    public static List<Studentscourses> GetListStudentCourses()
    {
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
    public static int ToRegistrationCourse(Students student, Courses course)
    {
        int check=2;//default;
        String dayofweek=course.getDayOfWeek();
        int shift=course.getShift();

        if(StudentsCoursesDAO.CountCoursesRegistrated(student.getStudentsPK().getStudentId())==8)
            return 2;//sinh vien da dang ki 8 mon =>khong duoc dang ki nua
        Set<Studentscourses> studentscoursesSet=student.getStudentscoursesSet();
        for(Studentscourses s:studentscoursesSet)
        {
            if(s.getCourse().getDayOfWeek().equals(dayofweek) && s.getCourse().getShift()==shift)
                return 3;//Da dang ki mon hoc co thoi gian giong nhau
        }
        Studentscourses dangkikhoahoc=new Studentscourses(student,course);
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=null;
        try
        {
            transaction=session.beginTransaction();
            session.save(dangkikhoahoc);
            transaction.commit();
            check=1;
        }
        catch (Exception e)
        {
            System.out.println("Exception in StudentcoursesDAO: "+e.getMessage());
        }
        finally {
            if(session!=null)
                session.close();
        }
        return check;
    }
    public static long CountCoursesRegistrated(String studentID)
    {
        long count=0;
        Session session=HibernateUtil.getSessionFactory().openSession();;
        Transaction transaction=null;
        try{
            transaction=session.beginTransaction();
            String hql="select count(*) from Studentscourses as s where s.studentscoursesPrimarykey.studentIdRegistrated=:ID";
            Query q=session.createQuery(hql);
            q.setParameter("ID",studentID);
            q.list();
            count=(long)q.uniqueResult();
            transaction.commit();;
        }
        catch (Exception e)
        {
            System.out.println("Exception in StudentsCoursesDAO: "+e.getMessage());
            count=-1;
        }
        finally {
            if(session!=null)
                session.close();
        }
        return count;
    }

}
