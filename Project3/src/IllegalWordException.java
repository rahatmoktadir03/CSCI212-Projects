/**
 * The IllegalWordException class represents a custom exception for illegal words.
 * It extends the IllegalArgumentException class, indicating that it is a type of
 * IllegalArgumentException specifically for handling illegal words.
 */
// Custom exception class for illegal words
class IllegalWordException extends IllegalArgumentException {
    /**
     * Constructs an IllegalWordException with the specified error message.
     *
     * @param message The detail message explaining the reason for the exception.
     */
    // Constructor for IllegalWordException
    public IllegalWordException(String message) {
        super(message); // Pass the error message to the superclass (IllegalArgumentException)
    }
}
