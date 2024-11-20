package com.groupproject.javachess;

import java.util.ArrayList;

public class Knight extends ChessPiece {

    public Knight(boolean isBlack) {
        this.isBlack = isBlack;

        this.imgPath = "images/pieces/n";
        this.type = ChessType.KNIGHT;
    }

    @Override
    public ArrayList<Integer[]> getMoves(int x, int y) {
        ChessBoard board = ChessBoard.getInstance();
        ChessPiece[][] pieces = board.getPieces();

        ArrayList<Integer[]> moves = new ArrayList<>();

        /*
            OOOOO
            xOOOO
            OO OO
            OOOOO
            OOOOO
         */
        if (board.inBounds(x - 2) && board.inBounds(y - 1) &&
                (pieces[y - 1][x - 2] instanceof Blank || pieces[y - 1][x - 2].isBlack != this.isBlack)) {
            moves.add(new Integer[]{x - 2, y - 1});
        }

        /*
            OxOOO
            0OOOO
            OO OO
            OOOOO
            OOOOO
         */
        if (board.inBounds(x - 1) && board.inBounds(y - 2) &&
                (pieces[y - 2][x - 1] instanceof Blank || pieces[y - 2][x - 1].isBlack != this.isBlack)) {
            moves.add(new Integer[]{x - 1, y - 2});
        }

        /*
            O0OxO
            0OOOO
            OO OO
            OOOOO
            OOOOO
         */
        if (board.inBounds(x + 1) && board.inBounds(y - 2) &&
                (pieces[y - 2][x + 1] instanceof Blank || pieces[y - 2][x + 1].isBlack != this.isBlack)) {
            moves.add(new Integer[]{x + 1, y - 2});
        }

        /*
            O0O0O
            0OOOx
            OO OO
            OOOOO
            OOOOO
         */
        if (board.inBounds(x + 2) && board.inBounds(y - 1) &&
                (pieces[y - 1][x + 2] instanceof Blank || pieces[y - 1][x + 2].isBlack != this.isBlack)) {
            moves.add(new Integer[]{x + 2, y - 1});
        }

        /*
            O0O0O
            0OOO0
            OO OO
            OOOOx
            OOOOO
         */
        if (board.inBounds(x + 2) && board.inBounds(y + 1) &&
                (pieces[y + 1][x + 2] instanceof Blank || pieces[y + 1][x + 2].isBlack != this.isBlack)) {
            moves.add(new Integer[]{x + 2, y + 1});
        }

        /*
            O0O0O
            0OOO0
            OO OO
            OOOO0
            OOOxO
         */
        if (board.inBounds(x + 1) && board.inBounds(y + 2) &&
                (pieces[y + 2][x + 1] instanceof Blank || pieces[y + 2][x + 1].isBlack != this.isBlack)) {
            moves.add(new Integer[]{x + 1, y + 2});
        }

        /*
            O0O0O
            0OOO0
            OO OO
            OOOO0
            OxOOO
         */
        if (board.inBounds(x - 1) && board.inBounds(y + 2) &&
                (pieces[y + 2][x - 1] instanceof Blank || pieces[y + 2][x - 1].isBlack != this.isBlack)) {
            moves.add(new Integer[]{x - 1, y + 2});
        }

        /*
            O0O0O
            0OOO0
            OO OO
            xOOO0
            OOOOO
         */
        if (board.inBounds(x - 2) && board.inBounds(y + 1) &&
                (pieces[y + 1][x - 2] instanceof Blank || pieces[y + 1][x - 2].isBlack != this.isBlack)) {
            moves.add(new Integer[]{x - 2, y + 1});
        }

        return moves;
    }
}
