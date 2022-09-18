package reservation.app.utility;

import reservation.app.entity.Airlines;
import reservation.app.entity.Cities;

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


}
