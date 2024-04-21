package games.chess.piece;

import games.chess.constant.ChessPieceColor;

public class King extends AbstractPiece{
    public King(String name, String nameUnit, Integer current, ChessPieceColor color) {
        this.nameUnit = nameUnit;
        this.name = name;
        this.current = current;
        this.color = color;
    }

    @Override
    public void possibleMove(){
        searchRight();
        searchLeft();
        searchStraightForward();
        searchStraightBackward();

        searchRightForward();
        searchLeftForward();
        searchRightBackward();
        searchLeftBackward();
    }

    private void route(Integer idx, ChessPieceColor colorOpponent){
        if(idx > 10 && idx < 88){
            if(boardMap.get(idx) == null) possibleMoveSet.add(idx);
            else if(boardMap.get(idx).getColor().equals(colorOpponent)) possibleMoveSet.add(idx);
        }
    }
    @Override
    void searchRight(){
        Integer idx;
        switch (this.color){
            case ChessPieceColor.WHITE:
                idx = this.current - 1;
                route(idx,ChessPieceColor.BLACK);
                break;
            case ChessPieceColor.BLACK:
                idx = this.current + 1;
                route(idx,ChessPieceColor.WHITE);
                break;
        }
    }
    @Override
    void searchLeft(){
        Integer idx;
        switch (this.color){
            case ChessPieceColor.WHITE:
                idx = this.current + 1;
                route(idx,ChessPieceColor.BLACK);
                break;
            case ChessPieceColor.BLACK:
                idx = this.current - 1;
                route(idx,ChessPieceColor.WHITE);
                break;
        }
    }
    @Override
    void searchStraightForward(){
        Integer idx;
        switch (this.color){
            case ChessPieceColor.WHITE:
                idx = this.current + 10;
                route(idx,ChessPieceColor.BLACK);
                break;
            case ChessPieceColor.BLACK:
                idx = this.current - 10;
                route(idx,ChessPieceColor.WHITE);
                break;
        }
    }
    @Override
    void searchStraightBackward(){
        Integer idx;
        switch (this.color){
            case ChessPieceColor.WHITE:
                idx = this.current - 10;
                route(idx,ChessPieceColor.BLACK);
                break;
            case ChessPieceColor.BLACK:
                idx = this.current + 10;
                route(idx,ChessPieceColor.WHITE);
                break;
        }
    }

    @Override
    void searchLeftForward(){
        Integer idx;
        switch (this.color){
            case ChessPieceColor.WHITE:
                idx = this.current + 10 +1;
                route(idx,ChessPieceColor.BLACK);
                break;
            case ChessPieceColor.BLACK:
                idx = this.current - 10 -1;
                route(idx,ChessPieceColor.WHITE);
                break;
        }
    }

    @Override
    void searchRightForward(){
        Integer idx;
        switch (this.color){
            case ChessPieceColor.WHITE:
                idx = this.current + 10 - 1;
                route(idx,ChessPieceColor.BLACK);
                break;
            case ChessPieceColor.BLACK:
                idx = this.current - 10 + 1;
                route(idx,ChessPieceColor.WHITE);
                break;
        }
    }

    @Override
    void searchRightBackward(){
        Integer idx;
        switch (this.color){
            case ChessPieceColor.WHITE:
                idx = this.current - 10 - 1;
                route(idx,ChessPieceColor.BLACK);
                break;
            case ChessPieceColor.BLACK:
                idx = this.current + 10 + 1;
                route(idx,ChessPieceColor.WHITE);
                break;
        }
    }
    @Override
    void searchLeftBackward(){
        Integer idx;
        switch (this.color){
            case ChessPieceColor.WHITE:
                idx = this.current - 10 + 1;
                route(idx,ChessPieceColor.BLACK);
                break;
            case ChessPieceColor.BLACK:
                idx = this.current + 10 - 1;
                route(idx,ChessPieceColor.WHITE);
                break;
        }
    }
}
