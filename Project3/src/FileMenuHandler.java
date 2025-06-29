import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

/**
 * The FileMenuHandler class handles action events for the file menu items.
 * It provides methods to open a file using a file chooser dialog and read/display its contents.
 */
// This class handles the action events for the file menu items
public class FileMenuHandler implements ActionListener {
    JFrame jframe; // JFrame reference
    /**
     * Constructs a FileMenuHandler object with a reference to the JFrame.
     *
     * @param jf The JFrame to associate with this FileMenuHandler.
     */
    // Constructor to initialize the JFrame reference
    public FileMenuHandler (JFrame jf) {
        jframe = jf;
    }
    // This method is invoked when an action event occurs
    /**
     * Invoked when an action event occurs.
     *
     * @param event The ActionEvent object generated when a menu item is clicked.
     */
    public void actionPerformed(ActionEvent event) {
        String menuName;
        menuName = event.getActionCommand();
        // Check which menu item was clicked
        if (menuName.equals("Open"))
            openFile( );
        else if (menuName.equals("Quit"))
            // If Quit is clicked, exit the program
            System.exit(0);
    } //actionPerformed

    /**
     * Opens a file using a file chooser dialog.
     */
    // Method to open a file using a file chooser dialog
    private void openFile( ) {
        JFileChooser chooser;
        int status;
        chooser = new JFileChooser( );
        // Display the file chooser dialog and get the user's selection
        status = chooser.showOpenDialog(null);
        // If the user selects a file, read its contents
        if (status == JFileChooser.APPROVE_OPTION)
            readSource(new File(chooser.getSelectedFile().getAbsolutePath()));
        else
            JOptionPane.showMessageDialog(null, "Open File dialog canceled");
    } //openFile

    /**
     * Reads and displays the contents of the selected file.
     *
     * @param chosenFile The File object representing the selected file.
     */
    // Method to read and display the contents of the selected file
    private void readSource(File chosenFile) {
        String chosenFileName = chosenFile.getAbsolutePath();
        Project3.getFile(chosenFileName);
    }
}