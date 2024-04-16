package games.chess.handler;

import games.chess.constant.ChessPieceColor;
import games.chess.exception.InvalidMoveException;
import games.chess.exception.InvalidTurnException;
import games.chess.piece.AbstractPiece;
import games.chess.piece.Piece;


public class CommandHandler {

    private final Board chessBoard;

    private Piece piece;

    public CommandHandler(Board chessBoard) {
        this.chessBoard = chessBoard;

    }

    public boolean validateTurnColor(String chessPiece) throws InvalidTurnException{
        if (chessBoard.getTurnColor() == ChessPieceColor.WHITE){
            if(!chessBoard.getWhitePieces().contains(chessPiece.toUpperCase())){
                throw new InvalidTurnException(chessBoard.getTurnColor().toString());
            }
        }else if(chessBoard.getTurnColor() == ChessPieceColor.BLACK){
            if(!chessBoard.getBlackPieces().contains(chessPiece.toUpperCase())){
                throw new InvalidTurnException(chessBoard.getTurnColor().toString());
            }
        }
        return true;
    }
    public void move(String chessPiece, Integer to)throws InvalidMoveException {
        // to do

        AbstractPiece abstractPiece = chessBoard.getPieceMap().get(chessPiece.toUpperCase());
        abstractPiece.move(chessBoard,to);

    }

    public void alternateTurn(){
        if(chessBoard.getTurnColor().equals(ChessPieceColor.WHITE)) {
            chessBoard.setTurnColor(ChessPieceColor.BLACK);
        }else if(chessBoard.getTurnColor().equals(ChessPieceColor.BLACK)){
            chessBoard.setTurnColor(ChessPieceColor.WHITE);
        }
        chessBoard.printBoard();
    }
}
