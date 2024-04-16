package games.chess.handler;

import games.chess.constant.ChessPieceColor;
import games.chess.piece.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static games.chess.constant.ChessPiece.*;

public class Board {

    public Map<String, AbstractPiece> pieceMap = new HashMap<>();
    public Map<String, AbstractPiece> getPieceMap() {return pieceMap;}

    public final Map<String,AbstractPiece> initPiece = new HashMap<>();



    public Map<Integer, AbstractPiece> boardMap = new HashMap<>();
    public Map<Integer, AbstractPiece> getBoardMap() {return boardMap;}


    public Integer[][] board;

    private ChessPieceColor turnColor;
    public void setTurnColor(ChessPieceColor turnColor) {
        this.turnColor = turnColor;
    }
    public ChessPieceColor getTurnColor() {
        return turnColor;
    }

    private final Set<String> whitePieces = new HashSet<>();
    private final Set<String> blackPieces= new HashSet<>();

    public Set<String> getWhitePieces() {return whitePieces;}
    public Set<String> getBlackPieces() {
        return blackPieces;
    }

    private void initWhitePiece(){
        whitePieces.add(WHITE_PAWN_1);
        whitePieces.add(WHITE_PAWN_2);
        whitePieces.add(WHITE_PAWN_3);
        whitePieces.add(WHITE_PAWN_4);
        whitePieces.add(WHITE_PAWN_5);
        whitePieces.add(WHITE_PAWN_6);
        whitePieces.add(WHITE_PAWN_7);
        whitePieces.add(WHITE_PAWN_8);
        whitePieces.add(WHITE_KING);
        whitePieces.add(WHITE_QUEEN);
        whitePieces.add(WHITE_BISHOP_1);
        whitePieces.add(WHITE_BISHOP_2);
        whitePieces.add(WHITE_KNIGHT_1);
        whitePieces.add(WHITE_KNIGHT_2);
        whitePieces.add(WHITE_ROCK_1);
        whitePieces.add(WHITE_ROCK_2);
    }
    private void initBlackPiece(){
        blackPieces.add(BLACK_PAWN_1);
        blackPieces.add(BLACK_PAWN_2);
        blackPieces.add(BLACK_PAWN_3);
        blackPieces.add(BLACK_PAWN_4);
        blackPieces.add(BLACK_PAWN_5);
        blackPieces.add(BLACK_PAWN_6);
        blackPieces.add(BLACK_PAWN_7);
        blackPieces.add(BLACK_PAWN_8);
        blackPieces.add(BLACK_KING);
        blackPieces.add(BLACK_QUEEN);
        blackPieces.add(BLACK_BISHOP_1);
        blackPieces.add(BLACK_BISHOP_2);
        blackPieces.add(BLACK_KNIGHT_1);
        blackPieces.add(BLACK_KNIGHT_2);
        blackPieces.add(BLACK_ROCK_1);
        blackPieces.add(BLACK_ROCK_2);
    }

    public void init(){
        initWhitePiece();
        initBlackPiece();

        board = new Integer[8][8];
        turnColor = ChessPieceColor.WHITE;

        for (int i = 0 ; i < board.length ; i++){
            int x =(i+1) * 10;
            for (int j = 0 ; j< board.length ; j++){
                board[i][j] = x+j+1;
            }
        }

        initPieceMap();
        initBoardMap();

    }
    private void initPieceMap(){
        pieceMap.put(WHITE_PAWN_1,new Pawn(PAWN,WHITE_PAWN_1,21,ChessPieceColor.WHITE));
        pieceMap.put(WHITE_PAWN_2,new Pawn(PAWN,WHITE_PAWN_2, 22,ChessPieceColor.WHITE));
        pieceMap.put(WHITE_PAWN_3,new Pawn(PAWN,WHITE_PAWN_3, 23,ChessPieceColor.WHITE));
        pieceMap.put(WHITE_PAWN_4,new Pawn(PAWN,WHITE_PAWN_4, 24,ChessPieceColor.WHITE));
        pieceMap.put(WHITE_PAWN_5,new Pawn(PAWN,WHITE_PAWN_5, 25,ChessPieceColor.WHITE));
        pieceMap.put(WHITE_PAWN_6,new Pawn(PAWN,WHITE_PAWN_6, 26,ChessPieceColor.WHITE));
        pieceMap.put(WHITE_PAWN_7,new Pawn(PAWN,WHITE_PAWN_7, 27,ChessPieceColor.WHITE));
        pieceMap.put(WHITE_PAWN_8,new Pawn(PAWN,WHITE_PAWN_8, 28,ChessPieceColor.WHITE));

        pieceMap.put(BLACK_PAWN_1,new Pawn(PAWN,BLACK_PAWN_1,71,ChessPieceColor.BLACK));
        pieceMap.put(BLACK_PAWN_2,new Pawn(PAWN,BLACK_PAWN_2, 72,ChessPieceColor.BLACK));
        pieceMap.put(BLACK_PAWN_3,new Pawn(PAWN,BLACK_PAWN_3, 73,ChessPieceColor.BLACK));
        pieceMap.put(BLACK_PAWN_4,new Pawn(PAWN,BLACK_PAWN_4, 74,ChessPieceColor.BLACK));
        pieceMap.put(BLACK_PAWN_5,new Pawn(PAWN,BLACK_PAWN_5, 75,ChessPieceColor.BLACK));
        pieceMap.put(BLACK_PAWN_6,new Pawn(PAWN,BLACK_PAWN_6, 76,ChessPieceColor.BLACK));
        pieceMap.put(BLACK_PAWN_7,new Pawn(PAWN,BLACK_PAWN_7, 77,ChessPieceColor.BLACK));
        pieceMap.put(BLACK_PAWN_8,new Pawn(PAWN,BLACK_PAWN_8, 78,ChessPieceColor.BLACK));

        pieceMap.put(WHITE_ROCK_1,new Rock(ROCK,WHITE_ROCK_1, 11,ChessPieceColor.WHITE));
        pieceMap.put(WHITE_KNIGHT_1,new Knight(KNIGHT,WHITE_KNIGHT_1, 12,ChessPieceColor.WHITE));
        pieceMap.put(WHITE_BISHOP_1,new Bishop(BISHOP,WHITE_BISHOP_1, 13,ChessPieceColor.WHITE));
        pieceMap.put(WHITE_KING,new King(KING,WHITE_KING, 14,ChessPieceColor.WHITE));
        pieceMap.put(WHITE_QUEEN,new Queen(QUEEN,WHITE_QUEEN, 15,ChessPieceColor.WHITE));
        pieceMap.put(WHITE_BISHOP_2,new Bishop(BISHOP,WHITE_BISHOP_2, 16,ChessPieceColor.WHITE));
        pieceMap.put(WHITE_KNIGHT_2,new Knight(KNIGHT,WHITE_KNIGHT_2, 17,ChessPieceColor.WHITE));
        pieceMap.put(WHITE_ROCK_2,new Rock(ROCK,WHITE_ROCK_2, 18,ChessPieceColor.WHITE));

        pieceMap.put(BLACK_ROCK_1,new Rock(ROCK,BLACK_ROCK_1, 81,ChessPieceColor.BLACK));
        pieceMap.put(BLACK_KNIGHT_1,new Knight(KNIGHT,BLACK_KNIGHT_1, 82,ChessPieceColor.BLACK));
        pieceMap.put(BLACK_BISHOP_1,new Bishop(BISHOP,BLACK_BISHOP_1, 83,ChessPieceColor.BLACK));
        pieceMap.put(BLACK_QUEEN,new Queen(QUEEN,BLACK_QUEEN, 84,ChessPieceColor.BLACK));
        pieceMap.put(BLACK_KING,new King(KING,BLACK_KING, 85,ChessPieceColor.BLACK));
        pieceMap.put(BLACK_BISHOP_2,new Bishop(BISHOP,BLACK_BISHOP_2, 86,ChessPieceColor.BLACK));
        pieceMap.put(BLACK_KNIGHT_2,new Knight(KNIGHT,BLACK_KNIGHT_2, 87,ChessPieceColor.BLACK));
        pieceMap.put(BLACK_ROCK_2,new Rock(ROCK,BLACK_ROCK_2, 88,ChessPieceColor.BLACK));

    }


    private void initBoardMap(){
        boardMap.put(21,new Pawn(PAWN,WHITE_PAWN_1,21,ChessPieceColor.WHITE));
        boardMap.put(22,new Pawn(PAWN,WHITE_PAWN_2, 22,ChessPieceColor.WHITE));
        boardMap.put(23,new Pawn(PAWN,WHITE_PAWN_3, 23,ChessPieceColor.WHITE));
        boardMap.put(24,new Pawn(PAWN,WHITE_PAWN_4, 24,ChessPieceColor.WHITE));
        boardMap.put(25,new Pawn(PAWN,WHITE_PAWN_5, 25,ChessPieceColor.WHITE));
        boardMap.put(26,new Pawn(PAWN,WHITE_PAWN_6, 26,ChessPieceColor.WHITE));
        boardMap.put(27,new Pawn(PAWN,WHITE_PAWN_7, 27,ChessPieceColor.WHITE));
        boardMap.put(28,new Pawn(PAWN,WHITE_PAWN_8, 28,ChessPieceColor.WHITE));

        boardMap.put(71,new Pawn(PAWN,BLACK_PAWN_1,71,ChessPieceColor.BLACK));
        boardMap.put(72,new Pawn(PAWN,BLACK_PAWN_2, 72,ChessPieceColor.BLACK));
        boardMap.put(73,new Pawn(PAWN,BLACK_PAWN_3, 73,ChessPieceColor.BLACK));
        boardMap.put(74,new Pawn(PAWN,BLACK_PAWN_4, 74,ChessPieceColor.BLACK));
        boardMap.put(75,new Pawn(PAWN,BLACK_PAWN_5, 75,ChessPieceColor.BLACK));
        boardMap.put(76,new Pawn(PAWN,BLACK_PAWN_6, 76,ChessPieceColor.BLACK));
        boardMap.put(77,new Pawn(PAWN,BLACK_PAWN_7, 77,ChessPieceColor.BLACK));
        boardMap.put(78,new Pawn(PAWN,BLACK_PAWN_8, 78,ChessPieceColor.BLACK));

        boardMap.put(11,new Rock(ROCK,WHITE_ROCK_1, 11,ChessPieceColor.WHITE));
        boardMap.put(12,new Knight(KNIGHT,WHITE_KNIGHT_1, 12,ChessPieceColor.WHITE));
        boardMap.put(13,new Bishop(BISHOP,WHITE_BISHOP_1, 13,ChessPieceColor.WHITE));
        boardMap.put(14,new King(KING,WHITE_KING, 14,ChessPieceColor.WHITE));
        boardMap.put(15,new Queen(QUEEN,WHITE_QUEEN, 15,ChessPieceColor.WHITE));
        boardMap.put(16,new Bishop(BISHOP,WHITE_BISHOP_2, 16,ChessPieceColor.WHITE));
        boardMap.put(17,new Knight(KNIGHT,WHITE_KNIGHT_2, 17,ChessPieceColor.WHITE));
        boardMap.put(18,new Rock(ROCK,WHITE_ROCK_2, 18,ChessPieceColor.WHITE));

        boardMap.put(81,new Rock(ROCK,BLACK_ROCK_1, 81,ChessPieceColor.BLACK));
        boardMap.put(82,new Knight(KNIGHT,BLACK_KNIGHT_1, 82,ChessPieceColor.BLACK));
        boardMap.put(83,new Bishop(BISHOP,BLACK_BISHOP_1, 83,ChessPieceColor.BLACK));
        boardMap.put(84,new Queen(QUEEN,BLACK_QUEEN, 84,ChessPieceColor.BLACK));
        boardMap.put(85,new King(KING,BLACK_KING, 85,ChessPieceColor.BLACK));
        boardMap.put(86,new Bishop(BISHOP,BLACK_BISHOP_2, 86,ChessPieceColor.BLACK));
        boardMap.put(87,new Knight(KNIGHT,BLACK_KNIGHT_2, 87,ChessPieceColor.BLACK));
        boardMap.put(88,new Rock(ROCK,BLACK_ROCK_2, 88,ChessPieceColor.BLACK));

    }


    public void printBoard(){
        for (Integer[] integers : board) {
            System.out.print("| ");
            for (int j = 0; j < board.length; j++) {
                if (boardMap.get(integers[j]) != null) {
                    System.out.print(boardMap.get(integers[j]).getNameUnit() + " | ");
                } else {
                    System.out.print(integers[j] + "  | ");
                }
            }
            System.out.println();
        }
        if(turnColor.equals(ChessPieceColor.WHITE)) printWhiteTurn();
        else if (turnColor.equals(ChessPieceColor.BLACK)) printBlackTurn();
    }

    public AbstractPiece setPieceMap(String name,String nameUnit,Integer coor, ChessPieceColor color){
        pieceMap.put(PAWN, new Pawn(name,nameUnit,coor,color));
        pieceMap.put(ROCK, new Rock(name,nameUnit,coor,color));
        pieceMap.put(KNIGHT, new Knight(name,nameUnit,coor,color));
        pieceMap.put(BISHOP, new Bishop(name,nameUnit,coor,color));
        pieceMap.put(KING, new King(name,nameUnit,coor,color));
        pieceMap.put(QUEEN, new Queen(name,nameUnit,coor,color));

        return pieceMap.get(name);
    }

    public void printWhiteTurn(){
        System.out.println("--White turn--");

    }
    public void printBlackTurn(){
        System.out.println("--Black turn--");

    }
}
