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

	public void initialize() {
		try {
			ResultSet test = Database.getInstance().query("SELECT idequipements,name,images FROM equipements");
			while (test.next()) {
				int id = test.getInt("idequipements");
				String name = test.getString("name");
				String url = test.getString("images");
				// System.out.println("ID:"+id+"\nName:"+name+"\nURL:"+url);
				Equipement e = new Equipement(id, name, url);
				e.setTextFill(Color.web("#FFFFFF"));
				tp.getChildren().add(e);

				// c. EQUIVALENT SET CHILDREN
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
//	public void confirmer() throws SQLException {
//		Equipement c = null;
//		int idequipements = 0;
//		int idUti = LogIn.id;
//		Boolean nouveau = false;
//		
//		
//		// System.out.println("IDUTI"+idUti);
//		ObservableList<Node> list = tp.getChildren();
//		// System.out.println("ok confirmer"+list.size());
//		for (int i = 0; i < list.size(); i++) {
//			// System.out.println(list.get(i));
//			ResultSet EqJoueur = Database.getInstance().query("SELECT * FROM utilisateur_equipements WHERE idUtilisateur = '" + idUti + "'");
//			while(EqJoueur.next()) {
//				System.out.println("EqJoueur/equuipements:"+EqJoueur.getInt("idEquipement"));
//				System.out.println("EqJoueur/utilisateur:"+EqJoueur.getInt("idUtilisateur"));
//			}
//			Boolean equipementadd = true;
//			c = (Equipement) list.get(i);
//		    System.out.println("Equipement"+c);
//			idequipements = c.getIdEquipements();
//			
//			try {
//				if(EqJoueur.next() == false && i == 0 ||  nouveau == true)
//				{
//					    nouveau = true;
//					if (c.isSelected() == true) {
//						Database.getInstance().insertEquip(idUti, idequipements);
//						System.out.println("ajouter");
//					}
//				}
//				else {
//					
//					while (EqJoueur.next()) {
//						System.out.println(EqJoueur.getInt(2));
//						if (EqJoueur.getInt(2) == idequipements) {
//							equipementadd = false;
//						}
//					}
//					if(equipementadd == true)
//					{
//						if (c.isSelected() == true) {
//							equipementadd = true;
//							Database.getInstance().insertEquip(idUti, idequipements);
//							System.out.println("ajouter");
//						}
//					}
//				}
//			} catch (SQLException e) {
//					System.out.println("crash");
//			}
	//	}

//	}
	public boolean checkBDD () throws SQLException {
		
		int idUti = LogIn.id;
		ResultSet Check = Database.getInstance().query("SELECT * FROM utilisateur_equipements WHERE idUtilisateur = '"+idUti+"' AND idEquipement = '"+this.idequipements+"'");
	
		return !Check.next();
	}
	public void confirmer() throws SQLException, IOException
	{
			Equipement c = null;
			int idUti = LogIn.id;
		//	System.out.println("IDUTI"+idUti);
			ObservableList<Node> list = tp.getChildren();
		//	System.out.println("ok confirmer"+list.size());
			for(int i=0;i<list.size();i++) {
				//System.out.println("LIST:"+list.get(i));
				c = (Equipement) list.get(i);
			//	System.out.println("C:"+c);
				idequipements = c.getIdEquipements();
			//	System.out.println("idEquipements"+idequipements);
				if (c.isSelected() == true && checkBDD()) {
					//System.out.println("Entre if isselected");
					Database.getInstance().insertEquip(idUti, idequipements);
				}
			}
			App.setRoot("ChoixGear");
			
	}


}
