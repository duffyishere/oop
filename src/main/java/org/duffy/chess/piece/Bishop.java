package org.duffy.chess.piece;

import org.duffy.chess.Chess;
import org.duffy.chess.Location;
import org.duffy.chess.Team;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends ChessPiece {
    public Bishop(Team team, Location location) {
        super(team, location);
    }

    @Override
    public List<Location> showMovablePaths() {
        List<Location> path = new ArrayList<>();
        Chess chess = Chess.getInstance();

        // 왼쪽 위
        Location next = new Location(getLocation().row() - 1, getLocation().col() - 1);
        while (chess.canMove(getLocation(), next)) {
            path.add(next);
            next = new Location(next.row() - 1, next.col() - 1);
        }

        // 오른쪽 위
        next = new Location(getLocation().row() - 1, getLocation().col() + 1);
        while (chess.canMove(getLocation(), next)) {
            path.add(next);
            next = new Location(next.row() - 1, next.col() + 1);
        }

        // 왼쪽 아래
        next = new Location(getLocation().row() + 1, getLocation().col() - 1);
        while (chess.canMove(getLocation(), next)) {
            path.add(next);
            next = new Location(next.row() + 1, next.col() - 1);
        }

        // 오른쪽 아래
        next = new Location(getLocation().row() + 1, getLocation().col() + 1);
        while (chess.canMove(getLocation(), next)) {
            path.add(next);
            next = new Location(next.row() + 1, next.col() + 1);
        }

        return path;
    }

    @Override
    public String toString() {
        return "Bishop";
    }
}
