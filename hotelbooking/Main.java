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
            controller.getAllHotels().forEach(System.out::println);
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
            printMessage("\nPrint all hotels by given parameters in map persons = 2, price = 300, city = 'Kiev', hotelName = 'Radisson' (controller.findRoom(map))!");
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
            printMessage("\nPrint all hotels by given parameters in map price = 100, city = 'Kiev' (controller.findRoom(map))!");
            controller.findRoom(map).forEach(System.out::print);
        } catch (NullPointerException e) {
            printMessage("Try/Catch in main() method from Main class: NullPointerException! There are no registered users or current user is not set so findRoom() method returns null!");
        }

        long hotelId = 7;
        long userId = currentUser.getCurrentUser().getId();
        long roomId = 1;

        if (controller.bookRoom(roomId, userId, hotelId)) {
            printMessage("\nPrint hotel with reserved room by given parameters hotelId = " + hotelId + ", roomId = " + roomId + ", userId = " + userId + "\n" +
            controller.getHotelById(hotelId).toString());
        } else {
            printMessage("No rooms found by given parameters hotelId = " + hotelId + ", roomId = " + roomId + ", userId = " + userId);
        }

        hotelId = 1;
        userId = currentUser.getCurrentUser().getId();
        roomId = 1;

        if (controller.bookRoom(roomId, userId, hotelId)) {
            printMessage("\nPrint hotel with reserved room by given parameters hotelId = " + hotelId + ", roomId = " + roomId + ", userId = " + userId + "\n" +
                    controller.getHotelById(hotelId).toString());
        }


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


        /*System output:
        Hotel Online Booking System!

        Register user1 (controller.registerUser(user1)).

        Register user2 (controller.registerUser(user2)).

        Try to print list of registered users (controller.getAllUsers()) when current user is not set!

        Try/Catch in isUserRegistered() method from the Controller class: NullPointerException! Current user is not set!

        Try/Catch in main() method from Main class: NullPointerException! Current user is not set so getAllUsers() method returns null!

        Try to print list of registered users (controller.getAllUsers()) when current user is set to not registered user3!

        Set user3 as current user (currentUser.setCurrentUser(user3)).

        Current user is User{userId=3, firstName='Stepan', lastName='Stepanov', userRegistered=false}

        Current user is not registered! Please, register user in the system! User{userId=3, firstName='Stepan', lastName='Stepanov', userRegistered=false}

        Try/Catch in main() method from Main class: NullPointerException! Current user is user3 but he is not registered so getAllUsers() method returns null!

        Try to print list of registered users (controller.getAllUsers()) when current user is set to registered user2!

        Set user2 as current user (currentUser.setCurrentUser(user2)).

        Current user is User{userId=2, firstName='Petr', lastName='Petrov', userRegistered=true}

        Registered users (controller.getAllUsers()):
        User{userId=1, firstName='Ivan', lastName='Ivanov', userRegistered=true}
        User{userId=2, firstName='Petr', lastName='Petrov', userRegistered=true}

        Print all hotels from DAO (controller.getAllHotels())

        Print all hotels in Kiev city (controller.findHotelByCity("Kiev"))!

        Hotel{hotelId=1, hotelName='Radisson Hotel', hotelCity='Kiev', hotelRooms=[
        Room{roomId=1, persons=1, price=100.0, userReserved=null},
        Room{roomId=2, persons=1, price=150.0, userReserved=null},
        Room{roomId=3, persons=1, price=200.0, userReserved=null},
        Room{roomId=4, persons=2, price=250.0, userReserved=null},
        Room{roomId=5, persons=2, price=300.0, userReserved=null},
        Room{roomId=6, persons=2, price=350.0, userReserved=null},
        Room{roomId=7, persons=3, price=400.0, userReserved=null},
        Room{roomId=8, persons=3, price=450.0, userReserved=null},
        Room{roomId=9, persons=3, price=500.0, userReserved=null},
        Room{roomId=10, persons=3, price=550.0, userReserved=null}]}

        Hotel{hotelId=2, hotelName='Hyatt Regency Hotel', hotelCity='Kiev', hotelRooms=[
        Room{roomId=11, persons=1, price=100.0, userReserved=null},
        Room{roomId=12, persons=1, price=150.0, userReserved=null},
        Room{roomId=13, persons=1, price=200.0, userReserved=null},
        Room{roomId=14, persons=2, price=250.0, userReserved=null},
        Room{roomId=15, persons=2, price=300.0, userReserved=null},
        Room{roomId=16, persons=2, price=350.0, userReserved=null},
        Room{roomId=17, persons=3, price=400.0, userReserved=null},
        Room{roomId=18, persons=3, price=450.0, userReserved=null},
        Room{roomId=19, persons=3, price=500.0, userReserved=null},
        Room{roomId=20, persons=3, price=550.0, userReserved=null}]}

        Print all hotels in Nikolaev city (controller.findHotelByCity("Nikolaev"))!

        Print all hotels by hotel name Bristol (controller.findHotelByName("Bristol"))!

        Hotel{hotelId=6, hotelName='Bristol Hotel', hotelCity='Odessa', hotelRooms=[
        Room{roomId=51, persons=1, price=100.0, userReserved=null},
        Room{roomId=52, persons=1, price=150.0, userReserved=null},
        Room{roomId=53, persons=1, price=200.0, userReserved=null},
        Room{roomId=54, persons=2, price=250.0, userReserved=null},
        Room{roomId=55, persons=2, price=300.0, userReserved=null},
        Room{roomId=56, persons=2, price=350.0, userReserved=null},
        Room{roomId=57, persons=3, price=400.0, userReserved=null},
        Room{roomId=58, persons=3, price=450.0, userReserved=null},
        Room{roomId=59, persons=3, price=500.0, userReserved=null},
        Room{roomId=60, persons=3, price=550.0, userReserved=null}]}

        Print all hotels by hotel name Hilton (controller.findHotelByName("Hilton"))!

        Print all hotels by given parameters in map persons = 2, price = 300, city = 'Kiev', hotelName = 'Radisson' (controller.findRoom(map))!

        Hotel{hotelId=1, hotelName='Radisson Hotel', hotelCity='Kiev', hotelRooms=[
        Room{roomId=5, persons=2, price=300.0, userReserved=null}]}
        Print all hotels by given parameters in map price = 100, city = 'Kiev' (controller.findRoom(map))!

        Hotel{hotelId=1, hotelName='Radisson Hotel', hotelCity='Kiev', hotelRooms=[
        Room{roomId=1, persons=1, price=100.0, userReserved=null}]}
        Hotel{hotelId=2, hotelName='Hyatt Regency Hotel', hotelCity='Kiev', hotelRooms=[
        Room{roomId=11, persons=1, price=100.0, userReserved=null}]}
         */
    }
}
