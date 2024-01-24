package university.pdp.service;

import university.pdp.entity.Meal;
import university.pdp.entity.Reservation;
import university.pdp.entity.Slot;

import java.util.ArrayList;
import java.util.List;

import static university.pdp.entity.Restaurant.bookings;
import static university.pdp.entity.Restaurant.getTablesCount;
import static university.pdp.service.MainService.getInputChoice;
import static university.pdp.service.RestaurantService.addReservationToList;
import static university.pdp.service.RestaurantService.reservations;
import static university.pdp.utility.PrintUtility.*;
import static university.pdp.utility.Validator.*;

public class ReservationService {

    private ReservationService() {

    }

    public static void reservationCRUD() {
        int choice;
        do {
            displayReservationIntro();
            choice = getInputChoice();
            performOperation(choice);
        } while (choice != 5);
    }

    public static void performOperation(int choice) {
        switch (choice) {
            case 1 -> addReservation();
            case 2 -> seeReservations();
            case 3 -> updateReservation();
            case 4 -> deleteReservation();
            case 5 -> printReturnMessage();
            default -> displayInvalidInputMessage();
        }
    }

    public static void addReservation() {
        String customerName = validateName();
        int peopleCount = validatePeopleCount();
        List<Meal> selectedMeals = selectMeals();

        Reservation reservation = createReservationWithValidTable(customerName, peopleCount, selectedMeals);

        addReservationToList(reservation);
        displaySuccessfulReservationMessage();
    }

    private static Reservation createReservationWithValidTable(String customerName, int peopleCount, List<Meal> selectedMeals) {
        String date;
        String time;
        int tableNumber;

        do {
            date = validateDate();
            time = validateTime();
            tableNumber = generateTableNumber(date, time);

            if (tableNumber == 0) {
                printNoFreeTableMessage();
            }

        } while (tableNumber == 0);

        double price = calculatePrice(selectedMeals);
        return createReservation(customerName, date, time, peopleCount, selectedMeals, tableNumber, price);
    }


    private static Reservation createReservation(String customerName, String date, String time, int peopleCount, List<Meal> selectedMeals, int tableNumber, double price) {
        return new Reservation(customerName, date, time, peopleCount, selectedMeals, tableNumber, price);
    }


    private static List<Meal> selectMeals() {
        List<Meal> selectedMeals = new ArrayList<>();

        printMenu();

        int numberOfMeals = getNumberOfMeals();

        for (int i = 0; i < numberOfMeals; i++) {
            selectAndAddMeal(selectedMeals);
        }

        return selectedMeals;
    }

    private static int getNumberOfMeals() {
        int numberOfMeals;

        do {
            printMelSelectionChoiceMessage();
            numberOfMeals = getInputChoice();

            if (numberOfMeals < 1 || numberOfMeals > 10) {
                displayInvalidInputMessage();
            }

        } while (numberOfMeals < 1 || numberOfMeals > 10);

        return numberOfMeals;
    }


    private static void selectAndAddMeal(List<Meal> selectedMeals) {
        displayNumberOfMealToSelectMessage();
        int mealNumber = getInputChoice();

        Meal selectedMeal = getMenuMealByNumber(mealNumber);

        if (selectedMeal != null) {
            selectedMeals.add(selectedMeal);
            printMealAddedMessage(selectedMeal);
        } else {
            printInvalidMealNumberErrorMessage();
        }
    }


    private static Meal getMenuMealByNumber(int mealNumber) {
        return menu.meals().get(mealNumber - 1);
    }

    private static double calculatePrice(List<Meal> selectedMeals) {
        return selectedMeals.stream().mapToDouble(Meal::getPrice).sum();
    }

    private static int generateTableNumber(String date, String time) {
        for (int i = 1; i <= getTablesCount(); i++) {
            if (isTableAvailable(i, date, time)) {
                return i;
            }
        }
        return 0;
    }

    private static boolean isTableAvailable(int tableNumber, String date, String time) {
        Slot slot = new Slot(tableNumber, date, time);
        if (!bookings.containsKey(slot)) {
            bookings.put(slot, true);
            return true;
        }
        return false;
    }

    private static void seeReservations() {
        if (reservations.isEmpty()) {
            displayEmptyReservationsMessage();
        } else {
            printLine();
            printReservationTableHeading();
            printLine();
            for (int i = 0; i < reservations.size(); i++) {
                Reservation reservation = reservations.get(i);
                printReservation(i, reservation);
            }
        }
    }


    public static String getMealNames(List<Meal> meals) {
        StringBuilder mealNames = new StringBuilder();
        for (Meal meal : meals) {
            mealNames.append(meal.getName()).append(", ");
        }

        if (mealNames.length() > 60) {
            return mealNames.substring(0, 50) + "...";
        }

        return mealNames.toString();
    }

    private static void updateReservation() {
        seeReservations();
        displayNumberOfReservationToUpdate();
        int choice = getInputChoice();

        if (choice >= 1 && choice <= reservations.size()) {
            Reservation selectedReservation = reservations.get(choice - 1);

            List<Meal> updatedMeals = selectMeals();
            selectedReservation.setMeals(updatedMeals);

            displaySuccessfulUpdateMessage();
        } else {
            displayInvalidInputMessage();
        }
    }


    private static void deleteReservation() {
        seeReservations();
        displayNumberOfReservationToDelete();
        int choice = getInputChoice();

        if (choice >= 1 && choice <= reservations.size()) {
            reservations.remove(choice - 1);
            displaySuccessfulDeleteMessage();
        } else {
            displayInvalidInputMessage();
        }
    }

}
