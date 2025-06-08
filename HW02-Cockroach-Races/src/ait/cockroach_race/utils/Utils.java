package ait.cockroach_race.utils;

import java.util.Scanner;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (08.06.2025)
 */
public class Utils {
    /**
     * Method to check if a string is a number.
     * @param str - еhe value of the string entered by the user.
     * @return boolean
     */
    public static boolean isInteger(String str) {
        return str.matches("\\d+"); // Только положительные целые числа
    }

    /**
     * Method to read a user input parameter from console.
     * @param str - a message string describing the expected input parameter.
     * @return int
     */
    public static int readInputParameter(String str) {
        Scanner sc = new Scanner(System.in);
        boolean isTrue = true;
        int inputInt = 0;

        while (isTrue) {
            System.out.println(str);
            String inputCount = sc.nextLine().trim();

            if (isInteger(inputCount)) {
                inputInt = Integer.parseInt(inputCount);
                isTrue = false;
            } else {
                System.out.println("Entered value is not a number!");
                System.out.println("Please try again.");
            }
        }
        return inputInt;
    }
}
