package GDR;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * 
 * @author julien
 * 
 */
public class Recette {
	private String nom;
	private Reference ref;
	private Categorie cat;
	private String instructions;
	private int cle;
	private HashMap<Integer, Ingredient> ingredients = new HashMap<>();
	private HashMap<Integer, Preparation> preparations = new HashMap<>();

	/**
	 * construit une nouvelle reference a moitie vide
	 * 
	 * @param cat
	 * @param ref
	 */
	public Recette(Categorie cat, Reference ref) {
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
			String sel = "Select max(nr) from recettes";
			ResultSet results = stmt.executeQuery(sel);
			while (results.next()) {
				this.cle = results.getInt(1) + 1;
			}
		} catch (SQLException e) {
			System.out.println("Pas de connexion" + e.toString());
		}
		this.nom = "En cours d'edition";
		this.cat = cat;
		this.ref = ref;

	}

	/**
	 * Construit une recette et enregistre dans la BDD
	 * 
	 * @param nom
	 * @param ref
	 * @param cat
	 * @param instr
	 */
	public Recette(String nom, Reference ref, Categorie cat, String instr) {
		this.nom = nom;
		this.ref = ref;
		this.cat = cat;
		this.instructions = instr;

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
			String sel = "Select max(nr) from recettes";
			ResultSet results = stmt.executeQuery(sel);
			while (results.next()) {
				this.cle = results.getInt(1) + 1;
			}
			PreparedStatement inject = connexion
					.prepareStatement("Insert into recettes(nr,nom,nref,nc,instructions) values (?,?,?,?,?)");
			inject.setInt(1, this.cle);
			inject.setString(2, nom);
			inject.setInt(3, ref.getCle());
			inject.setInt(4, cat.getCle());
			inject.setString(5, instructions);
			inject.executeUpdate();
			// fermeture de la connexion
			if (connexion != null) {
				connexion.close();
			}
		} catch (SQLException e) {
			System.out.println("Pas de connexion" + e.toString());
		}

	}

	/**
	 * Lit une recette dans la BDD
	 * 
	 * @param cle
	 * @param refsMap
	 *            une Map des references disponibles liant leur cle a l'objet
	 * @param catsMap
	 *            une Map des Categories disponibles liant leur cle a l'objet
	 */
	public Recette(int cle, HashMap<Integer, Reference> refsMap,
			HashMap<Integer, Categorie> catsMap) {
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
			String sel = "Select nom,nref,nc,instructions from recettes where nr= "
					+ cle;
			ResultSet results = stmt.executeQuery(sel);
			while (results.next()) {
				this.nom = results.getString(1);
				this.ref = refsMap.get(results.getInt(2));
				this.cat = catsMap.get(results.getInt(3));
				this.instructions = results.getString(4);
			}
			Statement stmt2 = connexion.createStatement();
			String sel2 = "Select ningr from ingredients where nr= " + cle;
			ResultSet results2 = stmt2.executeQuery(sel2);
			while (results2.next()) {
				Ingredient ingr = new Ingredient(cle, results2.getInt(1));
				ingredients.put(ingr.getCle(), ingr);
			}
			Statement stmt3 = connexion.createStatement();
			String sel3 = "Select np from preparations where nr= " + cle;
			ResultSet results3 = stmt3.executeQuery(sel3);
			while (results3.next()) {
				Preparation prep = new Preparation(cle, results3.getInt(1));
				preparations.put(prep.getCle(), prep);
			}
			if (connexion != null) {
				connexion.close();
			}

		} catch (SQLException e) {
			System.out.println("Pas de connexion" + e.toString());
		}

	}

	/**
	 * 
	 * @return String nom de la recette
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * changer le nom
	 * 
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * 
	 * @return Reference
	 */
	public Reference getRef() {
		return ref;
	}

	/**
	 * Changer la reference
	 * 
	 * @param ref
	 */
	public void setRef(Reference ref) {
		this.ref = ref;
	}

	/**
	 * 
	 * @return Categorie
	 */
	public Categorie getCat() {
		return cat;
	}

	/**
	 * change la categorie
	 * 
	 * @param cat
	 */
	public void setCat(Categorie cat) {
		this.cat = cat;
	}

	public String toString() {
		String str = cat.getSouscat() + " /	" + nom;
		return str;
	}

	/**
	 * 
	 * @return cle
	 */
	public int getCle() {
		return cle;
	}

	/**
	 * 
	 * @return Arraylist des ingredients
	 */
	public ArrayList<Ingredient> getIngredients() {
		ArrayList<Ingredient> ingrediensListe = new ArrayList<>(
				ingredients.values());
		return ingrediensListe;
	}

	/**
	 * creer un nouvel ingredient et le passe dans la liste
	 * 
	 * @param nom
	 * @param qte
	 * @param unite
	 */
	public void newIngredients(String nom, int qte, String unite) {
		Ingredient ingr = new Ingredient(cle, nom, qte, unite);
		ingredients.put(ingr.getCle(), ingr);
	}

	/**
	 * @deprecated
	 * @param nom
	 * @param qte
	 */
	public void newIngredients(String nom, int qte) {
		Ingredient ingr = new Ingredient(cle, nom, qte);
		ingredients.put(ingr.getCle(), ingr);
	}

	/**
	 * suprime un ingredient
	 * 
	 * @param ingr
	 */
	public void delIngredient(Ingredient ingr) {
		ingredients.remove(ingr.getCle());
		ingr.deleteIt();
	}

	/**
	 * suprimme plusieurs ingredients
	 * 
	 * @param ingrs
	 *            tableau des ingredients a supprimer
	 */
	public void delIngredient(Ingredient[] ingrs) {
		for (Ingredient ingr : ingrs) {
			ingredients.remove(ingr.getCle());
			ingr.deleteIt();
		}
	}

	/**
	 * 
	 * @return String les instructions
	 */
	public String getInstrctions() {
		return instructions;
	}

	/**
	 * 
	 * @param instr
	 *            les instructions
	 */
	public void setInstruction(String instr) {
		this.instructions = instr;
	}

	/**
	 * Update la base de donnees avec les nouvelles donnees des objets recettes
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
					.prepareStatement("update recettes set nom = ?,nref = ?, nc =?, instructions = ? where nr = ?");
			up.setString(1, this.getNom());
			up.setInt(2, this.ref.getCle());
			up.setInt(3, this.cat.getCle());
			up.setString(4, this.instructions);
			up.setInt(5, this.cle);
			up.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Pas de connexion" + e.toString());
		}
	}

	public ArrayList<Preparation> getPreparations() {
		ArrayList<Preparation> prepListe = new ArrayList<>(
				preparations.values());
		return prepListe;
	}

	public void delPreparation(Preparation prep) {
		preparations.remove(prep.getCle());
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
					.prepareStatement("delete from preparations where nr = ? and np = ?");
			inject.setInt(1, prep.getNR());
			inject.setInt(2, prep.getCle());
			inject.executeUpdate();
			if (connexion != null) {
				connexion.close();
			}

		} catch (SQLException e) {
			System.out.println("Pas de connexion" + e.toString());
		}

	}

	public void newPreparation(Date dateprep, int note, String comment) {
		Preparation prep = new Preparation(this.cle, dateprep, note, comment);
		preparations.put(prep.getCle(), prep);
	}
}
