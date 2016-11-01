package hotelbooking;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hotel Online Booking System!");

        User user1 = new User(1, "Ivan", "Ivanov");
        User user2 = new User(2, "Petr", "Petrov");
        User user3 = new User(3, "Stepan", "Stepanov");


        Controller controller = new Controller();

        controller.registerUser(user1);
        controller.registerUser(user2);

        controller.userDAO.getAll().forEach(System.out::println);

        //controller.hotelDAO.getAll().forEach(System.out::println);

        controller.findHotelByCity("Kiev").forEach(System.out::println);
        try {
            controller.findHotelByCity("Kiev").forEach(System.out::println);
        } catch (NullPointerException e) {
            System.out.println("Found 0 hotels in Kiev.");
        }


    }
}
