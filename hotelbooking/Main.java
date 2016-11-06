package hotelbooking;

import java.util.HashMap;
import java.util.Map;

import static hotelbooking.Utils.printMessage;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hotel Online Booking System!");
        Controller controller = new Controller();
        CurrentUser currentUser = CurrentUser.getInstance();

        User user1 = new User(1, "Ivan", "Ivanov");
        User user2 = new User(2, "Petr", "Petrov");
        User user3 = new User(3, "Stepan", "Stepanov");

        printMessage("Register user1 (controller.registerUser(user1)).");
        controller.registerUser(user1);
        printMessage("Register user2 (controller.registerUser(user2)).");
        controller.registerUser(user2);

        printMessage("Try to print list of registered users (controller.getAllUsers()) when current user is not set!");
        try {
            controller.getAllUsers().forEach(System.out::println);
        } catch (NullPointerException e) {
            printMessage("Try/Catch in main() method from Main class: NullPointerException! Current user is not set so getAllUsers() method returns null!");
        }

        printMessage("Try to print list of registered users (controller.getAllUsers()) when current user is set to not registered user3!");
        printMessage("Set user3 as current user (currentUser.setCurrentUser(user3)).");
        currentUser.setCurrentUser(user3);
        try {
            controller.getAllUsers().forEach(System.out::println);
        } catch (NullPointerException e) {
            printMessage("Try/Catch in main() method from Main class: NullPointerException! Current user is user3 but he is not registered so getAllUsers() method returns null!");
        }

        printMessage("Try to print list of registered users (controller.getAllUsers()) when current user is set to registered user2!");
        printMessage("Set user2 as current user (currentUser.setCurrentUser(user2)).");
        currentUser.setCurrentUser(user2);
        printMessage("Registered users (controller.getAllUsers()):");
        try {
            controller.getAllUsers().forEach(System.out::println);
        } catch (NullPointerException e) {
            printMessage("Try/Catch in main() method from Main class: NullPointerException! There are no registered users so getAllUsers() method returns null!");
        }

        try {
            printMessage("Print all hotels from DAO (controller.getAllHotels())");
 //           controller.getAllHotels().forEach(System.out::println);
        } catch (NullPointerException e) {
            printMessage("Try/Catch in main() method from Main class: NullPointerException! Current user is is not registered so getAllHotels() method returns null!");
        }

        try {
            printMessage("Print all hotels in Kiev city (controller.findHotelByCity(\"Kiev\"))!");
            controller.findHotelByCity("Kiev").forEach(System.out::println);
            printMessage("Print all hotels in Nikolaev city (controller.findHotelByCity(\"Nikolaev\"))!");
            controller.findHotelByCity("Nikolaev").forEach(System.out::println);
            printMessage("Print all hotels by hotel name Bristol (controller.findHotelByName(\"Bristol\"))!");
            controller.findHotelByName("Bristol").forEach(System.out::println);
            printMessage("Print all hotels by hotel name Hilton (controller.findHotelByName(\"Hilton\"))!");
            controller.findHotelByName("Hilton").forEach(System.out::println);
        } catch (Exception e) {
            printMessage("Try/Catch in main() method from Main class: NullPointerException! There are no registered users or current user is not set so findHotelByCity() method returns null!");
        }

        Map<String, String> map = new HashMap<>();
        map.put("persons", "2");
        map.put("price", "300");
        map.put("city", "Kiev");
        map.put("hotelName", "Radisson");
        try {
            printMessage("Print all hotels by given parameters in map persons = 2, price = 300, city = 'Kiev', hotelName = 'Radisson' (controller.findRoom(map))!");
            controller.findRoom(map).forEach(System.out::print);
        } catch (NullPointerException e) {
            printMessage("Try/Catch in main() method from Main class: NullPointerException! There are no registered users or current user is not set so findRoom() method returns null!");
        }

        map.clear();
        //map.put("persons", "2");
        map.put("price", "100");
        map.put("city", "Kiev");
        //map.put("hotelName", "Radisson");
        try {
            printMessage("Print all hotels by given parameters in map price = 100, city = 'Kiev' (controller.findRoom(map))!");
            controller.findRoom(map).forEach(System.out::print);
        } catch (NullPointerException e) {
            printMessage("Try/Catch in main() method from Main class: NullPointerException! There are no registered users or current user is not set so findRoom() method returns null!");
        }


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





/*        try {
            controller.findHotelByCity("Kiev").forEach(System.out::println);
        } catch (NullPointerException e) {
            System.out.println("Found 0 hotels in Kiev.");
        }*/
    }
}
