package hotelbooking;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        List<Room> roomList = Arrays.asList(room1, room2, room3, room4, room5, room6, room7, room8, room9, room10);

        this.save(new Hotel(1, "Radisson Hotel", "Kiev", roomList));
        this.save(new Hotel(2, "Hyatt Regency Hotel", "Kiev", roomList));

        this.save(new Hotel(3, "Leopolis Hotel", "Lvov", roomList));
        this.save(new Hotel(4, "Nobilis Hotel", "Lvov", roomList));

        this.save(new Hotel(5, "Duke Hotel Odessa", "Odessa", roomList));
        this.save(new Hotel(6, "Bristol Hotel", "Odessa", roomList));
    }

    public List<Hotel> getByCity(String city) {
        return this.getAll().stream()
                .filter(hotel -> hotel.getCity().toLowerCase().contains(city.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public Hotel getById(long id) {
        return super.getById(id);
    }

    @Override
    public List<Hotel> getAll() {
        return super.getAll();
    }

    @Override
    public Hotel save(Hotel hotel) {
        return super.save(hotel);
    }

    @Override
    public void saveAll(List<Hotel> t) {
        super.saveAll(t);
    }

    @Override
    public void delete(Hotel hotel) {
        super.delete(hotel);
    }

    @Override
    public void deleteAll(List<Hotel> t) {
        super.deleteAll(t);
    }

    @Override
    public void deleteById(long id) {
        super.deleteById(id);
    }

}

