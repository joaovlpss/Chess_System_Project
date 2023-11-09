package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessPiece;
import chess.ChessPosition;
import chess.enums.Color;

public class UI {
    private static final String ANSI_RESET = "\u001B[0m"; // Reset color to temrinal default
    private static final String ANSI_WHITE = "\u001B[37m"; // White text color
    private static final String ANSI_YELLOW = "\u001B[33m"; // Yellow text color

    public static ChessPosition readChessPosition(Scanner sc){
        try{
        String s = sc.nextLine();
        char column = s.charAt(0);
        int row = Integer.parseInt(s.substring(1));
        return new ChessPosition(column, row);  
        }
        catch(RuntimeException e){
            throw new InputMismatchException("Error reading chess position. Valid positions are from a1 - h8.");
        }
    }
    
    public static void printBoard(ChessPiece[][] pieces){
        for (int i = 0; i < pieces.length; i++){
            System.out.print((8 - i) + " ");
            for (int j = 0; j < pieces.length; j++){ // Assuming a square board
                printPiece(pieces[i][j]);
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }

    private static void printPiece(ChessPiece piece) {
        if (piece == null) {
            System.out.print("-"); // Print a dash for empty squares
        } else {
            // Use the color corresponding to the piece's color
            if (piece.getColor() == Color.WHITE) {
                System.out.print(ANSI_WHITE + piece + ANSI_RESET); // White piece color
            } else {
                System.out.print(ANSI_YELLOW + piece + ANSI_RESET); // Black piece color, shown as yellow for visibility
            } 
        }
        System.out.print(" "); // Print a space after the piece or dash
    }
}
