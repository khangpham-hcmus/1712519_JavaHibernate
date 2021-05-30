package swingUI;

import dao.AccountsDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;

public class LoginSystem implements ActionListener {
    //Attributes:-------------------------------------------------------
    //Username:
    JPanel jpnusername=null;
    JLabel jlbusername=null;
    JTextField jtfusername=null;
    //Password:
    JPanel jpnpassword=null;
    JLabel jlbpassword=null;
    JPasswordField jtfpassword=null;
    //For type of account:
    JPanel jpntype_=null;
    JRadioButton jrbstudent=null;
    JRadioButton jrbteachermanager=null;
    ButtonGroup btg=null;
    //For login button field:
    JPanel jpnlogin=null;
    JButton jbtlogin=null;
    //For the message:
    JLabel jlbmessage=null;
    JPanel jpnmessage_=null;
    //Methods:----------------------------------------------------------
    public LoginSystem(){
        //--------------------------------------------------------------
        JFrame jframe=new JFrame("Login");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setLayout(new GridLayout(5,1));
        jframe.setLocation(450, 100);
        //--------------------------------------------------------------
        //For username field:
        jpnusername=new JPanel(new FlowLayout(FlowLayout.CENTER));
        jlbusername=new JLabel("USERNAME ");
        jtfusername=new JTextField(20);
        jtfusername.setActionCommand("jtfusername");
        jtfusername.addActionListener(this);
        jpnusername.add(jlbusername);
        jpnusername.add(jtfusername);
        jframe.add(jpnusername);
        //--------------------------------------------------------------
        //For password field:
        jpnpassword=new JPanel(new FlowLayout(FlowLayout.CENTER));
        jlbpassword=new JLabel("PASSWORD");
        jtfpassword=new JPasswordField(20);
        jtfpassword.setActionCommand("jtfpassword");
        jtfpassword.addActionListener(this);
        jpnpassword.add(jlbpassword);
        jpnpassword.add(jtfpassword);
        jframe.add(jpnpassword);
        //--------------------------------------------------------------
        //For type of account:
        //panel
        jpntype_=new JPanel(new FlowLayout(FlowLayout.CENTER));
        //student
        jrbstudent=new JRadioButton("STUDENT");
        jrbstudent.setActionCommand("jrbstudent");
        jrbstudent.addActionListener(this);
        //teacher
        jrbteachermanager=new JRadioButton("TEACHERMANAGER");
        jrbteachermanager.setActionCommand("jrbteachermanager");
        jrbteachermanager.addActionListener(this);
        //group 2 jradiobutton:
        btg=new ButtonGroup();
        btg.add(jrbstudent);
        btg.add(jrbteachermanager);
        //add into panel:
        jpntype_.add(jrbstudent);
        jpntype_.add(jrbteachermanager);
        //add into jframe:
        jframe.add(jpntype_);
        //--------------------------------------------------------------
        //For login button field:
        jpnlogin=new JPanel(new FlowLayout(FlowLayout.CENTER));
        jbtlogin=new JButton("LOGIN");
        jbtlogin.setActionCommand("jbtlogin");
        jbtlogin.addActionListener(this);
        jbtlogin.setPreferredSize(new Dimension(100,25));
        jpnlogin.add(jbtlogin);
        jframe.add(jpnlogin);
        //--------------------------------------------------------------

        //
        //-------------------------------------------------------------
        //
        //For the message label:
        jlbmessage=new JLabel("Input information in login the system!!!");
        jpnmessage_=new JPanel(new FlowLayout(FlowLayout.CENTER));
        jpnmessage_.add(jlbmessage);
        jframe.add(jpnmessage_);
        //
        //-----------------------------------------------------
        jframe.setPreferredSize(new Dimension(500,200));
        jframe.pack();
        jframe.setVisible(true);

    }
    private Integer _type_=0;
    @Override
    public void actionPerformed(ActionEvent ae) {
        // TODO Auto-generated method stub

        if(ae.getActionCommand().equals("jrbstudent")){
            _type_=2;
        }
        else if(ae.getActionCommand().equals("jrbteachermanager"))
        {
            _type_=1;
        }
        if(ae.getActionCommand().equals("jbtlogin")) {
            String _username_=jtfusername.getText();
            String  _password_=jtfpassword.getText();
            boolean check=AccountsDAO.Login(_username_,_password_,_type_);
            String loginsuccess="Login success. ";
            String loginfailed="Login failed. Checked again!!!";
            if(check){
            jlbmessage.setText(loginsuccess);
            }
            else {
                jlbmessage.setText(loginfailed);
            }
        }
        else
        {
            jlbmessage.setText("Input information in login the system!!!");
        }
    }


}
