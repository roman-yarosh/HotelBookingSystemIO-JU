package hotelbooking;

public class Room {

    private long roomId;
    private long hotelId;
    private int persons;
    private double price;
    private User userReserved;

    public Room(long roomId, int persons, double price, long hotelId) {
        this.roomId = roomId;
        this.persons = persons;
        this.price = price;
        this.hotelId = hotelId;
    }

    public long getId() {
        return roomId;
    }

    public int getPersons() {
        return persons;
    }

    public double getPrice() {
        return price;
    }

    public void setUserReserved(User userReserved) {
        this.userReserved = userReserved;
    }

    public User getUserReserved() {
        return userReserved;
    }

    @Override
    public String toString() {
        return "\nRoom{" +
                "roomId=" + roomId +
                ", hotelId=" + hotelId +
                ", persons=" + persons +
                ", price=" + price +
                ", userReserved=" + userReserved +
                "}";
    }
}
