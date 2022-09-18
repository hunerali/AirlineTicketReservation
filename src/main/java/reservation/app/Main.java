package reservation.app;

import reservation.app.database.Database;
import reservation.app.utility.RandomFlightGenerator;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//        RandomFlightGenerator rg = new RandomFlightGenerator();
//        System.out.println(rg.generateRandomFlights(3));
        Database db =new Database();
        db.startUp();

    }
}
