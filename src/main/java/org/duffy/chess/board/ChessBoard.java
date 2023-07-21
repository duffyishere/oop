package org.duffy.chess.board;

import org.duffy.chess.Location;
import org.duffy.chess.piece.ChessPiece;

public class ChessBoard {
    private static ChessBoard instance;

    private ChessPiece[][] board = new ChessPiece[8][8];

    private ChessBoard() {}

    public static synchronized ChessBoard getInstance() {
        if (instance == null)
            instance = new ChessBoard();

        return instance;
    }

    public void setup() {
        for (int col = 0; col < 8; col++) {
        }
    }

    public void move(Location from, Location to) {
        ChessPiece piece = board[from.row()][from.col()];
        if (piece == null)
            throw new IllegalArgumentException("Here is empty blank");

        if (piece.canMoved(to)) {
            board[to.row()][to.col()] = piece;
            board[from.row()][from.col()] = null;
            piece.moved(to);
        }
        else
            throw new IllegalArgumentException(piece.toString() + " is can't go " + to.toString());
    }
}
