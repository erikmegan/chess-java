package games.chess.exception;

public class GameDoneException extends Exception{

    private String name;

    public GameDoneException(String name) {
        this.name = name;
    }

    @Override
    public String getMessage() {
        return "game Done: " + name + " win";
    }
}
