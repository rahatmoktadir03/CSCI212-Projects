import javax.swing.*;
import java.awt.*;

/**
 * The PuzzleGUI class represents the graphical user interface (GUI) for the puzzle game.
 * It displays the subject letters and user solutions in text areas, and provides methods
 * for updating the GUI components.
 */

public class PuzzleGUI extends JFrame {
    // Declaring GUI components
    /** The text area for displaying subject letters. */
    public TextArea letterGiven;
    /** The text area for displaying user solutions. */
    public TextArea userSolution;
    /** The container for the content pane of the JFrame. */
    private Container myContentPane;

    /**
     * Constructs a PuzzleGUI object and initializes the GUI components.
     */

    // Constructor
    public PuzzleGUI () {
        // Setting frame properties
        setSize(500, 300);
        setLocation(200,200);
        createFileMenu();
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

    /**
     * Creates the file menu for the JFrame.
     */
    // This method creates the file menu for the JFrame
    private void createFileMenu() {
        JMenuItem item; // JMenuItem variable to create menu items
        JMenuBar menuBar  = new JMenuBar(); // Create a new menu bar
        JMenu fileMenu = new JMenu("File"); // Create a new menu named "File"
        FileMenuHandler fmh  = new FileMenuHandler(this); // Create a FileMenuHandler instance associated with this JFrame

        // Create and configure "Open" menu item
        item = new JMenuItem("Open"); // Create a menu item labeled "Open"
        item.addActionListener( fmh ); // Add an ActionListener to handle the "Open" menu item
        fileMenu.add( item ); // Add the "Open" menu item to the "File" menu
        // Add a horizontal separator line to the menu
        fileMenu.addSeparator(); // Add a separator line to visually separate menu items
        // Create and configure "Quit" menu item
        item = new JMenuItem("Quit"); // Create a menu item labeled "Quit"
        item.addActionListener( fmh ); // Add an ActionListener to handle the "Quit" menu item
        fileMenu.add( item ); // Add the "Quit" menu item to the "File" menu
        setJMenuBar(menuBar); // Set the menu bar for the JFrame
        menuBar.add(fileMenu); // Add the "File" menu to the menu bar
    }

    /**
     * Displays the assigned letters in the GUI.
     *
     * @param letterToUse The subject letters to display.
     */
    // Method to display assigned letters
    public void showData(String letterToUse) {
        // Appending assigned letters to the letterGiven text area
        letterGiven.append(letterToUse);
        // Displaying initial score in userSolution text area
        userSolution.append("User Score: 0");
    }

    /**
     * Updates the user score displayed in the GUI.
     *
     * @param score The updated user score.
     */
    // Method to update user score
    public void updateScore(int score) {
        // Replacing score display with updated score
        userSolution.replaceRange(Integer.toString(score), 12, 13);
    }

    /**
     * Appends the user solution to the text area in the GUI.
     *
     * @param solution The user solution to append.
     */
    // Method to append user solution to the text area
    public void appendSolution(String solution) {
        // Appending user solution to userSolution text area
        userSolution.append("\n" + solution);
    }
}