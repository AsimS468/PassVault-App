package passVault.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Objects;

public class FXML_Tester extends Application {

    private double xOffset = 0;
    private double yOffset = 0;

    @Override
    public void start(Stage stage) {
        try {
            // Set stage to undecorated and transparent (removes native title bar)
            stage.initStyle(StageStyle.TRANSPARENT);

            // Load the FXML and apply CSS
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("FXML/ProfileFXML/ProfileListView.fxml")));
            String css = Objects.requireNonNull(this.getClass().getResource("CSS/ProfileListStyle.css")).toExternalForm();

            // Load fonts
            Font.loadFont(getClass().getResourceAsStream("Fonts/PopularCafeNF.ttf"), 20);
            Font.loadFont(getClass().getResourceAsStream("Fonts/TypoGroteskRounded.ttf"), 20);
            Font.loadFont(getClass().getResourceAsStream("Fonts/Nunito-ExtraBold.ttf"), 20);

            // Create the custom title bar
            HBox titleBar = new HBox();
            titleBar.setAlignment(Pos.CENTER_RIGHT);
            titleBar.setPrefHeight(30); // Set the preferred height for the title bar

            // Minimize button
            Button minimizeButton = new Button("—");
            minimizeButton.setOnAction(event -> stage.setIconified(true));
            minimizeButton.setStyle("-fx-background-color: transparent; -fx-text-fill: #15b300;");

            // Close button
            Button closeButton = new Button("✕");
            closeButton.setOnAction(event -> stage.close());
            closeButton.setStyle("-fx-background-color: transparent; -fx-text-fill: #15b300; -fx-font-size: 10; -fx-font-size: 15;");

            titleBar.getChildren().addAll(minimizeButton, closeButton);

            // Enable dragging of the stage
            titleBar.setOnMousePressed(event -> {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            });
            titleBar.setOnMouseDragged(event -> {
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
            });

            VBox rootWithCustomTitleBar = new VBox(titleBar, root);
            rootWithCustomTitleBar.setFillWidth(true);

            Scene sceneWithCustomTitleBar = new Scene(rootWithCustomTitleBar);
            sceneWithCustomTitleBar.getStylesheets().add(css);

            stage.setScene(sceneWithCustomTitleBar);
            stage.setResizable(false);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
