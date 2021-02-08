package bullscows;

import java.util.Random;

public final class SecretNumber {
    public String secretNumber = "";
    private int bulls = 0;
    private int cows = 0;

    public int getBulls() {
        return this.bulls;
    }

    /**
     * THIS CLASS PROCESSING ALL ACTIONS WITH THE SECRET CODE
     *
     * @param length - length of the secret code
     * @param possibleSymbols - possible symbols of the secret code
     */

    public SecretNumber(int length, int possibleSymbols) {
        this.secretNumber = generateNumber(length, possibleSymbols);
    }

    private String generateNumber(int length, int possibleSymbols) {
        StringBuilder number = new StringBuilder(length);
        StringBuilder temp = new StringBuilder("1");
        Random random = new Random();

        possibleSymbols = symbolWeight(possibleSymbols);

        while (number.length() < length){

            temp.setCharAt(0, (char) (random.nextInt(41 + possibleSymbols) + 48)); //97 - 122 [a-z] 48 - 57 [0-9]

            if (number.indexOf(temp.toString()) == -1 && temp.toString().matches("[0-9a-z]+")) {
                number.append(temp);
            }
        }
        return number.toString();
    }

    private int symbolWeight(int weight) {
        return weight > 10 ? weight : weight - 41;
    }

    public void bullsAndCowsCounter(String userNumber) {
        this.bulls = 0;
        this.cows = 0;
        for (int i = 0; i < this.secretNumber.length(); i++) {
            if (this.secretNumber.charAt(i) == userNumber.charAt(i)) {
                this.bulls++;
            } else if (userNumber.contains("" + this.secretNumber.charAt(i))) {
                this.cows++;
            }
        }
    }

    public String grade() {
        if (this.bulls != 0 && cows != 0) {
            return this.bulls + " bull(s) and " + this.cows + " cow(s)";
        } else if (this.bulls == 0 && this.cows != 0) {
            return this.cows + " cow(s)";
        } else if (this.bulls != 0) {
            return this.bulls + " bull(s)";
        } else {
            return "None";
        }
    }
}
