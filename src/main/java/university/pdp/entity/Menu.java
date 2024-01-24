package university.pdp.entity;

import java.util.List;

public record Menu(List<Meal> meals) {
    public Menu {
        if (meals.size() != 10) {
            throw new IllegalArgumentException("Menu must contain exactly 10 meals");
        }
    }

    public void printMenu() {
        int maxNameLength = 4;  // Length of "Name"
        int maxPriceLength = 5; // Length of "Price"
        int maxDescLength = 11; // Length of "Description"

        for (Meal meal : meals) {
            maxNameLength = Math.max(maxNameLength, meal.getName().length());
            maxPriceLength = Math.max(maxPriceLength, String.format("%.2f", meal.getPrice()).length());
            maxDescLength = Math.max(maxDescLength, meal.getDescription().length());
        }

        StringBuilder stringBuilder = new StringBuilder("Menu:\n");
        for (int i = 0; i < meals.size(); i++) {
            Meal meal = meals.get(i);
            stringBuilder.append(String.format("Meal %d: \t", i + 1))
                    .append(String.format("%-" + maxNameLength + "s\t", meal.getName()))
                    .append(String.format("%-" + maxPriceLength + ".2f\t", meal.getPrice()))
                    .append(String.format("%-" + maxDescLength + "s", meal.getDescription()))
                    .append("\n");
        }
        System.out.println(stringBuilder);
    }
}
