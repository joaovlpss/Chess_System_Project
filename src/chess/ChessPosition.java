package chess;

import boardgame.Position;
import chess.exceptions.ChessException;

public class ChessPosition {
    private char column;
    private int row;

    public ChessPosition(char column, int row){
        if (column < 'a' || column > 'h' || row < 0 || row > 8){
            throw new ChessException("Position out of bounds. Valid values are a1 - h8.");
        }
        this.column = column;
        this.row = row;
    }

    public char getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    /* Converts ChessPositions to board matrix positions. 
     * Matrix rows are equal to 8 - ChessPosition rows
     * Matrix columns are equal to ChessPosition columns - 'a'
     * (because of Unicode encoding).
    */
    protected Position toPosition(){
        return new Position(8 - row, column - 'a');
    }

    // The inverse of toPosition
    protected static ChessPosition fromPosition(Position position){
        return new ChessPosition((char)('a' + position.getColumn()), 8 - position.getRow());
    }

    @Override
    public String toString(){
        return "" + column + row; // String concat to return column and row as Strings.
    }
}
