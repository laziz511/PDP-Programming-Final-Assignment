package university.pdp.service;

import university.pdp.entity.Reservation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static university.pdp.entity.Restaurant.*;
import static university.pdp.utility.PrintUtility.printPromptToContinue;

public class RestaurantService {

    public static final List<Reservation> reservations = new ArrayList<>();

    private RestaurantService() {
    }

    public static void viewRestaurantDetails() {
        displayRestaurantInfo();
        waitForEnter();
    }

    private static void waitForEnter() {
        printPromptToContinue();
        new Scanner(System.in).nextLine();
    }

    public static void displayRestaurantInfo() {
        System.out.println("Restaurant Details:");
        System.out.println("Name: " + getName());
        System.out.println("Address: " + getAddress());
        System.out.println("Tables Count: " + getTablesCount());
        System.out.println("Rating: " + getRating());
    }

    public static void addReservationToList(Reservation reservation) {
        reservations.add(reservation);
    }

}
