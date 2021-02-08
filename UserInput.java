package bullscows;

import java.util.Scanner;

public final class UserInput {
    private final static Scanner scanner = new Scanner(System.in);

    private static int codeLength;
    private static int possibleSymbols;

    public static int getCodeLength() {
        return codeLength;
    }

    public static int getPossibleSymbols() {
        return possibleSymbols;
    }

    /**
     * THIS CLASS PROCESSING ALL USER INPUT
     *
     * TO DISABLE TERMINATING PROGRAM AFTER AN ERROR COMMENT ALL System.exit(0) LINES
     *
     * I HAVEN'T USED TRY-CATCH BECAUSE I ALREADY IMPLEMENTED EXCEPTION HANDLING IN PREVIOUS SECTIONS, TOO LAZY FOR THIS
     */

    public static void configInput() {
        askCodeLength();
        askPossibleSymbols();

        if (codeLength > possibleSymbols) {
            System.out.printf("Error: it's not possible to generate a code with a length of %d with %d unique symbols.%n", codeLength, possibleSymbols);
            System.exit(0);
            configInput();
        }
    }

    public static void askCodeLength() {
        System.out.println("Please, enter the secret code's length:");
        String input = scanner.next();

        if (!input.matches("[0-9]+") || Integer.parseInt(input) < 1) {
            System.out.printf("Error: \"%s\" isn't a valid number.%n", input);
            System.exit(0);
            askCodeLength();
        }
        if (Integer.parseInt(input) > 36) {
            System.out.printf("Error: can't generate a secret number with a length of %s because there aren't enough unique symbols.%n", input);
            System.exit(0);
            askCodeLength();
        } else {
            codeLength = Integer.parseInt(input);
        }
    }

    public static void askPossibleSymbols() {
        System.out.println("Input the number of possible symbols in the code:");
        String input = scanner.next();

        if (!input.matches("[0-9]+")) {
            System.out.printf("Error: \"%s\" isn't a valid number.%n", input);
            System.exit(0);
            askPossibleSymbols();
        }
        if (Integer.parseInt(input) > 36) {
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            System.exit(0);
            askPossibleSymbols();
        } else {
            possibleSymbols = Integer.parseInt(input);
        }
    }

    public static String userInput(int length) {
        String input = scanner.next();

        if (input.length() != length) {
            System.out.printf("Error: input should contain %d symbols!%n", codeLength);
            System.exit(0);
            return userInput(length);
        } else {
            return input;
        }
    }
}
