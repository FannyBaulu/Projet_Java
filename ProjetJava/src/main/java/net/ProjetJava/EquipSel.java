package net.ProjetJava;

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
	
//	public void selection() throws SQLException {
//		ResultSet test = Database.getInstance().query("SELECT idequipements,name,images FROM equipements");
//		while(test.next())
//		{
//			int id = test.getInt("idequipements");
//			String name = test.getString("name");
//			String url = test.getString("images");
//			System.out.println("ID:"+id+"\nName:"+name+"\nURL:"+url);
//			Equipement e = new Equipement (id,name,url);
//			tp.getChildren().add(e);
//			//c.  EQUIVALENT SET CHILDREN
//		}
//		// recup CheckBox's TODO
//		// Ajouter Jointure TODO
//		
//		
//	}
	public void initialize()
	{
		try {
			ResultSet test = Database.getInstance().query("SELECT idequipements,name,images FROM equipements");
			while(test.next())
			{
				int id = test.getInt("idequipements");
				String name = test.getString("name");
				String url = test.getString("images");
				//System.out.println("ID:"+id+"\nName:"+name+"\nURL:"+url);
				Equipement e = new Equipement (id,name,url);
				e.setTextFill(Color.web("#FFFFFF"));
				tp.getChildren().add(e);
				
				//c.  EQUIVALENT SET CHILDREN
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void confirmer()
	{
			Equipement c = null;
			int idequipements = 0;
			int idUti = LogIn.id;
			System.out.println("IDUTI"+idUti);
			ObservableList<Node> list = tp.getChildren();
			System.out.println("ok confirmer"+list.size());
			for(int i=0;i<list.size();i++) {
				System.out.println(list.get(i));
				c = (Equipement) list.get(i);
				System.out.println(c);
				idequipements = c.getIdEquipements();
				System.out.println(idequipements);
			}
			if (c.isSelected() == true) {
				Database.getInstance().insertEquip(idUti, idequipements);
			}
	}
	
	
}
