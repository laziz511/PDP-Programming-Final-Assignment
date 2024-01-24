package university.pdp.utility;

import university.pdp.entity.Meal;
import university.pdp.entity.Menu;
import university.pdp.entity.Reservation;

import java.util.List;

import static university.pdp.service.ReservationService.getMealNames;

public class PrintUtility {
    public static final Menu menu = createMenu();

    private PrintUtility() {
    }

    public static void displayIntro() {
        System.out.println("1. View Restaurant Details");
        System.out.println("2. Reservation CRUD");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void displayReservationIntro() {
        System.out.println("Reservation CRUD:");
        System.out.println("1. Add Reservation");
        System.out.println("2. See Reservations");
        System.out.println("3. Update Reservation");
        System.out.println("4. Delete Reservation");
        System.out.println("5. Go back to Home Page");
        System.out.print("Enter your choice: ");
    }

    public static void printReturnMessage() {
        System.out.println("Going back to Home Page.");
    }

    public static void displayInvalidInputMessage() {
        System.out.println("Invalid choice. Please try again.");
    }

    public static void printExitMessage() {
        System.out.println("Exiting the application. Goodbye!");
    }

    public static void printPromptToContinue() {
        System.out.println("Press Enter to continue...");
    }
    public static void printMenu() {
        menu.printMenu();
    }

    public static void printNoFreeTableMessage() {
        System.out.println("There are no free tables for this date and time. Please choose a different date and time.");
    }

    public static void displaySuccessfulReservationMessage() {
        System.out.println("The reservation added successfully!");
    }
    public static void displayEmptyReservationsMessage() {
        System.out.println("There are no reservations.");
    }


    public static void printReservationTableHeading() {
        System.out.printf("%-5s %-15s %-12s %-10s %-60s %-25s %-10s%n", "ID", "Customer Name", "Date", "Time", "Meals", "Table", "Price");
    }

    public static void printMelSelectionChoiceMessage() {
        System.out.print("How many meals you want to select (1-10): ");
    }

    public static void printLine() {
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
    public static void displayNumberOfMealToSelectMessage() {
        System.out.print("Enter the number of the meal to select (1-10): ");
    }

    public static void printReservation(int i, Reservation reservation) {
        System.out.printf("%-5d %-15s %-12s %-10s %-60s %-25d $%.2f%n", i + 1, reservation.getCustomerName(), reservation.getDate(), reservation.getTime(), getMealNames(reservation.getMeals()), reservation.getTableNumber(), reservation.getPrice());
    }

    public static void displayNumberOfReservationToUpdate() {
        System.out.println("Enter the number of the reservation to update: ");
    }

    public static void displayNumberOfReservationToDelete() {
        System.out.println("Enter the number of the reservation to delete: ");
    }

    public static void displaySuccessfulUpdateMessage() {
        System.out.println("Reservation updated successfully!");
    }

    public static void displaySuccessfulDeleteMessage() {
        System.out.println("Reservation deleted successfully!");
    }

    public static void printInvalidMealNumberErrorMessage() {
        System.out.println("Invalid meal number. Please choose a valid meal (1-10).");
    }

    public static void printMealAddedMessage(Meal selectedMeal) {
        System.out.println("Meal added to the selection: " + selectedMeal.getName());
    }
    private static Menu createMenu() {
        return new Menu(List.of(
                new Meal("Spaghetti Bolognese", 12.99, "Classic Italian pasta with meat sauce"),
                new Meal("Chicken Alfredo", 15.99, "Creamy Alfredo sauce with grilled chicken"),
                new Meal("Margherita Pizza", 10.99, "Tomato, mozzarella, and basil"),
                new Meal("Caesar Salad", 8.99, "Fresh romaine lettuce with Caesar dressing"),
                new Meal("Teriyaki Salmon", 18.99, "Grilled salmon with teriyaki glaze"),
                new Meal("Vegetarian Stir Fry", 11.99, "Assorted vegetables in soy sauce"),
                new Meal("BBQ Ribs", 16.99, "Slow-cooked ribs with barbecue sauce"),
                new Meal("Mushroom Risotto", 13.99, "Creamy rice dish with mushrooms"),
                new Meal("Shrimp Scampi", 17.99, "Garlic butter shrimp over pasta"),
                new Meal("Chocolate Fondue", 9.99, "Assorted fruits dipped in chocolate")));
    }

}
