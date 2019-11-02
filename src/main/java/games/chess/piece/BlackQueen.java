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
public class BlackQueen extends AbstractPieceChessGeneral {

  public BlackQueen(String name, int y, int x){
    super.name = name;
    super.y = y;
    super.x = x;
  }

  public void searchLeftTop(int y, int x) {
  }

  public void searchLeftBottom(int y, int x) {
  }

  public void searchRightTop(int y, int x) {
  }

  public void searchRightBottom(int y, int x) {
  }
  public void searchForwardLeft(int y, int x) {
    List<Coordinate> list = new ArrayList<Coordinate>();
    int tempY = y;
    int tempX = x;
    while (true) {
      tempX = tempX - 1;
      tempY = tempY + 1;
      if (tempY >= 0 && tempX >= 0 && tempY < 8) {
        list.add(new Coordinate(tempY, tempX));
        possibleMove.put("searchForwardLeft", list);
      } else {
        break;
      }
    }
  }

  public void searchForwardRight(int y, int x) {
    List<Coordinate> list = new ArrayList<Coordinate>();
    int tempY = y;
    int tempX = x;
    while (true) {
      tempX = tempX + 1;
      tempY = tempY + 1;
      if (tempY >= 0 && tempX >= 0 && tempY < 8 && tempX < 8) {
        list.add(new Coordinate(tempY, tempX));
        possibleMove.put("searchForwardRight", list);
      } else {
        break;
      }
    }
  }

  public void searchBackwardLeft(int y, int x) {
    List<Coordinate> list = new ArrayList<Coordinate>();
    int tempY = y;
    int tempX = x;
    while (true) {
      tempX = tempX - 1;
      tempY = tempY - 1;
      if (tempY >= 0 && tempX >= 0 && tempY < 8 && tempX < 8) {
        list.add(new Coordinate(tempY, tempX));
        possibleMove.put("searchBackwardLeft", list);
      } else {
        break;
      }
    }
  }

  public void searchBackwardRight(int y, int x) {
    List<Coordinate> list = new ArrayList<Coordinate>();
    int tempY = y;
    int tempX = x;
    while (true) {
      tempX = tempX + 1;
      tempY = tempY - 1;
      if (tempY >= 0 && tempX >= 0 && tempX < 8) {
        list.add(new Coordinate(tempY, tempX));
        possibleMove.put("searchBackwardRight", list);
      } else {
        break;
      }
    }
  }

  public void searchForward(int y, int x) {
    List<Coordinate> list = new ArrayList<Coordinate>();
    for (int i = y + 1; i < 8; i++) {
      list.add(new Coordinate(i, x));
      possibleMove.put("searchForward", list);
    }
  }

  public void searchBackward(int y, int x) {
    List<Coordinate> list = new ArrayList<Coordinate>();
    for (int i = y - 1; i > 0; i--) {
      list.add(new Coordinate(i, x));
      possibleMove.put("searchBackward", list);
    }
  }

  public void searchLeft(int y, int x) {
    List<Coordinate> list = new ArrayList<Coordinate>();
    for (int j = x - 1; j > 0; j--) {
      list.add(new Coordinate(y, j));
      possibleMove.put("searchLeft", list);
    }
  }

  public void searchRight(int y, int x) {
    List<Coordinate> list = new ArrayList<Coordinate>();
    for (int j = x + 1; j < 8; j++) {
      list.add(new Coordinate(y, j));
      possibleMove.put("searchRight", list);
    }
  }

  public boolean validate(IPiece iPiece, int toY, int toX, IPiece[][] board,
      HashMap<String, IPiece> pieceFactory,
      HashMap<String, IPiece> deathFactory)
  {
    HashMap<String, List<Coordinate>> listPossibleMove = iPiece
        .findPossibleMoves(iPiece.getY(), iPiece.getX());
    boolean isValid = false;

    for (Map.Entry<String, List<Coordinate>> entry : listPossibleMove.entrySet()) {
      for(Coordinate coor : entry.getValue()){
        IPiece existPiece = board[coor.getY()][coor.getX()];
        if (toX == coor.getX() && toY == coor.getY()) {
          if (existPiece != null && existPiece.getType().equals(iPiece.getType())) {
            isValid = false;
            break;
          }
          deathFactory.put(existPiece.getName(), existPiece);
          System.out.println(existPiece.getName() + " move to death area");
          isValid = true;
          break;
        }
      }

      if (isValid) {
        break;
      }

    }

    if (isValid) {
      int prevY = iPiece.getY();
      int prevX = iPiece.getX();
      iPiece.setY(toY);
      iPiece.setX(toX);
      board[toY][toX] = pieceFactory.get(iPiece.getName());
      board[prevY][prevX] = null;
    }
    return isValid;
  }

  public String getClassName() {
    return BlackQueen.class.getName();
  }

  public String getType() {
    return ChessPiece.CHESS_TYPE_BLACK;
  }
}
