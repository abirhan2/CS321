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

import java.io.File;
import java.awt.Desktop;
import com.project.*;

public class ApproveGUI {
    
    static WorkflowTable wft = Main.wft;

    public void display(Stage stage){
        GridPane gridPane = new GridPane();
        Button b = new Button("get job"); 

        
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
        TextField display = new TextField("selected job id ");
        gridPane.add(display, 1, 0);
        gridPane.setAlignment(Pos.TOP_CENTER);


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

        var scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.show();
    }

    public void approvalScreen(Stage stage){
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(400, 200);
        TextField display = new TextField("email contents here");
        gridPane.add(display, 0, 0);

        Button b = new Button("send email"); 
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
    public void denyScreen(Stage stage){
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(400, 200);
        TextField display = new TextField("Item removed and returned for review.");
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
