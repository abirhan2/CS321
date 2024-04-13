package app.project;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import static javafx.geometry.HPos.CENTER;
import static javafx.geometry.HPos.RIGHT;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.Desktop;
import com.project.*;

public class DataEntryGUI {
    public void display(Stage stage){

        GridPane gridPane = new GridPane();
        Button b = new Button("Proceed to Data Entry"); 
        b.setAlignment(Pos.CENTER);

        
        gridPane.add(b, 0, 0);

        gridPane.setMinSize(400, 200);
        gridPane.setAlignment(Pos.CENTER);
        
        b.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                jobScreen(stage);
            }
        });
        
        
        var scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.show();
    }

    public void jobScreen(Stage stage){
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(400, 200);
        gridPane.setAlignment(Pos.CENTER);


        Label l = new Label("Enter a valid Email Address");
        l.setAlignment((Pos.TOP_CENTER));

        Button submit = new Button("Submit");
        submit.setAlignment(Pos.BOTTOM_RIGHT);
        Button cancel = new Button("Cancel");
        cancel.setAlignment(Pos.BOTTOM_LEFT);

        TextField email = new TextField();

        DataEntry data = new DataEntry();
        
        

        gridPane.add(l, 5, 0);
        gridPane.add(cancel, 1, 5);
        gridPane.add(submit, 10, 5);
        gridPane.add(email, 5, 2);

        cancel.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                cancelScreen(stage);
            }
        });

        submit.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent e) {
                data.setEmail(email.getText());
                if( data.email==null ||  !(data.email.contains("@")) ){
                    invalidScreen(stage);
                }
                else{
                    data.setID(new WorkflowTable().getID());
                    submitScreen(stage, data.email);
                }
            }
        });

        var scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.show();
    }


    public void submitScreen(Stage stage, String email){
        GridPane gridPane = new GridPane();
        Label l = new Label("You have signed in as " + email);
        Button b = new Button("Proceed back to the main screen"); 
        b.setAlignment(Pos.CENTER);
        l.setAlignment(Pos.TOP_CENTER);
        
        gridPane.add(b, 0, 5);
        gridPane.add(l, 0, 0);

        gridPane.setMinSize(400, 200);
        gridPane.setAlignment(Pos.CENTER);
        
        b.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                Main m1 = new Main();
                m1.start(stage);
            }
        });
        
        
        var scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.show();
    }

    public void cancelScreen(Stage stage){
        GridPane gridPane = new GridPane();
        Label l = new Label("You have cancelled the data entry process");
        Button b = new Button("Proceed back to the main screen"); 
        b.setAlignment(Pos.CENTER);
        l.setAlignment((Pos.TOP_CENTER));
        
        gridPane.add(b, 0, 5);
        gridPane.add(l, 0, 0);

        gridPane.setMinSize(400, 200);
        gridPane.setAlignment(Pos.CENTER);
        
        b.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                Main m1 = new Main();
                m1.start(stage);
            }
        });
        
        
        var scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.show();
    }

    public void invalidScreen(Stage stage){
        GridPane gridPane = new GridPane();
        Label l = new Label("Invalid Email. Please try again.");
        Button b = new Button("Return to login"); 
        l.setAlignment(Pos.CENTER);
        b.setAlignment(Pos.CENTER);

        
        gridPane.add(b, 0, 5);
        gridPane.add(l, 0, 0);

        gridPane.setMinSize(400, 200);
        gridPane.setAlignment(Pos.CENTER);
        
        b.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                jobScreen(stage);
            }
        });
        
        
        var scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.show();
    }
}
