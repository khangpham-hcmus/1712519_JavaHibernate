package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pojo.Classes;
import pojo.InformationOfClass;
import pojo.Students;
import util.HibernateUtil;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ClassesDAO {
    public static Classes GetClass(String ClassID)
    {
        Classes classes=null;
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=null;
        try{
            transaction=session.beginTransaction();
            classes=(Classes) session.get(Classes.class,ClassID);
            transaction.commit();
        }
        catch (Exception e)
        {
            System.out.println("Exc in ClassDAO: "+e.getMessage());
        }
        finally {
            if (session!=null)
                session.close();
        }
        return classes;
    }
    public static List<Classes> GetListClasses()
    {
        List<Classes> listAllClasses=null;
        Session ss= HibernateUtil.getSessionFactory().openSession();
        try{
            String hbl="from Classes";
            Query q=ss.createQuery(hbl);
            listAllClasses=q.list();
        }
        catch(Exception e){
            System.out.println("Exception in ClassesDAO: "+e.getMessage());
            listAllClasses=null;
        }
        finally {
            ss.close();
        }
        return listAllClasses;
    }
    public static boolean AddClass(String classID)
    {
        boolean checkAdd=false;
        Classes classes=ClassesDAO.GetClass(classID);
        if(classes==null)
        {
            Session session=HibernateUtil.getSessionFactory().openSession();
            Transaction transaction=null;
            try {
                transaction=session.beginTransaction();
                Classes lophoc=new Classes(classID);
                session.save(lophoc);
                transaction.commit();
                checkAdd=true;
            }
            catch (Exception exception)
            {
                checkAdd=false;
                System.out.println("Exc in ClassDAO: "+exception.getMessage());
            }
            finally {
                if(session!=null)
                    session.close();
            }
        }
        else
            checkAdd=false;
        return  checkAdd;
    }
    public static InformationOfClass GetInformationOfClass(String classID)
    {
        InformationOfClass thongtinLop=null;
        Classes lophoc=ClassesDAO.GetClass(classID);
        if(lophoc==null)
            thongtinLop=null;
        else
        {
            Integer TongHocSinh=0;
            Integer TongNam=0;
            Integer TongNu=0;
            try{
                Set<Students> studentsSet=lophoc.getStudents();
                TongHocSinh=studentsSet.size();
                Iterator<Students> studentsIterator=lophoc.getStudents().iterator();
                while(studentsIterator.hasNext())
                {
                    Students s= studentsIterator.next();
                    if(s.getGender().equals("Male"))
                        TongNam++;
                    else if(s.getGender().equals("Female"))
                        TongNu++;
                }
                thongtinLop=new InformationOfClass(classID,TongHocSinh,TongNam,TongNu);
            }
            catch (Exception e)
            {
                System.out.println("Exception in ClassesDAO getInformation class method: "+e.getMessage());
                thongtinLop=null;
            }
        }
        return thongtinLop;
    }
    public static Set<Students> GetListStudents(String classID)
    {
        Classes lophoc=ClassesDAO.GetClass(classID);
        if(lophoc==null)
            return null;
        else
            return lophoc.getStudents();
    }
    public static Students GetStudentInClass(String classId,String studentID)
    {
        Students hocsinh=null;
        Set<Students> ListStudents=ClassesDAO.GetListStudents(classId);
        if(ListStudents==null)
            return null;
        else
        {
            for(Students s:ListStudents)
            {
                if(s.getStudentsPK().getStudentId().equals(studentID))
                {
                    hocsinh=s;break;
                }
            }
            return hocsinh;
        }
    }
    public static Integer[] GetNumbers(String classid)
    {
        Integer datas[]=new Integer[3];
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=null;
        try{
            transaction=session.beginTransaction();
            Classes lophoc=session.get(Classes.class,classid);
            Set<Students> danhsachHocsinh=lophoc.getStudents();
            int tongSosinhvien=danhsachHocsinh.size();
            int tongnam=0;
            int tongnu=0;
            for(Students s:danhsachHocsinh)
            {
                if(s.getGender().equals("Male"))
                    tongnam++;
                else if(s.getGender().equals("Female")){
                    tongnu++;
                }
            }
            datas[0]=tongSosinhvien;
            datas[1]=tongnam;
            datas[2]=tongnu;
            transaction.commit();

        }
        catch (Exception exception)
        {
            System.out.println("Exception in ");
            datas[0]=-1;
            datas[1]=-1;
            datas[2]=-1;
        }
        finally {
            if(session!=null)
                session.close();
        }
        return datas;
    }

}
