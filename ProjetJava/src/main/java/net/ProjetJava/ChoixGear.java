package net.ProjetJava;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ChoixGear {
	@FXML
	private RadioButton Ranged_ATK;
	@FXML
	private RadioButton Cavalry_ATK;
	@FXML
	private RadioButton Infantry_ATK;
	@FXML
	private RadioButton Research_Speed;
	@FXML
	private RadioButton Construction_Speed;
	@FXML
	private RadioButton Gathering_Speed;
	@FXML
	private RadioButton Food_Production_Increase;
	@FXML
	private RadioButton Stone_Production_Increase;
	@FXML
	private RadioButton Ore_Production_Increase;
	@FXML
	private RadioButton Timber_Production_Increase;
	@FXML
	private RadioButton Gold_Production_Increase;
	@FXML
	private Button search;

	@FXML
	private ImageView Acc;
	@FXML
	private ImageView body;
	@FXML
	private ImageView Acc2;
	@FXML
	private ImageView helm;
	@FXML
	private ImageView Acc3;
	@FXML
	private ImageView foot;
	@FXML
	private ImageView mainH;
	@FXML
	private ImageView offH;
	
	@FXML
	private Label home;
	
	


	public void allBoosts() {
		// Requete SQL Additionne BOOSTS de Selection et affiche
	}

	public void popUpBoosts() {
		// recup : Boost 1,2..et Pourcentage 1,2...et Afficher par Equipement Sel
	}

	public void rechercheEquipement(RadioButton radio) throws SQLException {
		
		String name = radio.getId();
		ResultSet accessoire = Database.getInstance()
				.query("SELECT Images FROM bddlords.boost AS B JOIN bddlords.utilisateur_equipements AS UE"
						+ " ON UE.idEquipement = B.idequipement WHERE UE.idUtilisateur = '1'"
						+ " AND B.type = 'Accessories' Order by B." + name + " DESC LIMIT 1");
		// affichage dans image view
		accessoire.next();
		Image acc = new Image(getClass().getResourceAsStream("images"+accessoire.getString("Images")));
		Acc.setImage(acc);
		Acc2.setImage(acc);
		Acc3.setImage(acc);
		ResultSet bodyArmor = Database.getInstance()
				.query("SELECT Images FROM bddlords.boost AS B\r\n" + "JOIN bddlords.utilisateur_equipements AS UE\r\n"
						+ "ON UE.idEquipement = B.idequipement\r\n" + "WHERE UE.idUtilisateur = '1'\r\n"
						+ "AND B.type = 'Body Armor'\r\n" + "Order by B." + name + " DESC LIMIT 1");
		bodyArmor.next();
		
		Image bodya = new Image(getClass().getResourceAsStream("images"+bodyArmor.getString("Images")));
		
		body.setImage(bodya);
		ResultSet helmets = Database.getInstance()
				.query("SELECT Images FROM bddlords.boost AS B\r\n" + "JOIN bddlords.utilisateur_equipements AS UE\r\n"
						+ "ON UE.idEquipement = B.idequipement\r\n" + "WHERE UE.idUtilisateur = '1'\r\n"
						+ "AND B.type = 'Helmets'\r\n" + "Order by B." + name + " DESC LIMIT 1");
		helmets.next();
		Image helmetsI = new Image(getClass().getResourceAsStream("images"+helmets.getString("Images")));
		helm.setImage(helmetsI);
		ResultSet footwear = Database.getInstance()
				.query("SELECT Images FROM bddlords.boost AS B\r\n" + "JOIN bddlords.utilisateur_equipements AS UE\r\n"
						+ "ON UE.idEquipement = B.idequipement\r\n" + "WHERE UE.idUtilisateur = '1'\r\n"
						+ "AND B.type = 'Footwear'\r\n" + "Order by B." + name + " DESC LIMIT 1");
		footwear.next();
		Image footW = new Image(getClass().getResourceAsStream("images"+footwear.getString("Images")));
		foot.setImage(footW);
		ResultSet mainhand = Database.getInstance()
				.query("SELECT Images FROM bddlords.boost AS B\r\n" + "JOIN bddlords.utilisateur_equipements AS UE\r\n"
						+ "ON UE.idEquipement = B.idequipement\r\n" + "WHERE UE.idUtilisateur = '1'\r\n"
						+ "AND B.type = 'Main-Hand'\r\n" + "Order by B." + name + " DESC LIMIT 1");
		mainhand.next();
		Image mainHand = new Image(getClass().getResourceAsStream("images"+mainhand.getString("Images")));
		mainH.setImage(mainHand);
		ResultSet offHand = Database.getInstance()
				.query("SELECT Images FROM bddlords.boost AS B\r\n" + "JOIN bddlords.utilisateur_equipements AS UE\r\n"
						+ "ON UE.idEquipement = B.idequipement\r\n" + "WHERE UE.idUtilisateur = '1'\r\n"
						+ "AND B.type = 'Off-Hand'\r\n" + "Order by B." + name + " DESC LIMIT 1");
		offHand.next();
		Image offhand = new Image(getClass().getResourceAsStream("images"+offHand.getString("Images")));
		offH.setImage(offhand);

	}

	public void search() throws SQLException {

		if (Ranged_ATK.isSelected()) {
			rechercheEquipement(Ranged_ATK);
		} else if (Cavalry_ATK.isSelected()) {
			rechercheEquipement(Cavalry_ATK);
		} else if (Infantry_ATK.isSelected()) {
			rechercheEquipement(Infantry_ATK);
		} else if (Research_Speed.isSelected()) {
			rechercheEquipement(Research_Speed);
		} else if (Construction_Speed.isSelected()) {
			rechercheEquipement(Construction_Speed);
		} else if (Gathering_Speed.isSelected()) {
			rechercheEquipement(Gathering_Speed);
		} else if (Food_Production_Increase.isSelected()) {
			rechercheEquipement(Food_Production_Increase);
		} else if (Stone_Production_Increase.isSelected()) {
			rechercheEquipement(Stone_Production_Increase);
		} else if (Ore_Production_Increase.isSelected()) {
			rechercheEquipement(Ore_Production_Increase);
		} else if (Timber_Production_Increase.isSelected()) {
			rechercheEquipement(Timber_Production_Increase);
		} else if (Gold_Production_Increase.isSelected()) {
			rechercheEquipement(Gold_Production_Increase);
		}

		// Fonction de lancement de selection, comprends la requete SQL
	}
	
	public void home() throws IOException {
		App.setRoot("LogIn");
	}

}
