package com.groupproject.javachess;

import java.util.ArrayList;

public class Rook extends ChessPiece {

    public Rook(boolean isBlack) {
        this.isBlack = isBlack;

        this.imgPath = "images/pieces/r";
        this.type = ChessType.ROOK;
    }

    @Override
    public ArrayList<Integer[]> getMoves(int x, int y) {
        ChessBoard board = ChessBoard.getInstance();
        ChessPiece[][] pieces = board.getPieces();

        ArrayList<Integer[]> moves = new ArrayList<>();

        // Check Above
        for (int i = y - 1; i >= 0; i--) {
            if (!board.inBounds(i)) break;

            if (pieces[i][x] instanceof Blank || pieces[i][x].isBlack != this.isBlack) {
                moves.add(new Integer[]{x, i});
            } else {
                break;
            }
        }

        // Check Right
        for (int i = x + 1; i >= 0; i++) {
            if (!board.inBounds(i)) break;

            if (pieces[y][i] instanceof Blank || pieces[y][i].isBlack != this.isBlack) {
                moves.add(new Integer[]{i, y});
            } else {
                break;
            }
        }

        // Check Bottom
        for (int i = y + 1; i >= 0; i++) {
            if (!board.inBounds(i)) break;

            if (pieces[i][x] instanceof Blank || pieces[i][x].isBlack != this.isBlack) {
                moves.add(new Integer[]{x, i});
            } else {
                break;
            }
        }

        // Check Left
        for (int i = x - 1; i >= 0; i--) {
            if (!board.inBounds(i)) break;

            if (pieces[y][i] instanceof Blank || pieces[y][i].isBlack != this.isBlack) {
                moves.add(new Integer[]{i, y});
            } else {
                break;
            }
        }

        return moves;
    }
}
