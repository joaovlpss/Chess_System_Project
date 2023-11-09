package chess.pieces;

import chess.ChessPiece;
import boardgame.Board;
import chess.enums.Color;
import boardgame.Position;

public class King extends ChessPiece{
    
    public King(Board board, Color color){
        super(board, color);
    }

    @Override
    public String toString(){
        return "K";
    }

    private boolean canMove(Position position){
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    @Override
    public boolean[][] possibleMoves() { // Placeholder method for now.
        boolean[][] matrix = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0, 0);
       
        // Checking move possibility for the row above the King (north, nw, ne)
        for (int i = -1; i < 2; i++){
            p.setValues(position.getRow() - 1, position.getColumn() + i);
            if(getBoard().positionExists(p) && canMove(p)){
                matrix[p.getRow()][p.getColumn()] = true;
            }
        }

        // Checking move possibility for the row below the King (south, sw, se)
        for (int i = -1; i < 2; i++){
            p.setValues(position.getRow() + 1, position.getColumn() + i);
            if(getBoard().positionExists(p) && canMove(p)){
                matrix[p.getRow()][p.getColumn()] = true;
            }
        }

        // Checking move possibility for the King's right
        p.setValues(position.getRow(), position.getColumn() + 1);
        if(getBoard().positionExists(p) && canMove(p)){
            matrix[p.getRow()][p.getColumn()] = true;
        }
        
        // Checking move possibility for the King's left
        p.setValues(position.getRow(), position.getColumn() + -1);
        if(getBoard().positionExists(p) && canMove(p)){
            matrix[p.getRow()][p.getColumn()] = true;
        }

        return matrix;
    }
}
