package view;

import dto.I_Menu;
import controllers.Menu;
import dto.I_List;
import controllers.HotelList;

/**
 *
 * @author Dinh Gia Bao
 */
public class HotelManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        I_Menu menu = new Menu("Hotel Management System");
        
        
        menu.addNewOption("1. Load data from file to program");
        menu.addNewOption("2. Add a new hotel");
        menu.addNewOption("3. Checking exits hotel");
        menu.addNewOption("4. Update a hotel information");
        menu.addNewOption("5. Delete a hotel");
        menu.addNewOption("6. Search a hotel");
        menu.addNewOption("7. Display hotel list");
        menu.addNewOption("8. Save to file");
        menu.addNewOption("9. Quit");
        
        I_List list = new HotelList();
        
        int choice;
        boolean flag = false;
        do {
            menu.showMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    list.loadData();
                    break;
                case 2:
                    list.addHotel();
                    break;
                case 3:
                    list.checkExistsHotel();
                    break;
                case 4:
                    list.update();
                    break;
                case 5:
                    list.delete();
                    break;
                case 6:
                    list.search();
                    break;
                case 7:
                    list.printHotelListDescendingByName();
                    break;    
                case 8:
                    list.saveData();
                    break;                    
                case 9:
                    list.confirmExit();
                    flag = true;
                    break;
            }
           
        } while (!flag);
    }
    
}
