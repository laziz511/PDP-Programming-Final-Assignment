package university.pdp.utility;

import java.util.Scanner;

public class Validator {

    private static final Scanner scanner = new Scanner(System.in);

    private Validator() {

    }

    public static String validateName() {
        String name;
        do {
            System.out.print("Please enter your name: ");
            name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Invalid input. Please enter a valid name.");
            }
        } while (name.isEmpty());
        return name;
    }

    public static String validateDate() {
        String date;
        do {
            System.out.print("Please enter the date (e.g., YYYY-MM-DD): ");
            date = scanner.nextLine().trim();
            if (!isValidDate(date)) {
                System.out.println("Invalid date format. Please enter a valid date.");
            }
        } while (!isValidDate(date));
        return date;
    }

    public static String validateTime() {
        String startTime;
        do {
            System.out.print("Please enter the time (e.g., HH:mm): ");
            startTime = scanner.nextLine().trim();
        } while (!isValidTime(startTime));
        return startTime;
    }

    public static int validatePeopleCount() {
        int peopleCount;
        do {
            System.out.print("Please enter the number of people: ");
            if (scanner.hasNextInt()) {
                peopleCount = scanner.nextInt();
            } else {
                scanner.next();
                peopleCount = -1;
            }
            if (peopleCount <= 0) {
                System.out.println("Invalid input. Please enter a valid number of people.");
            }
        } while (peopleCount <= 0);
        return peopleCount;
    }

    public static boolean isValidDate(String date) {
        return date.matches("\\d{4}-\\d{2}-\\d{2}");
    }

    public static boolean isValidTime(String time) {
        return time.matches("^([01]?[0-9]|2[0-3]):[0-5][0-9]$");
    }

}
