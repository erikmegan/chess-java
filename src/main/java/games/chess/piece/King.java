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

    @Override
    void searchRight(){
        if(this.color.equals(ChessPieceColor.WHITE)){
            Integer idx = this.current - 1;
            if(boardMap.get(idx) != null
                    || boardMap.get(idx).getColor().equals(ChessPieceColor.BLACK)
            ){
                possibleMoveSet.add(idx);
            }
        }else if(this.color.equals(ChessPieceColor.BLACK)){
            Integer idx = this.current + 1;
            if(boardMap.get(idx) != null
                    || boardMap.get(idx).getColor().equals(ChessPieceColor.WHITE)
            ){
                possibleMoveSet.add(idx);
            }
        }
    }
    @Override
    void searchLeft(){
        if(this.color.equals(ChessPieceColor.WHITE)){
            Integer idx = this.current + 1;
            if(boardMap.get(idx) != null
                    || boardMap.get(idx).getColor().equals(ChessPieceColor.BLACK)
            ){
                possibleMoveSet.add(idx);
            }
        }else if(this.color.equals(ChessPieceColor.BLACK)){
            Integer idx = this.current - 1;
            if(boardMap.get(idx) != null
                    || boardMap.get(idx).getColor().equals(ChessPieceColor.WHITE)
            ){
                possibleMoveSet.add(idx);
            }
        }
    }
    @Override
    void searchStraightForward(){
        if(this.color.equals(ChessPieceColor.WHITE)){
            Integer idx = this.current + 10;
            if(boardMap.get(idx) != null
                    || boardMap.get(idx).getColor().equals(ChessPieceColor.BLACK)
            ){
                possibleMoveSet.add(idx);
            }
        }else if(this.color.equals(ChessPieceColor.BLACK)){
            Integer idx = this.current - 10;
            if(boardMap.get(idx) != null
                    || boardMap.get(idx).getColor().equals(ChessPieceColor.WHITE)
            ){
                possibleMoveSet.add(idx);
            }
        }
    }
    @Override
    void searchStraightBackward(){
        if(this.color.equals(ChessPieceColor.WHITE)){
            Integer idx = this.current - 10;
            if(boardMap.get(idx) != null
                    || boardMap.get(idx).getColor().equals(ChessPieceColor.BLACK)
            ){
                possibleMoveSet.add(idx);
            }
        }else if(this.color.equals(ChessPieceColor.BLACK)){
            Integer idx = this.current + 10;
            if(boardMap.get(idx) != null
                    || boardMap.get(idx).getColor().equals(ChessPieceColor.WHITE)
            ){
                possibleMoveSet.add(idx);
            }
        }
    }

    @Override
    void searchLeftForward(){
        if(this.color.equals(ChessPieceColor.WHITE)){
            Integer to = this.current + 10 +1;
            if(boardMap.get(to) != null
                    || boardMap.get(to).getColor().equals(ChessPieceColor.BLACK)
            ){
                possibleMoveSet.add(this.current + 10 + 1);
            }
        }else if(this.color.equals(ChessPieceColor.BLACK)){
            Integer to = this.current - 10 -1;
            if(boardMap.get(to) != null
                    || boardMap.get(to).getColor().equals(ChessPieceColor.WHITE)
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
                    || boardMap.get(to).getColor().equals(ChessPieceColor.BLACK)
            ){
                possibleMoveSet.add(this.current + 10 + 1);
            }
        }else if(this.color.equals(ChessPieceColor.BLACK)){
            Integer to = this.current - 10 + 1;
            if(boardMap.get(to) != null
                    || boardMap.get(to).getColor().equals(ChessPieceColor.WHITE)
            ){
                possibleMoveSet.add(this.current - 10 - 1);
            }
        }
    }

    @Override
    void searchRightBackward(){
        if(this.color.equals(ChessPieceColor.WHITE)){
            Integer idx = this.current - 10 - 1;
            if(boardMap.get(idx) != null
                    || boardMap.get(idx).getColor().equals(ChessPieceColor.BLACK)
            ){
                possibleMoveSet.add(idx);
            }
        }else if(this.color.equals(ChessPieceColor.BLACK)){
            Integer idx = this.current + 10 + 1;
            if(boardMap.get(idx) != null
                    || boardMap.get(idx).getColor().equals(ChessPieceColor.WHITE)
            ){
                possibleMoveSet.add(idx);
            }
        }
    }
    @Override
    void searchLeftBackward(){
        if(this.color.equals(ChessPieceColor.WHITE)){
            Integer idx = this.current - 10 + 1;
            if(boardMap.get(idx) != null
                    || boardMap.get(idx).getColor().equals(ChessPieceColor.BLACK)
            ){
                possibleMoveSet.add(idx);
            }
        }else if(this.color.equals(ChessPieceColor.BLACK)){
            Integer idx = this.current + 10 - 1;
            if(boardMap.get(idx) != null
                    || boardMap.get(idx).getColor().equals(ChessPieceColor.WHITE)
            ){
                possibleMoveSet.add(idx);
            }
        }
    }
}
