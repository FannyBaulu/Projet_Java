package net.ProjetJava;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Register {
	@FXML
	private Label lblusernamer;
	@FXML
	private Label lblmail;
	@FXML
	private Label lblpasswordr;
	@FXML
	private TextField TFusernamer;
	@FXML
	private TextField TFmail;
	@FXML
	private TextField TFpasswordr;
	@FXML
	private Label lblstatusr;
	@FXML
	private Button loginr;
	@FXML
	private Button create;

	/**
	 * Check if the informations typed by the user already exist into the database.
	 * 
	 * @return false if it does.
	 */
	public boolean checkRegister() {

		if (!TFmail.getText().equals("") && !TFusernamer.getText().equals("") && !TFpasswordr.getText().equals("")) {
			ResultSet test = Database.getInstance().query("SELECT * FROM utilisateur");
			try {
				while (test.next()) {
					if (test.getString(2).equals(TFusernamer.getText()) || test.getString(4).equals(TFmail.getText())) {
						return false;
					}
				}
				return true;

			} catch (SQLException e) {
				return false;
			}
		}
		return false;
	}

	/**
	 * If the informations typed by the user doesn't exist into the database, this
	 * method insert them into it. If not, inform the user of the registration
	 * failure.
	 * 
	 * @param event
	 * @throws IOException
	 */
	public void Register(ActionEvent event) throws IOException {

		Boolean test = checkRegister();
		System.out.println(test);
		if (test == true) {
			Database.getInstance().insertUser(TFmail.getText(), TFusernamer.getText(), TFpasswordr.getText());
			lblstatusr.setText("Account created");
		} else {
			lblstatusr.setText("Failed to create account");
		}
	}

	/**
	 * Set the root to the Login page.
	 * 
	 * @throws IOException
	 */
	public void LogIn() throws IOException {
		App.setRoot("LogIn");
	}

}
