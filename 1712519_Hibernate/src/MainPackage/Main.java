package MainPackage;

import dao.AccountsDAO;
import pojo.Accounts;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        try{
        System.out.println("Hello world");
        List<Accounts> allAccounts= AccountsDAO.getAllAccounts();
        for(Accounts e:allAccounts){
            System.out.println(e.toString());
        }}
        catch (Exception e){
            System.out.println("Exception in main: "+e.getMessage());
        }
    }
}
