package games.chess.handler;

import games.chess.constant.ChessPieceColor;
import games.chess.exception.InvalidMoveException;
import games.chess.exception.InvalidTurnException;
import games.chess.piece.AbstractPiece;


public class CommandHandler {

    private final Board chessBoard;

    public CommandHandler(Board chessBoard) {
        this.chessBoard = chessBoard;

    }

    public void validateTurnColor(String chessPiece) throws InvalidTurnException{
        if (chessBoard.getTurnColor() == ChessPieceColor.WHITE){
            if(!chessBoard.getWhitePieces().contains(chessPiece.toUpperCase())){
                throw new InvalidTurnException(chessBoard.getTurnColor().toString());
            }
        }else if(chessBoard.getTurnColor() == ChessPieceColor.BLACK){
            if(!chessBoard.getBlackPieces().contains(chessPiece.toUpperCase())){
                throw new InvalidTurnException(chessBoard.getTurnColor().toString());
            }
        }
    }
    public void move(String chessPiece, Integer to)throws InvalidMoveException {
        AbstractPiece abstractPiece = chessBoard.getPieceMap().get(chessPiece.toUpperCase());
        abstractPiece.move(chessBoard,to);
        alternateTurn();
    }

    private void alternateTurn(){
        switch (chessBoard.getTurnColor()){
            case ChessPieceColor.WHITE:
                chessBoard.setTurnColor(ChessPieceColor.BLACK);
                break;
            case ChessPieceColor.BLACK:
                chessBoard.setTurnColor(ChessPieceColor.WHITE);
                break;
        }
        chessBoard.printBoard();
    }

    public void infoPossibleMove(String chessPiece){
        AbstractPiece abstractPiece = chessBoard.getPieceMap().get(chessPiece.toUpperCase());
        abstractPiece.infoPossibleMove(chessBoard);
    }
}
