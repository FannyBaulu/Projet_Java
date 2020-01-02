package net.ProjetJava;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Update {
	
	@FXML
	private TextField username;
	@FXML
	private TextField email;
	@FXML
	private TextField psw;
	@FXML
	private TextField newpsw;
	@FXML
	private Button update;
	@FXML
	private Button login;
	@FXML
	private Label status;

	public void login () throws IOException{
		App.setRoot("LogIn");
		}
	
	public boolean checkRegister() {

		if (!email.getText().equals("") && !username.getText().equals("") && !psw.getText().equals("")) {
			ResultSet test = Database.getInstance().query("SELECT * FROM utilisateur");
			try {
				while (test.next()) {
					System.out.println("Utilisateur ecrit:"+username.getText());
					System.out.println("Utilisateur BDD:"+test.getString(2));
					System.out.println("Mail BDD: "+test.getString(4));
					System.out.println("Mail ecrit : "+email.getText());
					System.out.println("Psw BDD:" +test.getString(3));
					System.out.println("Psw ecrit:" + psw.getText());
					if (test.getString(2).equals(username.getText()) && test.getString(4).equals(email.getText()) && test.getString(3).equals(psw.getText())) {
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
	
	public void launchUpdate() {
		
		if (checkRegister()==true&& psw.getText()!=newpsw.getText())
		{
			Database.getInstance().updateUser(newpsw.getText(),username.getText());
			status.setText("Account updated");
		}
		else {
			status.setText("Password already exist or this account doesn't exist");
		}
		
	}
}
