package reservation.app.dao;

import reservation.app.database.Database;
import reservation.app.entity.Booking;

import java.util.List;

public class BookingDAO implements DAO<Booking> {
    private final Database db;

    public BookingDAO(Database db) {
        this.db = db;
    }

    @Override
    public List<Booking> getAll() {
        return db.getBookings();
    }

    @Override
    public Booking get(int id) {
        return db.getBookings().get(id);
    }

    @Override
    public boolean create(Booking booking) {
        return db.getBookings().add(booking);
    }

    @Override
    public boolean delete(Booking booking) {
        return db.getBookings().remove(booking);
    }

    @Override
    public boolean delete(int id) {
        return db.getBookings().remove(db.getBookings().get(id));
    }
}
