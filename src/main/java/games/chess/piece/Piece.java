package games.chess.piece;

import games.chess.constant.ChessPieceColor;
import games.chess.exception.InvalidMoveException;
import games.chess.handler.Board;

import java.util.List;

public interface Piece {

    void move(Board chessBoard, Integer to)throws InvalidMoveException;

    void possibleMove();

}
