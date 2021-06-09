package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pojo.Courses;
import pojo.Studentscourses;
import pojo.Subjects;
import util.HibernateUtil;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

public class SubjectsDAO {
    public static Subjects GetSubject(String SubjectId) {
        Subjects subjects = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            subjects = (Subjects) session.get(Subjects.class, SubjectId);
        } catch (Exception e) {
            subjects = null;
        } finally {
            if (session != null)
                session.close();
        }
        return subjects;
    }

    public static List<Subjects> GetListSubjects() {
        List<Subjects> ListSubjects = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from Subjects";
            Query q = session.createQuery(hql);
            ListSubjects = q.list();
        } catch (Exception exception) {
            ListSubjects = null;
        } finally {
            if (session != null)
                session.close();
        }
        return ListSubjects;
    }

    public static boolean AddSubject(Subjects subjects) {
        boolean check = false;
        Subjects monhoc = SubjectsDAO.GetSubject(subjects.getSubjectId());
        if (monhoc == null) {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                session.save(subjects);
                transaction.commit();
                check = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                check = false;
            } finally {
                if (session != null)
                    session.close();
            }
        } else
            check = false;
        return check;
    }

    public static boolean DeleteSubject(String subjectID) {
        boolean checkDelete = false;
        Subjects sb = SubjectsDAO.GetSubject(subjectID);
        if (sb == null)
            checkDelete = false;
        else {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = null;
            try {
                transaction=session.beginTransaction();
                session.delete(sb);
                transaction.commit();
                checkDelete=true;
            } catch (Exception e) {
                System.out.println("Exc in SubjectDAO: "+ e.toString());
                checkDelete = false;
            } finally {
                if (session != null)
                    session.close();
            }
        }
        return checkDelete;
    }

    public static Subjects GetListCoursesOfSubjects(String maMonHoc) {
        Subjects monhoc = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql1 = "from Subjects as s where s.subjectId=:maMonhoc ";
            Query q = session.createQuery(hql1);
            q.setParameter("maMonhoc", maMonHoc);
            monhoc = (Subjects) q.uniqueResult();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        } finally {
            if (session != null)
                session.close();
        }
        return monhoc;
    }

    public static boolean UpdateInformationSubject(String SubjectID, String newNameSubject, Integer CreditNum)
    {
        boolean checkUpdate = false;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Subjects monhoc = SubjectsDAO.GetSubject(SubjectID);
        Transaction transaction = null;
        if (monhoc == null) {
            checkUpdate = false;
        } else {
            transaction = session.beginTransaction();
            if (newNameSubject.equals("") == false)
                monhoc.setSubjectName(newNameSubject);
            if (CreditNum != 0)
                monhoc.setCreditNumber(CreditNum);
            session.saveOrUpdate(monhoc);
            transaction.commit();
            checkUpdate = true;
        }
        return checkUpdate;
    }
}
