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

public class Main extends Application{
    public static WorkflowTable wft; 
    public static void main(String args[]){
        wft = new WorkflowTable();
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
