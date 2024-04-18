package games.chess.client;


import games.chess.exception.CloseReaderException;
import games.chess.exception.InvalidTurnException;
import games.chess.handler.Board;
import games.chess.handler.CommandHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;


public class ClientTests {

    private static CommandHandler commandHandler;

    @BeforeAll
    public static void setup(){
        Board chessBoard = new Board();
        chessBoard.init();
        commandHandler = new CommandHandler(chessBoard);
    }

    @Test
    public void handleInput2line_exit() throws CloseReaderException, IOException {
        Client client = new Client(new BufferedReader(new StringReader("exit")), commandHandler);
        Assertions.assertThrows(CloseReaderException.class,() -> client.handleInput2line(), "Reader Closed");
    }

    @Test
    public void handleInput_exit() throws CloseReaderException, IOException {
        Client client = new Client(new BufferedReader(new StringReader("exit")), commandHandler);
        Assertions.assertThrows(CloseReaderException.class,() -> client.handleInput(), "Reader Closed");
    }


}
