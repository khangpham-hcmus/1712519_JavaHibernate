package swingUI;

import dao.AccountsDAO;
import pojo.Accounts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JButton jbtRegistrationCourse=null;

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
        jbtRegistrationCourse=new JButton("Registrate course");

        LeftPanel = new JPanel();
        LeftPanel.setLayout(new GridLayout(0, 1));

        LeftPanel.add(jbtInformation);
        LeftPanel.add(jbtRegistrationCourse);
        LeftPanel.add(jbtChangeInformation);
        LeftPanel.add(jbtChangePassword);
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
    public void ShowGUI(boolean value)
    {
        this.pack();
        this.setVisible(value);
    }

}
