package dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import pojo.Subjects;
import util.HibernateUtil;

import java.util.List;
public class SubjectsDAO {
    public static List<Subjects> getAllSubjects(){
        List<Subjects> listAllSubjects=null;
        Session ss= HibernateUtil.getSessionFactory().openSession();;
        try{
            String hbl="select sb from Subjects as sb";
            Query q=ss.createQuery(hbl);
            listAllSubjects=q.list();

        }
        catch (Exception e){
            System.out.println("Exception in SubjectsDAO: "+e.getMessage());
        }
        return listAllSubjects;
    }
}
