package utils;

import dto.HotelInformation;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Dinh Gia Bao
 */
public class Validation {

    public static Scanner sc = new Scanner(System.in);

    
    //nhập vào một chuỗi kí tự, theo định dạng đc đưa vào
    //định dạng xài Regular Expression
    public static String getID(String inputMsg, String errorMsg, String format) {
        String id;
        boolean match;
        while (true) {
            System.out.print(inputMsg);
            id = sc.nextLine().trim().toUpperCase();
            match = id.matches(format);
            if (id.length() == 0 || id.isEmpty() || match == false)
                System.err.println(errorMsg);
            else
                return id;            
        }
    }
    
    public static String inputPattern(String msg, String pt){
        String s = "";
        //Pattern pattern = Pattern.compile(pt);
        System.out.println(msg);
        while(true){
            s = sc.nextLine();
            if(!s.trim().isEmpty() && s.matches(pt)){
                break;
            }
            else{
                System.err.println("Please correct the format! ");
            }
        }
        return s;
    }
    
    
    public static String inputString(String msg, String err){
        String s = "";
        while(true){
            System.out.println(msg);
            s = sc.nextLine();
            if(!s.isEmpty()) break;
            System.err.println(err);
        }
        return s;
    }
    
    
    //Update Hotel ( Name, Room , Address, Phone, Rating )
    public static String updateName(String msg, HotelInformation hotel, String pt){
        String s = "";
        //Pattern pattern = Pattern.compile("^[a-zA-Z0-9\\s]+");
        while(true){
            System.out.println(msg);
            s = sc.nextLine();
            if(s.trim().isEmpty()){
                return hotel.getHotelName();
            }
            else if(!s.matches(pt)){
                System.err.println("Please enter the correct format of name");
            }
            else{
                return s;
            }
        }
    }
    //getIntBlankRoom : nếu Enter(ko nhập gì) -> info not change
    public static int updateRoom(String msg, HotelInformation hotel, int min, int max){
        String numStr = "";
        while(true){
            try{
                System.out.println(msg);
                numStr = sc.nextLine();

                if(!numStr.isEmpty()){
                    int num = Integer.parseInt(numStr);
                    if(num >= min && num <= max){
                        return num;
                    }
                    else{
                        System.err.println("Please input an integer number in range " + min + " -> " + max);
                    }
                } 
                else{
                    return hotel.getHotelRoomAvailable();
                }
            } catch (Exception e) {
                //System.err.println(e);
                System.err.println("Invalid input. Please enter a valid integer.");
            }
        }
    }
    
    public static String updateAddress(String msg, HotelInformation hotel, String pt){
        String s = "";
        //Pattern pattern = Pattern.compile("^[a-zA-Z0-9\\s]+");
        while(true){
            System.out.println(msg);
            s = sc.nextLine();
            if(s.trim().isEmpty()){
                return hotel.getHotelAddress();
            }
            else if(!s.matches(pt)){
                System.err.println("Please enter the correct format of address");
            }
            else{
                return s;
            }
        }
    }
    
    public static String updatePhone(String msg, HotelInformation hotel, String pt){
        String s = "";
        //Pattern pattern = Pattern.compile("^[a-zA-Z0-9\\s]+");
        while(true){
            System.out.println(msg);
            s = sc.nextLine();
            if(s.trim().isEmpty()){
                return hotel.getHotelPhone();
            }
            else if(!s.matches(pt)){
                System.err.println("Please enter the correct format of address! (Include 10 digits and first start with number 0)");
            }
            else{
                return s;
            }
        }
    }
    
    // getIntBlankRating: nếu Enter(ko nhập gì) -> info not change
    public static int updateRating(String msg, HotelInformation hotel, int min, int max){
        String numStr = "";
        while(true){
            try{
                System.out.println(msg);
                numStr = sc.nextLine();

                if(!numStr.isEmpty()){
                    int num = Integer.parseInt(numStr);
                    if(num >= min && num <= max){
                        return num;
                    }
                    else{
                        System.out.println("Please input an integer number in range " + min + " -> " + max);
                    }
                } 
                else{
                    return hotel.getHotelRating();
                }
            }catch(NumberFormatException e) {
                System.err.println("Invalid input. Please enter a valid integer.");
                
            }
        }
    }
    
    
    
    
//    //Cách 1:
//    public static int getInt(String msg, String err, int min, int max) {
//        int n;
//        while (true) {
//            try {
//                System.out.println(msg);
//                n = Integer.parseInt(sc.nextLine());
//                if (min <= n && n <= max) {
//                    break;
//                }
//                throw new NumberFormatException("Number must be in range [" + min + ";" + max + "]");
//            } catch (NumberFormatException ex) {
//                System.out.println("Please enter an integer number in range: " + min + "->" + max);
//            }
//        }
//        return n;
//    }
 
    //Cách 2:
    public static int getAnInteger(String inputMsg, String errorMsg, int lowerBound, int upperBound) {
        int n, tmp;
        //nếu đầu vào lower > upper thì đổi chỗ
        if (lowerBound > upperBound) {
            tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                if (n < lowerBound || n > upperBound)
                    throw new Exception();                
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }
    

    private static boolean idExist(String id, List<HotelInformation> hList) {
        for (HotelInformation o : hList) {
            if (o.getHotelId().equals(id))
                return true;
        }
        return false;
    }
    

}
