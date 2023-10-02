package com.example.csc311_loancalc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * The main class for the Loan Calculator application.
 */
public class HelloApplication extends Application {

    /**
     * The entry point of the application.
     *
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        launch();
    }

    /**
     * Start method called when launching the JavaFX application.
     *
     * @param stage The primary stage for the application.
     * @throws IOException If there is an error loading the FXML file.
     */
    @Override
    public void start(Stage stage) throws IOException {
        // Load the FXML layout file for the user interface
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        // Create a scene with the loaded FXML content
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        // Set the title of the application window
        stage.setTitle("Loan Calculator");

        // Set the scene for the stage
        stage.setScene(scene);

        // Show the stage (i.e., the application window)
        stage.show();
    }
}
