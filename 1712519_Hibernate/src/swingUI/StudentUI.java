package swingUI;

import dao.AccountsDAO;
import dao.CoursesDAO;
import dao.StudentsCoursesDAO;
import dao.StudentsDAO;
import pojo.Accounts;
import pojo.Courses;
import pojo.Studentscourses;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

public class StudentUI extends JFrame {
    //----------------------------------------------------------------------------------------
    public static final String ACTION_COMMAND = "Student";
    //----------------------------------------------------------------------------------------
    private Accounts account;
    //----------------------------------------------------------------------------------------
    private JButton jbtInformation=null;
    private JButton jbtChangeInformation=null;
    private JButton jbtChangePassword=null;
    private JButton jbtLogout=null;
    private  JButton jbtRegistratedResult=null;
    private JButton jbtRegistrationCourse=null;
    private JButton jbtResetpassword=null;

    private JPanel LeftPanel=null;
    private JPanel RightPanel=null;

    public StudentUI(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(275,90);
        this.setPreferredSize(new Dimension(1000,500));
        this.setTitle("Student");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(false);
        initComponents();
        initEvents();
    }

    private void initComponents()
    {
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new BorderLayout());

        jbtInformation=new JButton("Information");
        jbtChangeInformation=new JButton("Change information account");
        jbtChangePassword=new JButton("Change password");
        jbtLogout=new JButton("Log out");
        jbtRegistrationCourse=new JButton("Registrated course");
        jbtRegistratedResult=new JButton("Registrated result");
        jbtResetpassword=new JButton("Reset password");

        LeftPanel = new JPanel();
        LeftPanel.setLayout(new GridLayout(0, 1));

        LeftPanel.add(jbtInformation);
        LeftPanel.add(jbtRegistrationCourse);
        LeftPanel.add(jbtRegistratedResult);
        LeftPanel.add(jbtChangeInformation);
        LeftPanel.add(jbtChangePassword);
        LeftPanel.add(jbtResetpassword);
        LeftPanel.add(jbtLogout);

        RightPanel = new JPanel();
        RightPanel.setLayout(new BoxLayout(RightPanel, BoxLayout.Y_AXIS));

        contentPane.add(LeftPanel, BorderLayout.LINE_START);
        contentPane.add(RightPanel, BorderLayout.CENTER);

    }

    private void initEvents() {
        jbtInformation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //----------------------------------------------------------------------------------------
                RightPanel.removeAll();
                RightPanel.revalidate();
                RightPanel.repaint();
                //----------------------------------------------------------------------------------------
                Accounts acc= AccountsDAO.GetAccount(account.getUserName());
                String username=acc.getUserName();
                String password=acc.getPass();
                String studentID=acc.getStudent().getStudentsPK().getStudentId();
                String classID=acc.getStudent().getStudentsPK().getClassId();
                String studentName=acc.getStudent().getStudentName();
                String gender=acc.getStudent().getGender();
                String [][]data={
                        {username,password,studentID,classID,studentName,gender}
                };
                String[]columnName={"Username","Password","StudentId","ClassId","FullName","Gender"};
                JTable jtbStudent=new JTable(data,columnName);
                JScrollPane jScrollPane=new JScrollPane(jtbStudent);
                RightPanel.add(jScrollPane);
            }
        });
        jbtChangeInformation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //----------------------------------------------------------------------------------------
                RightPanel.removeAll();
                RightPanel.revalidate();
                RightPanel.repaint();
                //----------------------------------------------------------------------------------------
                RightPanel.add(new JPanel());
                String newName = JOptionPane.showInputDialog(RightPanel,"Input new full name:","Change full name",JOptionPane.WARNING_MESSAGE);
                if(newName != null && newName.isEmpty() == false) {
                    Accounts ac=AccountsDAO.GetAccount(account.getUserName());
                    boolean b= AccountsDAO.UpdateInformation(account.getUserName(),newName);
                    if(b) {
                        JOptionPane.showMessageDialog(RightPanel, "Update information successfully!");
                    } else {
                        JOptionPane.showMessageDialog(RightPanel, "Update failed");
                    }
                }
            }
        });
        jbtChangePassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //----------------------------------------------------------------------------------------
                RightPanel.removeAll();
                RightPanel.revalidate();
                RightPanel.revalidate();
                //----------------------------------------------------------------------------------------
                RightPanel.add(new JPanel());
                String newPass = JOptionPane.showInputDialog(RightPanel,"Input new password:","Change password",JOptionPane.WARNING_MESSAGE);
                if(newPass != null && newPass.isEmpty() == false) {
                    boolean b= AccountsDAO.UpdatePassword(account.getUserName(),newPass);
                    if(b) {
                        JOptionPane.showMessageDialog(RightPanel, "Change password successfully!");
                    } else {
                        JOptionPane.showMessageDialog(RightPanel, "Change password failed");
                    }
                }
            }
        });
        jbtRegistrationCourse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RightPanel.removeAll();
                RightPanel.revalidate();
                RightPanel.revalidate();

                Vector headers=new Vector();
                headers.add("STT");
                headers.add("Year");
                headers.add("Name");
                headers.add("SubjectID");
                headers.add("SubjectName");
                headers.add("ClassID");
                headers.add("TheoryName");
                headers.add("Dayofweek");
                headers.add("Shift");
                headers.add("Room");

                List<Courses> danhsachKhoaHoc= CoursesDAO.GetCurrentSemesterCourse();
                Vector datas=new Vector();
                Integer i=0;
                for(Courses c:danhsachKhoaHoc)
                {
                    Vector line=new Vector();
                    line.add(i.toString());
                    line.add(c.getSemesterYearCourse());
                    line.add(c.getSemesterNameCourse());
                    line.add(c.getSubjectIdCourse());
                    line.add(c.getSubject().getSubjectName());
                    line.add(c.getClassIdCourse());
                    line.add(c.getTheoryTeacher());
                    line.add(c.getDayOfWeek());
                    line.add(c.getShift());
                    line.add(c.getShift());
                    line.add(c.getRoom());
                    datas.add(line);
                    i++;
                }
                JTable jTable=new JTable(new DefaultTableModel(datas,headers));
                JScrollPane jScrollPane=new JScrollPane(jTable);
                RightPanel.add(jScrollPane);
                String stt=JOptionPane.showInputDialog(RightPanel,"Input stt to registrated course: ","Registration Courses",JOptionPane.WARNING_MESSAGE);
                Integer value=Integer.parseInt(stt);
                if(value>=0&&value<danhsachKhoaHoc.size())
                {
                    Courses khoahoc=danhsachKhoaHoc.get(value);
                    Studentscourses svkh=new Studentscourses(account.getStudent(),khoahoc);
                    int b= StudentsCoursesDAO.ToRegistrationCourse(account.getStudent(),khoahoc);
                    if(b==1)
                    {
                        JOptionPane.showMessageDialog(RightPanel,"Registration successfully");
                    }
                    else
                        JOptionPane.showMessageDialog(RightPanel, "Registration failed");
                }
                else
                    JOptionPane.showMessageDialog(RightPanel,"Invalid input");
            }
        });
        jbtRegistratedResult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RightPanel.removeAll();
                RightPanel.revalidate();
                RightPanel.repaint();
                List<Studentscourses> dsdk= StudentsDAO.GetCoursesRegistrated(account.getStudent().getStudentsPK().getStudentId());
                Vector headers=new Vector();
                Integer i=0;
                headers.add("STT");
                headers.add("MSSV");
                headers.add("NAME");
                headers.add("CourseName");
                headers.add("DayofWeek");
                Vector datas=new Vector();
                for(Studentscourses s:dsdk)
                {
                    Vector line=new Vector();
                    line.add(i.toString());
                    line.add(s.getStudent().getStudentsPK().getStudentId());
                    line.add(s.getStudent().getStudentName());
                    line.add(s.getCourse().getSubject().getSubjectName());
                    line.add(s.getCourse().getDayOfWeek());
                    datas.add(line);
                    i++;
                }
                JTable jTable=new JTable(new DefaultTableModel(datas,headers));
                JScrollPane jScrollPane=new JScrollPane(jTable);
                RightPanel.add(jScrollPane);
            }
        });
        jbtResetpassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RightPanel.removeAll();
                RightPanel.revalidate();
                RightPanel.repaint();
                boolean b=StudentsDAO.ResetPasswordStudent(account.getStudent().getStudentsPK().getStudentId());
                if(b)
                {
                    JOptionPane.showMessageDialog(RightPanel,"Reset Okey");
                }
                else {
                    JOptionPane.showMessageDialog(RightPanel,"Reset failed");
                }
            }
        });
    }
    public void addLogoutListener(ActionListener listener) {
        jbtLogout.addActionListener(listener);
        jbtLogout.setActionCommand(ACTION_COMMAND);
    }

    public void setCurrentStudent(Accounts acc)
    {
        this.account=acc;
    }
    public Accounts getCurrentStudent()
    {
        return this.account;
    }
    public void  ShowGUI(boolean value)
    {
        this.pack();
        this.setVisible(value);
    }

}
