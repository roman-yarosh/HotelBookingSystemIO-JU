package hotelbooking;

import java.util.List;
import java.util.Map;

public class Controller {

    User registerUser(User user) {
        return UserDAO.save(user);
    }

    List<Hotel> findHotelByName(String name) {
        return null;
    }

    List<Hotel> findHotelByCity(String city) {
        return null;
    }

    void bookRoom(long roomId, long userId, long hotelId) {

    }

    void cancelReservation(long roomId, long userId, long hotelId) {

    }

    List<Hotel> findRoom(Map<String, String> params) {
        return null;
    }


}
