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

public class CreateMasterPassController {
    @FXML
    private PasswordField InputPass;
    @FXML
    private PasswordField ConfirmPass;
    @FXML
    private Label ErrorLabel;
    private Stage stage;
    private double xOffset = 0;
    private double yOffset = 0;

    public void onNextButtonClick(ActionEvent event) throws IOException {
        File masterPasswordFile = new File("src/data/aud/mpf.txt");
        ErrorLabel.setText(""); // Clear any previous error messages

        String inputtedPass = InputPass.getText();
        String confirmPass = ConfirmPass.getText();
        if(inputtedPass.equals(confirmPass) && (!inputtedPass.isEmpty() && !confirmPass.isEmpty())){
            FileWriter myWriter = new FileWriter(masterPasswordFile);
            myWriter.write( "true\nPassword: " + inputtedPass + "\n");  // Write the default data
            myWriter.close();

            stage = (Stage)((Node)event.getSource()).getScene().getWindow();

            // Load FXML and CSS
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("FXML/CreateSecurityQuestionsView.fxml")));
            String css = Objects.requireNonNull(getClass().getResource("CSS/CreateSecurityQuestionsStyle.css")).toExternalForm();

            // Create custom title bar and wrap root with it
            VBox rootWithCustomTitleBar = new VBox(createCustomTitleBar(), root);
            rootWithCustomTitleBar.setFillWidth(true);

            Scene scene = new Scene(rootWithCustomTitleBar);
            scene.getStylesheets().add(css);

            stage.setScene(scene);
            stage.initStyle(StageStyle.TRANSPARENT); // Make sure stage style is set correctly
            stage.show();
        } else if (inputtedPass != null && confirmPass.isEmpty()) {
            ErrorLabel.setText("Input your password in both fields!");
        } else if (inputtedPass.isEmpty() && confirmPass != null) {
            ErrorLabel.setText("Input your password in both fields!");
        } else if (inputtedPass.isEmpty() && confirmPass.isEmpty()){
            ErrorLabel.setText("The fields are empty!");
        } else {
            ErrorLabel.setText("The fields do not match!");
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

