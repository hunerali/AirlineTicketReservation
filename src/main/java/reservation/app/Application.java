package reservation.app;

import reservation.app.controller.BookingController;
import reservation.app.controller.FlightController;
import reservation.app.controller.UserController;
import reservation.app.dao.BookingDAO;
import reservation.app.dao.FlightDAO;
import reservation.app.dao.UserDAO;
import reservation.app.database.Database;
import reservation.app.entity.User;
import reservation.app.service.BookingService;
import reservation.app.service.FlightService;
import reservation.app.service.UserService;

import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Optional;
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

    public boolean run() {
        guestMenu();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter command: ");
        String command = sc.nextLine();
        switch (command) {
            case "1": {
                register();
                break;
            }
            case "2": {
                User u = login();
            }
        }
        return false;
    }

    private void guestMenu() {
        System.out.println("1.Registration\n" +
                "2.Login\n" +
                "3.View TimeTable\n" +
                "4.Exit");
    }

    private void userMenu() {
        System.out.println("1.View TimeTable\n" +
                "2.Make Reservation\n" +
                "3.Cancel Reservation\n" +
                "4.Log out");
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
