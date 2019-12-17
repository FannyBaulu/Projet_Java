package net.ProjetJava;

import java.io.File;
import java.sql.ResultSet;

import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.TilePane;

public class Equipement extends CheckBox{
	

	
		private int idequipements;
		private String name;
		private String url;
		public ImageView test;
		public Image test2;
		
		public Equipement (int idequipements,String name,String url)
		{
			this.idequipements = idequipements;
			this.name = name;
			this.url = url;
			//SET Images
			File file = new File("images"+url);
			test2 = new Image(file.toURI().toString());
			test = new ImageView(test2);
			test.setFitHeight(37);
			test.setFitWidth(35);
			this.setGraphic(test);
			this.setText(name);
			
//			this.setPrefWidth(value);
		}
		public Boolean test ()
		{
			ResultSet test = Database.getInstance().query("SELECT * FROM boost");
			
			return false;
		}

		
		
		
		
		public int getIdEquipements() {
			return idequipements;
		}
		public void setIdEquipements(int idequipements) {
			this.idequipements = idequipements;
		}
		public String getNom() {
			return name;
		}
		public void setNom(String name) {
			this.name = name;
		}
		public String getImage() {
			return url;
		}
		public void setImage(String url) {
			this.url = url;
		}
	}

