package reservation.app.utility;

import reservation.app.entity.Airlines;
import reservation.app.entity.Cities;
import reservation.app.entity.Flight;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomFlightGenerator {
    private static final Random rd = new Random();
    private int id;

    public static Airlines airline() {
        return Airlines.values()[rd.nextInt(Airlines.values().length)];
    }

    public static Cities location() {
        return Cities.values()[rd.nextInt(Cities.values().length)];
    }

    public static Cities destination() {
        return Cities.values()[rd.nextInt(Cities.values().length)];
    }

    public static LocalDateTime dateTime() {
        return LocalDateTime.of(2022,
                LocalDateTime.now().getMonth().getValue() + rd.nextInt(3) + 1,
                rd.nextInt(28) + 1,
                rd.nextInt(23) + 1, rd.nextInt(4) * 10);
    }

    public Flight generate() {
        Airlines airline = airline();
        Cities location = location();
        Cities destination = destination();
        LocalDateTime dateTime = dateTime();

        return new Flight(id++, airline, location, destination, dateTime);
    }

    public List<Flight> generateRandomFlights(int size) {
        List<Flight> flights = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Flight flight = generate();
            flights.add(flight);
        }
        return flights;
    }


}
