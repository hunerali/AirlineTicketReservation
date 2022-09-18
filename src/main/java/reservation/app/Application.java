package reservation.app;

import reservation.app.controller.BookingController;
import reservation.app.controller.FlightController;
import reservation.app.controller.UserController;
import reservation.app.dao.BookingDAO;
import reservation.app.dao.FlightDAO;
import reservation.app.dao.UserDAO;
import reservation.app.database.Database;
import reservation.app.entity.Booking;
import reservation.app.entity.Flight;
import reservation.app.entity.Passanger;
import reservation.app.entity.User;
import reservation.app.service.BookingService;
import reservation.app.service.FlightService;
import reservation.app.service.UserService;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Application {
    Database database = new Database();

    private UserController userController = configurationUser(database);
    private BookingController bookingController = configurationBooking(database);
    private FlightController flightController = configurationFlight(database);

    {
        try {
            database.startUp();
        } catch (FileNotFoundException e) {
            System.out.println("Something went wrong");
        }
    }

    public boolean run() throws FileNotFoundException {
        guestMenu();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter command: ");
        String command = sc.nextLine();
        switch (command) {
            case "1":
                register();
                break;

            case "2":
                User u = login();
                userRun(u);
                break;

            case "3":
                flightController.getAllFlights().forEach(System.out::println);
                break;

            case "4":
                System.out.println("Application shutted down");
                database.shutDown();
                return false;

            default:
                System.out.println("No such command");

        }
        return true;
    }

    private void guestMenu() {
        System.out.println("\n1.Registration\n" +
                "2.Login\n" +
                "3.View TimeTable\n" +
                "4.Exit");
    }

    private void userMenu() {
        System.out.println("1.View TimeTable\n" +
                "2.Make Reservation\n" +
                "3.Cancel Reservation\n" +
                "4.View Bookings\n" +
                "5.Log out");
    }

    private void register() {
        int userId = 1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Set user name: ");
        String un = sc.nextLine();
        System.out.println("Set password: ");
        String p = sc.nextLine();
        User newUser = new User(userId++, un, p);
        userController.register(newUser);
    }

    private User login() {
        User u = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter user name: ");
        String un = sc.nextLine();
        System.out.println("Enter password: ");
        String p = sc.nextLine();
        if (!userController.login(un, p)) {
            System.out.println("Username or password is invalid");
        } else {
            Iterator<User> iterator = userController.getAllUsers().iterator();
            while (iterator.hasNext()) {
                u = iterator.next();
                if (u.getUsername().equals(un) && u.getPassword().equals(p)) {
                    return u;
                }
            }
        }
        return u;
    }

    public boolean userMenuCase(User user) throws FileNotFoundException {
        userMenu();
        System.out.println("Enter command: ");
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();
        switch (command) {
            case "1": {
                flightController.getAllFlights().forEach(System.out::println);
                break;
            }
            case "2": {
                doReservation(user);
                break;
            }
            case "3": {
                deleteReservation(user);
                break;
            }
            case "4": {
                viewBookings(user);
                break;
            }
            case "5": {
                System.out.println("Logged out");
                database.shutDown();
                return false;
            }
            default:
                System.out.println("No such command!");
        }
        return true;
    }

    private void userRun(User user) throws FileNotFoundException {
        while (userMenuCase(user))
            if (!userMenuCase(user)) {
                break;
            }
    }

    private void doReservation(User user) {
        int bookingId = 1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter location: ");
        String location = sc.nextLine();
        System.out.println("Enter destination: ");
        String destination = sc.nextLine();
        Flight flight = null;
        Iterator<Flight> iterator = flightController.getAllFlights().iterator();
        while (iterator.hasNext()) {
            Flight f = iterator.next();
            if (f.getLocation().name().equalsIgnoreCase(location)
                    && f.getDestination().name().equalsIgnoreCase(destination)) {
                flight = f;
            }
        }
        List<Passanger> list = new ArrayList<>();
        list.addAll(passangers());
        Booking b = new Booking(bookingId++, user, flight, list);
        bookingController.reservation(b);
        user.getBookings().add(b);
    }

    private void deleteReservation(User user) {
        System.out.println("Your reservations: ");
        user.getBookings().forEach(x -> {
            System.out.println(user.getBookings().indexOf(x) + " " + x);
        });
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ID for cancellation: ");
        int id = sc.nextInt();
        if (user.getBookings().size() > id) {
            user.getBookings().remove(user.getBookings().get(id));
        }

    }

    private void viewBookings(User user) {
        user.getBookings().forEach(System.out::println);
    }

    private List<Passanger> passangers() {
        int passangerId = 1;
        List<Passanger> passangerList = new ArrayList<>();
        System.out.println("Enter passanger count for reservation: ");
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        for (int i = 0; i < count; i++) {
            Scanner sc0 = new Scanner(System.in);
            System.out.println("Enter passanger name:");
            String name = sc0.nextLine();
            Scanner sc1 = new Scanner(System.in);
            System.out.println("Enter passanger surname: ");
            String surname = sc1.nextLine();
            passangerList.add(new Passanger(passangerId++, name, surname));
        }
        return passangerList;
    }


    private UserController configurationUser(Database database) {
        UserDAO dao = new UserDAO(database);
        UserService service = new UserService(dao);
        return new UserController(service);
    }

    private BookingController configurationBooking(Database database) {
        BookingDAO dao = new BookingDAO(database);
        BookingService service = new BookingService(dao);
        return new BookingController(service);
    }

    private FlightController configurationFlight(Database database) {
        FlightDAO dao = new FlightDAO(database);
        FlightService service = new FlightService(dao);
        return new FlightController(service);
    }
}
