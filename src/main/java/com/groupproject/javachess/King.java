package com.groupproject.javachess;

import java.util.ArrayList;

public class King extends ChessPiece {

    public King(boolean isBlack) {
        this.isBlack = isBlack;

        this.imgPath = "images/pieces/k";
        this.type = ChessType.KING;
    }

    @Override
    public ArrayList<Integer[]> getMoves(int x, int y) {
        ChessBoard board = ChessBoard.getInstance();
        ChessPiece[][] pieces = board.getPieces();

        ArrayList<Integer[]> moves = new ArrayList<>();

        /*
            xoo
            o o
            ooo
         */
        if (board.inBounds(x - 1) && board.inBounds(y - 1) &&
                (pieces[y - 1][x - 1] instanceof Blank || pieces[y - 1][x - 1].isBlack != this.isBlack)) {
            moves.add(new Integer[]{x - 1, y - 1});
        }

        /*
            oxo
            o o
            ooo
         */
        if (board.inBounds(y - 1) &&
                (pieces[y - 1][x] instanceof Blank || pieces[y - 1][x].isBlack != this.isBlack)) {
            moves.add(new Integer[]{x, y - 1});
        }

        /*
            oox
            o o
            ooo
         */
        if (board.inBounds(x + 1) && board.inBounds(y - 1) &&
                (pieces[y - 1][x + 1] instanceof Blank || pieces[y - 1][x + 1].isBlack != this.isBlack)) {
            moves.add(new Integer[]{x + 1, y - 1});
        }

        /*
            ooo
            o x
            ooo
         */
        if (board.inBounds(x + 1) &&
                (pieces[y][x + 1] instanceof Blank || pieces[y][x + 1].isBlack != this.isBlack)) {
            moves.add(new Integer[]{x + 1, y});
        }

        /*
            ooo
            o o
            oox
         */
        if (board.inBounds(x + 1) && board.inBounds(y + 1) &&
                (pieces[y + 1][x + 1] instanceof Blank || pieces[y + 1][x + 1].isBlack != this.isBlack)) {
            moves.add(new Integer[]{x + 1, y + 1});
        }

        /*
            ooo
            o o
            oxo
         */
        if (board.inBounds(y + 1) &&
                (pieces[y + 1][x] instanceof Blank || pieces[y + 1][x].isBlack != this.isBlack)) {
            moves.add(new Integer[]{x, y + 1});
        }

        /*
            ooo
            o o
            xoo
         */
        if (board.inBounds(x - 1) && board.inBounds(y + 1) &&
                (pieces[y + 1][x - 1] instanceof Blank || pieces[y + 1][x - 1].isBlack != this.isBlack)) {
            moves.add(new Integer[]{x - 1, y + 1});
        }

        /*
            ooo
            x o
            ooo
         */
        if (board.inBounds(x - 1) &&
                (pieces[y][x - 1] instanceof Blank || pieces[y][x - 1].isBlack != this.isBlack)) {
            moves.add(new Integer[]{x - 1, y});
        }

        return moves;
    }
}
