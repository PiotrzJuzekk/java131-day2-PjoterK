package Ex24;

public class BasketEmptyException extends RuntimeException {
    public BasketEmptyException() {
        super("uzupelnij koszyk");
    }

    public BasketEmptyException(String message) {
        super(message);
    }
}
