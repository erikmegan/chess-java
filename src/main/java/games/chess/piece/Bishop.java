package games.chess.piece;

import games.chess.constant.ChessPieceColor;

public class Bishop extends AbstractPiece{
    public Bishop(String name, String nameUnit, Integer current, ChessPieceColor color) {
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
    }

}
