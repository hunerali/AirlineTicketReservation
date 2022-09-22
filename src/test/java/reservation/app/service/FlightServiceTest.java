package reservation.app.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reservation.app.dao.FlightDAO;
import reservation.app.database.Database;
import reservation.app.entity.Flight;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class FlightServiceTest {
    private FlightService service;
    private Flight flight;

    @BeforeEach
    void startUp() throws FileNotFoundException {
        Database database = new Database();
        FlightDAO dao = new FlightDAO(database);
        service = new FlightService(dao);
        database.startUp();
        flight = database.getFlights().get(0);
    }

    @Test
    void testGetAll() {
        assertEquals(30, service.getAllFlights().size());
    }

    @Test
    void testGetFlight() {
        assertEquals(flight, service.getAllFlights().get(0));
    }


}