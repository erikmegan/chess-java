package games.chess.exception;

public class InvalidMoveException extends Exception{
    private String name;

    public InvalidMoveException(String name) {
        this.name = name;
    }

    @Override
    public String getMessage() {
        return "invalid coordinate";
    }
}
