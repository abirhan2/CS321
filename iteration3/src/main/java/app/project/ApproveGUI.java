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

public class ApproveGUI {
    
    static WorkflowTable wft = Main.wft;

    public void display(Stage stage){
        GridPane gridPane = new GridPane();
        Button b = new Button("get job but evil"); 

        
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

        ApprovalItem a = wft.getNextApprovalItem();
        if(a==null){
            Text display = new Text("No jobs available");
            gridPane.add(display, 1, 0);
        }
        else{
            Text display = new Text("selected job id " + a.getID());
            gridPane.add(display, 1, 0);
            ///applicant info display, doesnt work on my ubuntu machine, uncomment for windows
            // if (Desktop.isDesktopSupported()) {
            //     try {
            //         System.out.println("attempting to open pdf");
            //         Desktop desktop = Desktop.getDesktop();
            //         File myFile = a.viewForm();
            //         desktop.open(myFile);
            //     } catch (IOException ex) {
            //         System.out.println("ERROR OPENING FILE");
            //     }
            // } 
        
            Button abutton = new Button("approve");
            Button dbutton = new Button("deny");
            gridPane.add(abutton, 0, 1);
            gridPane.add(dbutton, 2, 1);
            abutton.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent e) {
                    approvalScreen(stage);
                }
            });
            dbutton.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent e) {
                    denyScreen(stage);
                }
            });
            }
        

        var scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.show();
    }

    public void approvalScreen(Stage stage){
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setMinSize(400, 200);
        TextField display = new TextField("email contents here");
        gridPane.add(display, 0, 0);

        Button b = new Button("send email"); 
        gridPane.add(b, 1, 1);
        b.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                //add ability to send a real email here. For now, it will just print
                System.out.println(display.getText());
                //return the requested documents here. I plan on doing this by hashing applicant names to files
                display(stage);
            }
        });
        var scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.show();
    }
    public void denyScreen(Stage stage){
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(400, 200);
        Text display = new Text("Item removed and returned for review.");
        gridPane.add(display, 0, 0);

        Button b = new Button("get next job"); 
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