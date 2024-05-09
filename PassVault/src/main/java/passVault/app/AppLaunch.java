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
import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class AppLaunch extends Application {

    private double xOffset = 0;
    private double yOffset = 0;

    @Override
    public void start(Stage stage) throws IOException {
        AdminFileManager.DefaultTXTdata(true);
        File masterPasswordFile = new File("src/data/aud/mpf.txt");
        String firstLine;
        if (masterPasswordFile.exists()) {
            Scanner myReader = new Scanner(masterPasswordFile);
            firstLine = myReader.nextLine();

            if (firstLine.equals("false")) {
                try {
                    stage.initStyle(StageStyle.TRANSPARENT);
                    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("FXML/FirstStartupView.fxml")));
                    String css = Objects.requireNonNull(this.getClass().getResource("CSS/FirstStartupStyle.css")).toExternalForm();

                    Font.loadFont(getClass().getResourceAsStream("Fonts/PopularCafeNF.ttf"), 20);
                    Font.loadFont(getClass().getResourceAsStream("Fonts/TypoGroteskRounded.ttf"), 20);
                    Font.loadFont(getClass().getResourceAsStream("Fonts/Nunito-ExtraBold.ttf"), 20);

                    HBox titleBar = new HBox();
                    titleBar.setAlignment(Pos.CENTER_RIGHT);
                    titleBar.setPrefHeight(30); // Set the preferred height for the title bar

                    Button minimizeButton = new Button("—");
                    minimizeButton.setOnAction(event -> stage.setIconified(true));
                    minimizeButton.setStyle("-fx-background-color: transparent; -fx-text-fill: #15b300;");

                    Button closeButton = new Button("✕");
                    closeButton.setOnAction(event -> stage.close());
                    closeButton.setStyle("-fx-background-color: transparent; -fx-text-fill: #15b300; -fx-font-size: 10; -fx-font-size: 15;");

                    titleBar.getChildren().addAll(minimizeButton, closeButton);

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
            } else if (firstLine.equals("true")) {
                try {
                    stage.initStyle(StageStyle.TRANSPARENT);
                    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("FXML/LoginView.fxml")));
                    String css = Objects.requireNonNull(this.getClass().getResource("CSS/LoginStyle.css")).toExternalForm();

                    Font.loadFont(getClass().getResourceAsStream("Fonts/PopularCafeNF.ttf"), 20);
                    Font.loadFont(getClass().getResourceAsStream("Fonts/TypoGroteskRounded.ttf"), 20);
                    Font.loadFont(getClass().getResourceAsStream("Fonts/Nunito-ExtraBold.ttf"), 20);

                    HBox titleBar = new HBox();
                    titleBar.setAlignment(Pos.CENTER_RIGHT);
                    titleBar.setPrefHeight(30); // Set the preferred height for the title bar

                    Button minimizeButton = new Button("—");
                    minimizeButton.setOnAction(event -> stage.setIconified(true));
                    minimizeButton.setStyle("-fx-background-color: transparent; -fx-text-fill: #15b300;");

                    Button closeButton = new Button("✕");
                    closeButton.setOnAction(event -> stage.close());
                    closeButton.setStyle("-fx-background-color: transparent; -fx-text-fill: #15b300; -fx-font-size: 10; -fx-font-size: 15;");

                    titleBar.getChildren().addAll(minimizeButton, closeButton);

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
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
