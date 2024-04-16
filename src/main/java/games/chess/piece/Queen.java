package games.chess.piece;

import games.chess.constant.ChessPieceColor;

public class Queen extends AbstractPiece{
    public Queen(String name, String nameUnit, Integer current, ChessPieceColor color) {
        this.nameUnit = nameUnit;
        this.name = name;
        this.current = current;
        this.color = color;
    }

    @Override
    public void possibleMove(){
        searchRightForward();
        searchLeftForward();
        searchRightBackward();
        searchLeftBackward();

        searchStraightForward();
        searchStraightBackward();
        searchLeft();
        searchRight();
    }
}
