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
public class Ingredient {
	private int nr;
	private int cle;
	private String nom;
	private String unite;
	private int qte;

	/**
	 * Construit un ingredient a partir de la BDD avec le numero de recette et
	 * le cle de lingredient
	 * 
	 * @param nr
	 *            numero de la recette
	 * @param cle
	 */
	public Ingredient(int nr, int cle) {
		this.cle = cle;
		this.nr = nr;

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
			PreparedStatement stmt = connexion
					.prepareStatement("Select nom,qte,unite from ingredients where nr= ? and ningr= ?");
			stmt.setInt(1, nr);
			stmt.setInt(2, cle);
			ResultSet results = stmt.executeQuery();
			while (results.next()) {
				this.nom = results.getString(1);
				this.qte = results.getInt(2);
				this.unite = results.getString(3);
			}
		} catch (SQLException e) {
			System.out.println("Pas de connexion" + e.toString());
		}

	}

	/**
	 * Construit un nouvel ingredient et l'enregistre dans la BDD
	 * 
	 * @param nr
	 * @param nom
	 * @param qte
	 * @param unite
	 */
	public Ingredient(int nr, String nom, int qte, String unite) {
		this.nr = nr;
		this.nom = nom;
		this.unite = unite;
		this.qte = qte;

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
			String sel = "Select max(ningr) from ingredients where nr = " + nr;
			ResultSet results = stmt.executeQuery(sel);
			while (results.next()) {
				this.cle = results.getInt(1) + 1;
			}

			PreparedStatement injectingr = connexion
					.prepareStatement("Insert into ingredients(nr,ningr,nom,qte,unite) values (?,?,?,?,?)");
			injectingr.setInt(1, nr);
			injectingr.setInt(2, cle);
			injectingr.setString(3, nom);
			injectingr.setInt(4, qte);
			injectingr.setString(5, unite);
			injectingr.executeUpdate();
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
	 * @deprecated
	 * @param nr
	 * @param nom
	 * @param qte
	 */
	public Ingredient(int nr, String nom, int qte) {
		this.nr = nr;
		this.nom = nom;
		this.unite = null;
		this.qte = qte;

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
			String sel = "Select max(ningr) from ingredients where nr = " + cle;
			ResultSet results = stmt.executeQuery(sel);
			while (results.next()) {
				this.cle = results.getInt(1) + 1;
			}

			PreparedStatement injectingr = connexion
					.prepareStatement("Insert into ingredients(nr,ningr,nom,qte) values (?,?,?,?)");
			injectingr.setInt(1, nr);
			injectingr.setInt(2, cle);
			injectingr.setString(3, nom);
			injectingr.setInt(4, qte);
			injectingr.executeUpdate();
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
	 * @return nom de l'ingredient
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Changer le nom de l'ingredient
	 * 
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * 
	 * @return String nom de l'unite
	 */
	public String getUnite() {
		return unite;
	}

	/**
	 * 
	 * @param unite
	 */
	public void setUnite(String unite) {
		this.unite = unite;
	}

	/**
	 * 
	 * @return int quantite
	 */
	public int getQte() {
		return qte;
	}

	/**
	 * enregistre la quantite
	 * 
	 * @param qte
	 */
	public void setQte(int qte) {
		this.qte = qte;
	}

	public String toString() {
		if (unite == " " || unite == "" || unite == null) {
			return nom + " " + qte;
		} else {
			return nom + " " + qte + " " + unite;
		}
	}

	/**
	 * 
	 * @return Cle de l'ingredient
	 */
	public int getCle() {
		return cle;
	}

	/**
	 * supprime l'ingredient de la BDD
	 */
	public void deleteIt() {
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
			PreparedStatement inject = connexion
					.prepareStatement("delete from ingredients where nr = ? and ningr = ?");
			inject.setInt(1, this.nr);
			inject.setInt(2, this.cle);
			inject.executeUpdate();
			if (connexion != null) {
				connexion.close();
			}

		} catch (SQLException e) {
			System.out.println("Pas de connexion" + e.toString());
		}

	}
}
