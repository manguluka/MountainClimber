package stoqscreen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

	public static void main(String[] args) {
		launch(args);
		
	}

	@Override
	public void start(Stage stage) throws Exception {
		StackPane pane = new StackPane();
		Scene scene = new Scene(pane, 400, 500);
		stage.setTitle("stoqscreen Sign In");
		stage.setScene(scene); // Place the scene in the stage
	    stage.show(); // Display the stage
	}

}
