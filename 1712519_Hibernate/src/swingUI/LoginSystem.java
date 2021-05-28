package swingUI;

import dao.AccountsDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;

public class LoginSystem implements ActionListener {
        JFrame jf=null;
        JLabel userJLB=null;
        JTextField userJTF=null;
        JTextField passJTF=null;
        JLabel passJLB=null;
        JButton loginJB=null;
        JPasswordField jPasswordField__=null;
        JLabel typejlb=new JLabel("TYPE ACCOUNT: ");
        JRadioButton jradioStudent=new JRadioButton("Student");
        JRadioButton jradioTeachermanager=new JRadioButton("Teachermanager");
        ButtonGroup buttonGroup__=new ButtonGroup();
        JTextField jtfRS=null;
        public LoginSystem(){
                //config jframe
                jf=new JFrame("LOGIN INTO COURSES REGISTRATION SYSTEM!!");
                jf.setSize(600,600);
                jf.setLayout(null);
                jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                //usernameUI:
                userJLB=new JLabel("USERNAME: ");
                userJTF=new JTextField(10);
                userJTF.addActionListener(this);
                userJTF.setActionCommand("jtfuser");
                //locate them:
                userJLB.setBounds(50,50,100,30);
                userJTF.setBounds(150,50,200,30);
                jf.add(userJLB);
                jf.add(userJTF);
                //passwordUI:
                passJLB=new JLabel("PASSWORD: ");
                passJTF=new JTextField(10);
                passJTF.addActionListener(this);
                passJTF.setActionCommand("jtfpassword");
                //locate them:
                passJLB.setBounds(50,90,100,30);
                passJTF.setBounds(150,90,200,30);
                //type of account:
                typejlb.setBounds(50,140,100,30);
                jradioStudent.setBounds(150,140,75,30);
                jradioTeachermanager.setBounds(225,140,150,30);
                jradioStudent.addActionListener(this);
                jradioTeachermanager.addActionListener(this);
                //set action command:
                jradioStudent.setActionCommand("student");
                jradioTeachermanager.setActionCommand("teachermanager");
                //
                jf.add(typejlb);
                buttonGroup__.add(jradioStudent);
                buttonGroup__.add(jradioTeachermanager);
                jf.add(jradioStudent);
                jf.add(jradioTeachermanager);
                jf.add(passJLB);
                jf.add(passJTF);
                //add button:
                loginJB=new JButton("SIGN IN");
                loginJB.setBounds(218,180,130,30);
                loginJB.addActionListener(this);
                loginJB.setActionCommand("loginbutton");
                jf.add(loginJB);
                //
                jtfRS=new JTextField(10);
                jtfRS.setBounds(50,225,300,30);
                jf.add(jtfRS);
                //show to screen:
                jf.setVisible(true);

        }
        private String _username_=null;
        private String _password_=null;
        private Integer _type_=0;
    @Override
    public void actionPerformed(ActionEvent ae) {

            //check type of account:
                if(ae.getActionCommand().equals("student")){
                        _type_=2;
                }
                else if(ae.getActionCommand().equals("teachermanager")) {
                        _type_ = 1;
                }
           //
            if(ae.getActionCommand().equals("jtfuser")){
                    _username_=userJTF.getText();
                    System.out.println(_username_);
            }
           //
            if(ae.getActionCommand().equals("jtfpassword")) {
                    _password_ = passJTF.getText();
                    System.out.println(_password_);
            }
           //
            if(ae.getActionCommand().equals("loginbutton")) {
                    System.out.println(_username_+_password_+_type_);
                    if(_username_==null||_password_==null||_type_==0){
                            jtfRS.setText("INFORMATION IS NOT COMPLETED.");
                    }
                    else{
                            jtfRS.setText("INFORMATION IS COMPLETED.");
                    }
            }



    }


}
