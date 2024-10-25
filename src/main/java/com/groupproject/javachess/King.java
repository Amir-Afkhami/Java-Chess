package com.groupproject.javachess;

public class King extends ChessPiece {

    public King(boolean isBlack) {
        this.isBlack = isBlack;

        this.imgPath = "images/pieces/k";
        this.type = ChessType.KING;
    }

    @Override
    public int[][] getMoves() {
        return new int[0][];
    }
}
