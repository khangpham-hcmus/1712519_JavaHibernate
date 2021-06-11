package MainPackage;

import dao.SemestersDAO;
import pojo.Semesters;
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
            List<Semesters> ds= SemestersDAO.GetListSemesters();
        }
        catch (Exception e){
            System.out.println("Exception in main: "+e.toString());
        }
    }
}
