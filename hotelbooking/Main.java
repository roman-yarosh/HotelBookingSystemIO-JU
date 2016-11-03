package hotelbooking;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hotel Online Booking System!");

        User user1 = new User(1, "Ivan", "Ivanov");
        User user2 = new User(2, "Petr", "Petrov");
        User user3 = new User(3, "Stepan", "Stepanov");

        Controller controller = new Controller();

        controller.registerUser(user1);
        controller.registerUser(user2);

        controller.getAllUsers().forEach(System.out::println);

        Map<String, String> map = new HashMap<>();
        map.put("persons", "2");
        map.put("price", "300");
        map.put("city", "Kiev");
        map.put("hotelName", "Radisson");
        controller.findRoom(map).forEach(System.out::print);

        //controller.getAllHotels().forEach(System.out::println);

        long hotelId = 6;
        long userId = 2;
        long roomId = 55;

//        if (controller.bookRoom(roomId, userId, hotelId)) System.out.println(controller.getHotelById(hotelId));

        roomId = 53;
//        if (controller.bookRoom(roomId, userId, hotelId)) System.out.println(controller.getHotelById(hotelId));

        userId = 2;
        roomId = 53;
//        if (controller.cancelReservation(roomId, userId, hotelId)) System.out.println(controller.getHotelById(hotelId));

     /*   hotelId = 150;
        try {
            controller.getHotelById(hotelId).getHotelRooms().get(2).setUserReserved(user2);
        } catch (NullPointerException e) {
            System.out.println("No Hotel with id = " + hotelId + "!");;
        }


        controller.getAllHotels().forEach(System.out::println);
*/
//        controller.findHotelByCity("Kiev").forEach(System.out::println);
//        controller.findHotelByCity("Odessa").forEach(System.out::println);
//        controller.findHotelByCity("Lvov").forEach(System.out::println);

        //controller.findHotelByName("Leopolis").forEach(System.out::println);
        //controller.findHotelByName("Hyatt").forEach(System.out::println);
        //controller.findHotelByName("Nobilis").forEach(System.out::println);


/*        try {
            controller.findHotelByCity("Kiev").forEach(System.out::println);
        } catch (NullPointerException e) {
            System.out.println("Found 0 hotels in Kiev.");
        }*/


    }
}
