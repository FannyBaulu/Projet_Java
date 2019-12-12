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
private Label create;

public boolean checkLogin() {

	if (!TFusername.getText().equals("") && !TFpassword.getText().equals("")) {
		ResultSet test = Database.getInstance().query("SELECT * FROM utilisateur WHERE UtilisateurNom = '"+TFusername.getText()+"'");
		try {
			while (test.next()) {
				if (test.getString(3).equals(TFpassword.getText())) {
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


public void Login (ActionEvent event) throws IOException {
	Boolean test = checkLogin();
	if (test == true) {
		lblstatus.setText("Login Success");
		App.setRoot("EquipSel");
	}
	else {
		lblstatus.setText("Login Failed");
	}
}
public void createacc () throws IOException
{
	  App.setRoot("Register");
}
}

