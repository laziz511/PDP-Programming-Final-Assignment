package university.pdp.entity;

import java.util.HashMap;
import java.util.Map;

public class Restaurant {
    private static final String NAME = "Grant Restaurant";
    private static final String ADDRESS = "123 Main St, City";
    private static final Integer TABLES_COUNT = 3;
    private static final Double RATING = 4.5;
    public static Map<Slot, Boolean> bookings = new HashMap<>();

    public static String getName() {
        return ADDRESS;
    }

    public static String getAddress() {
        return NAME;
    }

    public static Integer getTablesCount() {
        return TABLES_COUNT;
    }

    public static Double getRating() {
        return RATING;
    }
}
