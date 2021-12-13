package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.ui.UI;

public class App extends Application {

    @Override
    public void start(Stage stage) {

        UI ui = new UI();
        Scene scene = ui.getScene();

        stage.setScene(scene);
        stage.show();


    }

    public static void main( String[] args ) {
        launch();

    }
}
