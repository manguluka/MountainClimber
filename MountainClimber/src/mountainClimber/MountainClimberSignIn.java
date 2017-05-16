package mountainClimber;

//TODO: Need to implement custom title bar!
//Video for reference: https://www.youtube.com/watch?v=fT8gl6R2xmc
//Try to mimic new age design See: Spotify Title Bar

import com.sun.glass.events.MouseEvent;

import java.sql.*;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.*;

import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;



public class MountainClimberSignIn extends Application {
	String username, password;
	Pane pane = new Pane();
	Scene scene = new Scene(pane, 325, 400);
	


	@Override
	public void start(Stage stage) throws Exception {
	//TODO: Turn the home page into a function that can be called so a user can interchange betweeen login and sign up
		
		stage.setTitle("mountainclimber Sign In");
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

	    Image logo = new Image(getClass().getResourceAsStream("logo.png"));
	    ImageView logoImage = new ImageView(logo);
	    logoImage.setFitWidth(200);
	    logoImage.setPreserveRatio(true);
	    logoImage.setLayoutX(pane.getWidth()/2 - 100);
	    logoImage.setLayoutY(20);


	    Button signIn = new Button("", signInImage);
	    signIn.setLayoutX(scene.getWidth()/2-140);
	    signIn.setLayoutY(300);

	    Button signUp = new Button("", signUpImage);
	    signUp.setLayoutX(scene.getWidth()/2);
	    signUp.setLayoutY(300);
	    signUp.setStyle("-fx-background-color: transparent;");

	    /*Text or = new Text("or");
	    or.setLayoutX(scene.getWidth()/2);
	    or.setLayoutY(375);
	    or.setFont(Font.font ("Arial", 18));*/

	    signIn.setStyle("-fx-background-color: transparent;");
	    TextField userInputField = new TextField();
	    userInputField.setPromptText("username");
	    userInputField.setMinWidth(300);
	    userInputField.setMinHeight(40);
	    userInputField.setLayoutX(scene.getWidth()/2-150);
	    userInputField.setLayoutY(170);
	    userInputField.setStyle("-fx-focus-color: #e67e22");
	    userInputField.setFont(Font.font ("Arial", 16));
	    userInputField.setStyle( "-fx-shape: \"M170,0 H0 V30 H170 Z\";");
	    userInputField.setStyle("-fx-background-color: -fx-text-box-border, -fx-control-inner-background;");

	    PasswordField passwordInputField = new PasswordField();
	    passwordInputField.setPromptText("password");
	    passwordInputField.setMinWidth(300);
	    passwordInputField.setMinHeight(40);
	    passwordInputField.setLayoutX(scene.getWidth()/2-150);
	    passwordInputField.setLayoutY(240);
	    passwordInputField.setStyle("-fx-focus-color: #e67e22");
	    passwordInputField.setFont(Font.font ("Arial", 16));
	    passwordInputField.setStyle( "-fx-shape: \"M170,0 H0 V30 H170 Z\";");
	    passwordInputField.setStyle("-fx-background-color: -fx-text-box-border, -fx-control-inner-background;");
	    
	    Hyperlink link = new Hyperlink("https://www.google.com/");
	    


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
	    		//displaySignInPage(pane);

	    		sqlConnect(username,password,stage);


	    	}

			else {

			}
	    });

	    signUp.setOnMouseClicked(evt ->
	    {
	    	try {
				Desktop.getDesktop().browse(new URI("https://www.facebook.com/")); //INSERT MOUNTAINCLIMBER LINK HERE
			} catch (IOException | URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	//pane.getChildren().clear();
	    	//displaySignUpPage();
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
	    	    		sqlConnect(username, password, stage);
	    	    	}
	            }
	    });

	    pane.setStyle("-fx-background-color: #ecf0f1");
	    pane.getChildren().add(signIn);
	    pane.getChildren().add(signUp);
	    pane.getChildren().add(userInputField);
	    pane.getChildren().add(passwordInputField);
//	    pane.getChildren().add(or);
	    pane.getChildren().add(logoImage);


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

	public void displaySignInPage(Pane pane)
	{
		final WebView loadAnim = new WebView();
		final WebEngine webEngine = loadAnim.getEngine();
		File f = new File("C:\\Users\\Tyler\\Documents\\GitHub\\MountainClimber\\MountainClimber\\src\\mountainClimber\\cube.svg");
		webEngine.load(f.toURI().toString());


		loadAnim.setLayoutX(pane.getWidth()/2-40);
		loadAnim.setLayoutY(pane.getHeight()/2-40);

		loadAnim.setLayoutX(pane.getWidth()/2-40);
		loadAnim.setLayoutY(pane.getHeight()/2-40);
		pane.getChildren().add(loadAnim);
	}


	public void sqlConnect(String username, String password, Stage stage)
	{
		//#ECF0F1
		username = username.trim();
		password = password.trim();

		Image loading = new Image(getClass().getResourceAsStream("loading.gif"));
		ImageView loadingV = new ImageView(loading);
		loadingV.setFitHeight(125);
	    loadingV.setFitWidth(125);
	   	loadingV.setPreserveRatio(true);
		String sql = "SELECT * FROM mountain_users WHERE username= " + username + " AND password = " + password;
		//SQL Add Statement Confirmed INSERT INTO mountain_users (email,password) VALUES('2tylerericmanning@gmail.com', SHA1('test'));
		
		loadingV.setLayoutX(pane.getWidth()/2-64);
		loadingV.setLayoutY(pane.getHeight()/2-64);
		pane.getChildren().add(loadingV);
		
	}
}
