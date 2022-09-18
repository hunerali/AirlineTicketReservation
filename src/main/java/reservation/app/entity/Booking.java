package reservation.app.entity;

import java.util.List;
import java.util.Objects;

public class Booking {
    private int id;
    private User user;
    private Flight flight;
    private List<Passanger> passangers;

    public Booking(int id, User user, Flight flight, List<Passanger> passangers) {
        this.id = id;
        this.user = user;
        this.flight = flight;
        this.passangers = passangers;
    }

    public Booking(User user, Flight flight, List<Passanger> passangers) {
        this.user = user;
        this.flight = flight;
        this.passangers = passangers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public List<Passanger> getPassangers() {
        return passangers;
    }

    public void setPassangers(List<Passanger> passangers) {
        this.passangers = passangers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return id == booking.id && user.equals(booking.user) && flight.equals(booking.flight) && passangers.equals(booking.passangers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, flight, passangers);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", user=" + user +
                ", flight=" + flight +
                ", passangers=" + passangers +
                '}';
    }
}
