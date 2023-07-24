package org.duffy.chess;

public record Location(
        int row,
        int col
) {

    @Override
    public String toString() {
        return "col: " + col + " row: " + row;
    }

    public boolean isValid() {
        return 0 <= row && row < Chess.BOARD_WIDTH && 0 <= col && col < Chess.BOARD_HEIGHT;
    }
}
