package hotelbooking;

public class Room {

    private long roomId;
    private int persons;
    private double price;
    private User userReserved;

    public Room(long roomId, int persons, double price) {
        this.roomId = roomId;
        this.persons = persons;
        this.price = price;
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
                ", persons=" + persons +
                ", price=" + price +
                ", userReserved=" + userReserved +
                "}";
    }
}
