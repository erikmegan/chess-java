package games.chess.client;

import games.chess.exception.CloseReaderException;
import games.chess.exception.GameDoneException;
import games.chess.exception.InvalidMoveException;
import games.chess.exception.InvalidTurnException;
import games.chess.handler.CommandHandler;
import games.chess.utils.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;

public class Client {

    private final BufferedReader inputReader;

    private final CommandHandler commandHandler;

    public boolean gameDone = false;

    private String chessPiece;

    private Integer to;

    public Client(BufferedReader inputReader, CommandHandler commandHandler) {
        this.inputReader = inputReader;
        this.commandHandler = commandHandler;
    }

    public void handleInput() throws IOException,CloseReaderException{
        boolean cont = true;
        while (cont){
            try {
                handleInputChessPiece();
                handleInputCoor();
                commandHandler.move(chessPiece,to);
                commandHandler.alternateTurn();
                if(gameDone){
                    cont=false;
                }

            }
            catch (GameDoneException | InvalidMoveException e){
                System.out.println("Error : " +  e.getMessage());
            }
        }
        inputReader.close();


    }
    public void handleInputChessPiece() throws IOException,CloseReaderException,GameDoneException {
        boolean cont = true;
        while (cont){
            try {
                System.out.print("input chess piece :");
                String inputLine = this.inputReader.readLine();
                if (inputLine == null) break;

                inputLine = inputLine.trim();
                if (inputLine.isEmpty()) continue;

                if (inputLine.equalsIgnoreCase("exit")){
                    throw new CloseReaderException("exit");
                }

                if (commandHandler.validateTurnColor(inputLine)) {
                    cont = false;
                    chessPiece = inputLine;
                }
            } catch (InvalidTurnException e) {
                System.out.println("Error : " + e.getMessage());
            }
        }
    }
    public void handleInputCoor() throws IOException,CloseReaderException,GameDoneException {
        boolean cont = true;
        while (cont){
            try {
                System.out.print("input coordinate :");
                String inputLine = this.inputReader.readLine();
                if (inputLine == null) break;
                inputLine = inputLine.trim();
                if (inputLine.isEmpty()) continue;
                if (inputLine.equalsIgnoreCase("exit")){
                    throw new CloseReaderException("exit");
                }
                if(!StringUtils.isInteger(inputLine)) throw new NumberFormatException();

//                cont = !commandHandler.move(chessPiece,Integer.parseInt(inputLine));
//                if(commandHandler.move(chessPiece,Integer.parseInt(inputLine))){
                cont = false;
                to = Integer.parseInt(inputLine);
//                }
            }catch ( NumberFormatException e){
                System.out.println("Error : " + e.getMessage());
            }
        }

    }

}
