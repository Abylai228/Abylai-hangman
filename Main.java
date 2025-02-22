import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String[] words = {"JAVA", "PYTHON", "ANDROID", "JAVASCRIPT", "COMPUTER"};


        int index = (int) (Math.random() * words.length);
        String wordToGuess = words[index];


        StringBuilder currentGuess = new StringBuilder();
        for (int i = 0; i < wordToGuess.length(); i++) {
            currentGuess.append("_");
        }

        int attemptsLeft = 6;
        boolean wordGuessed = false;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Hangman!");
        System.out.println("You have " + attemptsLeft + " attempts to guess the word.");


        while (attemptsLeft > 0 && !wordGuessed) {
            System.out.println("\nCurrent word: " + currentGuess);
            System.out.print("Enter a letter: ");
            char guess = scanner.next().toUpperCase().charAt(0);


            boolean correctGuess = false;
            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.charAt(i) == guess) {
                    currentGuess.setCharAt(i, guess);
                    correctGuess = true;
                }
            }

            if (correctGuess) {
                System.out.println("Good job! " + guess + " is in the word.");
            } else {
                attemptsLeft--;
                System.out.println("Oops! " + guess + " is not in the word.");
                System.out.println("You have " + attemptsLeft + " attempts left.");
            }


            if (currentGuess.toString().equals(wordToGuess)) {
                wordGuessed = true;
            }
        }


        if (wordGuessed) {
            System.out.println("\nCongratulations! You've guessed the word: " + wordToGuess);
        } else {
            System.out.println("\nGame over! The word was: " + wordToGuess);
        }

        scanner.close();
    }
}


