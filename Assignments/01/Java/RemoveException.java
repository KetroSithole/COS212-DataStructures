public class RemoveException extends Throwable {
    public RemoveException(String s) {
        message = s;
    }

    public String getMessage() {
        return message;
    }

    private String message;
}
