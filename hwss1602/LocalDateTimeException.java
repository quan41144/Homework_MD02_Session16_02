package hwss1602;

public class LocalDateTimeException extends RuntimeException {
    public LocalDateTimeException() {super("Enter not valid date");}
    public LocalDateTimeException(String message) {
        super(message);
    }
}
