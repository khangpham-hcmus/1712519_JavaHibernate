package MainPackage;

import dao.AccountsDAO;
import pojo.Accounts;
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
            List<Accounts> ds=AccountsDAO.GetTeachermanagerAccount();
            for(Accounts s:ds)
            {System.out.println(s);}
        }
        catch (Exception e){
            System.out.println("Exception in main: "+e.toString());
        }
    }
}
