package com.project;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application{
    public static void main(String args[]){
        launch();
    }
    @Override
    public void start(Stage stage) {
        // var javaVersion = SystemInfo.javaVersion();
        // var javafxVersion = SystemInfo.javafxVersion();

        Button button1 = new Button("data entry"); 
        Button button2 = new Button("review");
        Button button3 = new Button("approve"); 

        GridPane gridPane = new GridPane();  
        gridPane.setMinSize(400, 200);
        gridPane.add(button1, 0, 3); 
        gridPane.add(button2, 1, 3); 
        gridPane.add(button3, 2, 3);

        var label = new Label("select job");
        var scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.show();
    }
    
}
