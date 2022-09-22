package reservation.app.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reservation.app.database.Database;
import reservation.app.entity.Flight;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class FlightDAOTest {

    private Database database;
    private Flight flight;
    private FlightDAO dao;

    @BeforeEach
    void startUp() throws FileNotFoundException {
        database = new Database();
        dao = new FlightDAO(database);
        database.startUp();
        flight = database.getFlights().get(0);
    }

    @Test
    void testGetAll() {
        assertEquals(30, dao.getAll().size());
    }

    @Test
    void getFlight() {
        assertEquals(flight, dao.getAll().get(0));
    }

    @Test
    void testDeleteFlight() {
        assertTrue(dao.delete(flight));
    }

}