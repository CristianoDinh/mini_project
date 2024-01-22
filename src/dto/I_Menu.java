
package dto;

/**
 *
 * @author Dinh Gia Bao
 */
public interface I_Menu {
    void addNewOption(String newOption);
    void showMenu();
    //Get User's choices
    int getChoice();
    //Confirm yes/no (Y/N)
    boolean confirmYesNo(String s);
    
}
