package swingUI;

import dao.AccountsDAO;
import pojo.Accounts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeachermanagerGUI extends JFrame {
    public static final String ACTION_COMMAND = "Teachermanager";

    private Accounts currentAccount;

    private JButton jbtChangeInfomation=null;
    private JButton jbtInformation=null;
    private JButton jbtChangePassword=null;
    private JButton jbtLogout=null;

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

        jbtChangeInfomation=new JButton("Change information account");
        jbtInformation=new JButton("Information account");
        jbtChangePassword = new JButton("Change password");
        jbtLogout = new JButton("Log out");

        LeftPanel.add(jbtChangeInfomation);
        LeftPanel.add(jbtInformation);
        LeftPanel.add(jbtChangePassword);
        LeftPanel.add(jbtLogout);

        RightPanel = new JPanel();
        RightPanel.setLayout(new BoxLayout(RightPanel, BoxLayout.Y_AXIS));

        contentPane.add(LeftPanel, BorderLayout.LINE_START);
        contentPane.add(RightPanel, BorderLayout.CENTER);
    }

    private void initEvents() {
        jbtChangeInfomation.addActionListener(new ActionListener() {
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
    public void SetVisible(boolean value){
        this.pack();
        this.setVisible(value);
    }
    //-------------------------------------------------
}
