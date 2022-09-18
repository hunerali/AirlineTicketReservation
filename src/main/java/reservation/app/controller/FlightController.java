package reservation.app.controller;

import reservation.app.entity.Flight;
import reservation.app.service.FlightService;

import java.util.List;
import java.util.stream.Collectors;

public class FlightController {
    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }
    public List<Flight> getAllFlights(){
        return flightService.getAllFlights();
    }

    public boolean create(Flight flight){
        return flightService.create(flight) ;
    }

    public Flight getFlight(int id){
        return flightService.getFlight(id);
    }
    public List<Flight> getAllFlightsForDestination(String cityTo, String cityFrom){
        return flightService.getAllFlightsForDestination(cityTo,cityFrom);
    }

    public boolean deleteFlight(int id){
        return flightService.deleteFlight(id);
    }
}
