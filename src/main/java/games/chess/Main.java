package games.chess;

import games.chess.client.Client;
import games.chess.exception.CloseReaderException;
import games.chess.handler.Board;
import games.chess.handler.CommandHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

        Board chessBoard = new Board();
        chessBoard.init();
        CommandHandler commandHandler = new CommandHandler(chessBoard);
        chessBoard.printBoard();


        try {
            Client client = new Client(new BufferedReader(new InputStreamReader(System.in)),commandHandler);
            client.handleInput();
        }catch (IOException e){
            System.out.println("IOException : "+ e.getMessage());
        }catch (CloseReaderException e){
            System.out.println(e.getMessage());
        }



    }
}