package games.chess.piece;

import games.chess.constant.Coordinate;
import java.util.HashMap;
import java.util.List;

/**
 * @author ErikMegantara
 */
public interface IPiece {
  HashMap<String, List<Coordinate>> findPossibleMoves(int y, int x);


   boolean validate(IPiece iPiece, int toY, int toX, IPiece[][] board,
      HashMap<String, IPiece> pieceFactory,
      HashMap<String, IPiece> deathFactory);

  int getY();

  int getX();

  void setY(int y);

  void setX(int x);

  String getClassName();

  String getName();

  String getType();
}
