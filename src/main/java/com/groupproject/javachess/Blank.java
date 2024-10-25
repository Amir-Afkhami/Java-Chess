package com.groupproject.javachess;

public class Blank extends ChessPiece {
    public Blank(boolean isBlack) {
        this.isBlack = isBlack;

        this.imgPath = "images/pieces/blank";
        this.type = ChessType.BLANK;
    }

    @Override
    public int[][] getMoves() {
        return null;
    }
}
