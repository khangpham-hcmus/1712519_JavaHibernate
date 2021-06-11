package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pojo.Courses;
import pojo.CoursesPK;
import pojo.Semesters;
import pojo.Subjects;
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
    public static boolean AddCourseForCurrentSemester(String subjectId,String classID,String theoryTeacherName,String dayOfWeek,int shift,int maxslot,String room)
    {
        boolean check=false;
        Semesters currentSemester=SemestersDAO.GetCurrentSemester();
        Courses khoahoc=new Courses();
        String year=currentSemester.getYear();
        String name=currentSemester.getName();
        CoursesPK pk=new CoursesPK(year,name,subjectId,classID);
        khoahoc.setCoursePK(pk);
        khoahoc.setTheoryTeacher(theoryTeacherName);
        khoahoc.setRoom(room);
        khoahoc.setMaxSlot(maxslot);
        khoahoc.setDayOfWeek(dayOfWeek);
        khoahoc.setShift(shift);
        Courses course=CoursesDAO.GetCourse(year,name,subjectId,classID);
        if(course!=null)
            return false;//khoa hoc da ton tai
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=null;
        try {

            transaction=session.beginTransaction();
            session.save(khoahoc);
            transaction.commit();
            check=true;
        }
        catch (Exception exception)
        {
            System.out.println("Exception in coursesDAO add course current semerter: "+exception.getMessage());
            check=false;
        }
        finally {
            if (session!=null)
                session.close();
        }
        return check;
    }
    public static boolean DeleteCourse(Courses course)
    {
        boolean check=false;
        String year=course.getSemesterYearCourse();
        String name=course.getSemesterNameCourse();
        String subjectID=course.getSubjectIdCourse();
        String classID=course.getClassIdCourse();
        Courses khoahoc=CoursesDAO.GetCourse(year,name,subjectID,classID);
        if(khoahoc==null)
            check=false;
        else { //khoa hoc dang ton tai:
            Session session=HibernateUtil.getSessionFactory().openSession();
            Transaction transaction=null;
            try {
                transaction=session.beginTransaction();
                String hql1="delete from Studentscourses as s where s.studentscoursesPrimarykey.semesterYearCourse=:Year and s.studentscoursesPrimarykey.semesterNameCourse=:Name ";
                hql1+=" and s.studentscoursesPrimarykey.classIdCourse=:classID and s.studentscoursesPrimarykey.subjectIdCourse=:subjectID";
                Query q1=session.createQuery(hql1);
                q1.setParameter("Year",year);
                q1.setParameter("Name",name);
                q1.setParameter("classID",classID);
                q1.setParameter("subjectID",subjectID);
                q1.executeUpdate();
                String hql2="delete from Courses as c where c.coursePK.semesterYear=:Year and c.coursePK.semesterName=:name and c.coursePK.subjectId=:subjectID and c.coursePK.classId=:classID";
                Query q2=session.createQuery(hql2);
                q2.setParameter("Year",year);
                q2.setParameter("name",name);
                q2.setParameter("subjectID",subjectID);
                q2.setParameter("classID",classID);
                q2.executeUpdate();
                transaction.commit();
                check=true;
            }
            catch (Exception e)
            {
                System.out.println("Exception in CoursesDAO delete method: "+e.getMessage());
            }
            finally {
                if(session!=null)
                    session.close();
            }
        }
        return check;
    }
}
