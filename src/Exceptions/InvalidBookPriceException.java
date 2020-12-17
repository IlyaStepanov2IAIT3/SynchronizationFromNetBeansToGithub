package Exceptions;

public class InvalidBookPriceException extends IllegalArgumentException {
    public InvalidBookPriceException(String message) {
        super(message);
    }
}
