
package controllers;

import dto.I_List;
import java.util.ArrayList;
import dto.HotelInformation;
import fileIO.SaveLoadFile;

import java.util.Scanner;
import utils.MyUtils;
import utils.Validation;

import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Dinh Gia Bao
 */
public class HotelList implements I_List {
    
     ArrayList<HotelInformation> hotelList = new ArrayList<>();
    
    private SaveLoadFile fi;
        String fileName = "Hotel.dat";
        //String fileName = "Tester.dat";
    
    private Scanner sc = new Scanner(System.in);
    
    // Trong truong hop ko co ham loadData !!!
//    public HotelList() {
//        //hotelList = new ArrayList<>();
//        fi = new SaveLoadFile();
//        try {
//            fi.loadDataFromFile(hotelList, fileName);
//        } catch (Exception e) {
//            System.out.println("List empty");
//        }
//
//        if (hotelList.isEmpty()) {
//            System.err.println("Empty list, please add new one to have information in File 📂");
////            addHotel();
//        }

    
    @Override
    public void loadData() {
        //hotelList = new ArrayList<>();
        if (!hotelList.isEmpty()) {
            System.err.println("Data was loaded before");
            return;
        }
        fi = new SaveLoadFile();
        try {
            fi.loadDataFromFile(hotelList, fileName);
        } catch (Exception e) {
            System.out.println("List empty");
        }

        if (hotelList.isEmpty()) {
            System.err.println("Empty list, please add new one to have information in File 📂");
//            addHotel();
        }
        else {
            System.out.println("Loading data from file sucessfully...");
        }
    }
    @Override
    public void addHotel() {
        String hotelId;
        String hotelName;
        int hotelRoomAvailable;
        String hotelAdress;
        String hotelPhone;
        int hotelRating;
        boolean choice;
        
        do {
            int pos;  //lưu vị trí tìm thấy id 

            //chửi khi nhập sai định dạng id, hay nhập trùng id 
            do {
                hotelId = Validation.getID("Input Hotel Id(HXX): ", 
                        "The format of id is HXX (X stands for a digit number)", "^H\\d{2}");
                pos = searchHotelByID(hotelId);
                if (pos >= 0)
                    System.out.println("This hotel id is already exists. "
                            + "Input another one!");
            } while (pos != -1);

            hotelName = MyUtils.getString("Input hotel name: ", "The hotel name is required!");
            hotelRoomAvailable = Validation.getAnInteger("Input amount of available rooms: ", "Available rooms is from (1...100)", 1, 100);
            hotelAdress = Validation.inputPattern("Input hotel adress: ", "^[a-zA-Z0-9/,\\s]+");
            hotelPhone = Validation.inputPattern("Input phone number: ", "0\\d{9}");
            hotelRating = Validation.getAnInteger("Input hotel rating(1->6): ", "Hotel rating just only be in (1->5) !", 1, 6);

            hotelList.add(new HotelInformation(hotelId, hotelName, hotelRoomAvailable, hotelAdress, hotelPhone, hotelRating));
            System.out.println("A new Hotel profile is added sucessfully");

            choice = MyUtils.confirmYesNo("Do you want to continue adding new hotel? (Y/N): ");
        } while (choice == true);
    }
    
    //hàm helper/hàm phụ trợ
    //hàm này sẽ trả về vị trí tìm thấy Object trong mảng 
    //quy ước: -1 hok tìm thấy 
    //trả về >=0 vị trí tìm thấy trong mảng 
    public int searchHotelByID(String hotelID) {
        //tìm kiếm: thuật toán trâu bò, rà, quét hết mảng 
        //so khớp id của Object thứ i trong mảng coi có bằng id đưa vào hem 
        int pos; 
        if (hotelList.isEmpty()) //ko có Object nào, kết thúc cuộc chơi ngay
            return -1; //ko tìm gì cả
        //quét hết list, coi có trùng id nào ko, thì trả về vị trí
        for (int i = 0; i < hotelList.size(); i++) 
            if (hotelList.get(i).getHotelId().equalsIgnoreCase(hotelID))
                return i;            
        //đi hết cả for mà hok thấy, thì return -1 - not found 
        return -1;            
    }
    
    
    
    @Override
    public void checkExistsHotel() {

        boolean choice ;
        do {
            String id = Validation.inputString("Enter ID to check: ", "ID can't be empty!!!").toUpperCase();
            
            int pos = searchHotelByID(id);
            if (pos >= 0)
                System.out.println("This hotel is exist in the list.");
            else 
                System.out.println("No Hotel Found !");
            
            choice = MyUtils.confirmYesNo("Do you want to continue Searching hotel information? (Y/N): ");
        } while (choice);
        
    }        

    
    @Override
    public void update() {
        String hotelId;
        String hotelName;
        int hotelRoomAvailable;
        String hotelAddress;
        String hotelPhone;
        int hotelRating;
        
        hotelId = Validation.inputString("Enter hotel ID: ", "This field can not be blank !").toUpperCase();
        boolean check = true;
        //fi.loadDataFromFile(hotelList, fileName);
        HotelInformation hotelInfo = searchHotelByID(hotelList, hotelId);
        
        int hotelIndex = hotelList.indexOf(hotelInfo); // lấy Index của hotelInfo vừa được cập nhật
        if (hotelInfo != null) {
            System.out.println("The old information of this hotel :\n"+ hotelInfo +"\nEnter new information 👇");
            hotelName = Validation.updateName("Enter hotel name: ", hotelInfo, "^[a-zA-Z\\s]+$");
            hotelRoomAvailable = Validation.updateRoom("Enter room available: ", hotelInfo, 1, 1000);
            hotelAddress = Validation.updateAddress("Enter hotel address: ", hotelInfo, "^[a-zA-Z0-9,/\\s]+");
            hotelPhone = Validation.updatePhone("Enter hotel phone: ", hotelInfo, "0\\d{9}");
            hotelRating = Validation.updateRating("Enter hotel rating(1-6): ", hotelInfo,1, 6);

//            HotelInformation existingHotel = hotelList.get(hotelList.indexOf(hotelInfo));
                                                            // Lấy ra indexOf (object hotelInfo) được lưu trong hotelList
                                            //lấy ra Object trong hotelList tại vị trí get()                
//            existingHotel.setHotelAddress(hotelAddress);
//            existingHotel.setHotelName(hotelName);
//            existingHotel.setHotelRoomAvailable(hotelRoomAvailable);
//            existingHotel.setHotelPhone(hotelPhone);
//            existingHotel.setHotelRating(hotelRating);
            
            // Update the object in the list
//            hotelList.set(hotelList.indexOf(hotelInfo), existingHotel);

            hotelList.set(hotelList.indexOf(hotelInfo), new HotelInformation(hotelId, hotelName, hotelRoomAvailable, hotelAddress, hotelPhone, hotelRating));
            System.out.println("After updating: ");          
            
            System.out.println(hotelList.get(hotelIndex)); //In ra  Object của hotelList tại Index của HotelInfo vừa được cập nhật
            //fi.saveDataToFile(hotelList, fileName, "New hotel data has been updated to File successfully!");

        } else {
            System.out.println("Hotel does not exist");
        }
    
    }
    //hàm helper/phụ trợ
    public static HotelInformation searchHotelByID(ArrayList<HotelInformation> hotelList, String id){
        for (HotelInformation hotelInformation : hotelList) {
            if(hotelInformation.getHotelId().equals(id))
                return hotelInformation;
        }
        return null;
    }
    
    
    @Override
    public void delete() {
        String id = Validation.inputString("Enter ID to delete hotel: ", "ID can't be empty").toUpperCase();
        HotelInformation hotelInfo = searchHotelByID(hotelList, id);
        boolean check;
        boolean condition = false;
        if (hotelInfo == null) {
            System.err.println("This ID does not exist. ");
        }
        while (hotelInfo != null) {
            System.out.println("Do you ready want to delete this hotel?");
            
            check = MyUtils.confirmYesNo("Yes or No (Y/N)? ");
            if (check) {
                hotelList.remove(hotelInfo);
                System.out.println("Removed Successfully");
                condition = true;
                break;
            } else {
                System.out.println("Failed to remove");
                break;
            }
        }
//        if(condition){
//            fi.saveDataToFile(hotelList, fileName, "Hotel data has been deleting from File !");
//        }
    }

    
    @Override
    public void search() {
//        ArrayList<HotelInformation> hList = new ArrayList<>();
//        fi.loadDataFromFile(hList, fileName);
        
        boolean check = false;
        int choice;
        String[] subOpList = {"\n============== SEARCHING OPTIONS ==================", "  5.1 Searching by Hotel_Id      [Enter 1]",
            "  5.2 Searching by Hotel_Address [Enter 2]", "  5.3 Quit                       [Enter 3]"};
        for (String string : subOpList) {
            System.out.println(string);
        }
        do {
            choice = Validation.getAnInteger("Enter your option(1 -> 3): ", "Your option must be in range(1...3)", 1, 3);
            switch (choice) {
                case 1: //tìm Id equals: giống hệt

                    String id = Validation.inputString("Enter ID to search: ", "This field can not be blank.");
                    
                    for (HotelInformation tmp : hotelList) {
                        if (tmp.getHotelId().equals(id.toUpperCase())) {
                            System.out.println(tmp);
                            check = true;
                        }
                    }
                    if (!check) {
                        System.err.println("This hotel ID does not exist!");
                    }
                    break;
                    
                case 2: //tìm Hotel ,descending theo hotel_Room_Available => Collections.sort
                    String address = Validation.inputString("Enter hotel address to search: ", "This field can not be blank.");
                    Collections.sort(hotelList, Comparator.comparing(HotelInformation::getHotelRoomAvailable).reversed());
        
// Sắp xếp danh sách theo trường hotelRoomAvailable giảm dần
//Collections.sort(hotelList, Collections.reverseOrder());

                    for (HotelInformation tmp : hotelList) {
                        if (tmp.getHotelAddress().contains(address)) {
                            System.out.println(tmp);
                            check = true;
                        }
                    }
                    if (!check) {
                        System.out.println("This hotel Address does not exist!");
                    }
                    break;
                default:
                    System.out.println("Quit searching hotel...");
                    break;
            }
        } while (choice == 1 || choice == 2);
    }

 
    @Override
    public void printHotelListDescendingByName() {
        //ArrayList<HotelInformation> hList = new ArrayList<>();
        //fi.loadDataFromFile(hotelList, fileName);
        
        Collections.sort(hotelList, Comparator.comparing(HotelInformation::getHotelName).reversed());
        //C2: Collections.sort(hList, Collections.reverseOrder());
        if (hotelList.isEmpty()) {
            System.err.println("No data received! Empty list!\nPlease choose [Option 2] to add a new one ...");
        
        } else {
            System.out.println("___________________________________________________________________________________________________________________________________________________________");
            System.out.printf("|%-10s|%-18s|%20s|%-70s|%-13s|%-13s|\n", "Hotel_id", "Hotel_Name", "Hotel_Room_Available", "Hotel_Address", "Hotel_Phone", "Hotel_Rating");
            System.out.println("___________________________________________________________________________________________________________________________________________________________");
            for (HotelInformation hotelInformation : hotelList) {
                System.out.print(hotelInformation);
            }
        }
    }

    
    @Override
    public void saveData() {
        if (hotelList.isEmpty()) {
            System.err.println("There is nothing to save...");
        }else{
        fi.saveDataToFile(hotelList, fileName, "Save Hotel data successfully !");
        //hotelList.clear();
        }
    }

//    @Override
//    public void confirmExit(int count) {
//        boolean condition = false;
//        if(count != 0){
//            condition = MyUtils.confirmYesNo("Do you want to save data which has been changed above to File before exiting? Y/N: ");
//            if(condition){
//                fi.saveDataToFile(hotelList, fileName,"Save data successfully."); 
//            }
//        }
//        System.out.println("Thank you for using my system ❤ ");
//    }

    @Override
    public void confirmExit() {
        boolean condition = false;
        if(!hotelList.isEmpty()){
            condition = MyUtils.confirmYesNo("Do you want to save data which has been changed above to File before exiting? Y/N: ");
            if(condition){
                fi.saveDataToFile(hotelList, fileName,"Save data successfully."); 
            }
        }
        System.out.println("Thank you for using my system ❤ ");
    }
}
