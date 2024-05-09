package passVault.app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class FirstStartupController {

    private Stage stage;
    private double xOffset = 0;
    private double yOffset = 0;

    public void onSetupButtonClick(ActionEvent event) throws IOException {


        stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        // Load FXML and CSS
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("FXML/CreateMasterPassView.fxml")));
        String css = Objects.requireNonNull(getClass().getResource("CSS/CreateMasterPassStyle.css")).toExternalForm();

        // Create custom title bar and wrap root with it
        VBox rootWithCustomTitleBar = new VBox(createCustomTitleBar(), root);
        rootWithCustomTitleBar.setFillWidth(true);

        Scene scene = new Scene(rootWithCustomTitleBar);
        scene.getStylesheets().add(css);

        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT); // Make sure stage style is set correctly
        stage.show();
    }

    private HBox createCustomTitleBar() {
        HBox titleBar = new HBox();
        titleBar.setAlignment(Pos.CENTER_RIGHT);
        titleBar.setPrefHeight(30);

        Button minimizeButton = new Button("—");
        minimizeButton.setOnAction(e -> stage.setIconified(true));
        minimizeButton.setStyle("-fx-background-color: transparent; -fx-text-fill: #15b300;");

        Button closeButton = new Button("✕");
        closeButton.setOnAction(e -> stage.close());
        closeButton.setStyle("-fx-background-color: transparent; -fx-text-fill: #15b300; -fx-font-size: 15;");

        titleBar.getChildren().addAll(minimizeButton, closeButton);

        // Enable dragging of the stage
        titleBar.setOnMousePressed(e -> {
            xOffset = e.getSceneX();
            yOffset = e.getSceneY();
        });
        titleBar.setOnMouseDragged(e -> {
            stage.setX(e.getScreenX() - xOffset);
            stage.setY(e.getScreenY() - yOffset);
        });

        return titleBar;
    }
}
