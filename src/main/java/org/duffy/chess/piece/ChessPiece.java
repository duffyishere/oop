package org.duffy.chess.piece;

import org.duffy.chess.Chess;
import org.duffy.chess.Team;
import org.duffy.chess.Location;

import java.util.List;

public abstract class ChessPiece {
    private Team team;
    private Location location;

    public ChessPiece(Team team, Location location) {
        this.team = team;
        this.location = location;
    }

    public Location getLocation() { return location; }
    public Team getTeam() { return team; }

    public void moved(Location location) { this.location = location; }
    public boolean isEnemy(ChessPiece piece) {
        if (piece.getTeam().equals(team))
            return false;
        else return true;
    }

    public void kill(ChessPiece piece) {
        piece.dead();
    }
    public void dead() {
        Chess.getInstance().exceptPiece(location);
        location = null;
    }

    public abstract List<Location> showMovablePaths();
    public boolean canMove(Location location) {
        return showMovablePaths().contains(location);
    };
    public abstract String toString();
}
