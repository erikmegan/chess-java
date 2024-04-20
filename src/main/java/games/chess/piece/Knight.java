package games.chess.piece;

import games.chess.constant.ChessPieceColor;

public class Knight extends AbstractPiece{
    public Knight(String name, String nameUnit, Integer current, ChessPieceColor color) {
        this.nameUnit = nameUnit;
        this.name = name;
        this.current = current;
        this.color = color;
    }

    @Override
    public void possibleMove(){
        searchTopRight();
        searchTopLeft();
        searchRightTop();
        searchRightBottom();
        searchBottomRight();
        searchBottomLeft();
        searchLeftTop();
        searchLeftBottom();
    }

    private void route(Integer idx, ChessPieceColor colorOpponent){
        if(boardMap.get(idx) == null
                || boardMap.get(idx).getColor().equals(colorOpponent)
        ){
            possibleMoveSet.add(idx);
        }
    }

    private void searchTopRight(){
        if(this.color.equals(ChessPieceColor.WHITE)){
            Integer idx = this.current + 20 - 1;
            route(idx,ChessPieceColor.BLACK);
        }else if(this.color.equals(ChessPieceColor.BLACK)){
            Integer idx = this.current - 20 + 1 ;
            route(idx,ChessPieceColor.WHITE);
        }
    }
    private void searchTopLeft(){
        if(this.color.equals(ChessPieceColor.WHITE)){
            Integer idx = this.current + 20 + 1;
            route(idx,ChessPieceColor.BLACK);
        }else if(this.color.equals(ChessPieceColor.BLACK)){
            Integer idx = this.current - 20 - 1 ;
            route(idx,ChessPieceColor.WHITE);
        }
    }
    private void searchRightTop(){
        if(this.color.equals(ChessPieceColor.WHITE)){
            Integer idx = this.current - 2 + 10;
            route(idx,ChessPieceColor.BLACK);
        }else if(this.color.equals(ChessPieceColor.BLACK)){
            Integer idx = this.current + 2 - 10 ;
            route(idx,ChessPieceColor.WHITE);
        }
    }
    private void searchRightBottom(){
        if(this.color.equals(ChessPieceColor.WHITE)){
            Integer idx = this.current - 2 - 10;
            route(idx,ChessPieceColor.BLACK);
        }else if(this.color.equals(ChessPieceColor.BLACK)){
            Integer idx = this.current + 2 + 10 ;
            route(idx,ChessPieceColor.WHITE);
        }
    }
    private void searchLeftTop(){
        if(this.color.equals(ChessPieceColor.WHITE)){
            Integer idx = this.current + 2 + 10;
            route(idx,ChessPieceColor.BLACK);
        }else if(this.color.equals(ChessPieceColor.BLACK)){
            Integer idx = this.current - 2 - 10 ;
            route(idx,ChessPieceColor.WHITE);
        }
    }
    private void searchLeftBottom(){
        if(this.color.equals(ChessPieceColor.WHITE)){
            Integer idx = this.current + 2 - 10;
            route(idx,ChessPieceColor.BLACK);
        }else if(this.color.equals(ChessPieceColor.BLACK)){
            Integer idx = this.current - 2 + 10 ;
            route(idx,ChessPieceColor.WHITE);
        }
    }
    private void searchBottomRight(){
        if(this.color.equals(ChessPieceColor.WHITE)){
            Integer idx = this.current - 20 - 1;
            route(idx,ChessPieceColor.BLACK);
        }else if(this.color.equals(ChessPieceColor.BLACK)){
            Integer idx = this.current + 20 + 1 ;
            route(idx,ChessPieceColor.WHITE);
        }
    }
    private void searchBottomLeft(){
        if(this.color.equals(ChessPieceColor.WHITE)){
            Integer idx = this.current - 20 + 1;
            route(idx,ChessPieceColor.BLACK);
        }else if(this.color.equals(ChessPieceColor.BLACK)){
            Integer idx = this.current + 20 - 1 ;
            route(idx,ChessPieceColor.WHITE);
        }
    }
}
