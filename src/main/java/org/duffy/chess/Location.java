package org.duffy.chess;

public record Location(
        int row,
        int col
) {

    @Override
    public String toString() {
        return "col: " + col + " row: " + row;
    }
}
