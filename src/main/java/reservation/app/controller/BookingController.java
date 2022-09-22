package reservation.app.controller;

import reservation.app.entity.Booking;
import reservation.app.entity.User;
import reservation.app.service.BookingService;

import java.util.List;

public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    public boolean reservation(Booking booking) {
        return bookingService.reservation(booking);
    }

    public List<Booking> getBooking(User user) {
        return bookingService.getBooking(user);
    }

    public boolean deleteBooking(int id) {
        return bookingService.deleteBooking(id);
    }

    public boolean deleteBooking(Booking booking) {
        return bookingService.deleteBooking(booking);

    }
}
