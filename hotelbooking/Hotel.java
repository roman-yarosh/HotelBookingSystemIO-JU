package hotelbooking;

import java.util.List;

public class Hotel implements HasGetIdMethod {

    private long hotelId;
    private String hotelName;
    private String hotelCity;
    private List<Room> hotelRooms;

    public Hotel(long hotelId, String hotelName, String hotelCity, List<Room> hotelRooms) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.hotelCity = hotelCity;
        this.hotelRooms = hotelRooms;
    }

    @Override
    public long getId() {
        return hotelId;
    }

    public String getName() {
        return hotelName;
    }

    public String getCity() {
        return hotelCity;
    }

    public List<Room> getHotelRooms() {
        return hotelRooms;
    }

    @Override
    public String toString() {
        return "\nHotel{" +
                "hotelId=" + hotelId +
                ", hotelName='" + hotelName + '\'' +
                ", hotelCity='" + hotelCity + '\'' +
                ", hotelRooms=" + hotelRooms +
                '}';
    }
}
