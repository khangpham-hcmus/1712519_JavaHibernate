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
    public static List<Subjects> GetListSubjects()
    {
       List<Subjects> ListSubjects=null;
       Session session=HibernateUtil.getSessionFactory().openSession();
       try{
           String hql="from Subjects as sb";
           Query q= session.createQuery(hql);
           ListSubjects=q.list();
       }
       catch (Exception e) {
           ListSubjects=null;
       }
       finally {
           if(session!=null)
               session.close();
       }
       return ListSubjects;
    }
    public static Subjects GetSubject(String SubjectId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        Subjects monhoc=null;
        try {
            transaction=session.beginTransaction();
            monhoc=session.load(Subjects.class,SubjectId);
            Hibernate.initialize(SubjectId);
            transaction.commit();


        } catch (Exception exception)
        {
            System.out.println(exception.getMessage());
            monhoc=null;
        }
        finally {
            if(session!=null)
                session.close();
        }
        return monhoc;
    }


}
