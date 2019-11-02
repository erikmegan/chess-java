package games.chess.piece;

import games.chess.constant.ChessPiece;
import java.util.HashMap;

/**
 * @author ErikMegantara
 */
public class BlackPawn extends AbstractPieceChessGeneral {

  public BlackPawn(String name, int y, int x){
    super.name = name;
    super.y = y;
    super.x = x;
  }

  public void searchForwardLeft(int y, int x) {
  }

  public void searchForwardRight(int y, int x) {
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

  public void searchForward(int y, int x){
  }

  public void searchBackward(int y, int x){
  }

  public void searchLeft(int y, int x){
  }

  public void searchRight(int y, int x){
  }
  public boolean validate(IPiece iPiece, int toY, int toX, IPiece[][] board,
      HashMap<String, IPiece> pieceFactory,
      HashMap<String, IPiece> deathFactory)
  {
    return true;
  }

  public String getClassName() {
    return BlackPawn.class.getName();
  }

  public String getType() {
    return ChessPiece.CHESS_TYPE_BLACK;
  }
}
