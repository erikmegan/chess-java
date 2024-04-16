package games.chess.piece;

import games.chess.constant.ChessPieceColor;

public class Rock extends AbstractPiece{

    public Rock(String name, String nameUnit, Integer current, ChessPieceColor color) {
        this.nameUnit = nameUnit;
        this.name = name;
        this.current = current;
        this.color = color;
    }
    @Override
    public void possibleMove(){
        searchStraightForward();
        searchStraightBackward();
        searchLeft();
        searchRight();
    }

}
