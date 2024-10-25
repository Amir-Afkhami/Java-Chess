package com.groupproject.javachess;

public class Pawn extends ChessPiece {

    public Pawn(boolean isBlack) {
        this.isBlack = isBlack;


        this.imgPath = "images/pieces/p";
        this.type = ChessType.PAWN;
    }

    @Override
    public int[][] getMoves() {
        return new int[0][];
    }
}
