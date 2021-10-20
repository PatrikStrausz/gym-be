package sk.kosickaakademia.strausz.exception;

public class InvalidLoginDataException extends RuntimeException {

    public InvalidLoginDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
