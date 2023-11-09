package chess.pieces;

import chess.ChessPiece;
import boardgame.Board;
import chess.enums.Color;

public class King extends ChessPiece{
    
    public King(Board board, Color color){
        super(board, color);
    }

    @Override
    public String toString(){
        return "K";
    }

    @Override
    public boolean[][] possibleMoves() { // Placeholder method for now.
        boolean[][] matrix = new boolean[getBoard().getRows()][getBoard().getColumns()];
        return matrix;
    }
}
