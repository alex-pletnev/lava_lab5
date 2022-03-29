package exception;

public class IncorrectCoordinateException extends NumberFormatException {
    public IncorrectCoordinateException() {
    }

    public IncorrectCoordinateException(String message) {
        super(message);
    }
}
