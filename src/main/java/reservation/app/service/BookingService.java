package reservation.app.service;

import reservation.app.dao.BookingDAO;
import reservation.app.entity.Booking;
import reservation.app.entity.User;

import java.util.List;
import java.util.stream.Collectors;

public class BookingService {
    private final BookingDAO bookingDAO;

    public BookingService(BookingDAO bookingDAO) {
        this.bookingDAO = bookingDAO;
    }

    public List<Booking> getAllBookings() {
        return bookingDAO.getAll();
    }

    public boolean reservation(Booking booking) {
        return bookingDAO.create(booking);
    }

    public List<Booking> getBooking(User user) {
        return bookingDAO.getAll().stream()
                .filter(booking -> booking.getUser().equals(user))
                .collect(Collectors.toList());
    }

    public boolean deleteBooking(int id){
        return bookingDAO.delete(id);
    }

    public boolean deleteBooking(Booking booking){
        return bookingDAO.delete(booking);
    }
}
