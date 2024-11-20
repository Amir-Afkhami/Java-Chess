package com.groupproject.javachess;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Objects;

public class ChessBoard {
    int turns = 0;

    private static ChessBoard INSTANCE;

    GridPane background;
    GridPane gameBoard;
    ChessPiece[][] pieces;

    boolean isAI = true;

    private ChessBoard(GridPane bgBoard, GridPane gameBoard) {
        this.background = bgBoard;
        this.gameBoard = gameBoard;
        this.pieces = new ChessPiece[8][8];
    }

    public void init() {
        initBoardBG();
        initPieces();
    }

    public static ChessBoard getInstance() {
        if (INSTANCE != null) {
            return INSTANCE;
        } else {
            INSTANCE = new ChessBoard(new GridPane(), new GridPane());
            return INSTANCE;
        }
    }

    public ChessPiece[][] getPieces() {
        return this.pieces;
    }

    public boolean inBounds(int x) {
        return x > -1 && x < 8;
    }

    public void setBoards(GridPane bgBoard, GridPane gameBoard) {
        this.background = bgBoard;
        this.gameBoard = gameBoard;
    }

    private void initBoardBG() {
        try {
            String walnutPath = Objects.requireNonNull(this.getClass().getResource("images/walnut.png")).toExternalForm();
            String lightPath = Objects.requireNonNull(this.getClass().getResource("images/finewood.png")).toExternalForm();

            Image walnut = new Image(walnutPath);
            Image light = new Image(lightPath);

            // Assign each cell an image
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if ((i + j) % 2 == 0) {
                        ImageView view = new ImageView(light);
                        view.setPreserveRatio(true);
                        view.setFitWidth(85);
                        view.setFitHeight(85);
                        background.add(view, j, i);
                    } else {
                        ImageView view = new ImageView(walnut);
                        view.setPreserveRatio(true);
                        view.setFitWidth(85);
                        view.setFitHeight(85);
                        background.add(view, j, i);
                    }
                }
            }
        } catch (NullPointerException e) {
            System.err.println("[ERROR] Could not retrieve images for chess board");
        }
    }

    private void initPieces() {
        pieces[7][0] = new Rook(false);
        pieces[7][1] = new Knight(false);
        pieces[7][2] = new Bishop(false);
        pieces[7][3] = new King(false);
        pieces[7][4] = new Queen(false);
        pieces[7][5] = new Bishop(false);
        pieces[7][6] = new Knight(false);
        pieces[7][7] = new Rook(false);

        pieces[0][0] = new Rook(true);
        pieces[0][1] = new Knight(true);
        pieces[0][2] = new Bishop(true);
        pieces[0][3] = new King(true);
        pieces[0][4] = new Queen(true);
        pieces[0][5] = new Bishop(true);
        pieces[0][6] = new Knight(true);
        pieces[0][7] = new Rook(true);

        for (int i = 0; i < 8; i++) {
            pieces[6][i] = new Pawn(false);
            pieces[1][i] = new Pawn(true);
        }

        for (int i = 0; i < 8; i++) {
            pieces[2][i] = new Blank(false);
            pieces[3][i] = new Blank(false);
            pieces[4][i] = new Blank(false);
            pieces[5][i] = new Blank(false);
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ImageView img = new ImageView(pieces[i][j].getImage());

                img.setPreserveRatio(true);
                img.setFitWidth(85);
                img.setFitHeight(85);
                img.setOnMouseClicked(mouseEvent -> {
                    int column = (int) Math.floor(mouseEvent.getSceneX() / 85);
                    int row = (int) Math.floor((mouseEvent.getSceneY() - 50) / 85);

                    ChessBoard.getInstance().handleClick(column, row);
                });

                gameBoard.add(img, j, i);
            }

        }
    }

    private void handleClick(int x, int y) {
        System.out.println("X: " + x + " Y: " + y);
        ArrayList<Integer[]> moves = pieces[y][x].getMoves(x, y);

        for (Integer[] move : moves) {
            System.out.println("Column: " + move[0] + " Row: " + move[1]);
        }
    }
}
