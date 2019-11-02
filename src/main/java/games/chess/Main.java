package games.chess;

import games.chess.board.Board;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Notes ");
        System.out.println("Y: vertical");
        System.out.println("X: horizontal");
        System.out.println("=================================");
        Board board = new Board();
        board.printBoard();
        Scanner input = new Scanner(System.in);
        boolean cnt = true;
        boolean whiteTurn = true;
        boolean blackTurn = true;
        int coorY = 0;
        int coorX = 0;
        while (cnt){
            System.out.print("Piece name: ");
            String name = input.next().toUpperCase();
            if(name.equals("exit")){
                cnt = false;
                continue;
            }
            try {
                System.out.print("input Y: ");
                coorY = Integer.parseInt(input.next());
            } catch (NumberFormatException e) {
                System.out.println("Wrong integer type Y ");
                cnt = false;
                continue;
            }
            try {
                System.out.print("input X: ");
                coorX = Integer.parseInt(input.next());
            } catch (NumberFormatException e) {
                System.out.println("Wrong integer type X ");
                cnt = false;
                continue;
            }

            board.move(name,coorY,coorX);
        }



    }
}