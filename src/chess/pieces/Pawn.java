package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.enums.Color;

public class Pawn extends ChessPiece {
    public Pawn(Board board, Color color){
        super(board, color);
    }

    @Override
    public String toString(){
        return "P";
    }

    @Override
    public boolean[][] possibleMoves() { // Placeholder method for now.
        boolean[][] matrix = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0,0);
        
        // Setting p to the row above the pawn 
        // Checking if p has any pieces or not
        p.setValues(position.getRow() - 1, position.getColumn());
        if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            matrix[p.getRow()][p.getColumn()] = true;
        }

        // Checking if there are any opponent pieces to the right of the pawn
        p.setValues(position.getRow() - 1, position.getColumn() + 1);
        if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
            matrix[p.getRow()][p.getColumn()] = true;
        }

        // Checking if there are any opponent pieces to the left of the pawn
        p.setValues(position.getRow() - 1, position.getColumn() - 1);
        if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
            matrix[p.getRow()][p.getColumn()] = true;
        }

        return matrix;
    }
}
