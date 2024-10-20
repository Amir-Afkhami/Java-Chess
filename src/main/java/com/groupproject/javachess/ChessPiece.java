package com.groupproject.javachess;

public abstract class ChessPiece {
    public ChessType type;

    int x, y;
    boolean side;

    public abstract int[][] getMoves(ChessPiece[] pieces);

    public int getX() {
        return x;
    };
    public int getY() {
        return y;
    }
    public boolean getSide() {
        return side;
    }

    public void setX(int x) {
        if(x >= 0 && x < 8) {
            this.x = x;
        }
    }
    public void setY(int y) {
        if(y >= 0 && y < 8) {
            this.y = y;
        }
    }
}
