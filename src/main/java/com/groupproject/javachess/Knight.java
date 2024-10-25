package com.groupproject.javachess;

public class Knight extends ChessPiece{

    public Knight(boolean isBlack) {
        this.isBlack = isBlack;

        this.imgPath = "images/pieces/n";
        this.type = ChessType.KNIGHT;
    }

    @Override
    public int[][] getMoves() {
        return new int[0][];
    }
}
