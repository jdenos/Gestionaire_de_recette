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
public class Categorie {
	private int cle;
	private String souscat;
	private boolean sale;

	// import de la gestion sql

	/**
	 * Construit une nouvelle Categorie en genere automatiquement la clef et
	 * enregistre dans la BDD mySQL
	 * 
	 * @param sale
	 *            true si la categorie est sale false si sucre
	 * @param souscat
	 *            nom de la sous-categorie
	 */
	public Categorie(boolean sale, String souscat) {
		this.sale = sale;
		this.souscat = souscat;

		// generer une cle a partir de la DB
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
			String sel = "Select max(nc) from categories";
			ResultSet results = stmt.executeQuery(sel);
			while (results.next()) {
				this.cle = results.getInt(1) + 1;
			}
			PreparedStatement injectcat = connexion
					.prepareStatement("Insert into categories(nc,sale,nomcat) values (?,?,?)");
			injectcat.setInt(1, this.cle);
			if (this.sale) {
				injectcat.setInt(2, 1);
			} else {
				injectcat.setInt(2, 0);
			}
			injectcat.setString(3, this.souscat);
			injectcat.executeUpdate();
			// fermeture de la connexion
			if (connexion != null) {
				connexion.close();
			}
		} catch (SQLException e) {
			System.out.println("Pas de connexion" + e.toString());
		}

	}

	/**
	 * Creer une categorie a partir des informations de la BDD
	 * 
	 * @param cle
	 *            nc dans la BDD
	 */
	public Categorie(int cle) {
		/* Connexion à la base de données */
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
			String sel = "Select sale,nomcat from categories where nc= " + cle;
			ResultSet results = stmt.executeQuery(sel);
			while (results.next()) {
				if (results.getInt(1) == 0) {
					this.sale = false;
				} else {
					this.sale = true;
				}

				this.souscat = results.getString(2);
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
	 * la categorie est elle sale ?
	 * 
	 * @return Boolean
	 */
	public boolean getSale() {
		return sale;
	}

	/**
	 * rendre la categorie sale ou sucre
	 * 
	 * @param sale
	 *            Boolean
	 */
	public void setSale(boolean sale) {
		this.sale = sale;
	}

	/**
	 * 
	 * @return String nom de la sous-cat
	 */
	public String getSouscat() {
		return souscat;
	}

	/**
	 * changer le nom de la sous-categorie
	 * 
	 * @param souscat
	 *            nouveau nom
	 */
	public void setSouscat(String souscat) {
		this.souscat = souscat;
	}

	public String toString() {
		return souscat;
	}

	/**
	 * renvoi la cle de la BDD
	 * 
	 * @return int
	 */
	public int getCle() {
		return cle;
	}
	/**
	 * update la base de donnees avec les nouvelles data
	 */
	public void bddUpdate(){

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
					.prepareStatement("update table categories set sale = ?, nomcat = ?  where nc = ?");
			up.setString(2, this.souscat);
			up.setInt(3, cle);
			if (this.sale == false){
				up.setInt(1, 0);
			}
			else{
				up.setInt(1, 1);
			}
			up.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Pas de connexion" + e.toString());
		}

	}
	
}
