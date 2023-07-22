package org.duffy.chess.piece;

import org.duffy.chess.Team;
import org.duffy.chess.Location;
import org.duffy.chess.board.ChessBoard;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Pawn extends ChessPiece {
    public Pawn(Team team, Location location) {
        super(team, location);
    }

    @Override
    public List<Location> showMovablePaths() {
        ChessBoard boards = ChessBoard.getInstance();
        Location now = getLocation();
        List<Location> paths = new ArrayList<>();

        if (getTeam().equals(Team.WHITE)) {
            paths.addAll(getMovableStraightPaths(boards, now));
            paths.addAll(getMovableLeftDiagonal(boards, now));
            paths.addAll(getMovableRightDiagonal(boards, now));
        }
        // When color's Black
        else {

        }

        return paths;
    }

    private List<Location> getMovableStraightPaths(ChessBoard boards, Location now) {
        List<Location> paths = new ArrayList<>();
        if (checkStraightAhead(boards, now))
            paths.add(new Location(now.row() + 1, now.col()));
        if (checkStraightTwoAhead(boards, now))
            paths.add(new Location(now.row() + 2, now.col()));

        return paths;
    }

    private boolean checkStraightAhead(ChessBoard boards, Location now) {
        Optional<ChessPiece> moveToNextBlock = boards.getPiece(new Location(now.row() + 1, now.col()));
        if (moveToNextBlock.isEmpty()) return true;
        else return false;
    }

    private boolean checkStraightTwoAhead(ChessBoard boards, Location now) {
        Optional<ChessPiece> moveToNextBlock = boards.getPiece(new Location(now.row() + 2, now.col()));
        if (isFirstMove(now) && moveToNextBlock.isEmpty()) return true;
        else return false;
    }

    private boolean isFirstMove(Location now) {
        return now.row() == 1;
    }

    private List<Location> getMovableLeftDiagonal(ChessBoard board, Location now) {
        List<Location> paths = new ArrayList<>();
        if (checkLeftDiagonalAhead(board, now))
            paths.add(new Location(now.row() + 1, now.col() - 1));

        return paths;
    }

    private boolean checkLeftDiagonalAhead(ChessBoard board, Location now) {
        Optional<ChessPiece> moveToNextBlock = board.getPiece(new Location(now.row() + 1, now.col() - 1));
        if (moveToNextBlock.isPresent() && isEnemy(moveToNextBlock.get())) return true;
        else return false;
    }

    private List<Location> getMovableRightDiagonal(ChessBoard board, Location now) {
        List<Location> paths = new ArrayList<>();
        if (checkRightDiagonalAhead(board, now))
            paths.add(new Location(now.row() + 1, now.col() + 1));

        return paths;
    }

    private boolean checkRightDiagonalAhead(ChessBoard board, Location now) {
        Optional<ChessPiece> moveToNextBlock = board.getPiece(new Location(now.row() + 1, now.col() + 1));
        if (moveToNextBlock.isPresent() && isEnemy(moveToNextBlock.get())) return true;
        else return false;
    }

    @Override
    public boolean canMoved(Location destination) {
        return this.showMovablePaths().contains(destination);
    }

    @Override
    public String toString() {
        return "Pawn";
    }
}
