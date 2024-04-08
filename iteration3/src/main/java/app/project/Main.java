package app.project;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

import com.project.*;

/**
 * class for the entry point of the program. This is the first screen that everyone sees before they choose which job is theirs.
 * This class contains the workflowtable that each of the steps work from. 
 * sidenote for the future - we may need to learn more about this running multiple times, like if one of each step is active. I personally don't know how that works
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
     * starting point for the gui
     * there is a button for each of the steps to select which one is yours. 
     * @param stage is the stage that the user sees.
     */
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

        //this is how you program what happens when the button is pressed. Able to call stuff from a different class, approvegui is the one that I (logan) will work from
        button3.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                ApproveGUI g = new ApproveGUI();
                g.display(stage);
            }
        });

        var label = new Label("select job");
        var scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.show();
    }
    
}
