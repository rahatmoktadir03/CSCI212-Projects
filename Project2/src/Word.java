public class Word {
    String z; // Member variable to store the word

    // Constructor for Word object
    public Word(String string){
        this.z = string; // Initialize the word using the constructor parameter
    }

    // Method to get the word
    public String getWord(){
        return z; // Return the stored word
    }

    // Method to set the word
    public void setWord(String string){
        this.z = string; // Set the word using the parameter value
    }
}
