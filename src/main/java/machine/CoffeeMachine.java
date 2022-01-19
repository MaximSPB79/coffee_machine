package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] ingredients = getCoffee(400, 540, 120, 9, 550);
        int[] ingredientsX = new int[5];
        action(scanner, ingredients, ingredientsX);
    }

    private static void action(Scanner scanner, int[] ingredients, int[] ingredientsX) {
        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.next();
            System.out.println();

            switch (action) {
                case "buy":
                    buy(scanner, ingredients, ingredientsX);
                    break;
                case "fill":
                    fill(scanner, ingredients);
                    break;
                case "take":
                    take(ingredients);
                    break;
                case "remaining":
                    printInfo(ingredients);
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("No such operation");
                    break;
            }
        }
    }


    private static void printInfo(int[] ingredients) {
        System.out.println("The coffee machine has:");
        System.out.println(ingredients[0] + " ml of water");
        System.out.println(ingredients[1] + " ml of milk");
        System.out.println(ingredients[2] + " g of coffee beans");
        System.out.println(ingredients[3] + " disposable cups");
        System.out.println("$" + ingredients[4] + " of money");
        System.out.println();
    }

    static void buy(Scanner scanner, int[] ingredients, int[] ingredientsX) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String option = scanner.next();
        switch (option) {
            case "1":
                ingredientAnalysis(ingredients, getCoffee(250, 0, 16, 1, 4));
                break;
            case "2":
                ingredientAnalysis(ingredients, getCoffee(350, 75, 20, 1, 7));
                break;
            case "3":
                ingredientAnalysis(ingredients, getCoffee(200, 100, 12, 1, 6));
                break;
            case "back":
                System.out.println();
                break;
            default:
                System.out.println("Enter a number from 1 to 3");
        }
    }

    private static int[] ingredientAnalysis(int[] ingredients, int[] ingredientsX) {
        if (ingredients[0] >= ingredientsX[0] &&
                ingredients[1] >= ingredientsX[1] &&
                ingredients[2] >= ingredientsX[2] &&
                ingredients[3] >= ingredientsX[3]) {
            System.out.println("I have enough resources, making you a coffee!");
            System.out.println();

            coffeeMaking(ingredients, ingredientsX);

        } else if (ingredients[0] < ingredientsX[0]) {
            System.out.println("Sorry, not enough water!");
            System.out.println();
        } else if (ingredients[1] < ingredientsX[1]) {
            System.out.println("Sorry, not enough milk!");
            System.out.println();
        } else if (ingredients[2] < ingredientsX[2]) {
            System.out.println("Sorry, not enough coffee!");
            System.out.println();
        } else if (ingredients[3] < ingredientsX[3]) {
            System.out.println("Sorry, not enough cups!");
            System.out.println();
        }
        return ingredients;
    }

    private static void coffeeMaking(int[] ingredients, int[] ingredientsX) {
        ingredients[0] -= ingredientsX[0];
        ingredients[1] -= ingredientsX[1];
        ingredients[2] -= ingredientsX[2];
        ingredients[3]--;
        ingredients[4] += ingredientsX[4];
    }

    private static int[] getCoffee(int woter, int milk, int coffee, int cups, int money) {
        int[] ingredients = new int[5];
        ingredients[0] = woter;
        ingredients[1] = milk;
        ingredients[2] = coffee;
        ingredients[3] = cups;
        ingredients[4] = money;
        return ingredients;
    }

    private static int[] fill(Scanner scanner, int[] ingredients) {
        System.out.println("Write how many ml of water you want to add:");
        ingredients[0] += scanner.nextInt();

        System.out.println("Write how many ml of milk you want to add:");
        ingredients[1] += scanner.nextInt();

        System.out.println(" Write how many grams of coffee beans you want to add:");
        ingredients[2] += scanner.nextInt();

        System.out.println("Write how many disposable cups of coffee you want to add:");
        ingredients[3] += scanner.nextInt();
        System.out.println();
        return ingredients;
    }

    private static int[] take(int[] ingredients) {
        System.out.println("I gave you $" + ingredients[4]);
        System.out.println();
        ingredients[4] = 0;
        return ingredients;
    }
}

