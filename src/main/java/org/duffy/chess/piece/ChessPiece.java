package org.duffy.chess.piece;

import org.duffy.chess.Team;
import org.duffy.chess.Location;
import org.duffy.chess.board.ChessBoard;

import java.util.List;

public abstract class ChessPiece {
    private Team team;
    private Location location;

    public ChessPiece(Team team, Location location) {
        this.team = team;
        this.location = location;
    }

    public void moved(Location location) {
        this.location = location;
    }

    public Location getLocation() { return location; }
    public ChessPiece[][] getBoard() { return ChessBoard.getInstance().board; }
    public Team getColor() { return getColor(); }

    public abstract List<Location> showMovablePaths();
    public abstract boolean canMoved(Location destination);
    public abstract String toString();
}
