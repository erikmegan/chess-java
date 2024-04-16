package games.chess.exception;

public class CloseReaderException extends Exception{
    public CloseReaderException(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public String getMessage() {
        return "Reader Closed";
    }
}
