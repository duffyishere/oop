package org.duffy.chess;

public record Location(
        int col,
        int row
) {

    @Override
    public String toString() {
        return "col: " + col + " row: " + row;
    }
}
