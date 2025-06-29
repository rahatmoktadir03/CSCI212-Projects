import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * This class demonstrates a simple application that counts the frequency of words in a text file.
 */
public class Project4 {
    /**
     * The main method of the application.
     * It prompts the user to select a file using a file chooser dialog,
     * then calls the wordFrequencyCount method to count the frequency of words in the selected file.
     *
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        // Initialize filename to an empty string
        String filename = "";

        // Declare and initialize a file chooser
        JFileChooser chooser;
        int status;
        chooser = new JFileChooser();
        // Display the file chooser dialog and get the user's selection
        status = chooser.showOpenDialog(null);
        // If the user selects a file, get its absolute path
        if (status == JFileChooser.APPROVE_OPTION)
            filename = chooser.getSelectedFile().getAbsolutePath();
        else
            // If the user cancels the dialog, show a message dialog
            JOptionPane.showMessageDialog(null, "Open File dialog canceled");
        // Print the selected file's absolute path
        System.out.println(filename);
        // Call the wordFrequencyCount method to count word frequencies in the selected file
        wordFrequencyCount(filename);
    }
    /**
     * Counts the frequency of each word in the specified file and prints the results.
     *
     * @param filename The name of the file to analyze.
     */
        public static void wordFrequencyCount (String filename) {
            // Initialize an ArrayList to store words from the file
            ArrayList<String> wordsList = new ArrayList<>();
            try {
                // Create a Scanner to read from the file
                Scanner scanner = new Scanner(new File(filename));
                // Read each line from the file and process it
                while (scanner.hasNextLine()) {
                    // Convert the line to lowercase and split it into words
                    String line = scanner.nextLine().toLowerCase();
                    String[] words = line.split("[^a-zA-Z]+");
                    // Add the words to the ArrayList
                    wordsList.addAll(Arrays.asList(words));
                }
                // Closes the Scanner
                scanner.close();
            } catch (FileNotFoundException e) {
                // If the file is not found, print the error and return
                e.printStackTrace();
                return;
            }

            // Create a TreeMap to store word counts (sorted by word)
            TreeMap<String, Integer> wordCountMap = new TreeMap<>();
            // Count the frequency of each word in the ArrayList
            for (String word : wordsList) {
                // Skip empty words
                if (!word.isEmpty()) {
                    // Increment the count for the current word in the TreeMap
                    wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                }
            }

            // Print the word frequencies
            for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }
        }
    }
