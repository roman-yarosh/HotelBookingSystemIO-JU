package hotelbooking;

import java.util.List;
import java.util.Map;

import static hotelbooking.Utils.printMessage;

public class Controller {

    static UserDAO userDAO = new UserDAO();
    static HotelDAO hotelDAO = new HotelDAO();

    private CurrentUser currentUser;

    public Controller() {
        this.currentUser = CurrentUser.getInstance();
    }

    User registerUser(User user) {
        user.setUserRegistered(true);
        return userDAO.save(user);
    }

    List<Hotel> findHotelByName(String name) {
        if (isUserRegistered())
            return hotelDAO.getByName(name);
        else
            return null;
    }

    List<Hotel> findHotelByCity(String city) {
        if (isUserRegistered())
            return hotelDAO.getByCity(city);
        else
            return null;
    }

    boolean bookRoom(long roomId, long userId, long hotelId) {
        if (isUserRegistered()) {
            User user = userDAO.getById(userId);
            return hotelDAO.bookRoom(user, hotelId, roomId);
        } else
            return false;
    }

    boolean cancelReservation(long roomId, long userId, long hotelId) {
        if (isUserRegistered()) {
            User user = userDAO.getById(userId);
            return hotelDAO.cancelRoomReservation(user, hotelId, roomId);
        } else
            return false;
    }

        //Example for map: city - Kiev, hotelName - Radisson, price - 200, persons - 2
        List<Hotel> findRoom (Map < String, String > params){
            String city = null;
            String hotelName = null;
            double price = 0;
            int persons = 0;

            if (isUserRegistered()) {
                for (Map.Entry<String, String> paramsEntry : params.entrySet()) {
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
                                persons = 0;
                            }
                        }
                    } catch (NullPointerException e) {
                        System.err.println("NullPointerException exception in findRoom() in foreach map parameters!");
                    }
                }
                return hotelDAO.getRooms(city, hotelName, price, persons);
            } else
                return null;
        }

    public boolean isUserRegistered() {
        boolean userRegistered = currentUser.getCurrentUser().isUserRegistered();
        if (!userRegistered) printMessage("Current user is not registered! Please, register user is system!");
        return userRegistered;
    }

    List<User> getAllUsers() {
        if (isUserRegistered()) {
            return userDAO.getAll();
        } else
            return null;
    }

    List<Hotel> getAllHotels() {
        if (isUserRegistered()) {
            return hotelDAO.getAll();
        } else
            return null;
    }

    Hotel getHotelById(long hotelId) {
        if (isUserRegistered()) {
            return hotelDAO.getById(hotelId);
        } else
            return null;
    }
}
