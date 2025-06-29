public class UnsortedWordList extends WordList {
    // Constructor for UnsortedWordList class
    public UnsortedWordList(){
        super(); // Call the constructor of the superclass (WordList)
    }

    // Method to add a word to the unsorted list
    public void add(Word w){
        append(w); // Call the append method from the superclass to add the word
    }
}
