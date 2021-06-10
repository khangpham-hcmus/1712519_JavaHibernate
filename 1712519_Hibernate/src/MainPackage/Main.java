package MainPackage;

import dao.AccountsDAO;
import dao.CoursesDAO;
import pojo.Accounts;
import pojo.Courses;
import swingUI.Controller;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try
        {
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    Controller appController = new Controller();
                    appController.showLoginGUI();
                }
            });


        }
        catch (Exception e){
            System.out.println("Exception in main: "+e.toString());
        }
    }
}
