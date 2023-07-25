package org.duffy.chess.piece;

import org.duffy.chess.Team;
import org.duffy.chess.Location;
import org.duffy.chess.Chess;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Pawn extends ChessPiece {
    private final Location[] MOVABLE_DIRECTIONS_BLACK_TEAM = { new Location(1, -1), new Location(1, 0), new Location(1, 1) };
    private final Location[] MOVABLE_DIRECTIONS_WHITE_TEAM = { new Location(-1, -1), new Location(-1, 0), new Location(-1, 1) };

    public Pawn(Team team, Location location) {
        super(team, location);
    }

    @Override
    public List<Location> showMovablePaths() {
        List<Location> paths = new ArrayList<>();
        Location now = getLocation();
        if (getTeam().equals(Team.BLACK)) {
            for (int i = 0; i < MOVABLE_DIRECTIONS_BLACK_TEAM.length; i++) {
                Location next = now.sum(MOVABLE_DIRECTIONS_BLACK_TEAM[i]);
                if (canMove(i, next))
                    paths.add(next);
            }
        }
        else {
            for (int i = 0; i < MOVABLE_DIRECTIONS_WHITE_TEAM.length; i++) {
                Location next = now.sum(MOVABLE_DIRECTIONS_WHITE_TEAM[i]);
                if (canMove(i, next))
                    paths.add(next);
            }
        }

        return paths;
    }

    private boolean isFirstMoveWhite(Location now) {
        return now.row() == 1;
    }

    private boolean isFirstMoveBlack(Location now) {
        return now.row() == Chess.BOARD_HEIGHT - 2;
    }

    public boolean canMove(int index, Location next) {
        Location now = getLocation();

        if (!next.isValid()) return false;
        if (index == 0 || index == 2) {
            Optional<ChessPiece> nextPiece = Chess.getInstance().getPiece(next);
            if (nextPiece.isPresent() && nextPiece.get().getTeam() != getTeam())
                return true;
        }
        else if (index == 1) {
            Optional<ChessPiece> nextPiece = Chess.getInstance().getPiece(next);
            if (nextPiece.isEmpty())
                return true;
            if (getTeam() == Team.WHITE && isFirstMoveWhite(now))
                return true;
            else if (getTeam() == Team.BLACK && isFirstMoveBlack(now))
                return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "Pawn";
    }
}
