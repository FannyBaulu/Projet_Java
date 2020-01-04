package net.ProjetJava;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class LogIn {
	@FXML
	private Label lblusername;
	@FXML
	private Label lblpassword;
	@FXML
	private TextField TFusername;
	@FXML
	private TextField TFpassword;
	@FXML
	private Label lblstatus;
	@FXML
	private Button login;
	@FXML
	private Button update;
	@FXML
	private Label create;
	@FXML
	private Button delete;

	public static int id;

	/**
	 * Check into the database if the info typed by the user exists into the
	 * database.
	 * 
	 * @return true
	 */
	public boolean checkLogin() {
		this.id = 0;
		if (!TFusername.getText().equals("") && !TFpassword.getText().equals("")) {
			ResultSet test = Database.getInstance()
					.query("SELECT * FROM utilisateur WHERE UtilisateurNom = '" + TFusername.getText() + "'");
			try {
				while (test.next()) {
					if (test.getString(3).equals(TFpassword.getText())) {
						this.id = test.getInt(1);
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
	 * if the user exists, set the root to the "EquipSel" page. If it doesn't, it
	 * warn the user of the login failure.
	 * 
	 * @param event
	 * @throws IOException
	 */
	public void Login(ActionEvent event) throws IOException {
		Boolean test = checkLogin();
		if (test == true) {
			lblstatus.setText("Login Success");
			App.setRoot("EquipSel");
		} else {
			lblstatus.setText("Login Failed");
		}
	}

	/**
	 * Set the root to the register page.
	 * 
	 * @throws IOException
	 */
	public void createacc() throws IOException {
		App.setRoot("Register");
	}

	/**
	 * Set the root to the update page.
	 * 
	 * @throws IOException
	 */
	public void goUp() throws IOException {
		App.setRoot("Update");
	}

	/**
	 * Set the root to the delete page.
	 * 
	 * @throws IOException
	 */
	public void goDel() throws IOException {
		App.setRoot("Delete");
	}

	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		LogIn.id = id;
	}
}
