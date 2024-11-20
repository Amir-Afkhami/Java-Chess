package com.groupproject.javachess;

import java.util.ArrayList;

public class Bishop extends ChessPiece{

    public Bishop(boolean isBlack) {
        this.isBlack = isBlack;

        this.imgPath = "images/pieces/b";
        this.type = ChessType.BISHOP;
    }

    @Override
    public ArrayList<Integer[]> getMoves(int x, int y) {
        ChessBoard board = ChessBoard.getInstance();
        ChessPiece[][] pieces = board.getPieces();

        ArrayList<Integer[]> moves = new ArrayList<>();

        //Check top left
        int dx = -1, dy = -1;
        while(board.inBounds(x + dx) && board.inBounds(y + dy)) {
            if(pieces[y + dy][x + dx] instanceof Blank || pieces[y + dy][x + dx].isBlack != this.isBlack) {
                moves.add(new Integer[]{x + dx, y + dy});
            } else {
                break;
            }

            dx--;
            dy--;
        }

        //Check top right
        dx = 1;
        dy = -1;
        while(board.inBounds(x + dx) && board.inBounds(y + dy)) {
            if(pieces[y + dy][x + dx] instanceof Blank || pieces[y + dy][x + dx].isBlack != this.isBlack) {
                moves.add(new Integer[]{x + dx, y + dy});
            } else {
                break;
            }

            dx++;
            dy--;
        }

        //Check bottom right
        dx = 1;
        dy = 1;
        while(board.inBounds(x + dx) && board.inBounds(y + dy)) {
            if(pieces[y + dy][x + dx] instanceof Blank || pieces[y + dy][x + dx].isBlack != this.isBlack) {
                moves.add(new Integer[]{x + dx, y + dy});
            } else {
                break;
            }

            dx++;
            dy++;
        }

        //Check top right
        dx = -1;
        dy = 1;
        while(board.inBounds(x + dx) && board.inBounds(y + dy)) {
            if(pieces[y + dy][x + dx] instanceof Blank || pieces[y + dy][x + dx].isBlack != this.isBlack) {
                moves.add(new Integer[]{x + dx, y + dy});
            } else {
                break;
            }

            dx--;
            dy++;
        }

        return moves;
    }
}
