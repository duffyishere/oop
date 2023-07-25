package org.duffy.chess.piece;

import org.duffy.chess.Chess;
import org.duffy.chess.Location;
import org.duffy.chess.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Rook extends ChessPiece {

    public Rook(Team team, Location location) {
        super(team, location);
    }

    @Override
    public List<Location> showMovablePaths() {
        List<Location> path = new ArrayList<>();
        Location now = getLocation();

        for (int i = 0; i < Chess.BOARD_HEIGHT; i++) {
            if (now.row() == i) continue;
            Location vertical = new Location(now.row(), i);
            Optional<ChessPiece> piece = Chess.getInstance().getPiece(vertical);
            if (piece.isPresent() && piece.get().getTeam() == getTeam())
                break;
            else
                path.add(vertical);
        }
        for (int i = 0; i < Chess.BOARD_WIDTH; i++) {
            if (now.col() == i) continue;
            Location horizon = new Location(i, now.col());
            Optional<ChessPiece> piece = Chess.getInstance().getPiece(horizon);
            if (piece.isPresent() && piece.get().getTeam() == getTeam())
                break;
            else
                path.add(horizon);
        }
        return path;
    }

    @Override
    public String toString() {
        return "Rock";
    }
}
