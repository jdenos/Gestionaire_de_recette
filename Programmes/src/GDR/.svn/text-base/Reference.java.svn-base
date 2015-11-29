package GDR;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author julien
 * 
 */
public class Reference {

	private int cle;
	private String nom;

	/**
	 * construit une nouvelle reference et l'enregistre dans la BDD
	 * 
	 * @param nom
	 */
	public Reference(String nom) {
		this.nom = nom;
		// generation de la cle avec max dans DB
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("ERREUR : " + e.toString());
		}

		String url = "jdbc:mysql://localhost:3306/GDR";
		String utilisateur = "javalink";
		String motDePasse = "javalink";
		Connection connexion = null;
		try {
			connexion = DriverManager.getConnection(url, utilisateur,
					motDePasse);
			Statement stmt = connexion.createStatement();
			String sel = "Select max(nref) from ref";
			ResultSet results = stmt.executeQuery(sel);
			while (results.next()) {
				this.cle = results.getInt(1) + 1;
			}
			PreparedStatement injectref = connexion
					.prepareStatement("Insert into ref(nref,nom) values (?,?)");
			injectref.setInt(1, this.cle);
			injectref.setString(2, this.nom);
			injectref.executeUpdate();
			// fermeture de la connexion
			if (connexion != null) {
				connexion.close();
			}
		} catch (SQLException e) {
			System.out.println("Pas de connexion" + e.toString());
		}

	}

	/**
	 * lit la reference dans la BDD et la construit
	 * 
	 * @param cle
	 */
	public Reference(int cle) {
		this.cle = cle;

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("ERREUR : " + e.toString());
		}

		String url = "jdbc:mysql://localhost:3306/GDR";
		String utilisateur = "javalink";
		String motDePasse = "javalink";
		Connection connexion = null;
		try {
			connexion = DriverManager.getConnection(url, utilisateur,
					motDePasse);
			Statement stmt = connexion.createStatement();
			String sel = "Select nom from ref where nref= " + cle;
			ResultSet results = stmt.executeQuery(sel);
			while (results.next()) {
				this.nom = results.getString(1);
			}
			// fermeture de la connexion
			if (connexion != null) {
				connexion.close();
			}
		} catch (SQLException e) {
			System.out.println("Pas de connexion" + e.toString());
		}

	}

	/**
	 * 
	 * @return String nom de la reference
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * change le nom
	 * 
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	public String toString() {
		return nom;
	}

	/**
	 * 
	 * @return cle
	 */
	public int getCle() {
		return cle;
	}

	/**
	 * met a jour la BDD
	 */
	public void bddUpdate() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("ERREUR : " + e.toString());
		}

		String url = "jdbc:mysql://localhost:3306/GDR";
		String utilisateur = "javalink";
		String motDePasse = "javalink";
		Connection connexion = null;
		try {
			connexion = DriverManager.getConnection(url, utilisateur,
					motDePasse);
			PreparedStatement up = connexion
					.prepareStatement("update table ref set nom = ? where nref = ?");
			up.setString(1, this.nom);
			up.setInt(2, cle);
			up.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Pas de connexion" + e.toString());
		}

	}
}
