package swingUI;

import dao.AccountsDAO;
import pojo.Accounts;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Controller {
    //------------------------------------------------------
    private LoginSystem login;
    private TeachermanagerGUI teachermanagerGUI=null;
    private StudentUI studentUI=null;
    //-----------------------------------
    public Controller(){
        login=new LoginSystem();
        teachermanagerGUI=new TeachermanagerGUI();
        //studentUI=new StudentUI();

        login.addLoginListener(new LoginListener());
        teachermanagerGUI.addLogoutListener(new LogoutListener());
       // studentUI.addLogoutListener(new LogoutListener());
    }
    //-----------------------------------------
    public void showLoginGUI() {
        login.setVisible(true);
    }
    //-------------------------------
    class LoginListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            String[] info = login.GetInfo();
            Accounts account = AccountsDAO.GetAccount(info[0]);
            int checkLogin = 0;
            if (account.getPass().equals(info[1]))
                checkLogin = 1;
            if (checkLogin == 1) {
                int type = account.getTypeOfAccount();
                if (type == 1) {
                    //show GiaoVuFrame
                    login.setVisible(false);
                    teachermanagerGUI.setCurrentAccount(account);
                    teachermanagerGUI.SetVisible(true);
                } else if (type == 2) {
                    /*//show SinhVienFrame
                    loginFrame.setVisible(false);
                    sinhVienFrame.setTaiKhoan(account);
                    sinhVienFrame.showGUI();*/
                    login.showMessGUI("Student account");
                }
            }
        }
    }


    class LogoutListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if(command.equals(TeachermanagerGUI.ACTION_COMMAND)) {
                teachermanagerGUI.SetVisible(false);
            }
            /*else if(command.equals(studentUI.ACTION_COMMAND)) {
                studentUI.hideGUI();
            }*/
            login.setVisible(true);
        }
    }
}
