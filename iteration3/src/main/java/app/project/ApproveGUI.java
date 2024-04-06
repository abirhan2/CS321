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

    public void jobScreen(Stage screen){
        TextField display;
        File f = new File("test.txt");
        ApprovalItem a = new ApprovalItem(null);
        //ApprovalItem job = wft.getNextApprovalItem();             -line for future when wft is hashed out


    }

}
