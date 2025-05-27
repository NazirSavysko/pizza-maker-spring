package pizza.market;

import pizza.market.entity.pizza.Pizza;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;
import static pizza.market.entity.factory.PizzaFactory.createPizza;
import static pizza.market.entity.factory.PizzaFactory.closeFactory;

public final class PizzaMarket {
    private static final Scanner SCANNER = new Scanner(in);
    private static final String MESSAGE_IF_OCCUR_ERROR_WITH_MAKING_PIZZA =
            "An error occurred while making the pizza: %s";

    public static void main(String[] args) {
        byte choice;
        while (true) {
            try {
                showMenu();
                choice = SCANNER.nextByte();

                switch (choice) {
                    case 1:
                        makePizza();
                        break;
                    case 2:
                        exit();
                        closeFactory();
                        return;
                    default:
                        throw new IllegalArgumentException("Invalid choice");
                }

            } catch (Exception e) {
                out.printf(MESSAGE_IF_OCCUR_ERROR_WITH_MAKING_PIZZA, e.getMessage());
            } finally {
                if (SCANNER.hasNextLine()) {
                    SCANNER.nextLine();
                }
            }
        }
    }

    private static void showMenu() {
        out.println("Welcome to the Pizza Maker!");
        out.println("Please choose an option:");
        out.println("1. Make a pizza");
        out.println("2. Exit");
    }

    private static void makePizza() {
        try {
            out.println("Enter the type of pizza ");
            out.println("1. American pizza");
            out.println("2. Italian pizza");
            out.println("3. Asian pizza");

            final byte choice = SCANNER.nextByte();

            final Pizza pizza = getPizza(choice);
            pizza.bake();

        } catch (Exception e) {
            out.printf(MESSAGE_IF_OCCUR_ERROR_WITH_MAKING_PIZZA, e.getMessage());
        } finally {
            if (SCANNER.hasNextLine()) {
                SCANNER.nextLine();
            }
        }
    }

    private static Pizza getPizza(final byte choice) {
        switch (choice) {
            case 1:
                return createPizza("American pizza");
            case 2:
                return createPizza("Italian pizza");
            case 3:
                return createPizza("Asian pizza");
            default:
                throw new IllegalArgumentException("Invalid choice");
        }
    }

    private static void exit() {
        out.println("Thank you for using the Pizza Maker!");
        out.println("Goodbye!");
    }

}
