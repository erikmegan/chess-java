package games.chess.exception;

public class InvalidTurnException extends Exception{
    private String name;

    public InvalidTurnException(String name) {
        this.name = name;
    }

    @Override
    public String getMessage() {
        return "it is " + this.name + " turn";
    }
}
