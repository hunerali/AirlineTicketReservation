package reservation.app.dao;

import reservation.app.entity.Booking;

import java.util.List;

public class BookingDAO implements DAO<Booking> {

    @Override
    public List<Booking> getAll() {
        return null;
    }

    @Override
    public Booking get(int id) {
        return null;
    }

    @Override
    public boolean create(Booking booking) {
        return false;
    }

    @Override
    public boolean delete(Booking booking) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
