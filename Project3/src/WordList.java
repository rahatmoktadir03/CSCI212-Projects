/**
 * The WordList abstract class represents a list of words.
 * It provides a method to append a word to the end of the list.
 */
public abstract class WordList {
    /** Reference to the front node of the list. */
    public WordNode front; // Reference to the front node of the list
    /** Reference to the end node of the list. */
    public WordNode end; // Reference to the end node of the list
    /** Length of the list. */
    public int length; // Length of the list

    /**
     * Constructs a WordList object.
     * Initializes the front and end references to a dummy node and sets the length to zero.
     */
    // Constructor for WordList class
    public WordList(){
        // Create a dummy node to represent the front and end of the list
        WordNode morgan = new WordNode(null);
        front = morgan;
        end = morgan;
        length = 0; // Initialize the length to zero
    }

    /**
     * Appends a word to the end of the list.
     *
     * @param w The word to be appended to the list.
     */
    // Method to append a word to the end of the list
    public void append(Word w){
        WordNode node = new WordNode(w); // Create a new node with the given word
        end.next = node; // Link the new node to the end of the list
        end = node; // Update the end reference to the new node
        length++; // Increment the length of the list
    }
}