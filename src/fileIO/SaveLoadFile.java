
package fileIO;

import dto.HotelInformation;
import java.util.ArrayList;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Dinh Gia Bao
 */

public class SaveLoadFile {
//   ArrayList<HotelInformation> hotelList ;
   
    public <T> boolean saveDataToFile(ArrayList<T> list, String fName, String successMsg) {
        try {
            
            File f = new File(fName);
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (T item : list) {
                oos.writeObject(item);
            }
            fos.close();
            oos.close();
            System.out.println(successMsg);
            list.clear();
            return true; // Indicates a successful save
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
   
    
    public <T> boolean loadDataFromFile(ArrayList<T> list, String fName) {
        try {
            // check file exists
            File f = new File(fName);
            if (!f.exists()) {
                return false;
            }
            // read file
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            if (f.length() == 0) {
                System.err.println("File is empty");
            }
            boolean check = true;
            while (check) {
                try {
                    T c = (T) ois.readObject();
                    list.add(c);
                } catch (EOFException e) {
                    break;
                }
            }
            fis.close();
            ois.close();
        } catch (FileNotFoundException e) {
            // log error or throw exception
            System.err.println("File not found: " + fName);
            return false;
        } catch (IOException | ClassNotFoundException e) {
            // log error or throw exception
            System.err.println("Error reading from file: " + fName + e);
            return false;
        } catch (NumberFormatException e) {
            // log error or throw exception
            System.err.println("Error parsing double value from input: " + e.getMessage());
            return false;
        }
        return true;
    }    
    
}   
    
    
/*     
   public void loadDataFromFile(ArrayList<HotelInformation> hotel ,String fName) {
       //Clear current list before loading codes
       if (this.size() >0) this.clear();
       try {
           File f = new File (fName);   //checking the file
           if (!f.exists()) return;
           FileInputStream fi = new FileInputStream(f);     // read()
           ObjectInputStream fo = new ObjectInputStream(fi); //readObject
           HotelInformation h;
           while ( (h=(HotelInformation)(fo.readObject())) != null) {
               this.add(h);
           }
           fi.close(); fo.close();
       }
       catch (Exception e) {
           System.out.println(e);
       }
   }
       
   
   
   
       // Save the list to file
       //You can not append data to binary file because 
       //Java will write class information to the file
       // each time data are appended to the file
    public void saveDataToFile(String fName) {
        if (this.size() == 0) {
            System.out.println("Empty list.");
            return ;
        }
        try {
            FileOutputStream f = new FileOutputStream(fName);   // write()
            ObjectOutputStream fo = new ObjectOutputStream(f);  // writeObject()
            for (HotelInformation h : this) {
                fo.writeObject(h);
            }
            f.close(); fo.close();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
*/
    
    


