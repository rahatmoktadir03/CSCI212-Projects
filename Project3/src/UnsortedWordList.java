/**
 * The UnsortedWordList class represents an unsorted list of words.
 * It extends the WordList class and implements a method to add words to the unsorted list.
 */
public class UnsortedWordList extends WordList {

    /**
     * Constructs an UnsortedWordList object.
     * Calls the constructor of the superclass (WordList).
     */
    // Constructor for UnsortedWordList class
    public UnsortedWordList(){
        super(); // Call the constructor of the superclass (WordList)
    }

    /**
     * Adds a word to the unsorted list.
     *
     * @param w The word to be added to the unsorted list.
     */
    // Method to add a word to the unsorted list
    public void add(Word w){
        append(w); // Call the append method from the superclass to add the word
    }
}