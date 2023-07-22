package org.duffy.chess.board;

import org.duffy.chess.Location;
import org.duffy.chess.piece.ChessPiece;

import java.util.Optional;

public class ChessBoard {
    private static ChessBoard instance;

    public ChessPiece[][] board = new ChessPiece[8][8];

    private ChessBoard() {}

    public static synchronized ChessBoard getInstance() {
        if (instance == null)
            instance = new ChessBoard();

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
            throw new IllegalArgumentException(piece.toString() + " is can't go " + to.toString());
    }

    public Optional<ChessPiece> getPiece(Location location) {
        return Optional.ofNullable(board[location.row()][location.col()]);
    }
}
