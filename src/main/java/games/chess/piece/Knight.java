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

    private void searchTopRight(){
        if(this.color.equals(ChessPieceColor.WHITE)){
            Integer idx = this.current + 20 - 1;
            if(boardMap.get(idx) == null
                    || boardMap.get(idx).getColor().equals(ChessPieceColor.BLACK)
            ){
                possibleMoveSet.add(idx);
            }
        }else if(this.color.equals(ChessPieceColor.BLACK)){
            Integer idx = this.current - 20 + 1 ;
            if(boardMap.get(idx) == null
                    || boardMap.get(idx).getColor().equals(ChessPieceColor.WHITE)
            ){
                possibleMoveSet.add(idx);
            }
        }
    }
    private void searchTopLeft(){
        if(this.color.equals(ChessPieceColor.WHITE)){
            Integer idx = this.current + 20 + 1;
            if(boardMap.get(idx) == null
                    || boardMap.get(idx).getColor().equals(ChessPieceColor.BLACK)
            ){
                possibleMoveSet.add(idx);
            }
        }else if(this.color.equals(ChessPieceColor.BLACK)){
            Integer idx = this.current - 20 - 1 ;
            if(boardMap.get(idx) == null
                    || boardMap.get(idx).getColor().equals(ChessPieceColor.WHITE)
            ){
                possibleMoveSet.add(idx);
            }
        }
    }
    private void searchRightTop(){
        if(this.color.equals(ChessPieceColor.WHITE)){
            Integer idx = this.current - 2 + 10;
            if(boardMap.get(idx) == null
                    || boardMap.get(idx).getColor().equals(ChessPieceColor.BLACK)
            ){
                possibleMoveSet.add(idx);
            }
        }else if(this.color.equals(ChessPieceColor.BLACK)){
            Integer idx = this.current + 2 - 10 ;
            if(boardMap.get(idx) == null
                    || boardMap.get(idx).getColor().equals(ChessPieceColor.WHITE)
            ){
                possibleMoveSet.add(idx);
            }
        }
    }
    private void searchRightBottom(){
        if(this.color.equals(ChessPieceColor.WHITE)){
            Integer idx = this.current - 2 - 10;
            if(boardMap.get(idx) == null
                    || boardMap.get(idx).getColor().equals(ChessPieceColor.BLACK)
            ){
                possibleMoveSet.add(idx);
            }
        }else if(this.color.equals(ChessPieceColor.BLACK)){
            Integer idx = this.current + 2 + 10 ;
            if(boardMap.get(idx) == null
                    || boardMap.get(idx).getColor().equals(ChessPieceColor.WHITE)
            ){
                possibleMoveSet.add(idx);
            }
        }
    }
    private void searchLeftTop(){
        if(this.color.equals(ChessPieceColor.WHITE)){
            Integer idx = this.current + 2 + 10;
            if(boardMap.get(idx) == null
                    || boardMap.get(idx).getColor().equals(ChessPieceColor.BLACK)
            ){
                possibleMoveSet.add(idx);
            }
        }else if(this.color.equals(ChessPieceColor.BLACK)){
            Integer idx = this.current - 2 - 10 ;
            if(boardMap.get(idx) == null
                    || boardMap.get(idx).getColor().equals(ChessPieceColor.WHITE)
            ){
                possibleMoveSet.add(idx);
            }
        }
    }
    private void searchLeftBottom(){
        if(this.color.equals(ChessPieceColor.WHITE)){
            Integer idx = this.current + 2 - 10;
            if(boardMap.get(idx) == null
                    || boardMap.get(idx).getColor().equals(ChessPieceColor.BLACK)
            ){
                possibleMoveSet.add(idx);
            }
        }else if(this.color.equals(ChessPieceColor.BLACK)){
            Integer idx = this.current - 2 + 10 ;
            if(boardMap.get(idx) == null
                    || boardMap.get(idx).getColor().equals(ChessPieceColor.WHITE)
            ){
                possibleMoveSet.add(idx);
            }
        }
    }
    private void searchBottomRight(){
        if(this.color.equals(ChessPieceColor.WHITE)){
            Integer idx = this.current - 20 - 1;
            if(boardMap.get(idx) == null
                    || boardMap.get(idx).getColor().equals(ChessPieceColor.BLACK)
            ){
                possibleMoveSet.add(idx);
            }
        }else if(this.color.equals(ChessPieceColor.BLACK)){
            Integer idx = this.current + 20 + 1 ;
            if(boardMap.get(idx) == null
                    || boardMap.get(idx).getColor().equals(ChessPieceColor.WHITE)
            ){
                possibleMoveSet.add(idx);
            }
        }
    }
    private void searchBottomLeft(){
        if(this.color.equals(ChessPieceColor.WHITE)){
            Integer idx = this.current - 20 + 1;
            if(boardMap.get(idx) == null
                    || boardMap.get(idx).getColor().equals(ChessPieceColor.BLACK)
            ){
                possibleMoveSet.add(idx);
            }
        }else if(this.color.equals(ChessPieceColor.BLACK)){
            Integer idx = this.current + 20 - 1 ;
            if(boardMap.get(idx) == null
                    || boardMap.get(idx).getColor().equals(ChessPieceColor.WHITE)
            ){
                possibleMoveSet.add(idx);
            }
        }
    }
}
