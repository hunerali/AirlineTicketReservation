package reservation.app.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reservation.app.dao.FlightDAO;
import reservation.app.database.Database;
import reservation.app.entity.Airlines;
import reservation.app.entity.Cities;
import reservation.app.entity.Flight;
import reservation.app.service.FlightService;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class FlightControllerTest {
    private FlightController controller;
    private Flight flight;
    private Flight flight1;

    @BeforeEach
    void startUp() throws FileNotFoundException {
        Database database = new Database();
        FlightDAO dao = new FlightDAO(database);
        FlightService service = new FlightService(dao);
        controller = new FlightController(service);
        database.startUp();
        flight = database.getFlights().get(0);
        flight1 =
                new Flight(78, Airlines.AMERICAN_AIRLINES, Cities.ABU_DABI, Cities.KIEV, LocalDateTime.now());

    }

    @Test
    void testGetAll() {
        assertEquals(30, controller.getAllFlights().size());
    }

    @Test
    void testCreateFlight() {
        assertTrue(controller.create(flight1));
    }



}