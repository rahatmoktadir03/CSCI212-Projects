package main;

import java.util.*;
import javax.swing.*;

public class Project1 {
    public static void main(String[] args) {
        // Creating a TextFileInput object to read from the input file
        TextFileInput input = new TextFileInput("P1input.txt");
        // Array to store solutions
        String[] solutions = new String[21];
        // Read the first line from input file
        String line = input.readLine();
        // Convert characters to lowercase
        String charactersAssigned = line.toLowerCase();
        // Read remaining lines and store solutions
        line = input.readLine();
        int size = 0;
        while (line != null) {
            line = line.toLowerCase();
            solutions[size] = line;
            size++;
            line = input.readLine();
        }
        // Create an instance of PuzzleGUI class
        PuzzleGUI myGUI = new PuzzleGUI();
        // Display assigned characters in GUI
        myGUI.showData(charactersAssigned);

        // List to store correct guesses
        ArrayList<String> correctGuesses = new ArrayList<>();
        // Variables for user input and score
        String guess;
        int score = 0;
        // Loop to handle user input until "Stop" is entered
        while (true) {
            // Prompt user for input
            guess = (JOptionPane.showInputDialog("Type a sentence (or 'Stop' to exit):")).toLowerCase();
            // Check if the input is null or equals "Stop" (case-insensitive) to exit the program.
            if (guess == null || guess.equalsIgnoreCase("Stop")) {
                break;
            }
            // Check if input has at least 5 letters
            if (guess.length() < 5) {
                JOptionPane.showMessageDialog(null, "You were required to use at least 5 letters!");
                continue;
            }
            // Flag to track if all characters in the guess are assigned
            boolean flag = false;
            for (int i = 0; i < guess.length(); i++) {
                char currentGuessCharacter = guess.charAt(i);
                for (int j = 0; j < charactersAssigned.length(); j++) {
                   if (currentGuessCharacter == charactersAssigned.charAt(j)) {
                      flag = true;
                   }
                }
                if (flag == false) {
                    JOptionPane.showMessageDialog(null, "You used a letter that you weren't assigned.");
                    flag = true;
                    break;
                }
                flag = false;
            }
            // Continue if flag is true (indicating invalid guess)
            if (flag == true) {
                continue;
            }
            // Check if the guess matches any solution
            for (int i = 0; i < solutions.length; i++) {
                if (guess.equals(solutions[i])) {
                    flag = true;
                    boolean tempflag = false;
                    // Check if guess is already in correctGuesses
                    for (int j = 0; j < correctGuesses.size(); j++) {
                        if (guess.equals(correctGuesses.get(j))) {
                            tempflag = true;
                            break;
                        }
                    }
                    if (tempflag == false) {
                        correctGuesses.add(guess);
                    }
                    break;
                }
            }
            // Display message if guess is incorrect
            if (flag == false) {
                JOptionPane.showMessageDialog(null, "You failed to guess one of the solutions!");
            }
            // Append guess to GUI and update score
            myGUI.appendSolution(guess);
            score++;
            myGUI.updateScore(score);
        }
        // Print correct guesses
        for (int i = 0; i < correctGuesses.size(); i++) {
            System.out.println(correctGuesses.get(i));
        }
    }
}
