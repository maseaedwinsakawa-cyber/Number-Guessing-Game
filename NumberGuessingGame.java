
import java.util.Random;
import java.util.Scanner;

class NumberGuessingGame {

    private int secretNumber;
    private int userGuess;
    private int attempts;
    private int maxAttempts;
    private int minRange;
    private int maxRange;
    private boolean hasWon;
    private Scanner input;

    public NumberGuessingGame(int secretaNumber, int userGuess,
            int attempts, int maxAttempts, int minRange, int maxRange) {
        this.secretNumber = secretaNumber;
        this.userGuess = userGuess;
        this.attempts = attempts;
        this.maxAttempts = maxAttempts;
        this.minRange = minRange;
        this.maxRange = maxRange;
        this.hasWon = false;
        this.input = new Scanner(System.in);
    }

    public void generateSecretNumber() {
        Random random = new Random();
        secretNumber = random.nextInt(maxRange - minRange + 1) + minRange;

    }

    public int getUserGuess() {
        System.out.println("Enter your number between: " + minRange
                + " and " + maxRange + ":");
        int userGuess = input.nextInt();
        return userGuess;
    }

    public boolean checkGuess(int userGuess) {
        if (userGuess < minRange || userGuess > maxRange) {
            System.out.println("****Out Of Range*****");
            return false;
        } else {
            if (userGuess == secretNumber) {
                System.out.println("***You Just Won *****");
                this.hasWon = true;
                return true;
            } else if (userGuess > secretNumber) {
                System.out.println("=====To high try again =====");
                return false;
            } else {
                System.out.println("======To Low try again =====");
                return false;
            }
        }
    }

    public void playGame() {
        generateSecretNumber();
        this.attempts = 0;
        this.hasWon = false;
        while (attempts < maxAttempts && hasWon == false) {

            int guess = getUserGuess();
            this.hasWon = checkGuess(guess);
            this.attempts++;
            System.out.println("*******Attempts Remaining********");
            System.out.println(maxAttempts - attempts);
        }
        if (hasWon == false) {
            System.out.println("+++++****Game Over ++++++*****" + secretNumber);
        } else {
            System.out.println("=======You've Just Won nice Guessing Skills=======");
            System.out.println("********You Won After " + attempts + " Tries********* ");
        }

    }

    public void showWelcome() {
        System.out.println("Welcome to our NumberGuessing Game\n");
        System.out.println("*****************Enjoy The Game***********");
        System.out.println("******You Already Know The Rules*********");
        System.out.println("*****I'm Thinking of a number between " + minRange + " and " + maxRange);
        System.out.println("========Can You Guess The number ========");

    }

    public static void main(String[] args) {
        NumberGuessingGame game = new NumberGuessingGame(0, 0, 0, 5, 1, 100);
        game.showWelcome();
        game.playGame();
    }
}
