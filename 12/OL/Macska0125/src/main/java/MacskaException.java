public class MacskaException extends Exception {
    public MacskaException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "MacskaException keletkezett: " + getMessage();
    }
}
