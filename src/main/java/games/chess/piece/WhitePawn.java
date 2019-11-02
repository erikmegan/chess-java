package games.chess.piece;

import games.chess.constant.ChessPiece;
import games.chess.constant.Coordinate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WhitePawn extends AbstractPieceChessGeneral {

  public WhitePawn(String name, int y, int x) {
    super.name = name;
    super.y = y;
    super.x = x;
  }

  public String getClassName() {
    return WhitePawn.class.getName();
  }

  public void searchForwardLeft(int y, int x) {
    List<Coordinate> list = new ArrayList<Coordinate>();
    int tempY = y;
    int tempX = x;
    tempX = tempX - 1;
    tempY = tempY + 1;
    if (firstStep) {
      if (tempY >= 0 && tempX >= 0 && tempY < 8) {
        list.add(new Coordinate(tempY, tempX, true));
        possibleMove.put("searchForwardLeft", list);
      }
    }
    firstStep = false;
  }

  public void searchForwardRight(int y, int x) {
    List<Coordinate> list = new ArrayList<Coordinate>();
    int tempY = y;
    int tempX = x;
    tempX = tempX + 1;
    tempY = tempY + 1;
    if (firstStep) {
      if (tempY >= 0 && tempX >= 0 && tempY < 8 && tempX < 8) {
        list.add(new Coordinate(tempY, tempX, true));
        possibleMove.put("searchForwardRight", list);
      }
    }
    firstStep = false;
  }

  public void searchLeftTop(int y, int x) {
  }

  public void searchLeftBottom(int y, int x) {
  }

  public void searchRightTop(int y, int x) {
  }

  public void searchRightBottom(int y, int x) {
  }

  public void searchBackwardLeft(int y, int x) {
  }

  public void searchBackwardRight(int y, int x) {
  }

  public void searchForward(int y, int x) {
    List<Coordinate> list = new ArrayList<Coordinate>();
    if (y == 1) {
      list.add(new Coordinate(y + 2, x));
      possibleMove.put("searchForward", list);
    }
    list.add(new Coordinate(y + 1, x));
    possibleMove.put("searchForward", list);


  }

  public void searchBackward(int y, int x) {
  }

  public void searchLeft(int y, int x) {
  }

  public void searchRight(int y, int x) {
  }

  private boolean firstStep = true;

  public boolean validate(IPiece iPiece, int toY, int toX, IPiece[][] board,
      HashMap<String, IPiece> pieceFactory,
      HashMap<String, IPiece> deathFactory) {

    HashMap<String, List<Coordinate>> listPossibleMove = iPiece
        .findPossibleMoves(iPiece.getY(), iPiece.getX());
    boolean isValid = false;

    for (Map.Entry<String, List<Coordinate>> entry : listPossibleMove.entrySet()) {
      for (Coordinate coor : entry.getValue()) {
        IPiece existPiece = board[coor.getY()][coor.getX()];

        if (coor.isDiagonalPawn() && existPiece == null) {
          // Do Nothing
        } else if (!coor.isDiagonalPawn() && existPiece == null) {
          if (coor.getX() == toX && coor.getY() == toY) {
            int prevY = iPiece.getY();
            int prevX = iPiece.getX();
            iPiece.setY(toY);
            iPiece.setX(toX);
            board[toY][toX] = pieceFactory.get(iPiece.getName());
            board[prevY][prevX] = null;
            isValid = true;
          }
        } else {
          if (coor.isDiagonalPawn() && existPiece != null && !existPiece.getType()
              .equals(iPiece.getType())) {
            int prevY = iPiece.getY();
            int prevX = iPiece.getX();
            iPiece.setY(toY);
            iPiece.setX(toX);
            board[toY][toX] = pieceFactory.get(iPiece.getName());
            board[prevY][prevX] = null;
            isValid = true;
            deathFactory.put(existPiece.getName(), existPiece);
            System.out.println(existPiece.getName() + " move to death area");
          }

        }
      }


    }
    return isValid;
  }


  public String getType() {
    return ChessPiece.CHESS_TYPE_WHITE;
  }
}