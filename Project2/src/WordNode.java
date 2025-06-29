public class WordNode {
    protected Word data; // Data stored in the node
    protected WordNode next; // Reference to the next node in the list

    // Constructor for WordNode class
    public WordNode(Word w){
        data = w; // Initialize the data of the node with the given word
    }

    // Method to get the data stored in the node
    public Word getData(){
        return data; // Return the data of the node
    }

    // Method to get the reference to the next node in the list
    public  WordNode getNext(){
        return next; // Return the next node
    }
}
