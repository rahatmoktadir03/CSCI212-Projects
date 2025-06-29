import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Project2 {
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

        ArrayList<String> Solutions = new ArrayList<>();
        Solutions = inputFromFile("P1input.txt");
        print(myGUI, Solutions);

        // Testing the linked list with Unsort and Sort
        UnsortedWordList unsortedWordList = new UnsortedWordList();
        SortedWordList  sortedWordList = new SortedWordList();
        Word w1 = new Word("arthur");
        Word w2 = new Word("mallable");
        Word w3 = new Word("amicable");
        Word w4 = new Word("arousal");
        sortedWordList.add(w1);
        sortedWordList.add(w2);
        sortedWordList.add(w3);
        sortedWordList.add(w4);
        sortedWordList.print();
    }

    // Method to handle printing in the GUI
    public static void print(PuzzleGUI pg, ArrayList<String> SolutionsList) {
        // Extracting subject letters from the solutions list
        String SubjectLetters = SolutionsList.get(0);
        // Extracting the first letter from subject letters
        char firstLetter = SubjectLetters.charAt(0);
        // Variable to store the score
        int score = 0;
        // Container for GUI components
        Container myContentPane = pg.getContentPane();
        // Text area to display main text
        TextArea myTextArea = new TextArea();
        // Text area to display subscripts
        TextArea mySubscripts = new TextArea();
        // Adding text areas to the content pane
        myContentPane.add(myTextArea);
        myContentPane.add(mySubscripts);
        // Initializing unsorted and sorted word lists
        UnsortedWordList unsortedWordList = new UnsortedWordList();
        SortedWordList sortedWordList = new SortedWordList();

        // Adding solutions from input file to Unsorted Linked List
        for (int i = 0; i < SolutionsList.size(); i++) {
            Word w = new Word(SolutionsList.get(i));
            unsortedWordList.add(w);
        }

        // Displaying subject letters in the GUI
        myTextArea.append(SubjectLetters);
        // Prompting user to continue the game
        String userInput = JOptionPane.showInputDialog("Continue on with the game");
        // Loop to handle user guesses
        while (!userInput.equalsIgnoreCase("Stop")) { // loop to keep on running so user can constantly put inputs
            userInput = JOptionPane.showInputDialog("Guess a word or 'Stop' to quit");
            boolean z = true;
            while (z && !userInput.equalsIgnoreCase("Stop")) {
                // First letter must be in all cases
                if (!userInput.contains(String.valueOf(firstLetter))) {
                    JOptionPane.showMessageDialog(null, "Invalid input! Word does not contain the first letter.");
                    break;
                }
                // Valid letters check
                boolean validLetters = true;
                for (int i = 0; i < userInput.length(); i++) {
                    if (!SubjectLetters.contains(String.valueOf(userInput.charAt(i)))) {
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
                    char c = SubjectLetters.charAt(i);
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
                userInput = JOptionPane.showInputDialog("Guess a word or 'Stop' to quit");
            }
        }
    }

    // Method to read input from file
    public static ArrayList<String> inputFromFile(String filename) {
        TextFileInput in = new TextFileInput(filename);
        String line = in.readLine();

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
}