package passVault.app;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

public class ProfileCreateViewController {

    private Stage stage;
    private double xOffset = 0;
    private double yOffset = 0;

    public void onCancelButtonClick(ActionEvent event) throws IOException {


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
    }

    public void onNewProfileClick(ActionEvent event) throws IOException {


        stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        // Load FXML and CSS
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("FXML/ProfileFXML/ProfileCreateView.fxml")));
        String css = Objects.requireNonNull(getClass().getResource("CSS/ProfileEditStyle.css")).toExternalForm();

        // Create custom title bar and wrap root with it
        VBox rootWithCustomTitleBar = new VBox(createCustomTitleBar(), root);
        rootWithCustomTitleBar.setFillWidth(true);

        Scene scene = new Scene(rootWithCustomTitleBar);
        scene.getStylesheets().add(css);

        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT); // Make sure stage style is set correctly
        stage.show();
    }

    /**
     * Method for refreshing the list of customers in the Manager GUI.
     * @modifies this
     * @effects updates the list of customers in the Manager GUI
     */
//    @FXML
//    public void refreshCustomerList() {
//        ObservableList<Customer> customerList = FXCollections.observableArrayList(); // The list of customers to be displayed
//        FileManager fileManager = new FileManager();
//        List<String> customerFiles = fileManager.getFilesInDirectory(); // The list of customer files in the directory
//
//        for (String filename : customerFiles) { // Iterate through the customer files
//            String customerData = fileManager.readFromFile(filename); // Read the customer data from the file
//            String[] data = customerData.split("\n"); // Split the data into an array
//            String username = data[0].split(": ")[1]; // Get the username
//            String password = data[1].split(": ")[1]; // Get the password
//            double balance = Double.parseDouble(data[2].split(": ")[1]); // Get the balance
//
//            Customer customer = new Customer(username, password, balance); // Create a new customer
//            customer.getCustomerLevel(); // Get the customer level
//
//            customerList.add(customer); // Add the customer to the list
//        }
//
//        customerTable.setItems(customerList); // Set the items in the customer table
//    }

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
