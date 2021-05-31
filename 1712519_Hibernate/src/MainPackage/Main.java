package MainPackage;

import dao.*;
import pojo.*;

import java.util.List;
import java.util.Optional;
import swingUI.*;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        try {
          /* Accounts ac= AccountsDAO.GET_ACCOUNT_THROUGH_USERNAME_TYPE("1712519",2);
           System.out.println(ac.toString());
           System.out.println(ac.get_student_());
           System.out.println(ac.get_teachermanager_());*/

          // AccountsDAO.UPDATE_PASSWORD("1712519","khangpham");



        }
        catch (Exception e){
            System.out.println("Exception in main: "+e);

        }
    }
}
