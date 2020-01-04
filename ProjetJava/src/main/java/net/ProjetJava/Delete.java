package net.ProjetJava;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Delete {

	@FXML
	private TextField username;
	@FXML
	private TextField password;
	@FXML
	private TextField mail;
	@FXML
	private Button delete;
	@FXML
	private Button home;
	@FXML
	private Label status;

	/**
	 * Look into the database to check the existence of the user
	 * 
	 * @return true if exists
	 */
	public boolean checkLogin() {

		if (!username.getText().equals("") && !password.getText().equals("") && !mail.getText().equals("")) {
			ResultSet test = Database.getInstance()
					.query("SELECT * FROM utilisateur WHERE UtilisateurNom = '" + username.getText() + "'");
			try {
				while (test.next()) {
					if (test.getString(3).equals(password.getText()) && test.getString(4).equals(mail.getText())) {
						return true;
					}
				}
				return false;

			} catch (SQLException e) {
				return false;
			}
		}
		return false;
	}

	/**
	 * If the user is in the database, this method will delete it's information.
	 * 
	 * @param event
	 * @throws IOException
	 */
	public void delete(ActionEvent event) throws IOException {
		Boolean test = checkLogin();
		if (test == true) {
			Database.getInstance().deleteUser(username.getText());
			status.setText("Delete Success");
		} else {
			status.setText("Delete Failed");
		}
	}

	/**
	 * Set the current to the LogIn page.
	 * 
	 * @throws IOException
	 */
	public void home() throws IOException {
		App.setRoot("LogIn");
	}

}
