import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.Container;

public class PuzzleGUI extends JFrame {
    // Declaring GUI components
    private TextArea letterGiven;
    private TextArea userSolution;
    private Container myContentPane;

    // Constructor
    public PuzzleGUI () {
        // Setting frame properties
        setSize(500, 300);
        setLocation(200,200);
        setTitle("Puzzle");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        // Setting layout to 1 row, 2 columns
        setLayout(new GridLayout(1,2));
        // Getting content pane
        myContentPane = getContentPane();
        // Initializing text areas
        letterGiven = new TextArea();
        userSolution = new TextArea();
        // Making text areas uneditable
        letterGiven.setEditable(false);
        userSolution.setEditable(false);
        // Adding text areas to content pane
        myContentPane.add(letterGiven);
        myContentPane.add(userSolution);
    }

    // Method to display assigned letters
    public void showData(String letterToUse) {
        // Appending assigned letters to the letterGiven text area
        letterGiven.append(letterToUse);
        // Displaying initial score in userSolution text area
        userSolution.append("User Score: 0");
    }
    // Method to update user score
    public void updateScore(int score) {
        // Replacing score display with updated score
        userSolution.replaceRange(Integer.toString(score), 12, 13);
    }
    // Method to append user solution to the text area
    public void appendSolution(String solution) {
        // Appending user solution to userSolution text area
        userSolution.append("\n" + solution);
    }
}