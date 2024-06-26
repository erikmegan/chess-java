package games.chess.piece;

import games.chess.constant.ChessPieceColor;
import games.chess.exception.InvalidMoveException;
import games.chess.handler.Board;
import java.util.*;


public abstract class AbstractPiece implements Piece{

    public Map<Integer, AbstractPiece> boardMap = new HashMap<>();
    public Set<Integer> possibleMoveSet = new HashSet<>();

    public String nameUnit;
    public String getNameUnit() {return nameUnit;}

    String name;

    public String getName() {
        return name;
    }

    Integer current;

    ChessPieceColor color;
    public ChessPieceColor getColor() {return color;}

    public void infoPossibleMove(Board chessBoard){
        this.boardMap = chessBoard.getBoardMap();
        possibleMove();
        System.out.println("possible move for " + this.nameUnit + " : ");
        System.out.println(possibleMoveSet);
    }


    public void move(Board chessBoard, Integer to)throws InvalidMoveException {
        this.boardMap = chessBoard.getBoardMap();
        possibleMove();
        if(possibleMoveSet.contains(to)){
            if(boardMap.get(to) != null){
                AbstractPiece exist = boardMap.get(to);
                chessBoard.getPieceMap().remove(exist.getNameUnit());
                switch (exist.getColor()){
                    case ChessPieceColor.BLACK -> chessBoard.getBlackPieces().remove(exist.nameUnit);
                    case ChessPieceColor.WHITE -> chessBoard.getWhitePieces().remove(exist.nameUnit);
                }
            }
            boardMap.remove(this.current);
            boardMap.put(to, chessBoard.getAbstractPiece(this.name, this.nameUnit, to, this.color));
            this.current = to;
        }else{
            throw new InvalidMoveException("invalid move");
        }
    }

    public void possibleMove(){}


    private boolean route(Integer idx,ChessPieceColor colorOpponent){
        if(idx < 10 || idx > 88) return false;
        if(this.boardMap.get(idx) == null){
            possibleMoveSet.add(idx);
            return  true;
        }else if (boardMap.get(idx).getColor().equals(colorOpponent)){
            possibleMoveSet.add(idx);
            return false;
        }else{
            return false;
        }
    }
    void searchRightForward(){
        boolean cont = true;
        Integer idx = this.current;
        switch (this.color) {
            case ChessPieceColor.WHITE :
                while (cont){
                    idx = idx + 10 - 1;
                    cont = route(idx,ChessPieceColor.BLACK);
                }
                break;
            case ChessPieceColor.BLACK:
                while (cont){
                    idx = idx - 10 + 1;
                    cont = route(idx,ChessPieceColor.WHITE);
                }
                break;
        }
    }

    void searchLeftForward(){
        boolean cont = true;
        Integer idx = this.current;
        switch (this.color){
            case ChessPieceColor.WHITE:
                while (cont){
                    idx = idx + 10 + 1;
                    cont = route(idx,ChessPieceColor.BLACK);
                }
                break;
            case ChessPieceColor.BLACK:
                while (cont){
                    idx = idx - 10 - 1;
                    cont = route(idx,ChessPieceColor.WHITE);
                }
                break;
        }
    }

    void searchRightBackward(){
        boolean cont = true;
        Integer idx = this.current;
        switch (this.color){
            case ChessPieceColor.WHITE:
                while (cont){
                    idx = idx - 10 - 1;
                    cont = route(idx,ChessPieceColor.BLACK);
                }
                break;
            case ChessPieceColor.BLACK:
                while (cont){
                    idx = idx + 10 + 1;
                    cont = route(idx,ChessPieceColor.BLACK);
                }
                break;
        }
    }

    void searchLeftBackward(){
        boolean cont = true;
        Integer idx = this.current;
        switch (this.color){
            case ChessPieceColor.WHITE:
                while (cont){
                    idx = idx - 10 + 1;
                    cont = route(idx,ChessPieceColor.BLACK);
                }
                break;
            case ChessPieceColor.BLACK:
                while (cont){
                    idx = idx + 10 - 1;
                    cont = route(idx,ChessPieceColor.WHITE);
                }
                break;
        }
    }

     void searchStraightForward(){
         boolean cont = true;
         Integer idx = this.current;
         switch (this.color){
             case ChessPieceColor.WHITE:
                 while (cont){
                     idx += 10;
                     cont = route(idx,ChessPieceColor.BLACK);
                 }
                 break;
             case ChessPieceColor.BLACK:
                 while (cont){
                     idx -= 10;
                     cont = route(idx,ChessPieceColor.WHITE);
                 }
                 break;
         }
    }
     void searchStraightBackward(){
         boolean cont = true;
         Integer idx = this.current;
         switch (this.color){
             case ChessPieceColor.WHITE:
                 while (cont){
                     idx -= 10;
                     cont = route(idx,ChessPieceColor.BLACK);
                 }
                 break;
             case ChessPieceColor.BLACK:
                 while (cont){
                     idx += 10;
                     cont = route(idx,ChessPieceColor.WHITE);
                 }
                 break;
         }

    }
     void searchLeft(){
         boolean cont = true;
         Integer idx = this.current;
         switch (this.color){
             case ChessPieceColor.WHITE:
                 while (cont){
                     idx += 1;
                     cont = route(idx,ChessPieceColor.BLACK);
                 }
                 break;
             case ChessPieceColor.BLACK:
                 while (cont){
                     idx -= 1;
                     cont = route(idx,ChessPieceColor.WHITE);
                 }
                 break;
         }
    }
     void searchRight(){
         boolean cont = true;
         Integer idx = this.current;
         switch (this.color){
             case ChessPieceColor.WHITE:
                 while (cont){
                     idx -= 1;
                     cont = route(idx,ChessPieceColor.BLACK);
                 }
                 break;
             case ChessPieceColor.BLACK:
                 while (cont){
                     idx += 1;
                     cont = route(idx,ChessPieceColor.WHITE);
                 }
                 break;
         }
    }
}
