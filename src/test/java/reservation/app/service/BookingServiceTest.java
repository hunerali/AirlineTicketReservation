package reservation.app.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reservation.app.dao.BookingDAO;
import reservation.app.database.Database;
import reservation.app.entity.Booking;
import reservation.app.entity.Flight;
import reservation.app.entity.Passanger;
import reservation.app.entity.User;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookingServiceTest {
    private BookingService service;
    private User user;
    private Flight flight;
    List<Passanger> passangers;
    Booking booking;

    @BeforeEach
    void startUp() throws FileNotFoundException {
        Database database = new Database();
        BookingDAO dao = new BookingDAO(database);
        service = new BookingService(dao);
        database.startUp();
        user = database.getUsers().get(0);
        flight = database.getFlights().get(0);
        passangers = new ArrayList<>(List.of(new Passanger(1, "huner", "aliyev")));
        booking = new Booking(1, user, flight, passangers);

    }

    @Test
    void testGetAll() {
        service.reservation(booking);
        assertEquals(1, service.getAllBookings().size());
    }

    @Test
    void testReservation() {
        assertTrue(service.reservation(booking));
    }

    @Test
    void testDeleteBooking() {
        service.reservation(booking);
        assertTrue(service.deleteBooking(booking));
    }

}