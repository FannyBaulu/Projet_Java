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

	public boolean checkRegister() {

		if (!TFmail.getText().equals("") && !TFusernamer.getText().equals("") && !TFpasswordr.getText().equals("")) {
			ResultSet test = Database.getInstance().query("SELECT * FROM utilisateur");
			try {
				while (test.next()) {
					System.out.println(TFusernamer.getText());
					System.out.println(test.getString(2));
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

	public void LogIn() throws IOException {
		App.setRoot("LogIn");
	}

}
