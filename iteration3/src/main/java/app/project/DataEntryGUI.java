package app.project;


////////////////////////////////////////////////all import files necessary for the project
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
///////////////////////////////////////////////////////////////////////////////////////////

//DataEntryGUI Class
public class DataEntryGUI {

    //the stage that precedes the login page for the data entry section
    public void display(Stage stage){

        GridPane gridPane = new GridPane();//create a new screen to add elements onto
        Button b = new Button("Proceed to Data Entry"); //button(s)
        b.setAlignment(Pos.CENTER);

        
        gridPane.add(b, 0, 0);

        gridPane.setMinSize(400, 200);
        gridPane.setAlignment(Pos.CENTER);
        //elements of the display function's interface
        
        //when the: Proceed to Data Entry button is clicked...
        b.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                jobScreen(stage); //call jobScreen
            }
        });
        
        
        var scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.show();
    }

    //the login page for the data entry section
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
        //elements of the display function's interface

        cancel.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                cancelScreen(stage);
            }
        });//cancel button goes to call cancelScreen

        submit.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent e) {
                data.setEmail(email.getText());
                if( data.email==null ||  !(data.email.contains("@")) ){
                    invalidScreen(stage);//call invalidScreen if login credentials are faulty
                }
                else{
                    data.setID(new WorkflowTable().getID());
                    submitScreen(stage, data.email);//call submitScreen if the login credentials are valid
                }
            }
        });//submit button enters data into the system and gets verified before entering the review process

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
        //elements of the submitScreen function's interface

        b.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                Main m1 = new Main();
                m1.start(stage);//Proceed back to the main screen with the valid information
            }
        });//valid email has been entered,no need to remain in the dataEntry stage anymore, return to the Main stage
        
        
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
        //elements of the cancelScreen function's interface

        b.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                Main m1 = new Main();
                m1.start(stage);//leave the dataentryGUI process and return to MainGui stage
            }
        });//cancels the data entry process and returns to the homepage (hosting all 3 stages: dataEntry, Review, Approval)
        
        
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
        //elements of the invalidScreen function's interface

        b.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                jobScreen(stage);//try again and call jobScreen
            }
        });//indicates invalid information has been entered
        
        
        var scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.show();
    }
}
