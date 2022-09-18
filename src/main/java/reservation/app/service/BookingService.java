package reservation.app.service;

import reservation.app.dao.BookingDAO;
import reservation.app.dao.UserDAO;

public class BookingService {
    private final BookingDAO bookingDAO;

    public BookingService(BookingDAO bookingDAO ) {
        this.bookingDAO = bookingDAO;
    }
}
