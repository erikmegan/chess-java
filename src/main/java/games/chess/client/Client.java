package games.chess.client;

import games.chess.exception.CloseReaderException;
import games.chess.exception.GameDoneException;
import games.chess.exception.InvalidMoveException;
import games.chess.exception.InvalidTurnException;
import games.chess.handler.CommandHandler;
import games.chess.utils.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

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

    // for single input line
    public void handleInput()throws IOException,CloseReaderException{
        try {
            while (true) {
                System.out.print("input chess piece and coordinate :");
                String inputLine = this.inputReader.readLine();
                if (inputLine == null) break;

                inputLine = inputLine.trim();
                if (inputLine.isEmpty()) continue;

                if (inputLine.equalsIgnoreCase("exit")) {
                    throw new CloseReaderException("exit");
                }

                if (gameDone) {
                    break;
                }

                processInputLine(inputLine);
            }
        }
        finally {
            inputReader.close();
        }

    }
    private void processInputLine(String inputLine){
        String[] inputChunks = inputLine.split(" ");

        String piece = inputChunks[0];
        String[] params = Arrays.copyOfRange(inputChunks,1,inputChunks.length);

        try {
            commandHandler.validateTurnColor(piece);
            if(!StringUtils.isInteger(params[0])){
                if (params[0].equals("info")) {
                    // todo create command to give info available move
                    commandHandler.infoPossibleMove(piece);
                }else{
                    throw new NumberFormatException("coordinate must be integer");
                }
            }else{
                this.to = Integer.parseInt(params[0]);
                commandHandler.move(piece,to);
            }
        }catch (InvalidMoveException | InvalidTurnException | NumberFormatException e){
            System.out.println("Error : " + e.getMessage());
        }
    }


    // for 2 input line
    public void handleInput2line() throws IOException,CloseReaderException{
        boolean cont = true;
        while (cont){
            try {
                handleInputChessPiece();
                handleInputCoor();
                commandHandler.move(chessPiece,to);
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

                commandHandler.validateTurnColor(inputLine);
                this.chessPiece = inputLine;

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

                cont = false;
                this.to = Integer.parseInt(inputLine);
            }catch ( NumberFormatException e){
                System.out.println("Error : " + e.getMessage());
            }
        }
    }

}
