
package controllers;

import dto.I_Menu;
import java.util.ArrayList;
import utils.MyUtils;

import utils.Validation;

/**
 *
 * @author Dinh Gia Bao
 */
public class Menu implements I_Menu{
    
    private String menuTitle;
    private ArrayList<String> optionList = new ArrayList();
    //Contain options of Menu

    public Menu(String menuTitle) {
        this.menuTitle = menuTitle;
    }
    
    
    //Bổ sung từng lựa chọn cho -> Menu
    @Override
    public void addNewOption(String newOption) {
        optionList.add(newOption);
    }

    @Override
    public void showMenu() {
        if (optionList.isEmpty()) {
            System.out.println("There is no item in the Menu");
        }
        System.out.println("\n------------------------------------");
        System.out.println("Welcome to "+ menuTitle);
        System.out.println("------------------------------------");
        for (String x : optionList) {
            System.out.println(x);
        }
    }

    @Override
    public int getChoice() {
        int maxOption = optionList.size();
        
        String inputMsg = "Choose [1.." +maxOption+ "]: ";
        String errorMsg = "You are required to choose the option from 1.." +maxOption;
        
        //C1:return Validation.getInt(errorMsg, errorMsg, maxOption, maxOption);
        //C2: (giaolang)
        return Validation.getAnInteger(inputMsg, errorMsg, 1, maxOption);
    }

    @Override
    public boolean confirmYesNo(String s) {
        boolean flag = false;
        flag = MyUtils.confirmYesNo(s);
        return flag; 
    }
    
}
