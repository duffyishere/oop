package org.duffy.chess;

import org.duffy.chess.piece.ChessPiece;

import java.util.Optional;

public class Chess {
    private static Chess instance;

    public static final int BOARD_WIDTH = 8, BOARD_HEIGHT = 8;
    public ChessPiece[][] board = new ChessPiece[BOARD_HEIGHT][BOARD_WIDTH];

    private Chess() {}

    public static synchronized Chess getInstance() {
        if (instance == null)
            instance = new Chess();

        return instance;
    }

    private void setup() {
        for (int col = 0; col < 8; col++) {
        }
    }

    public void move(Location from, Location to) {
        Optional<ChessPiece> pieceOptional = getPiece(from);
        if (pieceOptional.isEmpty())
            throw new IllegalArgumentException("Here is empty blank");

        ChessPiece piece = pieceOptional.get();
        if (piece.canMoved(to)) {
            board[to.row()][to.col()] = piece;
            board[from.row()][from.col()] = null;
            piece.moved(to);
        }
        else
            throw new IllegalArgumentException(piece + " is can't go " + to.toString());
    }

    public Optional<ChessPiece> getPiece(Location location) {
        return Optional.ofNullable(board[location.row()][location.col()]);
    }
}
