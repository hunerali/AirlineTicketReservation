package reservation.app.service;

import reservation.app.dao.BookingDAO;
import reservation.app.dao.FlightDAO;

public class FlightService {
    private final FlightDAO flightDAO;

    public FlightService(FlightDAO flightDAO) {
        this.flightDAO = flightDAO;
    }
}
