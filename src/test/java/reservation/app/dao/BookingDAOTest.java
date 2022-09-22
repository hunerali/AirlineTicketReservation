package reservation.app.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reservation.app.database.Database;
import reservation.app.entity.Booking;
import reservation.app.entity.Flight;
import reservation.app.entity.Passanger;
import reservation.app.entity.User;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookingDAOTest {

    private Database database;
    private BookingDAO dao;

    private Flight flight;
    private User user;
    List<Passanger> passangers;

    @BeforeEach
    void startUp() throws FileNotFoundException {
        database = new Database();
        dao = new BookingDAO(database);
        database.startUp();
        flight = database.getFlights().get(0);
        user = new User(1, "huner", "1234");
        passangers = new ArrayList<>(List.of(new Passanger(1, "hunar", "aliyev")));

    }

    @Test
    void testGetAll() {
        assertEquals(0, dao.getAll().size());
    }

    @Test
    void testCreateBooking() {
        Booking b = new Booking(1, user, flight, passangers);
        assertTrue(dao.create(b));
    }

    @Test
    void testDeleteBooking(){
        Booking b = new Booking(1, user, flight, passangers);
        dao.create(b);
        assertTrue(dao.delete(b));
    }


}