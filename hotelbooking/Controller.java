package hotelbooking;

import java.util.List;
import java.util.Map;

public class Controller {

    UserDAO userDAO = new UserDAO();
    HotelDAO hotelDAO = new HotelDAO();

    User registerUser(User user) {
        user.setUserRegistered(true);
        return userDAO.save(user);
    }

    List<Hotel> findHotelByName(String name) {
        //hotelDAO.
        return null;
    }

    List<Hotel> findHotelByCity(String city) {
        return hotelDAO.getByCity(city);
    }

    void bookRoom(long roomId, long userId, long hotelId) {

    }

    void cancelReservation(long roomId, long userId, long hotelId) {

    }

    List<Hotel> findRoom(Map<String, String> params) {
        return null;
    }


}
