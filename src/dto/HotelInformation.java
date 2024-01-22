
package dto;

import java.io.Serializable;

/**
 *
 * @author Dinh Gia Bao
 */
public class HotelInformation implements Comparable<HotelInformation>, Serializable{
    private String hotelId;
    private String hotelName;
    private int hotelRoomAvailable;
    private String hotelAddress;
    private String hotelPhone;
    private int hotelRating;

    public HotelInformation() {
    }

    public HotelInformation(String hotelId, String hotelName, int hotelRoomAvailable, String hotelAdress, String hotelPhone, int hotelRating) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.hotelRoomAvailable = hotelRoomAvailable;
        this.hotelAddress = hotelAdress;
        this.hotelPhone = hotelPhone;
        this.hotelRating = hotelRating;
    }


    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getHotelRoomAvailable() {
        return hotelRoomAvailable;
    }

    public void setHotelRoomAvailable(int hotelRoomAvailable) {
        this.hotelRoomAvailable = hotelRoomAvailable;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAdress) {
        this.hotelAddress = hotelAdress;
    }

    public String getHotelPhone() {
        return hotelPhone;
    }

    public void setHotelPhone(String hotelPhone) {
        this.hotelPhone = hotelPhone;
    }

    public int getHotelRating() {
        return hotelRating;
    }

    public void setHotelRating(int hotelRating) {
        this.hotelRating = hotelRating;
    }

    @Override
    public String toString() {
        return String.format("|%-10s|%-18s|%20d|%-70s|%-13s|%8d star|\n", hotelId,hotelName ,hotelRoomAvailable,
                            hotelAddress, hotelPhone, hotelRating);
        
    }

    @Override
    public int compareTo(HotelInformation o) {
        return this.hotelId.compareToIgnoreCase(o.hotelId);
    }
    
    
}
