package com.groupproject.javachess;

public class Rook extends ChessPiece{

    public Rook(boolean isBlack) {
        this.isBlack = isBlack;

        this.imgPath = "images/pieces/r";
        this.type = ChessType.ROOK;
    }

    @Override
    public int[][] getMoves() {
        return new int[0][];
    }
}
