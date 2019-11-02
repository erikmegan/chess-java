package games.chess.piece;

import games.chess.constant.ChessPiece;
import games.chess.constant.Coordinate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ErikMegantara
 */
public class BlackKnight extends AbstractPieceChessGeneral {

  public BlackKnight(String name, int y, int x){
    super.name = name;
    super.y = y;
    super.x = x;
  }

  public String getClassName() {
    return BlackKnight.class.getName();
  }

  public void searchForward(int y, int x) {
  }

  public void searchBackward(int y, int x) {
  }

  public void searchLeft(int y, int x) {
  }

  public void searchRight(int y, int x) {
  }

  public void searchForwardLeft(int y, int x) {
    int tempY = y + 2;
    int tempX = x - 1;
    if (tempY >= 0 && tempX >= 0) {
      List<Coordinate> list = new ArrayList<Coordinate>();
      list.add(new Coordinate(tempY, tempX));
      possibleMove.put("searchForwardLeft", list);
    }
  }

  public void searchForwardRight(int y, int x) {
    int tempY = y + 2;
    int tempX = x + 1;
    if (tempY >= 0 && tempX >= 0) {
      List<Coordinate> list = new ArrayList<Coordinate>();
      list.add(new Coordinate(tempY, tempX));
      possibleMove.put("searchForwardRight", list);
    }
  }

  public void searchLeftTop(int y, int x) {
    int tempY = y + 1;
    int tempX = x - 2;
    if (tempY >= 0 && tempX >= 0) {
      List<Coordinate> list = new ArrayList<Coordinate>();
      list.add(new Coordinate(tempY, tempX));
      possibleMove.put("searchLeftTop", list);
    }
  }

  public void searchLeftBottom(int y, int x) {
    int tempY = y - 1;
    int tempX = x - 2;
    if (tempY >= 0 && tempX >= 0) {
      List<Coordinate> list = new ArrayList<Coordinate>();
      list.add(new Coordinate(tempY, tempX));
      possibleMove.put("searchLeftBottom", list);
    }
  }

  public void searchRightTop(int y, int x) {
    int tempY = y + 1;
    int tempX = x + 2;
    if (tempY >= 0 && tempX >= 0) {
      List<Coordinate> list = new ArrayList<Coordinate>();
      list.add(new Coordinate(tempY, tempX));
      possibleMove.put("searchRightTop", list);
    }
  }

  public void searchRightBottom(int y, int x) {
    int tempY = y - 1;
    int tempX = x + 2;
    if (tempY >= 0 && tempX >= 0) {
      List<Coordinate> list = new ArrayList<Coordinate>();
      list.add(new Coordinate(tempY, tempX));
      possibleMove.put("searchRightBottom", list);
    }
  }

  public void searchBackwardLeft(int y, int x) {
    int tempY = y - 2;
    int tempX = x - 1;
    if (tempY >= 0 && tempX >= 0) {
      List<Coordinate> list = new ArrayList<Coordinate>();
      list.add(new Coordinate(tempY, tempX));
      possibleMove.put("searchBackwardLeft", list);
    }
  }

  public void searchBackwardRight(int y, int x) {
    int tempY = y - 2;
    int tempX = x + 1;
    if (tempY >= 0 && tempX >= 0) {
      List<Coordinate> list = new ArrayList<Coordinate>();
      list.add(new Coordinate(tempY, tempX));
      possibleMove.put("searchBackwardRight", list);
    }
  }

  public boolean validate(IPiece iPiece, int toY, int toX, IPiece[][] board,
      HashMap<String, IPiece> pieceFactory,
      HashMap<String, IPiece> deathFactory)
  {
    HashMap<String, List<Coordinate>> listPossibleMove = iPiece
        .findPossibleMoves(iPiece.getY(), iPiece.getX());
    for (Map.Entry<String, List<Coordinate>> entry : listPossibleMove.entrySet()) {
      List<Coordinate> lists = entry.getValue();
      for (Coordinate a : lists) {
        if (a.getY() == toY && a.getX() == toX) {
          IPiece existPiece = board[toY][toX];
          if (existPiece == null) { // case when destination is available
            int prevY = iPiece.getY();
            int prevX = iPiece.getX();
            iPiece.setY(toY);
            iPiece.setX(toX);
            board[toY][toX] = pieceFactory.get(iPiece.getName());
            board[prevY][prevX] = null;
            return true;
          } else {
            if (existPiece.getType()
                .equals(iPiece.getType())) { // case when same piece move to sampe place
              System.out.println("cannot move to same type of piece");
            } else {
              if (!existPiece.getType().equals(iPiece.getType())) {
                deathFactory.put(existPiece.getName(), existPiece);
                System.out.println(existPiece.getName() + " move to death area");
              }
              int prevY = iPiece.getY();
              int prevX = iPiece.getX();
              iPiece.setY(toY);
              iPiece.setX(toX);
              board[toY][toX] = pieceFactory.get(iPiece.getName());
              board[prevY][prevX] = null;
              return true;
            }
          }
        }
      }
    }
    return false;
  }


  public String getType() {
    return ChessPiece.CHESS_TYPE_BLACK;
  }
}
