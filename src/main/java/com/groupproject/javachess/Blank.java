package com.groupproject.javachess;

import java.util.ArrayList;

public class Blank extends ChessPiece {
    public Blank() {
        this.isBlack = false;

        this.imgPath = "images/pieces/blank";
        this.type = ChessType.BLANK;
    }

    @Override
    public ArrayList<Integer[]> getMoves(int x, int y) {
        return null;
    }
}
