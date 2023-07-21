package org.duffy.chess.piece;

import org.duffy.chess.Location;
import org.duffy.chess.board.ChessBoard;

import java.util.List;

public abstract class ChessPiece {
    private ChessBoard board;

    private Location location;

    public ChessPiece(ChessBoard board, Location location) {
        this.board = board;
        this.location = location;
    }

    public void moved(Location location) {
        this.location = location;
    }
    public ChessBoard getBoard() {
        return board;
    }
    public Location getLocation() {
        return location;
    }

    public abstract List<Location> showMovablePaths();
    public abstract boolean canMoved(Location destination);
    public abstract String toString();
}
