package com.groupproject.javachess;

public class Queen extends ChessPiece{

    public Queen(boolean isBlack) {
        this.isBlack = isBlack;

        this.imgPath = "images/pieces/q";
        this.type = ChessType.QUEEN;
    }

    @Override
    public int[][] getMoves() {
        return new int[0][];
    }
}
