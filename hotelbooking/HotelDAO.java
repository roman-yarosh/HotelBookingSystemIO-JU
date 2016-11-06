package hotelbooking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static hotelbooking.Utils.printMessage;

public class HotelDAO extends AbstractDAOImpl<Hotel> {

    public HotelDAO() {

        Room room1 = new Room(1, 1, 100.0);
        Room room2 = new Room(2, 1, 150.0);
        Room room3 = new Room(3, 1, 200.0);
        Room room4 = new Room(4, 2, 250.0);
        Room room5 = new Room(5, 2, 300.0);
        Room room6 = new Room(6, 2, 350.0);
        Room room7 = new Room(7, 3, 400.0);
        Room room8 = new Room(8, 3, 450.0);
        Room room9 = new Room(9, 3, 500.0);
        Room room10 = new Room(10, 3, 550.0);
        List<Room> roomList1 = Arrays.asList(room1, room2, room3, room4, room5, room6, room7, room8, room9, room10);

        Room room11 = new Room(11, 1, 100.0);
        Room room12 = new Room(12, 1, 150.0);
        Room room13 = new Room(13, 1, 200.0);
        Room room14 = new Room(14, 2, 250.0);
        Room room15 = new Room(15, 2, 300.0);
        Room room16 = new Room(16, 2, 350.0);
        Room room17 = new Room(17, 3, 400.0);
        Room room18 = new Room(18, 3, 450.0);
        Room room19 = new Room(19, 3, 500.0);
        Room room20 = new Room(20, 3, 550.0);
        List<Room> roomList2 = Arrays.asList(room11, room12, room13, room14, room15, room16, room17, room18, room19, room20);

        Room room21 = new Room(21, 1, 100.0);
        Room room22 = new Room(22, 1, 150.0);
        Room room23 = new Room(23, 1, 200.0);
        Room room24 = new Room(24, 2, 250.0);
        Room room25 = new Room(25, 2, 300.0);
        Room room26 = new Room(26, 2, 350.0);
        Room room27 = new Room(27, 3, 400.0);
        Room room28 = new Room(28, 3, 450.0);
        Room room29 = new Room(29, 3, 500.0);
        Room room30 = new Room(30, 3, 550.0);
        List<Room> roomList3 = Arrays.asList(room21, room22, room23, room24, room25, room26, room27, room28, room29, room30);

        Room room31 = new Room(31, 1, 100.0);
        Room room32 = new Room(32, 1, 150.0);
        Room room33 = new Room(33, 1, 200.0);
        Room room34 = new Room(34, 2, 250.0);
        Room room35 = new Room(35, 2, 300.0);
        Room room36 = new Room(36, 2, 350.0);
        Room room37 = new Room(37, 3, 400.0);
        Room room38 = new Room(38, 3, 450.0);
        Room room39 = new Room(39, 3, 500.0);
        Room room40 = new Room(40, 3, 550.0);
        List<Room> roomList4 = Arrays.asList(room31, room32, room33, room34, room35, room36, room37, room38, room39, room40);

        Room room41 = new Room(41, 1, 100.0);
        Room room42 = new Room(42, 1, 150.0);
        Room room43 = new Room(43, 1, 200.0);
        Room room44 = new Room(44, 2, 250.0);
        Room room45 = new Room(45, 2, 300.0);
        Room room46 = new Room(46, 2, 350.0);
        Room room47 = new Room(47, 3, 400.0);
        Room room48 = new Room(48, 3, 450.0);
        Room room49 = new Room(49, 3, 500.0);
        Room room50 = new Room(50, 3, 550.0);
        List<Room> roomList5 = Arrays.asList(room41, room42, room43, room44, room45, room46, room47, room48, room49, room50);

        Room room51 = new Room(51, 1, 100.0);
        Room room52 = new Room(52, 1, 150.0);
        Room room53 = new Room(53, 1, 200.0);
        Room room54 = new Room(54, 2, 250.0);
        Room room55 = new Room(55, 2, 300.0);
        Room room56 = new Room(56, 2, 350.0);
        Room room57 = new Room(57, 3, 400.0);
        Room room58 = new Room(58, 3, 450.0);
        Room room59 = new Room(59, 3, 500.0);
        Room room60 = new Room(60, 3, 550.0);
        List<Room> roomList6 = Arrays.asList(room51, room52, room53, room54, room55, room56, room57, room58, room59, room60);

        this.save(new Hotel(1, "Radisson Hotel", "Kiev", roomList1));
        this.save(new Hotel(2, "Hyatt Regency Hotel", "Kiev", roomList2));

        this.save(new Hotel(3, "Leopolis Hotel", "Lvov", roomList3));
        this.save(new Hotel(4, "Nobilis Hotel", "Lvov", roomList4));

        this.save(new Hotel(5, "Duke Hotel Odessa", "Odessa", roomList5));
        this.save(new Hotel(6, "Bristol Hotel", "Odessa", roomList6));
    }

    public List<Hotel> getByCity(String city) {
        return this.getAll().stream()
                .filter(hotel -> hotel.getCity().toLowerCase().contains(city.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Hotel> getByName(String name) {
        return this.getAll().stream()
                .filter(hotel -> hotel.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    public Room getRoomById(long hotelId, long roomId) {
        Hotel hotel = getById(hotelId);
        if (hotel != null){
            for (Room room : hotel.getHotelRooms()){
                if (room.getId() == roomId) {
                    return room;
                }
            }
        } else printMessage("Hotel is not found in the system by id = " + hotelId + "! Please, enter another hotel!");
        return null;
    }

    public boolean bookRoom(User user, long hotelId, long roomId) {
        if (checkUserHotelRoom(user, hotelId, roomId)) {
            Room room = getRoomById(hotelId, roomId);
            room.setUserReserved(user);
            return true;
        }
        return false;
    }

    public boolean cancelRoomReservation(User user, long hotelId, long roomId) {
        if (checkUserHotelRoom(user, hotelId, roomId)) {
            Room room = getRoomById(hotelId, roomId);
            if (user.equals(room.getUserReserved())) {
                room.setUserReserved(null);
                return true;
            } else {
                printMessage(user + " did not book the room in hotel '" + getById(hotelId).getName() + "'! Please, try with another user!");
            }
        }
        return false;
    }

    private boolean checkUserHotelRoom(User user, long hotelId, long roomId){
        if (user == null) {
            printMessage("User is not found in the system! Please, register user in the system!");
            return false;
        }
        if (!user.isUserRegistered()) {
            printMessage("User is not registered in the system! Please, register user in the system!");
            return false;
        }
        Hotel hotel = getById(hotelId);
        if (hotel == null) {
            printMessage("Hotel is not found in the system by id = " + hotelId + "! Please, enter another hotel!");
            return false;
        }
        if (getRoomById(hotelId, roomId) == null) {
            printMessage("Room is not found in hotel '" + hotel.getName() + "' by id = " + roomId + "! Please, enter another room id!");
            return false;
        }
        return true;
    }

    public List<Hotel> getRooms(String city, String hotelName, double price, int persons) {

        List<Hotel> resultHotelList = new ArrayList<>();
        List<Room> roomList;
        //Select hotels with given city and hotel name. If city or hotel name is null filter returns all hotels.
        // If only one parameter given another parameter is ignored by true value in ternary operator
        List<Hotel> hotelList = getAll().stream()
                .filter(hotel -> ((city != null && city.length() > 2) ? hotel.getCity().toLowerCase().contains(city.toLowerCase()) : true) &&
                        ((hotelName != null && hotelName.length() > 2) ? hotel.getName().toLowerCase().contains(hotelName.toLowerCase()) : true))
                .collect(Collectors.toList());

        for (Hotel hotel : hotelList){
            roomList = hotel.getHotelRooms().stream()
                    .filter(room -> ((persons > 0 ? room.getPersons() == persons : true) &&
                            (price > 0 ? room.getPrice() == price : true)))
                    .collect(Collectors.toList());
            resultHotelList.add(new Hotel(hotel.getId(), hotel.getName(), hotel.getCity(), roomList));
        }
        return resultHotelList;
    }
}

