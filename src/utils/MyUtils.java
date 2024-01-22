
package utils;

/**
 *
 * @author Dinh Gia Bao
 */
import java.util.Scanner;

public class MyUtils {
    
    private static Scanner sc = new Scanner(System.in);
    
    
    public static String getString(String inputMsg,String errorMsg) {
        boolean check = true;
        String result = "";
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print(inputMsg);
            result = sc.nextLine();
            if (result.isEmpty()) {
                System.out.println(errorMsg);
            } else {
                check = false;
            }
        } while (check);
        return result;
    }
    
    public static boolean confirmYesNo(String msg) {
        
        String confirm = "";
        
            System.out.println(msg);
        do {
            confirm = sc.nextLine();
            
            if(confirm.equalsIgnoreCase("Y"))
                return true;
            else if(confirm.equalsIgnoreCase("N"))
                return false;
            else { 
                System.err.println("You must enter (Y or N): ");
                //nhập lại cho đến khi đúng
                //err.  ( in ra "String" màu đỏ )
            }
        } while (true);
        
        
    }
}
