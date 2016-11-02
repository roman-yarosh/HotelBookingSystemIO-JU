package hotelbooking;

import java.util.ArrayList;
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

    //city - Kiev, hotelName - Radisson, price - 200, persons - 2
    List<Hotel> findRoom(Map<String, String> params) {
        List<Hotel> hotelList = new ArrayList<>();
        String city;
        String hotelName;
        double price = 0;
        int persons = 0;

        for(Map.Entry<String, String> paramsEntry : params.entrySet()) {
            try {
                if (paramsEntry.getKey() != null && paramsEntry.getValue() != null && paramsEntry.getKey().toLowerCase().contains("city")) {
                    city = paramsEntry.getValue();
                }
                if (paramsEntry.getKey() != null && paramsEntry.getValue() != null && paramsEntry.getKey().toLowerCase().contains("name")) {
                    hotelName = paramsEntry.getValue();
                }
                if (paramsEntry.getKey() != null && paramsEntry.getValue() != null && paramsEntry.getKey().toLowerCase().contains("price")) {
                    try {
                        price = Double.valueOf(paramsEntry.getValue());
                    } catch (NumberFormatException e) {
                        price = 0;
                    }
                }
                if (paramsEntry.getKey() != null && paramsEntry.getValue() != null && paramsEntry.getKey().toLowerCase().contains("person")) {
                    try {
                        persons = Integer.parseInt(paramsEntry.getValue());
                    } catch (NumberFormatException e) {
                        persons =0;
                    }
                }
            } catch (NullPointerException e){
                System.err.println("NullPointerException exception in findRoom() in foreach map parameters!");
            }
        }

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
