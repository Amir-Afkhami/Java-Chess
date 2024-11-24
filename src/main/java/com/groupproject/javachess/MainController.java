package com.groupproject.javachess;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class MainController {

    double deltaX = 0;
    double deltaY = 0;

    String[] pieceNames = {"plt", "pdt", "rlt", "rdt", "nlt", "ndt", "blt", "bdt", "klt", "kdt", "qlt", "qdt"};
    Map<String, Image> pieces = new HashMap<>(12);

    @FXML
    private HBox titlebar;

    @FXML
    private GridPane mainGrid;

    @FXML
    private GridPane gameGrid;

    @FXML
    private void initialize() {

        ChessBoard board = ChessBoard.getInstance();

        board.setBoards(mainGrid, gameGrid);
        board.init();


    }

    @FXML
    protected void onDragStart(MouseEvent actionEvent) {
        deltaX = actionEvent.getSceneX();
        deltaY = actionEvent.getSceneY();

    }
    @FXML
    protected void onDragged(MouseEvent actionEvent) {
        Stage stage = (Stage) titlebar.getScene().getWindow();

        stage.setX(actionEvent.getScreenX() - deltaX);
        stage.setY(actionEvent.getScreenY() - deltaY);
    }
    @FXML
    protected void onMinimize(ActionEvent actionEvent) {
        Stage stage = (Stage) titlebar.getScene().getWindow();

        stage.setIconified(!stage.isIconified());
    }
    @FXML
    protected void onFullscreen(ActionEvent actionEvent) {
        Stage stage = (Stage) titlebar.getScene().getWindow();

        stage.setMaximized(!stage.isMaximized());
    }
    @FXML
    protected void onClose(ActionEvent actionEvent) {
        Stage stage = (Stage) titlebar.getScene().getWindow();

        stage.close();
    }
}