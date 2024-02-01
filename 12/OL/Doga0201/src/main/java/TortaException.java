public class TortaException extends Exception {
    public TortaException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "TortaException keletkezett: " + getMessage();
    }
}
