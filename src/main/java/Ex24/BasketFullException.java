package Ex24;

public class BasketFullException extends RuntimeException{
    public BasketFullException() {
        super("twoj koszyk jest pelny");
    }

    public BasketFullException(String message) {
        super(message);
    }
}
