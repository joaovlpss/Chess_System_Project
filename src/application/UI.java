package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.enums.Color;

public class UI {
    private static final String ANSI_RESET = "\u001B[0m"; // Reset color to temrinal default
    private static final String ANSI_WHITE = "\u001B[37m"; // White text color
    private static final String ANSI_YELLOW = "\u001B[33m"; // Yellow text color
    private static final String ANSI_RED_BACKGROUND = "\u001B[41m"; // Red background

    public static void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

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

    public static void printMatch(ChessMatch chessMatch){
        printBoard(chessMatch.getPieces());
        System.out.println();
        System.out.println("Turn: " + chessMatch.getTurn());
        System.out.println("Awaiting player: " + chessMatch.getCurrentPlayer());
    }
    
    public static void printBoard(ChessPiece[][] pieces){
        for (int i = 0; i < pieces.length; i++){
            System.out.print((8 - i) + " ");
            for (int j = 0; j < pieces.length; j++){ // Assuming a square board
                printPiece(pieces[i][j], false);
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }

    public static void printBoard(ChessPiece[][] pieces, boolean[][] possibleMoves){
        for (int i = 0; i < pieces.length; i++){
            System.out.print((8 - i) + " ");
            for (int j = 0; j < pieces.length; j++){ // Assuming a square board
                printPiece(pieces[i][j], possibleMoves[i][j]);
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }

    private static void printPiece(ChessPiece piece, boolean background) {
        if(background){
            System.out.print(ANSI_RED_BACKGROUND);
        }
        if (piece == null) {
            System.out.print("-" + ANSI_RESET); // Print a dash for empty squares
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
