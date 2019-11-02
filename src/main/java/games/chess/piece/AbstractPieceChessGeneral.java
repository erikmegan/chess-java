package games.chess.piece;

import games.chess.constant.Coordinate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author ErikMegantara
 */
public abstract class AbstractPieceChessGeneral implements IPiece {

  public HashMap<String, List<Coordinate>> possibleMove = new HashMap<String, List<Coordinate>>();
  public List<Coordinate> lists = new ArrayList<Coordinate>();

  protected String name;
  int y, x;

  public abstract void searchForwardLeft(int y, int x);

  public abstract void searchForwardRight(int y, int x);

  public abstract void searchBackwardLeft(int y, int x);

  public abstract void searchBackwardRight(int y, int x);

  public abstract void searchLeftTop(int y, int x);

  public abstract void searchLeftBottom(int y, int x);

  public abstract void searchRightTop(int y, int x);

  public abstract void searchRightBottom(int y, int x);

  public abstract void searchForward(int y, int x);

  public abstract void searchBackward(int y, int x);

  public abstract void searchLeft(int y, int x);

  public abstract void searchRight(int y, int x);

  public HashMap<String, List<Coordinate>> findPossibleMove(int y, int x) {
    searchForwardLeft(y, x);
    searchForwardRight(y, x);
    searchRightBottom(y, x);
    searchRightTop(y, x);
    searchLeftBottom(y, x);
    searchLeftTop(y, x);
    searchBackwardLeft(y, x);
    searchBackwardRight(y, x);

    searchForward(y, x);
    searchBackward(y, x);
    searchLeft(y, x);
    searchRight(y, x);
    return possibleMove;
  }

  public HashMap<String, List<Coordinate>> findPossibleMoves(int y, int x) {
    System.out.println("Success move " + getName() + " from : " + y + ", " + x);
    System.out.println();
    HashMap<String,List<Coordinate>> posibleMove = findPossibleMove(y, x);
    return posibleMove;
  }

  public abstract boolean validate(IPiece iPiece, int toY, int toX,
      IPiece[][] board,
      HashMap<String, IPiece> pieceFactory,
      HashMap<String, IPiece> deathFactory);

  public String getName(){
    return name;
  }

  public int getY(){
    return y;
  }

  public int getX(){
    return x;
  }

  public void setY(int y){
    this.y = y;
  }

  public void setX(int x){
    this.x = x;
  }

}
