package com.groupproject.javachess;

import java.util.ArrayList;

public class Blank extends ChessPiece {
    public Blank(boolean isBlack) {
        this.isBlack = isBlack;

        this.imgPath = "images/pieces/blank";
        this.type = ChessType.BLANK;
    }

    @Override
    public ArrayList<Integer[]> getMoves(int x, int y) {
        return null;
    }
}
