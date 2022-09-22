package reservation.app.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reservation.app.dao.BookingDAO;
import reservation.app.database.Database;
import reservation.app.entity.Booking;
import reservation.app.entity.Flight;
import reservation.app.entity.Passanger;
import reservation.app.entity.User;
import reservation.app.service.BookingService;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookingControllerTest {
    private BookingController controller;
    private Flight flight;
    private User user;
    private Booking booking;
    private List<Passanger> passangers;

    @BeforeEach
    void startUp() throws FileNotFoundException {
        Database database = new Database();
        BookingDAO dao = new BookingDAO(database);
        BookingService service = new BookingService(dao);
        database.startUp();
        user = database.getUsers().get(0);
        flight = database.getFlights().get(0);
        controller = new BookingController(service);
        passangers = new ArrayList<>(List.of(new Passanger(1, "huner", "aliyev")));
        booking = new Booking(1, user, flight, passangers);
    }

    @Test
    void testGetAll() {
        controller.reservation(booking);
        assertEquals(1, controller.getAllBookings().size());
    }

    @Test
    void testReservation() {
        assertTrue(controller.reservation(booking));
    }

    @Test
    void testDeletingBooking() {
        controller.reservation(booking);
        assertTrue(controller.deleteBooking(booking));
    }

}