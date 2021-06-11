package swingUI;

import dao.*;
import pojo.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Set;
import java.util.Vector;

public class TeachermanagerGUI extends JFrame {
    public static final String ACTION_COMMAND = "Teachermanager";

    private Accounts currentAccount;

    private JButton jbtInformation=null;
    private JButton jbtListAccountManager=null;
    private JButton jbtChangeInformation=null;
    private JButton jbtChangePassword=null;
    private JButton jbtLogout=null;
    private JButton jbtDeleteAccount=null;
    private JButton jbtSearchAccount=null;
    private JButton jbtAddAccount=null;
    private JButton jbtResetPassword=null;
    private JButton jbtListSubjects=null;
    private JButton jbtAddSubject=null;
    private JButton jbtDeletesubject=null;
    private JButton jbtSearchSubject=null;
    private JButton jbtListSemesterRegistrated=null;
    private JButton jbtCreateSemester=null;
    private  JButton jbtCreateCourse=null;
    private JButton jbtDeleteCourse=null;
    private  JButton jbtUpdateInformationSubject=null;

    private  JButton jbtListClasses=null;
    private  JButton jbtAddClass=null;
    private JButton jbtDeleteClass=null;

    private JButton jbtListStudents=null;

    private JPanel LeftPanel=null;
    private JPanel RightPanel=null;


    public TeachermanagerGUI() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(375,100);
        this.setPreferredSize(new Dimension(800,500));
        this.setTitle("Teachermanager");
        initComponents();
        initEvents();
    }

    private void initComponents() {
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new BorderLayout());

        LeftPanel = new JPanel();
        LeftPanel.setLayout(new GridLayout(0, 1));

        jbtInformation=new JButton("Information teachermanager");
        jbtListAccountManager=new JButton("List teachermanager");
        jbtUpdateInformationSubject=new JButton("Update credit subject");
        jbtAddAccount =new JButton("Add new account");
        jbtSearchAccount=new JButton("Search account");
        jbtChangeInformation=new JButton("Change information");
        jbtListSubjects=new JButton("List subjects");
        jbtAddSubject=new JButton("Insert subject");
        jbtDeletesubject=new JButton("Delete subject");
        jbtSearchSubject=new JButton("Search subject");
        jbtListSemesterRegistrated=new JButton("List semester registration ");
        jbtCreateSemester=new JButton("Create semester to registration");
        jbtCreateCourse=new JButton("Add course");
        jbtDeleteCourse=new JButton("Delete course");
        jbtDeleteAccount=new JButton("Delete account");
        jbtResetPassword=new JButton("Reset password ");
        jbtChangePassword = new JButton("Change password");
        jbtLogout = new JButton("Log out");
        jbtListClasses=new JButton("List Classes");
        jbtAddClass =new JButton("Add new class");
        jbtListStudents=new JButton("List students at class");


        LeftPanel.add(jbtInformation);
        LeftPanel.add(jbtListAccountManager);
        LeftPanel.add(jbtAddAccount);
        LeftPanel.add(jbtSearchAccount);
        LeftPanel.add(jbtDeleteAccount);

        LeftPanel.add(jbtListSubjects);
        LeftPanel.add(jbtAddSubject);
        LeftPanel.add(jbtSearchSubject);
        LeftPanel.add(jbtDeletesubject);
        LeftPanel.add(jbtUpdateInformationSubject);

        LeftPanel.add(jbtListSemesterRegistrated);
        LeftPanel.add(jbtCreateSemester);
        LeftPanel.add(jbtCreateCourse);
        LeftPanel.add(jbtDeleteCourse);
        LeftPanel.add(jbtChangeInformation);

        LeftPanel.add(jbtListClasses);
        LeftPanel.add(jbtAddClass);
        LeftPanel.add(jbtListStudents);


        LeftPanel.add(jbtResetPassword);
        LeftPanel.add(jbtChangePassword);
        LeftPanel.add(jbtLogout);

        RightPanel = new JPanel();
        RightPanel.setLayout(new BoxLayout(RightPanel, BoxLayout.Y_AXIS));

        contentPane.add(LeftPanel, BorderLayout.LINE_START);
        contentPane.add(RightPanel, BorderLayout.CENTER);
    }
    private void initEvents() {
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
                    Accounts ac=AccountsDAO.GetAccount(currentAccount.getUserName());
                    boolean b= AccountsDAO.UpdateInformation(currentAccount.getUserName(),newName);
                    if(b) {
                        JOptionPane.showMessageDialog(RightPanel, "Update information successfully!");
                    } else {
                        JOptionPane.showMessageDialog(RightPanel, "Update failed");
                    }
                }
            }
        });
        jbtInformation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //----------------------------------------------------------------------------------------
                RightPanel.removeAll();
                RightPanel.revalidate();
                RightPanel.repaint();
                //----------------------------------------------------------------------------------------
                JPanel newPanel=new JPanel();
                JTable jtbInfo=null;

                String username=currentAccount.getUserName();
                Accounts acc=AccountsDAO.GetAccount(username);
                currentAccount=acc;
                String password=acc.getPass();
                String hoten=currentAccount.getTeachermanager().getTeacherManagerName();
                String data[][]={
                        {username,password,hoten}
                };
                String columnName[]={"Username","Password","Fullname"};
                jtbInfo=new JTable(data,columnName);
                JScrollPane jScrollPane=new JScrollPane(jtbInfo);
                newPanel.add(jScrollPane);

                RightPanel.add(newPanel);
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
                    boolean b= AccountsDAO.UpdatePassword(currentAccount.getUserName(),newPass);
                    if(b) {
                        JOptionPane.showMessageDialog(RightPanel, "Change password successfully!");
                    } else {
                        JOptionPane.showMessageDialog(RightPanel, "Change password failed");
                    }
                }
            }
        });
        jbtListAccountManager.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //-------------------------------------------------------------------------------------
                RightPanel.removeAll();
                RightPanel.revalidate();
                RightPanel.repaint();
                //-------------------------------------------------------------------------------------
                List<Accounts> danhsachTK=AccountsDAO.GetTeachermanagerAccount();
                Vector header=new Vector();
                header.add("Username");
                header.add("Password");
                header.add("Fullname");
                Vector datas=new Vector();
                for(Accounts a:danhsachTK)
                {
                    Vector dataLine=new Vector();
                    dataLine.add(a.getUserName());
                    dataLine.add(a.getPass());
                    dataLine.add(a.getTeachermanager().getTeacherManagerName());
                    datas.add(dataLine);
                }
                JTable tables=new JTable(new DefaultTableModel(datas,header));
                JScrollPane jScrollPane=new JScrollPane(tables);
                RightPanel.add(jScrollPane);

            }
        });
        jbtSearchAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //-------------------------------------------------------------------------------------
                RightPanel.removeAll();
                RightPanel.revalidate();
                RightPanel.repaint();
                //-------------------------------------------------------------------------------------
                RightPanel.add(new JPanel());
                JTable jTable=null;
                String username = JOptionPane.showInputDialog(RightPanel,"Input username:","Search acocunt",JOptionPane.WARNING_MESSAGE);
                if(username != null && username.isEmpty() == false) {
                    Accounts taikhoan= AccountsDAO.GetAccount(username);
                    if(taikhoan!=null) {
                        String[]columnsName={"Username","Password","Fullname"};
                        String[][] datas={
                                {taikhoan.getUserName(),taikhoan.getPass(),taikhoan.getTeachermanager().getTeacherManagerName()}
                        };
                        jTable=new JTable(datas,columnsName);
                        JScrollPane jScrollPane=new JScrollPane(jTable);
                        RightPanel.removeAll();
                        RightPanel.revalidate();
                        RightPanel.repaint();
                        RightPanel.add(jScrollPane);
                    } else {
                        JOptionPane.showMessageDialog(RightPanel, "Account is not existing");
                    }
                }
            }
        });
        jbtAddAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //-------------------------------------------------------------------------------------
                RightPanel.removeAll();
                RightPanel.revalidate();
                RightPanel.repaint();
                //-------------------------------------------------------------------------------------
                RightPanel.add(new JPanel());
                JTable jTable=null;
                String username = JOptionPane.showInputDialog(RightPanel,"Input new username:","Insert new account",JOptionPane.WARNING_MESSAGE);
                if(username != null && username.isEmpty() == false) {
                    boolean b=AccountsDAO.AddTeacherManagerAccount(username);
                    if(b) {
                        JOptionPane.showMessageDialog(RightPanel, "Insert successfully");
                    } else {
                        JOptionPane.showMessageDialog(RightPanel, "Insert failed");
                    }
                }
            }
        });
        jbtResetPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //-------------------------------------------------------------------------------------
                RightPanel.removeAll();
                RightPanel.revalidate();
                RightPanel.repaint();
                //-------------------------------------------------------------------------------------
                RightPanel.add(new JPanel());
                String username=currentAccount.getUserName();
                boolean b=AccountsDAO.ResetPassword(username);
                if(b) {
                        JOptionPane.showMessageDialog(RightPanel, "Reset password successfully");
                }
                else {
                        JOptionPane.showMessageDialog(RightPanel, "Reset failed");
                }
            }
        });
        jbtDeleteAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //----------------------------------------------------------------------------------------
                RightPanel.removeAll();
                RightPanel.revalidate();
                RightPanel.revalidate();
                //----------------------------------------------------------------------------------------
                RightPanel.add(new JPanel());
                String username = JOptionPane.showInputDialog(RightPanel,"Input username to delete:","Delete account",JOptionPane.WARNING_MESSAGE);
                if(username != null && username.isEmpty() == false) {
                    boolean b= AccountsDAO.DeleteAccount(username);
                    if(b) {
                        JOptionPane.showMessageDialog(RightPanel, "Deleted successfully!");
                    } else {
                        JOptionPane.showMessageDialog(RightPanel, "Deleted failed");
                    }
                }
            }

        });
        jbtListSubjects.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //-------------------------------------------------------------------------------------
                RightPanel.removeAll();
                RightPanel.revalidate();
                RightPanel.repaint();
                //-------------------------------------------------------------------------------------
                Vector headers=new Vector();
                headers.add("SubjectID");
                headers.add("SubjectName");
                headers.add("Credits number");
                Vector datas=new Vector();
                List<Subjects> danhsachMonhoc= SubjectsDAO.GetListSubjects();
                for(Subjects s:danhsachMonhoc)
                {
                    Vector lineData=new Vector();
                    lineData.add(s.getSubjectId());
                    lineData.add(s.getSubjectName());
                    lineData.add(s.getCreditNumber());
                    datas.add(lineData);
                }
                JTable jTable=new JTable(new DefaultTableModel(datas,headers));
                JScrollPane jScrollPane=new JScrollPane(jTable);
                RightPanel.add(jScrollPane);
            }
        });
        jbtSearchSubject.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //----------------------------------------------------------------------------------------
                RightPanel.removeAll();
                RightPanel.revalidate();
                RightPanel.revalidate();
                //----------------------------------------------------------------------------------------
                RightPanel.add(new JPanel());
                String subjectID = JOptionPane.showInputDialog(RightPanel,"Input subjectID:","Search Subject",JOptionPane.WARNING_MESSAGE);
                if(subjectID != null && subjectID.isEmpty() == false) {
                    Subjects sb=SubjectsDAO.GetSubject(subjectID);
                    if(sb!=null) {
                        RightPanel.removeAll();
                        RightPanel.revalidate();
                        RightPanel.repaint();
                        String[]headers={"SubjectID","SubjectName","Credit number"};
                        String [][]data={
                                {sb.getSubjectId(),sb.getSubjectName(),sb.getCreditNumber().toString()}
                        };
                        JTable jTable=new JTable(data,headers);
                        JScrollPane jScrollPane=new JScrollPane(jTable);
                        RightPanel.add(jScrollPane);
                    } else {
                        JOptionPane.showMessageDialog(RightPanel, "Subject does not exist");
                    }
                }
            }

        });
        jbtAddSubject.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RightPanel.removeAll();
                RightPanel.revalidate();
                RightPanel.revalidate();
                //----------------------------------------------------------------------------------------
                JPanel panel = new JPanel();
                panel.setLayout(new GridLayout(4,2));

                JLabel jl4 = new JLabel("SubjectID:");
                JTextField jtf3 = new JTextField(20);
                panel.add(jl4);
                panel.add(jtf3);

                JLabel jl5 = new JLabel("SubjectName:");
                JTextField jtf4 = new JTextField(20);
                panel.add(jl5);
                panel.add(jtf4);

                JLabel jl6 = new JLabel("Creditnumber:");
                JTextField jtf6 = new JTextField(20);
                panel.add(jl6);
                panel.add(jtf6);

                JButton jbtinsert = new JButton("Insert");
                panel.add(jbtinsert);

                RightPanel.add(panel);

                jbtinsert.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String id=jtf3.getText();
                        String name=jtf4.getText();
                        Integer credit=Integer.parseInt(jtf6.getText());
                        Subjects subjects=new Subjects(id,name,credit);
                        boolean b=SubjectsDAO.AddSubject(subjects);
                        if(b)
                        {
                            JOptionPane.showMessageDialog(RightPanel, "Insert successfully");
                        }
                        else {
                            JOptionPane.showMessageDialog(RightPanel, "Insert failed");
                        }
                    }
                });

            }
        });
        jbtDeletesubject.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //----------------------------------------------------------------------------------------
                RightPanel.removeAll();
                RightPanel.revalidate();
                RightPanel.revalidate();
                //----------------------------------------------------------------------------------------
                RightPanel.add(new JPanel());
                String subjectid = JOptionPane.showInputDialog(RightPanel,"Input subjectID:","Delete subject",JOptionPane.WARNING_MESSAGE);
                if(subjectid != null && subjectid.isEmpty() == false) {
                    boolean b= SubjectsDAO.DeleteSubject(subjectid);
                    if(b) {
                        JOptionPane.showMessageDialog(RightPanel, "Deleted successfully!");
                    } else {
                            JOptionPane.showMessageDialog(RightPanel, "Deleted failed");
                    }
                }

            }
        });
        jbtListSemesterRegistrated.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RightPanel.removeAll();
                RightPanel.revalidate();
                RightPanel.repaint();
                List<Semesters> danhsachHocki= SemestersDAO.GetListSemesters();
                Vector headers=new Vector();
                headers.add("SemesterYear");
                headers.add("SemesterName");
                headers.add("Daybegin");
                headers.add("Dayend");
                headers.add("CurrentSemester");
                Vector datas=new Vector();
                for(Semesters s:danhsachHocki)
                {
                    Vector line=new Vector();
                    line.add(s.getSemestersPrimarykey().getSemesterYear());
                    line.add(s.getSemestersPrimarykey().getSemesterName());
                    line.add(s.getDayBegin());
                    line.add(s.getDayEnd());
                    line.add(s.getCurrentSemester());
                    datas.add(line);
                }
                JTable table=new JTable(new DefaultTableModel(datas,headers));
                JScrollPane jScrollPane=new JScrollPane(table);
                RightPanel.add(jScrollPane);
            }
        });
        jbtCreateSemester.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RightPanel.removeAll();
                RightPanel.revalidate();
                RightPanel.revalidate();
                //----------------------------------------------------------------------------------------
                JPanel panel=new JPanel(new GridLayout(5,2));
                JLabel jLabel1=new JLabel("Year");
                JTextField jtf1=new JTextField(20);
                panel.add(jLabel1);
                panel.add(jtf1);

                JLabel jLabel2=new JLabel("NameSemester");
                JTextField jTextField2=new JTextField(20);
                panel.add(jLabel2);
                panel.add(jTextField2);

                JLabel jLabel3=new JLabel("Daybegin");
                JTextField jTextField3=new JTextField(20);
                panel.add(jLabel3);
                panel.add(jTextField3);

                JLabel jLabel4=new JLabel("Dayend");
                JTextField jTextField4=new JTextField(20);
                panel.add(jLabel4);
                panel.add(jTextField4);

                JButton insert=new JButton("INSERT");
                panel.add(insert);
                RightPanel.add(panel);
                insert.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String year=jtf1.getText() ;
                        String name=jTextField2.getText();
                        String daybeign=jTextField3.getText();
                        String dayend=jTextField4.getText();
                        Semesters hk=new Semesters(year,name,daybeign,dayend,"1");
                        boolean b=SemestersDAO.AddSemester(hk);
                        if(b)
                        {
                            JOptionPane.showMessageDialog(RightPanel, "Creating successfully");
                        }
                        else {
                            JOptionPane.showMessageDialog(RightPanel, "Creating failed");
                        }
                    }
                });

            }
        });
        jbtCreateCourse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RightPanel.removeAll();
                RightPanel.revalidate();
                RightPanel.revalidate();
                //----------------------------------------------------------------------------------------
                JPanel panel=new JPanel(new GridLayout(8,2));
                JLabel jLabel1=new JLabel("SubjectID");
                JTextField jTextField1=new JTextField(20);
                panel.add(jLabel1);
                panel.add(jTextField1);

                JLabel jLabel2=new JLabel("ClassID");
                JTextField jTextField2=new JTextField(20);
                panel.add(jLabel2);
                panel.add(jTextField2);

                JLabel jLabel3=new JLabel("TheoryNameTeacher");
                JTextField jTextField3=new JTextField(20);
                panel.add(jLabel3);
                panel.add(jTextField3);

                JLabel jLabel4=new JLabel("DayOfWeek");
                JTextField jTextField4=new JTextField(20);
                panel.add(jLabel4);
                panel.add(jTextField4);

                JLabel jLabel5=new JLabel("Shift");
                JTextField jTextField5=new JTextField(20);
                panel.add(jLabel5);
                panel.add(jTextField5);

                JLabel jLabel6=new JLabel("Maxslot");
                JTextField jTextField6=new JTextField(20);
                panel.add(jLabel6);
                panel.add(jTextField6);

                JLabel jLabel7=new JLabel("Room");
                JTextField jTextField7=new JTextField(20);
                panel.add(jLabel7);
                panel.add(jTextField7);

                JButton insert=new JButton("INSERT");
                panel.add(insert);
                RightPanel.add(panel);

                insert.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String subjectID=jTextField1.getText();
                        String classID=jTextField2.getText();
                        String name=jTextField3.getText();
                        String day=jTextField4.getText();
                        Integer shift=Integer.parseInt(jTextField5.getText());
                        Integer maxslot=Integer.parseInt(jTextField6.getText());
                        String room=jTextField7.getText();

                        boolean b= CoursesDAO.AddCourseForCurrentSemester(subjectID,classID,name,day,shift,maxslot,room);
                        if(b)
                        {
                            JOptionPane.showMessageDialog(RightPanel, "Creating successfully");
                        }
                        else {
                            JOptionPane.showMessageDialog(RightPanel, "Creating failed");
                        }


                    }
                });
            }
        });
        jbtDeleteCourse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RightPanel.removeAll();
                RightPanel.revalidate();
                RightPanel.repaint();

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

                List<Courses> danhsachKhoaHoc=CoursesDAO.GetListCourses();
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

                String stt = JOptionPane.showInputDialog(RightPanel,"Input STT course to delete","Delete course",JOptionPane.WARNING_MESSAGE);
                Integer value=Integer.parseInt(stt);
                if(value>=0&&value<=danhsachKhoaHoc.size())
                {
                    Courses kh=danhsachKhoaHoc.get(value);
                    boolean b=CoursesDAO.DeleteCourse(kh);
                    if(b){
                        JOptionPane.showMessageDialog(RightPanel, "Deleted successfully");
                        RightPanel.removeAll();
                        RightPanel.revalidate();
                        RightPanel.repaint();
                        Vector header1=new Vector();
                        header1.add("STT");
                        header1.add("Year");
                        header1.add("Name");
                        header1.add("SubjectID");
                        header1.add("SubjectName");
                        header1.add("ClassID");
                        header1.add("TheoryName");
                        header1.add("Dayofweek");
                        header1.add("Shift");
                        header1.add("Room");
                        List<Courses> danhsachKhoaHocsau=CoursesDAO.GetListCourses();
                        Vector datass=new Vector();
                        Integer j=0;
                        for(Courses c:danhsachKhoaHocsau)
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
                            datass.add(line);
                            j++;
                        }
                        JTable jTable1=new JTable(new DefaultTableModel(datass,header1));
                        JScrollPane jScrollPane1=new JScrollPane(jTable1);
                        RightPanel.add(jScrollPane1);

                    }
                }
                else {
                    JOptionPane.showMessageDialog(RightPanel, "Deleted failed");
                }



            }
        });
        jbtUpdateInformationSubject.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //
                RightPanel.removeAll();
                RightPanel.revalidate();
                RightPanel.repaint();
                //
                JPanel jPanel1=new JPanel(new FlowLayout(FlowLayout.LEFT));
                JLabel jlb1=new JLabel("SubjectID: ");
                JTextField jtf1=new JTextField(15);
                jPanel1.add(jlb1);
                jPanel1.add(jtf1);

                JPanel jPanel2=new JPanel(new FlowLayout(FlowLayout.LEFT));
                JLabel jlb2=new JLabel("New credit number: ");
                JTextField jtf2=new JTextField(15);
                jPanel2.add(jlb2);
                jPanel2.add(jtf2);

                JButton jButton=new JButton("Update");
                JPanel jPanel3=new JPanel(new FlowLayout(FlowLayout.LEFT));
                jPanel3.add(jButton);

                JPanel jPanel4=new JPanel(new FlowLayout(FlowLayout.LEFT));
                jPanel4.add(jPanel1);
                jPanel4.add(jPanel2);
                jPanel4.add(jPanel3);

                RightPanel.add(jPanel4);

                jButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String subjectID=null;
                        int creditNumber=0;
                        boolean b=false;
                        try{
                            subjectID=jtf1.getText();
                            creditNumber= Integer.parseInt(jtf2.getText());
                            b=SubjectsDAO.UpdateCreditSubject(subjectID,creditNumber);
                        }
                        catch (Exception exc)
                        {
                            b=false;
                        }
                        if(b)
                        {
                            JOptionPane.showMessageDialog(RightPanel,"Update successfully");
                        }
                        else{
                            JOptionPane.showMessageDialog(RightPanel,"Update failed");
                        }
                    }
                });
            }
        });
        jbtListClasses.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RightPanel.removeAll();
                RightPanel.revalidate();
                RightPanel.repaint();
                //
                Vector headers  =new Vector();
                Integer i=0;
                headers.add("STT");
                headers.add("ClassID");
                headers.add("Sum");
                headers.add("Male");
                headers.add("Female");

                Vector datas=new Vector();
                List<Classes> danhsachLopHoc= ClassesDAO.GetListClasses();
                for(Classes s:danhsachLopHoc)
                {
                    Integer soluong[]=ClassesDAO.GetNumbers(s.getClassId());
                    Vector line=new Vector();
                    line.add(i.toString());
                    line.add(s.getClassId());
                    line.add(soluong[0].toString());
                    line.add(soluong[1].toString());
                    line.add(soluong[2].toString());
                    datas.add(line);
                }

                JTable jTable=new JTable(new DefaultTableModel(datas,headers));
                JScrollPane jScrollPane=new JScrollPane(jTable);
                RightPanel.add(jScrollPane);
            }
        });
        jbtAddClass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RightPanel.removeAll();
                RightPanel.revalidate();
                RightPanel.repaint();

                String id=JOptionPane.showInputDialog(RightPanel,"Input new classID","Add new class",JOptionPane.WARNING_MESSAGE);
                boolean b=false;
                try{
                    b=ClassesDAO.AddClass(id);
                }
                catch (Exception exception)
                {
                    b=false;
                }
                if(b)
                {
                    JOptionPane.showMessageDialog(RightPanel,"Insert okey");
                }
                else
                    JOptionPane.showMessageDialog(RightPanel,"Insert failed");
            }
        });
        jbtListStudents.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JTable jTable=null;
                JScrollPane jScrollPane=null;
                String classID=JOptionPane.showInputDialog(RightPanel,"Input classID to see students","List students",JOptionPane.WARNING_MESSAGE);
                Classes b=ClassesDAO.GetClass(classID);
                Vector headers=new Vector();
                headers.add("StudentID");
                headers.add("ClassID");
                headers.add("Fullname");
                Vector datass=new Vector();
                if(b!=null)
                {
                    Set<Students> danhsachHS=b.getStudents();
                    for(Students s:danhsachHS)
                    {
                        Vector line=new Vector();
                        line.add(s.getStudentsPK().getStudentId());
                        line.add(b.getClassId());
                        line.add(s.getStudentName());
                        datass.add(line);
                    }

                    RightPanel.removeAll();
                    RightPanel.revalidate();
                    RightPanel.repaint();
                    jTable=new JTable(new DefaultTableModel(datass,headers));
                    jScrollPane=new JScrollPane(jTable);
                    RightPanel.add(jScrollPane);
                }
                else
                    JOptionPane.showMessageDialog(RightPanel,"Class does not exist");

            }
        });
    }
    public void addLogoutListener(ActionListener listener)
    {
        jbtLogout.addActionListener(listener);
        jbtLogout.setActionCommand(ACTION_COMMAND);
    }
    //----------------------------------------------
    public void setCurrentAccount(Accounts acc)
    {
        this.currentAccount=acc;
    }
    public Accounts getCurrentAccount()
    {
        return this.currentAccount;
    }
    public void ShowGUI(boolean value)
    {
        this.pack();
        this.setVisible(value);
    }
    //-------------------------------------------------
}
