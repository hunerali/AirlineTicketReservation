package reservation.app.dao;

import reservation.app.database.Database;
import reservation.app.entity.Flight;

import java.util.List;

public class FlightDAO implements DAO<Flight> {
    private final Database database;

    public FlightDAO(Database database) {
        this.database = database;
    }

    @Override
    public List<Flight> getAll() {
        return database.getFlights();
    }

    @Override
    public Flight get(int id) {
        return database.getFlights().get(id);
    }

    @Override
    public boolean create(Flight flight) {
        return database.getFlights().add(flight);
    }

    @Override
    public boolean delete(Flight flight) {
        return database.getFlights().remove(flight);
    }

    @Override
    public boolean delete(int id) {
        return database.getFlights().remove(database.getFlights().remove(id));
    }
}
