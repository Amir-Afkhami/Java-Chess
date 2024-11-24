package com.groupproject.javachess;

import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Objects;

public class ChessBoard {
    private int turns = 0;
    private boolean isEnd = false;

    private static ChessBoard INSTANCE;

    private GridPane background;
    private GridPane gameBoard;
    private ChessPiece[][] pieces;
    private int selectionX;
    private int selectionY;
    ArrayList<Integer[]> moves;


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
                        ImageView view = createImage(walnut);

                        background.add(view, j, i);
                    } else {
                        ImageView view = createImage(light);

                        background.add(view, j, i);
                    }
                }
            }

            gameBoard.setOnMouseClicked(mouseEvent -> {
                int column = (int) Math.floor(mouseEvent.getSceneX() / 85);
                int row = (int) Math.floor((mouseEvent.getSceneY() - 50) / 85);

                ChessBoard.getInstance().handleClick(column, row);
            });
        } catch (NullPointerException e) {
            System.err.println("[ERROR] Could not retrieve images for chess board");
        }
    }

    private void initPieces() {
        pieces[7][0] = new Rook(false);
        pieces[7][1] = new Knight(false);
        pieces[7][2] = new Bishop(false);
        pieces[7][3] = new Queen(false);
        pieces[7][4] = new King(false);
        pieces[7][5] = new Bishop(false);
        pieces[7][6] = new Knight(false);
        pieces[7][7] = new Rook(false);

        pieces[0][0] = new Rook(true);
        pieces[0][1] = new Knight(true);
        pieces[0][2] = new Bishop(true);
        pieces[0][3] = new Queen(true);
        pieces[0][4] = new King(true);
        pieces[0][5] = new Bishop(true);
        pieces[0][6] = new Knight(true);
        pieces[0][7] = new Rook(true);

        for (int i = 0; i < 8; i++) {
            pieces[6][i] = new Pawn(false);
            pieces[1][i] = new Pawn(true);
        }

        for (int i = 0; i < 8; i++) {
            pieces[2][i] = new Blank();
            pieces[3][i] = new Blank();
            pieces[4][i] = new Blank();
            pieces[5][i] = new Blank();
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ImageView img = createImage(pieces[i][j].getImage());

                gameBoard.add(img, j, i);
            }

        }
    }

    private void handleClick(int x, int y) {
        if (this.isEnd) return;

        if (pieces[y][x].isBlack == (turns % 2 != 0) && !(pieces[y][x] instanceof Blank)) {
            this.selectionX = x;
            this.selectionY = y;
            this.moves = pieces[y][x].getMoves(x, y);

            this.clearHighlight();
            this.highlightBoard();
        } else {
            if (selectionX >= 0 && selectionY >= 0 && moves != null) {
                boolean isValid = false;
                for (Integer[] move : moves) {
                    if (move[0] == x && move[1] == y) {
                        isValid = true;
                        break;
                    }
                }

                if (isValid) {
                    ChessPiece target = pieces[y][x];

                    pieces[y][x] = pieces[selectionY][selectionX];
                    pieces[selectionY][selectionX] = target instanceof Blank ? target : new Blank();

                    ImageView movedImage = createImage(pieces[y][x].getImage());
                    ImageView replacementImage = createImage(pieces[selectionY][selectionX].getImage());

                    gameBoard.getChildren().removeIf(node -> GridPane.getColumnIndex(node) == x && GridPane.getRowIndex(node) == y);
                    gameBoard.getChildren().removeIf(node -> GridPane.getColumnIndex(node) == selectionX && GridPane.getRowIndex(node) == selectionY);

                    this.gameBoard.add(movedImage, x, y);
                    this.gameBoard.add(replacementImage, selectionX, selectionY);

                    turns++;

                    this.selectionX = -1;
                    this.selectionY = -1;
                    this.moves = null;

                    this.clearHighlight();

                    if (target instanceof King) {
                        winPopup(!target.getSide());
                        this.isEnd = true;
                    }
                }
            }

            selectionX = -1;
            selectionY = -1;
            this.moves = null;
            this.clearHighlight();
        }
    }

    private void clearHighlight() {
        background.getChildren().forEach(node -> {
            node.setEffect(null);
        });
    }

    private void highlightBoard() {
        for (Integer[] move : moves) {
            ColorAdjust hueShift = new ColorAdjust();
            if (pieces[move[1]][move[0]] instanceof Blank) {
                hueShift.setHue(2);
            } else {
                hueShift.setHue(-0.3);
            }
            background.getChildren().forEach(node -> {
                if (GridPane.getColumnIndex(node).equals(move[0]) && GridPane.getRowIndex(node).equals(move[1])) {
                    node.setEffect(hueShift);
                }
            });
        }
    }

    public static ImageView createImage(Image image) {
        ImageView img = new ImageView(image);

        img.setPreserveRatio(true);
        img.setFitWidth(85);
        img.setFitHeight(85);

        return img;
    }

    private void winPopup(boolean side) {
        Stage stage = (Stage) background.getScene().getWindow();
        Popup pop = new Popup();

        Label label = new Label((side ? "Black" : "White") + " won");

        label.setTextFill(new Color(1, 1, 1, 1));
        label.setStyle("-fx-font-size: 30;");

        pop.getContent().add(label);

        pop.show(stage);

    }
}
