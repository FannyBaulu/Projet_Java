package net.ProjetJava;

import java.io.IOException;
import java.sql.ResultSet;

import java.sql.SQLException;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.Node;
import javafx.scene.control.*;

public class EquipSel {
	@FXML
	private Button confirmer;
	@FXML
	private TilePane tp;

	private int idequipements;

	/**
	 * Set the list of equipments from the database into the FXML.
	 */
	public void initialize() {
		try {
			ResultSet test = Database.getInstance().query("SELECT idequipements,name,images FROM equipements");
			while (test.next()) {
				int id = test.getInt("idequipements");
				String name = test.getString("name");
				String url = test.getString("images");
				Equipement e = new Equipement(id, name, url);
				e.setTextFill(Color.web("#FFFFFF"));
				tp.getChildren().add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Check into the database if the equipement selected already is linked to the
	 * user.
	 * 
	 * @return
	 * @throws SQLException
	 */
	public boolean checkBDD() throws SQLException {

		int idUti = LogIn.id;
		ResultSet Check = Database.getInstance().query("SELECT * FROM utilisateur_equipements WHERE idUtilisateur = '"
				+ idUti + "' AND idEquipement = '" + this.idequipements + "'");

		return !Check.next();
	}

	/**
	 * Analyze which equipements has been selected and if it isn't linked to the
	 * user into the database, it will insert it into it. Then it sets the root to
	 * the "ChoixGear" page.
	 * 
	 * @throws SQLException
	 * @throws IOException
	 */
	public void confirmer() throws SQLException, IOException {
		Equipement c = null;
		int idUti = LogIn.id;
		ObservableList<Node> list = tp.getChildren();
		for (int i = 0; i < list.size(); i++) {
			c = (Equipement) list.get(i);
			idequipements = c.getIdEquipements();
			if (c.isSelected() == true && checkBDD()) {
				Database.getInstance().insertEquip(idUti, idequipements);
			}
		}
		App.setRoot("ChoixGear");

	}

}
