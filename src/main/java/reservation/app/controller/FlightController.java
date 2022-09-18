package reservation.app.controller;

import reservation.app.service.FlightService;

public class FlightController {
    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }
}
