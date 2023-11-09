package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.enums.Color;

public class Rook extends ChessPiece {  
    public Rook(Board board, Color color){
        super(board, color);
    }

    @Override
    public String toString(){
        return "R";
    }

    @Override
    public boolean[][] possibleMoves() { // Placeholder method for now.
        boolean[][] matrix = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0,0);

        // Cheking possible moves on rows above the rook.
        p.setValues(position.getRow() - 1, position.getColumn());
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            matrix[p.getRow()][p.getColumn()] = true;
            p.setRow(p.getRow() - 1); // Check next row above.
        }
        if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
            matrix[p.getRow()][p.getColumn()] = true;
        }

        // Now, for columns to the rook's left
        p.setValues(position.getRow(), position.getColumn() - 1);
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            matrix[p.getRow()][p.getColumn()] = true;
            p.setColumn(p.getColumn() - 1); // Check next column to the left
        }
        if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
            matrix[p.getRow()][p.getColumn()] = true;
        }

        // Now, for columns to the rook's right
        p.setValues(position.getRow(), position.getColumn() + 1);
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            matrix[p.getRow()][p.getColumn()] = true;
            p.setColumn(p.getColumn() + 1); // Check next column to the right
        }
        if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
            matrix[p.getRow()][p.getColumn()] = true;
        }

        // Now, for rows below the rook
        p.setValues(position.getRow() + 1, position.getColumn());
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            matrix[p.getRow()][p.getColumn()] = true;
            p.setRow(p.getRow() + 1); // Check next row below
        }
        if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
            matrix[p.getRow()][p.getColumn()] = true;
        }

        return matrix;
    }
}
