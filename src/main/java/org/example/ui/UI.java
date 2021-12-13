package org.example.ui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import org.example.domain.Text;
import org.example.logic.Converter;
import org.example.logic.TextReader;


import java.util.Scanner;

public class UI {

    private TextReader textReader = new TextReader();
    private Converter textConverter = new Converter();

    public Scene getScene() {

        //text read and serialized from standard input
        Text text = textReader.readAndSerializeData();

        VBox menu = new VBox();


        Button xmlButton = new Button("Convert to XML");
        Button csvButton = new Button("Convert to CSV");

        menu.getChildren().addAll(xmlButton, csvButton);

        xmlButton.setOnAction((event) -> {
            System.out.println(textConverter.convertToXml(text));
        });

        csvButton.setOnAction((event) -> {
            System.out.println(textConverter.convertToCsv(text));
        });


        Scene scene = new Scene(menu);

        return scene;
    }
}
