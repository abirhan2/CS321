package app.project;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import static javafx.geometry.HPos.RIGHT;

import java.io.File;

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

import com.project.*;

/**
 * main class for the program
 * @author Arron Birhanu, Buckley O'Day, Logan Ericksen
 * @version 1.0
 */

/**
 * Class for the entry point of the program. This is the first screen that everyone sees before they choose which job is theirs.
 * This class contains the WorkflowTable that each of the steps work from. 
 */
public class Main extends Application{
    public static WorkflowTable wft; 
    /**
     * main method that is the starting point for the program. created the workflow table and launches the gui
     * @param args not used
     */
    public static void main(String args[]){
        wft = new WorkflowTable();
        launch();
    }
    /**
     * Starting point for the GUI.
     * There is a button for each of the steps to select which one is yours. 
     * @param stage is the stage that the user sees.
     */
    @Override
    public void start(Stage stage) {
        
        // the buttons for each workflow step
        Button button1 = new Button("Data Entry"); 
        Button button2 = new Button("Review");
        Button button3 = new Button("Approval"); 

        GridPane gridPane = new GridPane();  
        gridPane.setMinSize(400, 200);
        gridPane.add(button1, 0, 3); 
        gridPane.add(button2, 1, 3); 
        gridPane.add(button3, 2, 3);

        // This button allows for the Data Entry GUI to open
        button1.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e) {
                DataEntryGUI d = new DataEntryGUI();
                d.display(stage);
            }
        });

        // This button allows for the Review GUI to open
        button2.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e) {
                ReviewGUI r = new ReviewGUI();
                r.display(stage);
            }
        });

        
        // This button allows for the Approve GUI to open
        button3.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                ApproveGUI g = new ApproveGUI();
                g.display(stage);
            }
        });

        
        // Reveal the Stage of the Main Window
        var label = new Label("Select Job");
        var scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.show();
    }
    
}