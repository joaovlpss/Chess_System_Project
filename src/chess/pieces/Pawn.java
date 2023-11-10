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
    public boolean[][] possibleMoves() { 
        boolean[][] matrix = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0,0);

        if (getColor() == Color.WHITE){ // White pawns can only move upwards
            // Setting p to the row above the pawn 
            // Checking if p has any pieces or not
            // If it's the first move, the Pawn can move two squares forward.

            p.setValues(position.getRow() - 1, position.getColumn());
            if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
                matrix[p.getRow()][p.getColumn()] = true;
            }
            // If it's the first move, the Pawn can move two squares forward.
            p.setValues(position.getRow() - 2, position.getColumn());
            Position p2 = new Position(position.getRow() - 1, position.getColumn()); // But only if the first square above it isn't occupied.
            if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0){
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
        }

        if (getColor() == Color.BLACK){ // Black pawns can only move downwards
            // Setting p to the row below the pawn 
            // Checking if p has any pieces or not
            p.setValues(position.getRow() + 1, position.getColumn());
            if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
                matrix[p.getRow()][p.getColumn()] = true;
            }
            // If it's the first move, the Pawn can move two squares forward.
            p.setValues(position.getRow() + 2, position.getColumn());
            Position p2 = new Position(position.getRow() + 1, position.getColumn()); // But only if the first square below it isn't occupied.
            if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0){
                matrix[p.getRow()][p.getColumn()] = true;
            }

            // Checking if there are any opponent pieces to the right of the pawn
            p.setValues(position.getRow() + 1, position.getColumn() + 1);
            if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
                matrix[p.getRow()][p.getColumn()] = true;
            }

            // Checking if there are any opponent pieces to the left of the pawn
            p.setValues(position.getRow() + 1, position.getColumn() - 1);
            if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
                matrix[p.getRow()][p.getColumn()] = true;
            }
        }
        return matrix;
    }
}
