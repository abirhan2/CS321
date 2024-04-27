package app.project;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import com.project.*;

/**
 * The class for the GUI for the Review WorkflowStep.
 */
public class ReviewGUI {
    
    // for checking the WorkflowTable more easily
    static WorkflowTable wft = Main.wft;
    ReviewItem test = new ReviewItem("test@email", 1);

    // displays the GUI panel for this step
    public void display(Stage stage){
        GridPane gridPane = new GridPane();
        Button b = new Button("Get Next Job"); 

        // positions and centers the panel
        gridPane.add(b, 0, 0);
        gridPane.setMinSize(400, 200);
        gridPane.setAlignment(Pos.CENTER);
        
        // action to take when this button is clicked
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

    /**
     * This method opens a new panel and selects the next Review Item.
     * @param stage The GUI component of this method.
     * @return void
     */
    public void jobScreen(Stage stage){

        // for testing
        // wft.addReviewItem(test);

        // fetches the next ReviewItem from the WorkflowTable
       
        

        // if there are no items for review, exit back to the main menu
        if (wft == null) {
            Main menu = new Main();
            menu.start(stage);
        }

        ReviewItem item = wft.getNextReviewItem();
        
        
        // creates and centers the panel
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(400, 200);
        gridPane.setAlignment(Pos.CENTER);

        // displays the form and its ID
        if(item == null){
            Main menu = new Main();
            menu.start(stage);
            return;
        }

        Text display = new Text("Selected Job ID: " + item.getID() + "\n" + "Email: " + item.getEmail());
        gridPane.add(display, 1, 0);
        gridPane.setAlignment(Pos.TOP_CENTER);
        
        Button abutton = new Button("Accept Applicant Data");
        Button ebutton = new Button("Edit Applicant Data");
        
        gridPane.add(abutton, 0, 1);
        gridPane.add(ebutton, 2, 1);

        // for accepting applicant data
        abutton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                // adds the ReviewItem to the Approval WorkflowTable
                wft.addApprovalItem(new ApprovalItem(item.getEmail(), item.getID()));
                display(stage);
            }
        });

        // for editing applicant data
        ebutton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                editScreen(stage, item);
            }
        });

        var scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * A method that allows the Reviewer to edit applicant data.
     * @param stage
     */
    public void editScreen(Stage stage, ReviewItem item){
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(400, 200);
        gridPane.setAlignment(Pos.TOP_CENTER);
        Label l = new Label("Edit Applicant Data");
        l.setAlignment(Pos.CENTER);

        Button b = new Button("Edit Email"); 
        gridPane.add(b, 1, 0);
        TextField newEmail = new TextField();
        gridPane.add(newEmail, 1, 1);

        // updates the applicant data
        b.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                item.setEmail(newEmail.getText()); 
                // adds the ReviewItem to the Approval WorkflowTable
                wft.addApprovalItem(new ApprovalItem(item.getEmail(), item.getID()));
                jobScreen(stage);
            }
        });
        var scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.show();
    }
}
