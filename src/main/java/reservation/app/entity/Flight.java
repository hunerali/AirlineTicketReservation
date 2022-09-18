package reservation.app.entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class Flight {
    private int id;
    private Airlines airline;
    private Cities location;
    private Cities destination;
    private LocalDateTime flightTime;

    public Flight(int id, Airlines airline, Cities location, Cities destination, LocalDateTime flightTime) {
        this.id = id;
        this.airline = airline;
        this.location = location;
        this.destination = destination;
        this.flightTime = flightTime;
    }

    public Flight(Airlines airline, Cities location, Cities destination, LocalDateTime flightTime) {
        this.airline = airline;
        this.location = location;
        this.destination = destination;
        this.flightTime = flightTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Airlines getAirline() {
        return airline;
    }

    public void setAirline(Airlines airline) {
        this.airline = airline;
    }

    public Cities getLocation() {
        return location;
    }

    public void setLocation(Cities location) {
        this.location = location;
    }

    public Cities getDestination() {
        return destination;
    }

    public void setDestination(Cities destination) {
        this.destination = destination;
    }

    public LocalDateTime getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(LocalDateTime flightTime) {
        this.flightTime = flightTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return id == flight.id && airline == flight.airline && location == flight.location && destination == flight.destination && flightTime.equals(flight.flightTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, airline, location, destination, flightTime);
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", airline=" + airline +
                ", location=" + location +
                ", destination=" + destination +
                ", flightTime=" + flightTime +
                '}';
    }
}
