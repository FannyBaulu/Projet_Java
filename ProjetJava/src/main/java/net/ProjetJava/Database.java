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
					"INSERT INTO utilisateur_equipements (idUtilisateur,idEquipements) VALIES(?,?)"
					
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
			ResultSet res = insertStatement2.getGeneratedKeys();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
 
	 
//	 public void updateUser(ToDo todo) {
//			try {
//				updateStatement.setString(1, todo.getTask());
//				updateStatement.setInt(2, todo.getId());
//				updateStatement.executeUpdate();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
}
