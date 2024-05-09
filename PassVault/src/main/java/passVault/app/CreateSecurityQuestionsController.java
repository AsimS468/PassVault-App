package passVault.app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class CreateSecurityQuestionsController {
    @FXML
    private TextField q1;
    @FXML
    private TextField q2;
    @FXML
    private TextField q3;
    @FXML
    private TextField a1;
    @FXML
    private TextField a2;
    @FXML
    private TextField a3;

    @FXML
    private Label ErrorLabel;
    private Stage stage;
    private double xOffset = 0;
    private double yOffset = 0;

    public void onNextButtonClick(ActionEvent event) throws IOException {
        File AdminFile = new File("src/data/aud/mpf.txt");
        ErrorLabel.setText(""); // Clear any previous error messages

        String qs1 = q1.getText();
        String qs2 = q2.getText();
        String qs3 = q3.getText();
        String ans1 = a1.getText();
        String ans2 = a2.getText();
        String ans3 = a3.getText();
        if((!qs1.isEmpty() && !ans1.isEmpty()) && (!qs2.isEmpty() && !ans2.isEmpty()) && (!qs3.isEmpty() && !ans3.isEmpty())){
            FileWriter myWriter = new FileWriter(AdminFile, true);
            myWriter.write( "\nQuestion 1: " + qs1 + "\nAnswer 1: " + ans1 +
                    "\n\nQuestion 2: " + qs2 + "\nAnswer 2: " + ans2 +
                    "\n\nQuestion 3: " + qs3 + "\nAnswer 3: " + ans3);  // Write the default data
            myWriter.close();

            stage = (Stage)((Node)event.getSource()).getScene().getWindow();

            // Load FXML and CSS
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("FXML/AllSetView.fxml")));
            String css = Objects.requireNonNull(getClass().getResource("CSS/AllSetStyle.css")).toExternalForm();

            // Create custom title bar and wrap root with it
            VBox rootWithCustomTitleBar = new VBox(createCustomTitleBar(), root);
            rootWithCustomTitleBar.setFillWidth(true);

            Scene scene = new Scene(rootWithCustomTitleBar);
            scene.getStylesheets().add(css);

            stage.setScene(scene);
            stage.initStyle(StageStyle.TRANSPARENT); // Make sure stage style is set correctly
            stage.show();
        } else {
            ErrorLabel.setText("You must have 3 security questions and answers!");
        }

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

