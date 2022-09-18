package reservation.app.dao;

import reservation.app.entity.Flight;

import java.util.List;

public class FlightDAO implements DAO<Flight> {
    @Override
    public List<Flight> getAll() {
        return null;
    }

    @Override
    public Flight get(int id) {
        return null;
    }

    @Override
    public boolean create(Flight flight) {
        return false;
    }

    @Override
    public boolean delete(Flight flight) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
