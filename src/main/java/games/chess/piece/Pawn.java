package games.chess.piece;

import games.chess.constant.ChessPieceColor;


public class Pawn extends AbstractPiece{
    public Pawn(String name, String nameUnit, Integer current, ChessPieceColor color) {
        this.nameUnit = nameUnit;
        this.name = name;
        this.current = current;
        this.color = color;
    }

    @Override
    public void possibleMove(){
        searchStraightForward();
        searchLeftForward();
        searchRightForward();
    }

    @Override
    void searchStraightForward(){
        if(this.color.equals(ChessPieceColor.WHITE)){
            Integer to = this.current + 10;
            if(boardMap.get(to) == null){
                possibleMoveSet.add(to);
            }
        }else if(this.color.equals(ChessPieceColor.BLACK)){
            Integer to = this.current - 10;
            if(boardMap.get(to) == null){
                possibleMoveSet.add(this.current - 10);
            }
        }
    }

    @Override
    void searchLeftForward(){
        if(this.color.equals(ChessPieceColor.WHITE)){
            Integer to = this.current + 10 +1;
            if(boardMap.get(to) != null
                && boardMap.get(to).getColor().equals(ChessPieceColor.BLACK)
            ){
                possibleMoveSet.add(this.current + 10 + 1);
            }
        }else if(this.color.equals(ChessPieceColor.BLACK)){
            Integer to = this.current - 10 -1;
            if(boardMap.get(to) != null
                    && boardMap.get(to).getColor().equals(ChessPieceColor.WHITE)
            ){
                possibleMoveSet.add(this.current - 10 - 1);
            }
        }
    }

    @Override
    void searchRightForward(){
        if(this.color.equals(ChessPieceColor.WHITE)){
            Integer to = this.current + 10 - 1;
            if(boardMap.get(to) != null
                    && boardMap.get(to).getColor().equals(ChessPieceColor.BLACK)
            ){
                possibleMoveSet.add(this.current + 10 + 1);
            }
        }else if(this.color.equals(ChessPieceColor.BLACK)){
            Integer to = this.current - 10 + 1;
            if(boardMap.get(to) != null
                    && boardMap.get(to).getColor().equals(ChessPieceColor.WHITE)
            ){
                possibleMoveSet.add(this.current - 10 - 1);
            }
        }
    }
}
