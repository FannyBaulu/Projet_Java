package net.ProjetJava;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




/**
 * @author fanny
 *
 */
public class Database {
	static private Database instance;
	// MySQL Connection
	private Connection cnx;

	// PrepareStatement for todo insertion
	private PreparedStatement insertStatement;
	private PreparedStatement insertStatement2;

	// PrepareUpdate
	private PreparedStatement updateStatement;
	private PreparedStatement safeupstatement;
	
	private PreparedStatement deleteStatement;

	private Database() {

		String url = "jdbc:mysql://localhost/bddlords?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String user = "root";
		String passwd = "BakaKuroNia35";
		try {
			cnx = DriverManager.getConnection(url, user, passwd);
			System.out.println("Connexion effective !");
			insertStatement = cnx.prepareStatement(
					"INSERT INTO utilisateur (UtilisateurNom,motdepasse,Mail) VALUES(?,?,?)",
					Statement.RETURN_GENERATED_KEYS // Avoid double id
					);
			insertStatement2 = cnx.prepareStatement(
					"INSERT INTO utilisateur_equipements (idUtilisateur,idEquipement) VALUES(?,?)"
					
					);
			
			safeupstatement = cnx.prepareStatement(
					"SET SQL_SAFE_UPDATES = 0");
			updateStatement = cnx.prepareStatement(	
					
					"UPDATE utilisateur SET motdepasse = ? WHERE UtilisateurNom=?"
					);
			deleteStatement = cnx.prepareStatement(
					"DELETE FROM utilisateur WHERE UtilisateurNom= ?"
					);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static Database getInstance() {
		if(instance!=null) {
			return instance;
		}
		instance = new Database();
		return instance;
	}

	
	public ResultSet query(String queryString) {
		Statement stm;
		ResultSet res = null;
		try {
			stm = cnx.createStatement();
			res = stm.executeQuery(queryString);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
		
	}

	
	 /**
	  * Allows to insert Username's Info into Database.
	 * @param UtilisateurNom
	 */
	public void insertUser(String UtilisateurNom,String motdepasse, String Mail) {
		try {
			insertStatement.setString(3, UtilisateurNom);
			insertStatement.setString(1, motdepasse);
			insertStatement.setString(2, Mail);
			int inserted = insertStatement.executeUpdate();
			ResultSet res = insertStatement.getGeneratedKeys();
			if (res.next() && inserted>0) {
				var lastID = res.getInt(1);
				// 
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void insertEquip (int idUtilisateur, int idEquipement) {
		try {
			
			insertStatement2.setInt(1, idUtilisateur);
			insertStatement2.setInt(2, idEquipement);
			int inserted = insertStatement2.executeUpdate();
			System.out.println("INSERTED:"+inserted);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	
	 
	 public void updateUser( String motdepasse, String UtilisateurNom) {
			try {
				safeupstatement.execute();
				updateStatement.setString(1, motdepasse);
				updateStatement.setString(2,UtilisateurNom);
				updateStatement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	 
	 public void deleteUser (String UtilisateurNom)
	 {
		 try {
			safeupstatement.execute();
			deleteStatement.setString(1, UtilisateurNom);
			deleteStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	 }
	
}
