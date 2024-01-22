
package dto;

/**
 *
 * @author Dinh Gia Bao
 */
public interface I_List {
    //1. Load data from file
    void loadData();
    
    //2. Add a new element (input from Scanner) to I_List
    void addHotel();
    //3. Check an exist hotel
    void checkExistsHotel();
    //4. Update Hotel Information
    void  update();
    
    
    //5. Delete a hotel
    void delete();
    
    
    //6. Searching hotel
    void search();
//    int searchByID(String id);
//    void searchByName(String name);
//Object searchByID(String id);
    
    //7. Displaying hotel List(descending by Hotel_Name)
    void printHotelListDescendingByName();
    
    //8. Save data to File
    void saveData();
    
    //9. Exit
    //void confirmExit(int count);
    void confirmExit();

    
 
   
    
}
