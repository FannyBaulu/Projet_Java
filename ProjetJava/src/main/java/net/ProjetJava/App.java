package net.ProjetJava;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

/**
 * JavaFX App
 */
public class App extends Application {

	private static Scene scene;

	@Override
	/**
	 * Set the stage into the Login FXML.
	 */
	public void start(Stage stage) throws IOException {

		scene = new Scene(loadFXML("LogIn"));
		stage.setScene(scene);
		stage.show();
	}

	/**
	 * Set the scene root into the login page.
	 * 
	 * @param fxml
	 * @throws IOException
	 */
	static void setRoot(String fxml) throws IOException {
		scene.setRoot(loadFXML(fxml));
	}

	/**
	 * Load the Login FXML.
	 * 
	 * @param fxml
	 * @return
	 * @throws IOException
	 */
	private static Parent loadFXML(String fxml) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
		return fxmlLoader.load();
	}

	public static void main(String[] args) {
		launch();
	}

}