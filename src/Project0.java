import javax.swing.JOptionPane;

public class Project0 {
    public static void main(String[] args) {
        while (true) {
            // Ask the user to enter a sentence using a JOptionPane dialog.
            String input = JOptionPane.showInputDialog("Type a sentence (or 'Stop' to exit):");
            // Check if the input is null or equals "Stop" (case-insensitive) to exit the program.
            if (input == null || input.equalsIgnoreCase("Stop")) {
                break;
            }
            // Initialize counters for uppercase 'E' and lowercase 'e' occurrences.
            int upperCaseECount = 0;
            int lowerCaseECount = 0;
            // Iterate through each character in the input sentence using a for loop.
            for (int i = 0; i < input.length(); i++) {
                // Get the current character at position 'i'.
                char c = input.charAt(i);
                // Check if the character is an uppercase 'E'.
                if (c == 'E') {
                    upperCaseECount++;
                }
                // Check if the character is a lowercase 'e'.
                else if (c == 'e') {
                    lowerCaseECount++;
                }
            }
            // Construct a message string with the counts.
            String message = "Number of uppercase 'E's: " + upperCaseECount + "\n" + "Number of lowercase 'e's: " + lowerCaseECount;
            // Display the message using a JOptionPane dialog.
            JOptionPane.showMessageDialog(null, message);
        }
    }
}
