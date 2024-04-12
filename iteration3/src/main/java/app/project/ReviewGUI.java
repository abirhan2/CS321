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

// just a copy of ApproveGUI for now
public class ReviewGUI {
    
    static WorkflowTable wft = Main.wft;

    public void display(Stage stage){
        GridPane gridPane = new GridPane();
        Button b = new Button("Get Job"); 

        
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
        TextField display = new TextField("Selected Job ID");
        gridPane.add(display, 1, 0);
        gridPane.setAlignment(Pos.TOP_CENTER);
        
        ReviewItem a = wft.getNextReviewItem();

        ///applicant info display
        if (Desktop.isDesktopSupported()) {
            try {
                System.out.println("Attempting to open file...");
                Desktop desktop = Desktop.getDesktop();
                File myFile = a.viewForm();
                desktop.open(myFile);
            } catch (IOException ex) {
                System.out.println("ERROR OPENING FILE");
            }
        } 
        
        Button abutton = new Button("Accept Applicant Form");
        Button ebutton = new Button("Edit Applicant Form");
        
        gridPane.add(abutton, 0, 1);
        gridPane.add(ebutton, 2, 1);

        abutton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                reviewScreen(stage);
            }
        });
        ebutton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                editScreen(stage);
            }
        });

        var scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.show();
    }

    public void reviewScreen(Stage stage){
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(400, 200);
        TextField display = new TextField("Review the Applicant");
        gridPane.add(display, 0, 0);

        Button b = new Button("Accept the Applicant"); 
        gridPane.add(b, 0, 0);
        b.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                display(stage);
            }
        });
        var scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.show();
    }
    public void editScreen(Stage stage){
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(400, 200);
        TextField display = new TextField("Edit Applicant Data");
        gridPane.add(display, 0, 0);

        Button b = new Button("Edit Form"); 
        gridPane.add(b, 0, 0);

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
