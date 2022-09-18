package reservation.app.database;

import reservation.app.entity.Booking;
import reservation.app.entity.Flight;
import reservation.app.entity.User;
import reservation.app.utility.RandomFlightGenerator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private final File fileU = new File("users.bin");
    private final File fileB = new File("booking.bin");
    private final File fileF = new File("flights.bin");

    private List<Booking> bookings = new ArrayList<>();
    private List<Flight> flights = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    public List<Booking> getBookings() {
        return bookings;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public List<User> getUsers() {
        return users;
    }

    public void save(File file, List list) throws FileNotFoundException {
        try (ObjectOutputStream write = new ObjectOutputStream(new FileOutputStream(file))) {
            write.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(File file, List list) throws FileNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            list.addAll((List) in.readObject());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void startUp() throws FileNotFoundException {
        RandomFlightGenerator randomFlightGenerator = new RandomFlightGenerator();
        if (fileB.exists()) load(fileB, bookings);
        if (fileU.exists()) load(fileU, users);
        if (fileF.exists()) {
            load(fileF, flights);
        } else {
            flights.addAll(randomFlightGenerator.generateRandomFlights(30));
            save(fileF, flights);
        }
    }

    public void shutDown() throws FileNotFoundException {
        save(fileF, flights);
        save(fileU, users);
        save(fileB, bookings);
    }


}
