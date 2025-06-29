/**
 * The WordNode class represents a node in a linked list of words.
 * It contains the data stored in the node and a reference to the next node in the list.
 */
public class WordNode {
    /** Data stored in the node. */
    protected Word data; // Data stored in the node
    /** Reference to the next node in the list. */
    protected WordNode next; // Reference to the next node in the list

    /**
     * Constructs a WordNode object with the specified word.
     *
     * @param w The word to be stored in the node.
     */
    // Constructor for WordNode class
    public WordNode(Word w){
        data = w; // Initialize the data of the node with the given word
    }

    /**
     * Retrieves the data stored in the node.
     *
     * @return The word stored in the node.
     */
    // Method to get the data stored in the node
    public Word getData(){
        return data; // Return the data of the node
    }

    /**
     * Retrieves the reference to the next node in the list.
     *
     * @return The reference to the next node.
     */
    // Method to get the reference to the next node in the list
    public  WordNode getNext(){
        return next; // Return the next node
    }
}
