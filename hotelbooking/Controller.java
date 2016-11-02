package hotelbooking;

import java.util.List;
import java.util.Map;

public class Controller {

    static UserDAO userDAO = new UserDAO();
    static HotelDAO hotelDAO = new HotelDAO();

    User registerUser(User user) {
        user.setUserRegistered(true);
        return userDAO.save(user);
    }

    List<Hotel> findHotelByName(String name) {
        return hotelDAO.getByName(name);
    }

    List<Hotel> findHotelByCity(String city) {
        return hotelDAO.getByCity(city);
    }

    boolean bookRoom(long roomId, long userId, long hotelId) {
        User user = userDAO.getById(userId);
        return hotelDAO.bookRoom(user, hotelId, roomId);
    }

    boolean cancelReservation(long roomId, long userId, long hotelId) {
        User user = userDAO.getById(userId);
        return hotelDAO.cancelRoomReservation(user, hotelId, roomId);
    }

    List<Hotel> findRoom(Map<String, String> params) {




        return null;
    }

    List<User> getAllUsers() {
        return userDAO.getAll();
    }

    List<Hotel> getAllHotels() {
        return hotelDAO.getAll();
    }

    Hotel getHotelById(long hotelId) {
        return hotelDAO.getById(hotelId);
    }


}
