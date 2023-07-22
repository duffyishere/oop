package org.duffy.chess;

import org.duffy.chess.board.ChessBoard;

public record Location(
        int row,
        int col
) {

    @Override
    public String toString() {
        return "col: " + col + " row: " + row;
    }

    public boolean isValid() {
        return 0 <= row && row < ChessBoard.WIDTH && 0 <= col && col < ChessBoard.HEIGHT;
    }
}
