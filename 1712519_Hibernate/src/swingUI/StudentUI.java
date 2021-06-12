package swingUI;

import pojo.Accounts;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentUI extends JFrame {
    //set action command
    public static final String ACTION_COMMAND = "StudentUI_COMMAND";
    //---------------------------------
    private Accounts currentStudent;
    //------------------------------------------------------------------
    private JFrame studentFrame=null;
    private JButton jbtInformation=null;
    private JButton jbtChangePassword=null;
    private JButton jbtLogout=null;

    private JPanel leftPanel;
    private JPanel rightPanel;
    public StudentUI(){
        studentFrame=new JFrame("Student") ;
        studentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        studentFrame.setVisible(false);
    }
    public void setVisible(boolean value)
    {
        studentFrame.setVisible(value);
    }
    public void addLogoutListener(ActionListener listener) {
        jbtLogout.addActionListener(listener);
        jbtLogout.setActionCommand(ACTION_COMMAND);
    }

    public void hideGUI() {
        rightPanel.removeAll();
        rightPanel.revalidate();
        rightPanel.repaint();
        this.setVisible(false);
    }
    //
    public void setCurrentStudent(Accounts acc)
    {
        this.currentStudent=acc;
    }
    public Accounts getCurrentStudent()
    {
        return this.currentStudent;
    }

}
