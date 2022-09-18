package reservation.app;

import reservation.app.database.Database;
import reservation.app.utility.RandomFlightGenerator;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Application app = new Application();
        while (app.run()) {
            if (!app.run()) break;
        }

    }
}
