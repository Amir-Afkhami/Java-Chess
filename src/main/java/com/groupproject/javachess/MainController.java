package com.groupproject.javachess;

import com.sun.tools.javac.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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

        // Populate Image Map
        try {
            for(String name : pieceNames) {
                String path = Objects.requireNonNull(this.getClass().getResource("images/pieces/" + name + ".png")).toExternalForm();
                Image img = new Image(path);

                pieces.put(name, img);
            }
        } catch (NullPointerException e) {
            System.err.println("[ERROR] Could not retrieve images for chess pieces");

            Stage stage = (Stage) titlebar.getScene().getWindow();
            stage.close();
        }

        try {
            String walnutPath = Objects.requireNonNull(this.getClass().getResource("images/walnut.png")).toExternalForm();
            String lightPath = Objects.requireNonNull(this.getClass().getResource("images/finewood.png")).toExternalForm();

            Image walnut = new Image(walnutPath);
            Image light = new Image(lightPath);

            // Assign each cell an image
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if((i + j) % 2 == 0) {
                        ImageView view = new ImageView(light);
                        view.setPreserveRatio(true);
                        view.setFitWidth(85);
                        view.setFitHeight(85);
                        mainGrid.add(view, j, i);
                    } else {
                        ImageView view = new ImageView(walnut);
                        view.setPreserveRatio(true);
                        view.setFitWidth(85);
                        view.setFitHeight(85);
                        mainGrid.add(view, j, i);
                    }
                }
            }
        } catch (NullPointerException e) {
            System.err.println("[ERROR] Could not retrieve images for chess board");

            Stage stage = (Stage) titlebar.getScene().getWindow();
            stage.close();
        }



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
    protected void onToggleSettings(ActionEvent actionEvent) {
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