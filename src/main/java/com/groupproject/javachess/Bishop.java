package com.groupproject.javachess;

public class Bishop extends ChessPiece{

    public Bishop(boolean isBlack) {
        this.isBlack = isBlack;

        this.imgPath = "images/pieces/b";
        this.type = ChessType.BISHOP;
    }

    @Override
    public int[][] getMoves() {
        return new int[0][];
    }
}
