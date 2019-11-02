package games.chess.constant;

import lombok.Data;

/**
 * @author ErikMegantara
 */
@Data
public class Coordinate {

  int y;
  int x;
  boolean isDiagonalPawn;

  public Coordinate(int y, int x) {
    this.y = y;
    this.x = x;
  }

  public Coordinate(int y, int x, boolean isDiagonalPawn) {
    this.y = y;
    this.x = x;
    this.isDiagonalPawn = isDiagonalPawn;
  }
}
