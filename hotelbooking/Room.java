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

    public void setUserReserved(User userReserved) {
        this.userReserved = userReserved;
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
