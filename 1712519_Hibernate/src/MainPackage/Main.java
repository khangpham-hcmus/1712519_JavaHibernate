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

            AccountsDAO.GET_INFORMATION_OF_ACCOUNT____("1712519",2);
        }
        catch (Exception e){
            System.out.println("Exception in main: "+e);

        }
    }
}
