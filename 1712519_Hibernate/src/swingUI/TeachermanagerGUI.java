package swingUI;

import dao.AccountsDAO;
import pojo.Accounts;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class TeachermanagerGUI extends JFrame {
    public static final String ACTION_COMMAND = "Teachermanager";

    private Accounts currentAccount;

    private JButton jbtInformation=null;
    private JButton jbtListAccountManager=null;
    private JButton jbtChangeInformation=null;
    private JButton jbtChangePassword=null;
    private JButton jbtLogout=null;
    private JButton jbtSearchAccount=null;
    private JButton jbtAddAccount=null;
    private JButton jbtResetPassword=null;

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

        jbtInformation=new JButton("Information account");
        jbtListAccountManager=new JButton("List teacherManager");
        jbtAddAccount =new JButton("Add new account");
        jbtSearchAccount=new JButton("Search account");
        jbtChangeInformation=new JButton("Change information");
        jbtResetPassword=new JButton("Reset password");
        jbtChangePassword = new JButton("Change password");
        jbtLogout = new JButton("Log out");

        LeftPanel.add(jbtInformation);
        LeftPanel.add(jbtListAccountManager);
        LeftPanel.add(jbtAddAccount);
        LeftPanel.add(jbtSearchAccount);
        LeftPanel.add(jbtChangeInformation);
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
