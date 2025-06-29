public class SortedWordList extends WordList {
    // Constructor for SortedWordList class
    public SortedWordList(){
        super(); // Call the constructor of the superclass (WordList)
    }

    // Method to add a word to the sorted list
    public void add(Word w){
        // Create a new node for the word
        WordNode node = new WordNode(w);
        // Initialize pointers for traversing the list
        WordNode pointer1 = front;// left pointer
        WordNode pointer2 = front.next; // right pointer
        // Traverse the list until the end or until the new word comes after the current word
        while(pointer2!= null && node.data.getWord().compareTo(pointer2.data.getWord())>0 ){
            pointer1 = pointer1.next; // Move left pointer forward
            pointer2 = pointer2.next; // Move right pointer forward
        }
        // Insert the new word node between pointer1 and pointer2
        node.next = pointer2;
        pointer1.next = node;
    }

    // Method to print the sorted word list
    public void print(){
        WordNode b = front.next; // Start from the first node after the dummy node
        // Traverse the list and print each word
        while(b!=null){
            System.out.println(b.data.getWord());
            b = b.next; // Move to the next node
        }
    }
}