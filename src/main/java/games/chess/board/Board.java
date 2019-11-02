package games.chess.board;

import games.chess.constant.ChessPiece;
import games.chess.piece.BlackBishop;
import games.chess.piece.BlackKing;
import games.chess.piece.BlackKnight;
import games.chess.piece.BlackPawn;
import games.chess.piece.BlackQueen;
import games.chess.piece.BlackRock;
import games.chess.piece.IPiece;
import games.chess.piece.WhiteBishop;
import games.chess.piece.WhiteKing;
import games.chess.piece.WhiteKnight;
import games.chess.piece.WhitePawn;
import games.chess.piece.WhiteQueen;
import games.chess.piece.WhiteRock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author ErikMegantara
 */
public class Board {

  public IPiece[][] board = new IPiece[8][8];
  public static HashMap<String, IPiece> pieceFactory = new HashMap<String, IPiece>();
  public HashMap<String, IPiece> deathFactory = new HashMap<String, IPiece>();

  public Board() {
    WhiteQueen whiteQueen = new WhiteQueen(ChessPiece.WHITE_QUEEN, 0, 4);
    WhiteKing whiteKing = new WhiteKing(ChessPiece.WHITE_KING, 0, 3);
    WhiteKnight whiteKnight1 = new WhiteKnight(ChessPiece.WHITE_KNIGHT_1, 0, 1);
    WhiteKnight whiteKnight2 = new WhiteKnight(ChessPiece.WHITE_KNIGHT_2, 0, 6);
    WhiteBishop whiteBishop1 = new WhiteBishop(ChessPiece.WHITE_BISHOP_1, 0, 2);
    WhiteBishop whiteBishop2 = new WhiteBishop(ChessPiece.WHITE_BISHOP_2, 0, 5);
    WhiteRock whiteRock1 = new WhiteRock(ChessPiece.WHITE_ROOK_1, 0, 0);
    WhiteRock whiteRock2 = new WhiteRock(ChessPiece.WHITE_ROOK_2, 0, 7);
    WhitePawn whitePawn1 = new WhitePawn(ChessPiece.WHITE_PAWN_1, 1, 0);
    WhitePawn whitePawn2 = new WhitePawn(ChessPiece.WHITE_PAWN_2, 1, 1);
    WhitePawn whitePawn3 = new WhitePawn(ChessPiece.WHITE_PAWN_3, 1, 2);
    WhitePawn whitePawn4 = new WhitePawn(ChessPiece.WHITE_PAWN_4, 1, 3);
    WhitePawn whitePawn5 = new WhitePawn(ChessPiece.WHITE_PAWN_5, 1, 4);
    WhitePawn whitePawn6 = new WhitePawn(ChessPiece.WHITE_PAWN_6, 1, 5);
    WhitePawn whitePawn7 = new WhitePawn(ChessPiece.WHITE_PAWN_7, 1, 6);
    WhitePawn whitePawn8 = new WhitePawn(ChessPiece.WHITE_PAWN_8, 1, 7);

    BlackQueen blackQueen = new BlackQueen(ChessPiece.BLACK_QUEEN, 0, 4);
    BlackKing blackKing = new BlackKing(ChessPiece.BLACK_KING, 0, 3);
    BlackKnight blackKnight1 = new BlackKnight(ChessPiece.BLACK_KNIGHT_1, 0, 1);
    BlackKnight blackKnight2 = new BlackKnight(ChessPiece.BLACK_KNIGHT_2, 0, 6);
    BlackBishop blackBishop1 = new BlackBishop(ChessPiece.BLACK_BISHOP_1, 0, 2);
    BlackBishop blackBishop2 = new BlackBishop(ChessPiece.BLACK_BISHOP_2, 0, 5);
    BlackRock blackRock1 = new BlackRock(ChessPiece.BLACK_ROOK_1, 0, 0);
    BlackRock blackRock2 = new BlackRock(ChessPiece.BLACK_ROOK_2, 0, 7);
    BlackPawn blackPawn1 = new BlackPawn(ChessPiece.BLACK_PAWN_1, 1, 0);
    BlackPawn blackPawn2 = new BlackPawn(ChessPiece.BLACK_PAWN_2, 1, 1);
    BlackPawn blackPawn3 = new BlackPawn(ChessPiece.BLACK_PAWN_3, 1, 2);
    BlackPawn blackPawn4 = new BlackPawn(ChessPiece.BLACK_PAWN_4, 1, 3);
    BlackPawn blackPawn5 = new BlackPawn(ChessPiece.BLACK_PAWN_5, 1, 4);
    BlackPawn blackPawn6 = new BlackPawn(ChessPiece.BLACK_PAWN_6, 1, 5);
    BlackPawn blackPawn7 = new BlackPawn(ChessPiece.BLACK_PAWN_7, 1, 6);
    BlackPawn blackPawn8 = new BlackPawn(ChessPiece.BLACK_PAWN_8, 1, 7);

    pieceFactory.put(ChessPiece.WHITE_QUEEN, whiteQueen);
    pieceFactory.put(ChessPiece.WHITE_KING, whiteKing);
    pieceFactory.put(ChessPiece.WHITE_KNIGHT_1, whiteKnight1);
    pieceFactory.put(ChessPiece.WHITE_KNIGHT_2, whiteKnight2);
    pieceFactory.put(ChessPiece.WHITE_BISHOP_1, whiteBishop1);
    pieceFactory.put(ChessPiece.WHITE_BISHOP_2, whiteBishop2);
    pieceFactory.put(ChessPiece.WHITE_ROOK_1, whiteRock1);
    pieceFactory.put(ChessPiece.WHITE_ROOK_2, whiteRock2);
    pieceFactory.put(ChessPiece.WHITE_PAWN_1, whitePawn1);
    pieceFactory.put(ChessPiece.WHITE_PAWN_2, whitePawn2);
    pieceFactory.put(ChessPiece.WHITE_PAWN_3, whitePawn3);
    pieceFactory.put(ChessPiece.WHITE_PAWN_4, whitePawn4);
    pieceFactory.put(ChessPiece.WHITE_PAWN_5, whitePawn5);
    pieceFactory.put(ChessPiece.WHITE_PAWN_6, whitePawn6);
    pieceFactory.put(ChessPiece.WHITE_PAWN_7, whitePawn7);
    pieceFactory.put(ChessPiece.WHITE_PAWN_8, whitePawn8);

    pieceFactory.put(ChessPiece.BLACK_QUEEN, blackQueen);
    pieceFactory.put(ChessPiece.BLACK_KING, blackKing);
    pieceFactory.put(ChessPiece.BLACK_KNIGHT_1, blackKnight1);
    pieceFactory.put(ChessPiece.BLACK_KNIGHT_2, blackKnight2);
    pieceFactory.put(ChessPiece.BLACK_BISHOP_1, blackBishop1);
    pieceFactory.put(ChessPiece.BLACK_BISHOP_2, blackBishop2);
    pieceFactory.put(ChessPiece.BLACK_ROOK_1, blackRock1);
    pieceFactory.put(ChessPiece.BLACK_ROOK_2, blackRock2);
    pieceFactory.put(ChessPiece.BLACK_PAWN_1, blackPawn1);
    pieceFactory.put(ChessPiece.BLACK_PAWN_2, blackPawn2);
    pieceFactory.put(ChessPiece.BLACK_PAWN_3, blackPawn3);
    pieceFactory.put(ChessPiece.BLACK_PAWN_4, blackPawn4);
    pieceFactory.put(ChessPiece.BLACK_PAWN_5, blackPawn5);
    pieceFactory.put(ChessPiece.BLACK_PAWN_6, blackPawn6);
    pieceFactory.put(ChessPiece.BLACK_PAWN_7, blackPawn7);
    pieceFactory.put(ChessPiece.BLACK_PAWN_8, blackPawn8);

    board[0][0] = whiteRock1;
    board[0][1] = whiteKnight1;
    board[0][2] = whiteBishop1;
    board[0][3] = whiteKing;
    board[0][4] = whiteQueen;
    board[0][5] = whiteBishop2;
    board[0][6] = whiteKnight2;
    board[0][7] = whiteRock2;
    board[1][0] = whitePawn1;
    board[1][1] = whitePawn2;
    board[1][2] = whitePawn3;
    board[1][3] = whitePawn4;
    board[1][4] = whitePawn5;
    board[1][5] = whitePawn6;
    board[1][6] = whitePawn7;
    board[1][7] = whitePawn8;

    board[7][0] = blackRock1;
    board[7][1] = blackKnight1;
    board[7][2] = blackBishop1;
    board[7][3] = blackKing;
    board[7][4] = blackQueen;
    board[7][5] = blackBishop2;
    board[7][6] = blackKnight2;
    board[7][7] = blackRock2;
    board[6][0] = blackPawn1;
    board[6][1] = blackPawn2;
    board[6][2] = blackPawn3;
    board[6][3] = blackPawn4;
    board[6][4] = blackPawn5;
    board[6][5] = blackPawn6;
    board[6][6] = blackPawn7;
    board[6][7] = blackPawn8;

  }

  public void printBoard() {
    for (int i = 0; i < 8; i++) {
      System.out.print("|");
      for (int j = 0; j < 8; j++) {
        if (board[i][j] == null) {
          System.out.print(i + "," + j + "|");
          continue;
        }
        System.out.print(board[i][j].getName() + "|");
      }
      System.out.println();
    }
    System.out.println();
    List<IPiece> blackDeathZone = new ArrayList<IPiece>(deathFactory.values());
    for(IPiece iPiece : blackDeathZone){
      if(iPiece.getType().equals(ChessPiece.CHESS_TYPE_BLACK)) {
        System.out.print("Black death : " + iPiece.getName() + " ");
      }
    }
    System.out.println();
    List<IPiece> whiteDeathZone = new ArrayList<IPiece>(deathFactory.values());
    for(IPiece iPiece : whiteDeathZone){
      if(iPiece.getType().equals(ChessPiece.CHESS_TYPE_WHITE)) {
        System.out.print("White death : " + iPiece.getName() + " ");
      }
    }

    System.out.println("=================================");
  }

  public void move(String whiteKnight1, int toY, int toX) {
    IPiece iPiece = pieceFactory.get(whiteKnight1);
    boolean isValid = iPiece.validate(iPiece,toY,toX,board,pieceFactory,deathFactory);
    if (!isValid) {
      System.out.println("invalid move");
    }
    printBoard();
  }
}
