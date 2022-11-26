package bullscows;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the length of the secret code:");
        String codeLengthString = scanner.nextLine();

        if (!codeLengthString.matches("\\d+")) {
            System.out.println("Error: \"" + codeLengthString + "\" isn't a valid number.");
            return;
        }
        int codeLength = Integer.parseInt(codeLengthString);

        if(codeLength < 1) {
            System.out.println("Error: can't generate a secret number with a length of " + codeLength );
            return;
        }

        if (codeLength > 36) {
            System.out.println("Error: can't generate a secret number with a length of 37 because there aren't enough unique digits and lowercase Latin characters(a-z).");
            return;
        }

        System.out.println("Input the number of possible symbols in the code:");
        String nrPossibleSymbolsString = scanner.nextLine();

        if (!nrPossibleSymbolsString.matches("\\d+")) {
            System.out.println("Error: \"" + nrPossibleSymbolsString + "\" isn't a valid number.");
            return;
        }

        int nrPossibleSymbols = Integer.parseInt(nrPossibleSymbolsString);

        if (nrPossibleSymbols > 36) {
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            return;
        }
        if (nrPossibleSymbols < codeLength) {
            System.out.println("Error: it's not possible to generate a code with a length of " + codeLength + " with " + nrPossibleSymbols + " unique symbols.");
            return;
        }

        Set<String> alphaNumericSet = new LinkedHashSet<>();
        while (alphaNumericSet.size() < codeLength) {
            alphaNumericSet.add(getRandomAlphaNumeric(nrPossibleSymbols));
        }



        //prepare the secret code
        String code = alphaNumericSet.stream().reduce("",
                String::concat);


        //Get the  max alphabet char from the alphabetSet
        String minDigit = "0";
        String maxDigit = "0";
        String minAlphabet = "";
        String maxAlphabet = "";
        for (int i = 0; i < nrPossibleSymbols; i++) {
            if (i < 10) {
                maxDigit = Math.max(i,
                        Integer.parseInt(maxDigit)) + "";
            } else {
                minAlphabet = "a";
                maxAlphabet = String.valueOf((char) Math.max(97,
                        i + 87));
            }
        }
        System.out.printf("The secret is prepared: %s (%s-%s, %s-%s).%n",
                "*".repeat(codeLength),
                minDigit,
                maxDigit,
                minAlphabet,
                maxAlphabet);


        System.out.println("Okay, let's start a game!");


        int turn = 1;

        Set<String> bulls;
        Set<String> cows;

        do {
            bulls = new HashSet<>();
            cows = new HashSet<>();

            System.out.println("Turn " + (turn) + ":");
            scanner = new Scanner(System.in);
            String userNumber = scanner.nextLine();

            for (int i = 0; i < userNumber.length(); i++) {
                if (userNumber.charAt(i) == code.charAt(i)) {
                    bulls.add(userNumber.substring(i,
                            i + 1));
                } else if (!bulls.contains(userNumber.substring(i,
                        i + 1)) && code.contains(userNumber.substring(i,
                        i + 1))) {
                    cows.add(userNumber.substring(i,
                            i + 1));
                }
            }

            if (bulls.isEmpty() && cows.isEmpty()) {
                System.out.println("Grade: None.");
            } else if (bulls.isEmpty()) {
                System.out.println("Grade: " + cows.size() + " cow(s). ");
            } else if (cows.isEmpty()) {
                System.out.println("Grade: " + bulls.size() + " bull(s).");
            } else {
                System.out.println("Grade: " + bulls.size() + " bull(s) and " + cows.size() + " cow(s). ");
            }
            turn++;
        } while (bulls.size() != codeLength);

        System.out.println("Congratulations! You guessed the secret code.");

    }

    private static String getRandomAlphaNumeric(int nrPossibleSymbols) {
        int random = (int) (Math.random() * nrPossibleSymbols); //number of chars
        if (random < 10) {
            return String.valueOf(random);
        } else {
            return String.valueOf((char) (random + 87));
        }
    }


}
