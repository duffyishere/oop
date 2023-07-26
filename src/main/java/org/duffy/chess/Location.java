package org.duffy.chess;

public record Location(
        int row,
        int col
) {

    @Override
    public String toString() {
        return "col: " + col + " row: " + row;
    }

    public Location sum(Location to) {
        return new Location(row + to.row, col + to.col);
    }
    public Location subtract(Location to) {
        return new Location(row - to.row, col - to.col);
    }

    public boolean isValid() {
        return 0 <= row && row < Chess.BOARD_WIDTH && 0 <= col && col < Chess.BOARD_HEIGHT;
    }
}
