package mountainClimber;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainPage{

	public MainPage(Stage stage)
	{
		Pane pane = new Pane();
		Scene scene = new Scene(pane, 325, 400);
		
		pane.getChildren().add(pane);
	}
}
