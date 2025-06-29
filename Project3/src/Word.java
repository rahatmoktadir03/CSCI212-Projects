/**
 * The Word class represents a word.
 * It provides methods to construct, get, and set the word, and throws an IllegalWordException
 * if the word contains non-lowercase letters.
 */
public class Word {
    /** The string representing the word. */
    String z; // Member variable to store the word

    /**
     * Constructs a Word object with the specified string.
     * Throws IllegalWordException if the string contains non-lowercase letters.
     *
     * @param string The string representing the word.
     * @throws IllegalWordException If the string contains non-lowercase letters.
     */
    // Constructor for Word object
    public Word(String string){
        // Check if the string contains any non-lowercase letters
        if (!string.matches("[a-z]+")) {
            // Throw IllegalWordException if the string contains illegal characters
            throw new IllegalWordException("The word contains non-lowercase letters: " + string);
        }
        this.z = string; // Initialize the word using the constructor parameter
    }

    /**
     * Retrieves the word.
     *
     * @return The string representing the word.
     */
    // Method to get the word
    public String getWord(){
        return z; // Return the stored word
    }

    /**
     * Sets the word with the specified string.
     * Throws IllegalWordException if the string contains non-lowercase letters.
     *
     * @param string The string representing the word.
     * @throws IllegalWordException If the string contains non-lowercase letters.
     */
    // Method to set the word
    public void setWord(String string){
        // Check if the string contains any non-lowercase letters
        if (!string.matches("[a-z]+")) {
            // Throw IllegalWordException if the string contains illegal characters
            throw new IllegalWordException("The word contains non-lowercase letters: " + string);
        }
        this.z = string; // Set the word using the parameter value
    }
}
