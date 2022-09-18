package reservation.app.service;

import reservation.app.dao.FlightDAO;
import reservation.app.entity.Flight;

import java.util.List;
import java.util.stream.Collectors;

public class FlightService {
    private final FlightDAO flightDAO;

    public FlightService(FlightDAO flightDAO) {
        this.flightDAO = flightDAO;
    }

    public List<Flight> getAllFlights(){
        return flightDAO.getAll();
    }

    public boolean create(Flight flight){
        return flightDAO.create(flight);
    }

    public Flight getFlight(int id){
        return flightDAO.get(id);
    }
    public List<Flight> getAllFlightsForDestination(String cityTo, String cityFrom){
        return flightDAO.getAll().stream()
                .filter(flight -> flight.getDestination().equals(cityTo)
                        && flight.getLocation().equals(cityFrom))
                .collect(Collectors.toList());
    }

    public boolean deleteFlight(int id){
        return flightDAO.delete(id);
    }


}
