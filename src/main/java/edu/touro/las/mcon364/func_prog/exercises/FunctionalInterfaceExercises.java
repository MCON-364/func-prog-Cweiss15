package edu.touro.las.mcon364.func_prog.exercises;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Functional Interface Practice
 *
 * In this assignment you will:
 *  - Create and return different functional interfaces
 *  - Apply them
 *  - Practice chaining where appropriate
 *
 * IMPORTANT:
 *  - Use lambdas
 *  - Do NOT use anonymous classes
 */
public class FunctionalInterfaceExercises {

    // =========================================================
    // PART 1 — SUPPLIERS
    // =========================================================

    /**
     * 1) Create a Supplier that returns the current year.
     *
     * Hint:
     * You can get the current date using:
     *     LocalDate.now()
     *
     * Then extract the year using:
     *     getYear()
     *
     * Example (not the solution):
     *
     */
    public static Supplier<Integer> currentYearSupplier() {
      Supplier<Integer> currentYear = () ->  LocalDate.now().getYear();
      return currentYear;
    }

    /**
     * 2) Create a Supplier that generates a random number
     * between 1 and 100.
     */
    public static Supplier<Integer> randomScoreSupplier() {
        Random r = new Random();
        Supplier<Integer> random = () -> r.nextInt(100)+1;
        return random;
    }

    // =========================================================
    // PART 2 — PREDICATES
    // =========================================================

    /**
     * 3) Create a Predicate that checks whether
     * a string is all uppercase.
     */
    public static Predicate<String> isAllUpperCase() {
        Predicate<String> isUpper = x -> x.equals(x.toUpperCase());
        return isUpper;
    }

    /**
     * 4) Create a Predicate that checks whether
     * a number is positive AND divisible by 5.
     *
     * Hint: consider chaining.
     */
    public static Predicate<Integer> positiveAndDivisibleByFive() {
        Predicate<Integer> isPandD5 = x -> x % 5 == 0 && x>0;
        return isPandD5;
    }

    // =========================================================
    // PART 3 — FUNCTIONS
    // =========================================================

    /**
     * 5) Create a Function that converts
     * a temperature in Celsius to Fahrenheit.
     *
     * Formula: F = C * 9/5 + 32
     */
    public static Function<Double, Double> celsiusToFahrenheit() {
        Function<Double, Double> convert = x -> x * 9/5 + 32;
        return convert;
    }

    /**
     * 6) Create a Function that takes a String
     * and returns the number of vowels in it.
     *
     * Bonus: Make it case-insensitive.
     */
    public static Function<String, Integer> countVowels() {
        Function<String, Integer> countVowels = x -> {int cnt = 0;
            x = x.toUpperCase();
            for(char c: x.toCharArray()) {
                if (c == 'E' || c=='I' || c=='A' || c=='O' || c=='U')
                    cnt++;
            }
            return cnt;
            };
        return countVowels;
    }

    // =========================================================
    // PART 4 — CONSUMERS
    // =========================================================

    /**
     * 7) Create a Consumer that prints a value
     * surrounded by "***"
     *
     * Example output:
     * *** Hello ***
     */
    public static Consumer<String> starPrinter() {
        Consumer<String> printer = x -> System.out.println("*** "+ x + " ***") ;
        return printer;
    }

    /**
     * 8) Create a Consumer that prints the square
     * of an integer.
     */
    public static Consumer<Integer> printSquare() {
        Consumer<Integer> square = x -> System.out.println(x*x);
        return square;
    }

    // =========================================================
    // PART 5 — APPLYING FUNCTIONAL INTERFACES
    // =========================================================

    /**
     * 9) Apply:
     *  - A Predicate
     *  - A Function
     *  - A Consumer
     *
     * Process the list as follows:
     *  - Keep only strings longer than 3 characters
     *  - Convert them to lowercase
     *  - Print them
     */
    public static void processStrings(List<String> values) {
        Predicate<String> isLong = x -> x.length() > 3;
        Function<String, String> toLower = x -> x.toLowerCase();
        Consumer<String> print = x -> System.out.println(x);
        for (String value : values) {
            if (isLong.test(value)) {
                String upperCase = toLower.apply(value);
                print.accept(upperCase);
            }
        }
    }

    /**
     * 10) Apply:
     *  - A Supplier
     *  - A Predicate
     *  - A Consumer
     *
     * Generate 5 random scores.
     * Print only those above 70.
     */
    public static void generateAndFilterScores() {
        Random r = new Random();
        Supplier<Integer> random = () -> r.nextInt(100)+1;
        Predicate<Integer> passing = x -> x > 70;
        Consumer<Integer> print = x -> System.out.println(x);
        for (int i = 1; i <= 5; i++) {
            int score = random.get();
            if (passing.test(score)) {
                print.accept(score);
            }
        }
    }
}
