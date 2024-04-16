package games.chess.piece;

import games.chess.constant.ChessPieceColor;
import games.chess.exception.InvalidMoveException;
import games.chess.handler.Board;
import java.util.*;


public class AbstractPiece implements Piece{

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

    public boolean move(Board chessBoard, Integer to)throws InvalidMoveException {
        this.boardMap = chessBoard.getBoardMap();
        possibleMove();
        if(possibleMoveSet.contains(to)){
            if(boardMap.get(to) != null){
                AbstractPiece exist = boardMap.get(to);
                chessBoard.getPieceMap().remove(exist.getNameUnit());
                if(exist.getColor().equals(ChessPieceColor.BLACK)){
                    chessBoard.getBlackPieces().remove(exist.nameUnit);
                }else if(exist.getColor().equals(ChessPieceColor.WHITE)){
                    chessBoard.getWhitePieces().remove(exist.nameUnit);
                }
            }

            boardMap.remove(this.current);
            boardMap.put(to, chessBoard.setPieceMap(this.name, this.nameUnit, to, this.color));
            this.current = to;
        }else{
            throw new InvalidMoveException("invalid move");
        }
        return true;
    }

    public void possibleMove(){}

    void searchRightForward(){
        if(this.color.equals(ChessPieceColor.WHITE)){
            boolean cont = true;
            Integer idx = this.current;
            while (cont){
                idx = idx + 10 - 1;
                if(this.boardMap.get(idx) == null){
                    possibleMoveSet.add(idx);
                }else if (boardMap.get(idx).getColor().equals(ChessPieceColor.BLACK)){
                    possibleMoveSet.add(idx);
                    cont = false;
                }else{
                    cont = false;
                }
                if(idx < 10 || idx > 88) cont = false;

            }
        }else if(this.color.equals(ChessPieceColor.BLACK)){
            boolean cont = true;
            Integer idx = this.current;
            while (cont){
                idx = idx - 10 + 1;
                if (boardMap.get(idx) == null){
                    possibleMoveSet.add(idx);
                }else if(boardMap.get(idx).getColor().equals(ChessPieceColor.WHITE)){
                    possibleMoveSet.add(idx);
                    cont = false;
                }else{
                    cont = false;
                }
                if(idx < 10 || idx > 88) cont = false;
            }
        }
    }
    void searchLeftForward(){
        if(this.color.equals(ChessPieceColor.WHITE)){
            boolean cont = true;
            Integer idx = this.current;
            while (cont){
                idx = idx + 10 + 1;
                if(this.boardMap.get(idx) == null){
                    possibleMoveSet.add(idx);
                }else if (boardMap.get(idx).getColor().equals(ChessPieceColor.BLACK)){
                    possibleMoveSet.add(idx);
                    cont = false;
                }else{
                    cont = false;
                }
                if(idx < 10 || idx > 88) cont = false;
            }
        }else if(this.color.equals(ChessPieceColor.BLACK)){
            boolean cont = true;
            Integer idx = this.current;
            while (cont){
                idx = idx - 10 - 1;
                if (boardMap.get(idx) == null){
                    possibleMoveSet.add(idx);
                }else if(boardMap.get(idx).getColor().equals(ChessPieceColor.WHITE)){
                    possibleMoveSet.add(idx);
                    cont = false;
                }else{
                    cont = false;
                }
                if(idx < 10 || idx > 88) cont = false;
            }
        }
    }
    void searchRightBackward(){
        if(this.color.equals(ChessPieceColor.WHITE)){
            boolean cont = true;
            Integer idx = this.current;
            while (cont){
                idx = idx - 10 - 1;
                if(this.boardMap.get(idx) == null){
                    possibleMoveSet.add(idx);
                }else if (boardMap.get(idx).getColor().equals(ChessPieceColor.BLACK)){
                    possibleMoveSet.add(idx);
                    cont = false;
                }else{
                    cont = false;
                }
                if(idx < 10 || idx > 88) cont = false;
            }
        }else if(this.color.equals(ChessPieceColor.BLACK)){
            boolean cont = true;
            Integer idx = this.current;
            while (cont){
                idx = idx + 10 + 1;
                if (boardMap.get(idx) == null){
                    possibleMoveSet.add(idx);
                }else if(boardMap.get(idx).getColor().equals(ChessPieceColor.WHITE)){
                    possibleMoveSet.add(idx);
                    cont = false;
                }else{
                    cont = false;
                }
                if(idx < 10 || idx > 88) cont = false;
            }
        }
    }
    void searchLeftBackward(){
        if(this.color.equals(ChessPieceColor.WHITE)){
            boolean cont = true;
            Integer idx = this.current;
            while (cont){
                idx = idx - 10 + 1;
                if(this.boardMap.get(idx) == null){
                    possibleMoveSet.add(idx);
                }else if (boardMap.get(idx).getColor().equals(ChessPieceColor.BLACK)){
                    possibleMoveSet.add(idx);
                    cont = false;
                }else{
                    cont = false;
                }
                if(idx < 10 || idx > 88) cont = false;
            }
        }else if(this.color.equals(ChessPieceColor.BLACK)){
            boolean cont = true;
            Integer idx = this.current;
            while (cont){
                idx = idx + 10 - 1;
                if (boardMap.get(idx) == null){
                    possibleMoveSet.add(idx);
                }else if(boardMap.get(idx).getColor().equals(ChessPieceColor.WHITE)){
                    possibleMoveSet.add(idx);
                    cont = false;
                }else{
                    cont = false;
                }
                if(idx < 10 || idx > 88) cont = false;
            }
        }
    }

     void searchStraightForward(){
        if(this.color.equals(ChessPieceColor.WHITE)){
            boolean cont = true;
            Integer idx = this.current;
            while (cont){
                idx += 10;
                if(this.boardMap.get(idx) == null){
                    possibleMoveSet.add(idx);
                }else if (boardMap.get(idx).getColor().equals(ChessPieceColor.BLACK)){
                    possibleMoveSet.add(idx);
                    cont = false;
                }else{
                    cont = false;
                }
                if(idx < 10 || idx > 88) cont = false;
            }
        }else if(this.color.equals(ChessPieceColor.BLACK)){
            boolean cont = true;
            Integer idx = this.current;
            while (cont){
                idx -= 10;
                if (boardMap.get(idx) == null){
                    possibleMoveSet.add(idx);
                }else if(boardMap.get(idx).getColor().equals(ChessPieceColor.WHITE)){
                    possibleMoveSet.add(idx);
                    cont = false;
                }else{
                    cont = false;
                }
                if(idx < 10 || idx > 88) cont = false;
            }
        }
    }
     void  searchStraightBackward(){
        if(this.color.equals(ChessPieceColor.WHITE)){
            boolean cont = true;
            Integer idx = this.current;
            while (cont){
                idx -= 10;
                if(this.boardMap.get(idx) == null){
                    possibleMoveSet.add(idx);
                }else if (boardMap.get(idx).getColor().equals(ChessPieceColor.BLACK)){
                    possibleMoveSet.add(idx);
                    cont = false;
                }else{
                    cont = false;
                }
                if(idx < 10 || idx > 88) cont = false;
            }
        }else if(this.color.equals(ChessPieceColor.BLACK)){
            boolean cont = true;
            Integer idx = this.current;
            while (cont){
                idx += 10;
                if (boardMap.get(idx) == null){
                    possibleMoveSet.add(idx);
                }else if(boardMap.get(idx).getColor().equals(ChessPieceColor.WHITE)){
                    possibleMoveSet.add(idx);
                    cont = false;
                }else{
                    cont = false;
                }
                if(idx < 10 || idx > 88) cont = false;
            }
        }
    }
     void  searchLeft(){
        if(this.color.equals(ChessPieceColor.WHITE)){
            boolean cont = true;
            Integer idx = this.current;
            while (cont){
                idx += 1;
                if(this.boardMap.get(idx) == null){
                    possibleMoveSet.add(idx);
                }else if (boardMap.get(idx).getColor().equals(ChessPieceColor.BLACK)){
                    possibleMoveSet.add(idx);
                    cont = false;
                }else{
                    cont = false;
                }
                if(idx < 10 || idx > 88) cont = false;
            }
        }else if(this.color.equals(ChessPieceColor.BLACK)){
            boolean cont = true;
            Integer idx = this.current;
            while (cont){
                idx -= 1;
                if (boardMap.get(idx) == null){
                    possibleMoveSet.add(idx);
                }else if(boardMap.get(idx).getColor().equals(ChessPieceColor.WHITE)){
                    possibleMoveSet.add(idx);
                    cont = false;
                }else{
                    cont = false;
                }
                if(idx < 10 || idx > 88) cont = false;
            }
        }
    }
     void searchRight(){
        if(this.color.equals(ChessPieceColor.WHITE)){
            boolean cont = true;
            Integer idx = this.current;
            while (cont){
                idx -= 1;
                if(this.boardMap.get(idx) == null){
                    possibleMoveSet.add(idx);
                }else if (boardMap.get(idx).getColor().equals(ChessPieceColor.BLACK)){
                    possibleMoveSet.add(idx);
                    cont = false;
                }else{
                    cont = false;
                }
                if(idx < 10 || idx > 88) cont = false;
            }
        }else if(this.color.equals(ChessPieceColor.BLACK)){
            boolean cont = true;
            Integer idx = this.current;
            while (cont){
                idx += 1;
                if (boardMap.get(idx) == null){
                    possibleMoveSet.add(idx);
                }else if(boardMap.get(idx).getColor().equals(ChessPieceColor.WHITE)){
                    possibleMoveSet.add(idx);
                    cont = false;
                }else{
                    cont = false;
                }
                if(idx < 10 || idx > 88) cont = false;
            }
        }
    }
}
