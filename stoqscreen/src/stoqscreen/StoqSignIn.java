package stoqscreen;


import com.sun.glass.events.MouseEvent;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/* Welcome to stoqscreen; the free stock screener
 * 
 * This project is dedicated to creating a free, sleek, and intuitive 
 * stock terminal. 
 * 
 * [KEY]
 * 		--Q Question from developer
 * 		--S Suggestion from developer
 * 
 * 
 * This section needs to start first when stoqscreen is launched. 
 * 		--Q Should we have a sign in section or will stoqscreen be for guest users?
 *		--Q What the hell should we name it?
 *		--S I have this idea of whenever a user adds a stock to "track" the ticker
 *			is written to a file inside of the program directory. Stoqscreen then 
 *			reads the file and retrieves the data from this master "user" file.
 * 
 */
public class StoqSignIn extends Application {

	/*public static void main(String[] args) {
		launch(args);
		
	}*/

	@Override
	public void start(Stage stage) throws Exception {
		Pane pane = new Pane();
		Scene scene = new Scene(pane, 400, 500);
		stage.setTitle("stoqscreen Sign In");
		stage.setScene(scene); // Place the scene in the stage
	    stage.show(); // Display the stage
	    
	    
	    stage.setResizable(false); //This is important for positioning purposes!
	    
	    
	    Image signIne = new Image(getClass().getResourceAsStream("signin.png"));
	    ImageView signInImage = new ImageView(signIne);
	    signInImage.setFitHeight(125);
	    signInImage.setFitWidth(125);
	    signInImage.setPreserveRatio(true);
	    
	    Button signIn = new Button("", signInImage);
	    signIn.setLayoutX(scene.getWidth()/2-62.5);
	    signIn.setLayoutY(300);
	    
	    signIn.setStyle("-fx-background-color: transparent;");
	    TextField userInputField = new TextField("username");
	    userInputField.setMinWidth(300);
	    userInputField.setMinHeight(40);
	    userInputField.setLayoutX(scene.getWidth()/2-150);
	    userInputField.setLayoutY(170);
	    userInputField.setStyle("-fx-focus-color: #e67e22");
	    
	    //TODO: Need to make lamda listener that makes text in text field go away when hovered on
	    
	    PasswordField passwordInputField = new PasswordField();
	    passwordInputField.setMinWidth(300);
	    passwordInputField.setMinHeight(40);
	    passwordInputField.setLayoutX(scene.getWidth()/2-150);
	    passwordInputField.setLayoutY(240);
	    passwordInputField.setStyle("-fx-focus-color: #e67e22");
	        
	    //TODO: Need to make lamda listener that makes text in text field go away when hovered on
	    //TODO: Find a way to display the word "password" before user types in input
	    
	    
	    
	    pane.getChildren().add(signIn);   
	    pane.getChildren().add(userInputField);
	    pane.getChildren().add(passwordInputField);
	    
	    
	}

}
