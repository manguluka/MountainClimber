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
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.regex.*;


public class StoqSignIn extends Application {
	String username, password;
	Pane pane = new Pane();
	Scene scene = new Scene(pane, 400, 500);
	
	@Override
	public void start(Stage stage) throws Exception {
		
		
		stage.setTitle("stoqscreen Sign In");
		stage.setScene(scene); // Place the scene in the stage
	    stage.show(); // Display the stage
	    
	    
	    stage.setResizable(false); //This is important for positioning purposes!
	    
	    
	    Image signIne = new Image(getClass().getResourceAsStream("signin.png"));
	    ImageView signInImage = new ImageView(signIne);
	    signInImage.setFitHeight(125);
	    signInImage.setFitWidth(125);
	    signInImage.setPreserveRatio(true);
	    
	    Image signUpe = new Image(getClass().getResourceAsStream("signup.png"));
	    ImageView signUpImage = new ImageView(signUpe);
	    signUpImage.setFitHeight(125);
	    signUpImage.setFitWidth(125);
	    signUpImage.setPreserveRatio(true);
	    
	    Button signIn = new Button("", signInImage);
	    signIn.setLayoutX(scene.getWidth()/2-62.5);
	    signIn.setLayoutY(300);
	    
	    Button signUp = new Button("", signUpImage);
	    signUp.setLayoutX(scene.getWidth()/2-62.5);
	    signUp.setLayoutY(388);
	    signUp.setStyle("-fx-background-color: transparent;");
	    
	    Text or = new Text("or"); 
	    or.setLayoutX(scene.getWidth()/2);
	    or.setLayoutY(375);
	    or.setFont(Font.font ("Arial", 18));
	    
	    signIn.setStyle("-fx-background-color: transparent;");
	    TextField userInputField = new TextField();
	    userInputField.setPromptText("username");
	    userInputField.setMinWidth(300);
	    userInputField.setMinHeight(40);
	    userInputField.setLayoutX(scene.getWidth()/2-150);
	    userInputField.setLayoutY(170);
	    userInputField.setStyle("-fx-focus-color: #e67e22");
	    userInputField.setFont(Font.font ("Arial", 16));
	    
		    
	    PasswordField passwordInputField = new PasswordField();
	    passwordInputField.setPromptText("password");
	    passwordInputField.setMinWidth(300);
	    passwordInputField.setMinHeight(40);
	    passwordInputField.setLayoutX(scene.getWidth()/2-150);
	    passwordInputField.setLayoutY(240);
	    passwordInputField.setStyle("-fx-focus-color: #e67e22");
	    passwordInputField.setFont(Font.font ("Arial", 16));
	        
	        
	    signIn.setOnMouseClicked(evt ->
	    {
	    	username = userInputField.getText();
			if (username.isEmpty())
			{
				userInputField.requestFocus();
				userInputField.setStyle("-fx-focus-color: red");    				
			}
			
			password = passwordInputField.getText();
			if (password.isEmpty())
			{
				passwordInputField.requestFocus();
				passwordInputField.setStyle("-fx-focus-color: red");
				
			}
			
			if (!username.isEmpty() && !password.isEmpty() && usernameRegexChecker(username) && passwordRegexChecker(password))
	    	{
	    		pane.getChildren().clear();
	    		//TODO: Play animation for SQL Connect!
	    	}
			
			else {
				
			}
	    });
	    
	    signUp.setOnMouseClicked(evt ->
	    {
	    	pane.getChildren().clear();
	    	displaySignUpPage();
	    });
	    
	    scene.setOnKeyPressed(evt -> 
	    {
	    	if (evt.getCode().equals(KeyCode.ENTER))
	            {
	    			username = userInputField.getText();
	    			if (username.isEmpty())
	    			{
	    				userInputField.requestFocus();
	    				userInputField.setStyle("-fx-focus-color: red");    				
	    			}
	    			
	    			password = passwordInputField.getText();
	    			if (password.isEmpty())
	    			{
	    				passwordInputField.requestFocus();
	    				passwordInputField.setStyle("-fx-focus-color: red");
	    				
	    			}
	    			
	    			if (!username.isEmpty() && !password.isEmpty() && usernameRegexChecker(username) && passwordRegexChecker(password))
	    	    	{
	    	    		pane.getChildren().clear();
	    	    		//TODO: Play animation for SQL Connect!
	    	    	}
	            }	   
	    });
	    
	    pane.setStyle("-fx-background-color: #ecf0f1");
	    pane.getChildren().add(signIn); 
	    pane.getChildren().add(signUp);
	    pane.getChildren().add(userInputField);
	    pane.getChildren().add(passwordInputField);
	    pane.getChildren().add(or);
	    
	    	    
	}

	public boolean usernameRegexChecker(String username)
	{
		boolean b = username.matches("^(?=.{4,12}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$"); //Definitely need to discuss this regex
		return true;
	}
	
	public boolean passwordRegexChecker(String password)
	{
		boolean b = password.matches("^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[^a-zA-Z0-9\\s]).{8,16}"); 
		// Regex for this field is ok, I figure it's another way of sanitizing input in case we find a hacker in our midst.
		// Please discuss if disagree
		
		return true;
	}
	
	public void displaySignUpPage()
	{
		TextField firstName = new TextField();
		firstName.setPromptText("First Name");
		firstName.setMinWidth(100);
	    firstName.setMinHeight(40);
	    firstName.setLayoutX(scene.getWidth()*.10);
	    firstName.setLayoutY(20);
	    firstName.setStyle("-fx-focus-color: #e67e22");
	    firstName.setFont(Font.font("Arial", 16));
		
	    TextField lastName = new TextField();
		lastName.setPromptText("Last Name");
	    lastName.setMinHeight(40);
	    lastName.setPrefWidth(200);
	    lastName.setMinWidth(300);
	    lastName.setLayoutX(scene.getWidth()*.10);
	    lastName.setLayoutY(80);
	    lastName.setStyle("-fx-focus-color: #e67e22");
	    lastName.setFont(Font.font("Arial", 16));
		
		pane.getChildren().addAll(firstName, lastName);
	}

}
