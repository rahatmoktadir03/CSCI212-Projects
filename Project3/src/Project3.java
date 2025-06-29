import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * The Project3 class represents the main class of the puzzle game application.
 * It handles the main functionality of the game, including GUI initialization,
 * user input handling, file reading, and game logic.
 */
public class Project3 {
    /** The subject letters for the game. */
    public static String Subjectletters;
    public static String filename;
    public static PuzzleGUI myGUI;

    /**
     * The main method of the Puzzle game application.
     *
     * @param args The command-line arguments.
     */

    public static void main(String[] args) {
        // Create an instance of PuzzleGUI class
        myGUI = new PuzzleGUI();
    }

    public static void cont() {
        ArrayList<String> Solutions = new ArrayList<>();
        Solutions = inputFromFile(filename);
        print(myGUI, Solutions);

        // Testing the linked list with Unsort and Sort
        UnsortedWordList unsortedWordList = new UnsortedWordList();
        SortedWordList sortedWordList = new SortedWordList();
    }

    /**
     * Prints the solutions to the puzzle game in the GUI.
     *
     * @param pg The PuzzleGUI object representing the GUI of the game.
     * @param SolutionsList The list of solutions to be printed.
     */

    // Method to handle printing in the GUI
    public static void print(PuzzleGUI pg, ArrayList<String> SolutionsList) {
        // Extracting the first letter from subject letters
        char firstLetter = Subjectletters.charAt(0);
        // Variable to store the score
        int score = 0;
        // Text area to display main text
        TextArea myTextArea = pg.letterGiven;
        // Text area to display subscripts
        TextArea mySubscripts = pg.userSolution;
        // Initializing unsorted and sorted word lists
        UnsortedWordList unsortedWordList = new UnsortedWordList();
        SortedWordList sortedWordList = new SortedWordList();

        // Adding solutions from input file to Unsorted Linked List
        for (int i = 0; i < SolutionsList.size(); i++) {
            Word w = new Word(SolutionsList.get(i));
            unsortedWordList.add(w);
        }

        // Displaying subject letters in the GUI
        myTextArea.append(Subjectletters);
        // Loop to handle user guesses
        while (unsortedWordList.length != sortedWordList.length) { // loop to keep on running so user can constantly put inputs
            String userInput = JOptionPane.showInputDialog("Guess a word or 'Stop' to quit");
            if (userInput.equalsIgnoreCase("Stop"))
                return;
            // First letter must be in all cases
            if (!userInput.contains(String.valueOf(firstLetter))) {
                JOptionPane.showMessageDialog(null, "Invalid input! Word does not contain the first letter.");
                break;
            }
            // Valid letters check
            boolean validLetters = true;
            for (int i = 0; i < userInput.length(); i++) {
                if (!Subjectletters.contains(String.valueOf(userInput.charAt(i)))) {
                    validLetters = false;
                    break;
                }
            }
            if (!validLetters) {
                JOptionPane.showMessageDialog(null, "Invalid input! Word contains invalid letters.");
                break;
            }
            // Length check
            if (userInput.length() < 5) {
                JOptionPane.showMessageDialog(null,
                        "User's guess is less than five letters, guess a word again or 'Stop' to quit");
                break;
            }
            // Solutions check
            boolean d = false;
            WordNode f = unsortedWordList.front.getNext();
            while (f != null) {
                if (userInput.equals(f.getData().getWord())) {
                    d = true;
                    Word w = new Word(userInput);
                    sortedWordList.add(w);
                }
                f = f.getNext();
            }
            if (d == false) {
                JOptionPane.showMessageDialog(null, "User's guess is not in the solutions, guess a word again or 'Stop' to quit");
                break;
            }
            // Contains all letters
            boolean b = true;
            for (int i = 0; i < userInput.length(); i++) {
                char c = Subjectletters.charAt(i);
                if (!userInput.contains(String.valueOf(c))) {
                    b = false;
                    break;
                }
            }
            if (b == false)
                score++;
            else
                score += 3;
            mySubscripts.setText("");
            WordNode x = sortedWordList.front.getNext();
            while (x != null) {
                mySubscripts.append(x.getData().getWord() + "\n");
                x = x.getNext();
            }
            mySubscripts.append("Your score is: " + score);
            if (unsortedWordList.length == sortedWordList.length) {
                // Display the score and ask the user if they want to play again
                int choice = JOptionPane.showConfirmDialog(null, "Congratulations! You won!\nYour score is: " + score + "\nWould you like to play again?", "Game Over", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    // Reset the game and play again
                    myTextArea.setText(""); // Clear previous game data from GUI
                    mySubscripts.setText(""); // Clear previous game data from GUI
                    break; // Break out of the loop to start a new game
                } else {
                    return;
                }
            }
        }
            JOptionPane.showMessageDialog(null, "You won!");
        }

        /**
         * Reads input from a file and returns a list of solutions.
         *
         * @param filename The name of the file to read solutions from.
         * @return An ArrayList containing the solutions read from the file.
         */

        // Method to read input from file
        public static ArrayList<String> inputFromFile (String filename){
            TextFileInput in = new TextFileInput(filename);
            String line = in.readLine();
            Subjectletters = line;
            line = in.readLine();

            ArrayList<String> SolutionsList = new ArrayList<>(); // Array stores values

            while (line != null) {
                StringTokenizer myTokens = new StringTokenizer(line, ","); // Implements tokenizer that breaks apart any texts
                while (myTokens.hasMoreTokens()) {
                    String s = myTokens.nextToken();
                    SolutionsList.add(s);
                }
                line = in.readLine();
            }
            in.close();
            return SolutionsList;
        }

        public static void getFile (String file){
            filename = file;
            cont();
        }
}