package university.pdp.service;

import java.util.Scanner;

import static university.pdp.service.ReservationService.reservationCRUD;
import static university.pdp.service.RestaurantService.viewRestaurantDetails;
import static university.pdp.utility.PrintUtility.*;

public class MainService {
    private static final Scanner scanner = new Scanner(System.in);

    private MainService() {
    }

    public static void startApplication() {
        int choice;

        do {
            displayIntro();

            choice = getInputChoice();

            switch (choice) {
                case 1 -> viewRestaurantDetails();
                case 2 -> reservationCRUD();
                case 3 -> stopApplication();
                default -> displayInvalidInputMessage();
            }
        } while (choice != 3);
    }

    static int getInputChoice() {
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        return choice;
    }

    private static void stopApplication() {
        printExitMessage();
        scanner.close();
        System.exit(0);
    }
}
