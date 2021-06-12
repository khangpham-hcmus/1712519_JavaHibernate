package swingUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
public class LoginSystem extends JFrame {
    //Attributes:-------------------------------------------------------
    JFrame jframe=null;
    //Username:
    JPanel jpnusername=null;
    JLabel jlbusername=null;
    JTextField jtfusername=null;
    //Password:
    JPanel jpnpassword=null;
    JLabel jlbpassword=null;
    JPasswordField jtfpassword=null;

    //For login button field:
    JPanel jpnlogin=null;
    JButton jbtlogin=null;
    //For the message:
    JLabel jlbmessage=null;
    JPanel jpnmessage_=null;
    //Methods:----------------------------------------------------------
    public LoginSystem(){
        //--------------------------------------------------------------
        jframe=new JFrame("Login");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setLayout(new GridLayout(5,1));
        jframe.setLocation(450, 100);
        //--------------------------------------------------------------
        //For username field:
        jpnusername=new JPanel(new FlowLayout(FlowLayout.CENTER));
        jlbusername=new JLabel("USERNAME ");
        jtfusername=new JTextField(20);
        jtfusername.setActionCommand("jtfusername");
        //jtfusername.addActionListener(this);
        jpnusername.add(jlbusername);
        jpnusername.add(jtfusername);
        jframe.add(jpnusername);
        //--------------------------------------------------------------
        //For password field:
        jpnpassword=new JPanel(new FlowLayout(FlowLayout.CENTER));
        jlbpassword=new JLabel("PASSWORD");
        jtfpassword=new JPasswordField(20);
        jtfpassword.setActionCommand("jtfpassword");
        //jtfpassword.addActionListener(this);
        jpnpassword.add(jlbpassword);
        jpnpassword.add(jtfpassword);
        jframe.add(jpnpassword);
        //--------------------------------------------------------------
        //--------------------------------------------------------------
        //For login button field:
        jpnlogin=new JPanel(new FlowLayout(FlowLayout.CENTER));
        jbtlogin=new JButton("LOGIN");
        jbtlogin.setActionCommand("jbtlogin");
        //jbtlogin.addActionListener(this);
        jbtlogin.setPreferredSize(new Dimension(100,25));
        jpnlogin.add(jbtlogin);
        jframe.add(jpnlogin);
        //-------------------------------------------------------------
        //For the message label:
        jlbmessage=new JLabel("Input information in login the system!!!");
        jpnmessage_=new JPanel(new FlowLayout(FlowLayout.CENTER));
        jpnmessage_.add(jlbmessage);
        jframe.add(jpnmessage_);
        //-----------------------------------------------------
        jframe.setPreferredSize(new Dimension(500,200));
        jframe.pack();
    }

    public void setVisible(boolean value)
    {
        jframe.setVisible(value);
    }

    public void addLoginListener(ActionListener listener)
    {
        jbtlogin.addActionListener(listener);
    }
    public String[] GetInfo(){
        String[] info=new String[2];
        info[0]=jtfusername.getText();
        info[1]=jtfpassword.getText();
        return info;
    }
    public void showMessGUI(String message)
    {
        JOptionPane.showMessageDialog(this,message);
    }
    public void setJlabel(String mess)
    {
        this.jlbmessage.setText(mess);
    }
}
