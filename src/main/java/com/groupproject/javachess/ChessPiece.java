package com.groupproject.javachess;

import javafx.scene.image.Image;

import java.util.Objects;

public abstract class ChessPiece {
    public ChessType type;
    // false = white and true = black
    protected boolean isBlack;
    protected String imgPath;

    public abstract int[][] getMoves();

    public boolean getSide() {
        return isBlack;
    }
    public Image getImage() {
        try {
            if(type == ChessType.BLANK) {
                String path = Objects.requireNonNull(this.getClass().getResource(this.imgPath + ".png"))
                        .toExternalForm();

                return new Image(path);
            }


            String color = isBlack ? "d" : "l";

            String path = Objects.requireNonNull(this.getClass().getResource(this.imgPath + color + "t.png"))
                    .toExternalForm();

            return new Image(path);
        } catch (NullPointerException e) {
            String path = this.getClass().getResource("images/test.png").toExternalForm();

            return new Image(path);
        }
    }
}
