package com.groupproject.javachess;

import java.util.ArrayList;

public class Pawn extends ChessPiece {

    public Pawn(boolean isBlack) {
        this.isBlack = isBlack;


        this.imgPath = "images/pieces/p";
        this.type = ChessType.PAWN;
    }

    @Override
    public ArrayList<Integer[]> getMoves(int x, int y) {
        ChessBoard board = ChessBoard.getInstance();
        ChessPiece[][] pieces = board.getPieces();

        ArrayList<Integer[]> moves = new ArrayList<>();

        // Check Ahead
        if (this.isBlack ) {
            if(board.inBounds(y + 1) && pieces[y + 1][x] instanceof Blank) {
                moves.add(new Integer[]{x, y + 1});

                if (y == 1 && pieces[y + 2][x] instanceof Blank)
                    moves.add(new Integer[]{x, y + 2});
            }

            //Check right flank
            if(board.inBounds(x + 1) && !(pieces[y + 1][x + 1] instanceof Blank) && pieces[y + 1][x + 1].isBlack != this.isBlack) {
                moves.add(new Integer[]{x + 1, y + 1});
            }
            //Check left flank
            if(board.inBounds(x - 1) && !(pieces[y + 1][x - 1] instanceof Blank) && pieces[y + 1][x - 1].isBlack != this.isBlack) {
                moves.add(new Integer[]{x - 1, y + 1});
            }

        } else {
            if (board.inBounds(y - 1) && pieces[y - 1][x] instanceof Blank) {
                moves.add(new Integer[]{x, y - 1});

                if (y == 6 && pieces[y - 2][x] instanceof Blank)
                    moves.add(new Integer[]{x, y - 2});
            }

            //Check right flank
            if(board.inBounds(x + 1) && !(pieces[y - 1][x + 1] instanceof Blank) && pieces[y - 1][x + 1].isBlack != this.isBlack) {
                moves.add(new Integer[]{x + 1, y - 1});
            }
            //Check left flank
            if(board.inBounds(x - 1) &&!(pieces[y - 1][x - 1] instanceof Blank) && pieces[y - 1][x - 1].isBlack != this.isBlack) {
                moves.add(new Integer[]{x - 1, y - 1});
            }
        }

        return moves;
    }
}
