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



public boolean checkLogin() {

	this.id=0;
	if (!TFusername.getText().equals("") && !TFpassword.getText().equals("")) {
		ResultSet test = Database.getInstance().query("SELECT * FROM utilisateur WHERE UtilisateurNom = '"+TFusername.getText()+"'");
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

public void goUp() throws IOException{
	App.setRoot("Update");
}
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

