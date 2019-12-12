package net.ProjetJava;

import java.io.IOException;
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



public void Login (ActionEvent event) throws IOException {
	if (TFusername.getText().equals("user")&& TFpassword.getText().contentEquals("pass")) {
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

