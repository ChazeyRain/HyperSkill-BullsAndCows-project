package bullscows;

public class Main {
    public static void main(String[] args) {
        UserInput.configInput();

        int codeLength = UserInput.getCodeLength();
        int possibleSymbols = UserInput.getPossibleSymbols();

        final String HIDDEN_SYMBOL = "*";

        System.out.println("The secret is prepared: " +
                HIDDEN_SYMBOL.repeat(codeLength) +
                " (0-" + (possibleSymbols < 11 ? (char) (possibleSymbols + 47) + ")" :
                "9), (a-" + (char) (possibleSymbols + 86) + ")"));

        gameTime(codeLength, possibleSymbols);

        System.out.println("Congratulations! You guessed the secret code.");
    }

    public static void gameTime(int secretNumberLength, int possibleSymbols) {
        SecretNumber secretNumber = new SecretNumber(secretNumberLength, possibleSymbols);

        boolean isRunning = true;
        int turns = 0;

        System.out.println("Okay, let's start a game!");
        while (isRunning) {
            turns++;
            System.out.printf("Turn %d:%n", turns);
            secretNumber.bullsAndCowsCounter(UserInput.userInput(secretNumberLength));
            System.out.println(secretNumber.grade());
            isRunning = secretNumber.getBulls() != secretNumberLength;
        }
    }
}
