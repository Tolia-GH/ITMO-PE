package Collection.Exceptions;

public class CommandUsageException extends RuntimeException {
    public CommandUsageException() {
        super();
    }
    public CommandUsageException(String message) {
        super(message);
    }
}
