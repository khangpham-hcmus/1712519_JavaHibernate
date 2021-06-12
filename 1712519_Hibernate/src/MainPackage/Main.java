package MainPackage;

import dao.AccountsDAO;
import swingUI.Controller;

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
