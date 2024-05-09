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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class LoginController {
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label wrongPassword;

    private final String[] WrongPassPrompt1 = {"Login unsuccessful. Please check your password and try again.",
            "Incorrect password. Please try again.",
            "Incorrect password. Please try again."};
    private final String[] WrongPassPrompt2 = {"Try again, but with feeling this time.",
            "Password denied. Are you even trying?",
            "Denied! Do you also forget faces this fast?",
            "Wrong. Did you try saying 'Please' yet?",
            "Error 404: Password not found.",
            "Nice try. Next guess?",
            "Incorrect. Did you forget something?",
            "Password rejected. This is not a drill!",
            "Whoops! That's not it. Go again?",
            "Strike one! Try again.",
            "Keep guessing!",
            "Not even close. You can do better!",
            "Oops! That's the password for something else.",
            "Yikes! Another typo?",
            "Try again, or I call the guessing police!",
            "Missed it by that much!",
            "Access denied. Did you eat a clown for breakfast?",
            "Nope. Want a hint?",
            "That password was so last season.",
            "No dice. Roll again?",
            "Wrong! Are your fingers dancing on the keyboard?",
            "Not that one. Your other favorite password?",
            "Are you really in charge of your memory?",
            "Wrong again, did you try putting it in rice?",
            "Password not recognized. Try again or try telepathy!",
            "Nuh uh", "You really want to get in don't you?",
            "Most people would have gotten it after 3 tries...",
            "Try again, with the power of friendship.",
            "WRONG!",
            "We can see why you need this app...",
            "Maybe the correct password is in your pocket",
            "Ok now the machine is judging you.",
            "You seem like you need hacking lessons. Contact me and I'll teach ya!",
            "Did I ever tell you the definition of insanity?",
            "Everyone used 12345 back in my day!",
            "What's funny is that you expect to find treasure!",
            "This is NOT the enigma machine!",
            "Never has a date been more disappointing...",
            "How the heck is it taking you this long?!",
            "Maybe the right password was the friends we made along the way."};
    private int attemptCount = 0;
    private Stage stage;
    private double xOffset = 0;
    private double yOffset = 0;

    public void onLoginButtonClick(ActionEvent event) throws IOException {
        attemptCount++;
        File masterPasswordFile = new File("src/data/aud/mpf.txt");
        BufferedReader reader = new BufferedReader(new FileReader(masterPasswordFile));
        reader.readLine();  // Read and ignore the first line
        String verify = reader.readLine();
        wrongPassword.setText(""); // Clear any previous error messages
        Scanner myReader = new Scanner(masterPasswordFile);
        String password = passwordField.getText();
        if(verify.equals("Password: " + password)){
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();

            // Load FXML and CSS
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("FXML/ProfileFXML/ProfileListView.fxml")));
            String css = Objects.requireNonNull(getClass().getResource("CSS/ProfileListStyle.css")).toExternalForm();

            // Create custom title bar and wrap root with it
            VBox rootWithCustomTitleBar = new VBox(createCustomTitleBar(), root);
            rootWithCustomTitleBar.setFillWidth(true);

            Scene scene = new Scene(rootWithCustomTitleBar);
            scene.getStylesheets().add(css);

            stage.setScene(scene);
            stage.initStyle(StageStyle.TRANSPARENT); // Make sure stage style is set correctly
            stage.show();

        } else {
            displayWrongPasswordMessage();
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

    private void displayWrongPasswordMessage() {
        Random random = new Random();
        if (attemptCount <= 3) {
            int index = random.nextInt(WrongPassPrompt1.length);
            wrongPassword.setText(WrongPassPrompt1[index]);
        } else {
            int index = random.nextInt(WrongPassPrompt2.length);
            wrongPassword.setText(WrongPassPrompt2[index]);
        }
    }

} 

