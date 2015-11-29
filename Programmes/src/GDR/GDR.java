package GDR;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import frame.Start;

/**
 * coeur du programme
 * 
 * @author julien
 * 
 */
public class GDR {
	private static HashMap<Integer, Reference> refsMap = new HashMap<>();
	private static HashMap<Integer, Categorie> catsMap = new HashMap<>();
	private static HashMap<Integer, Recette> recMaps = new HashMap<>();

	public static void main(String[] args) {
		start();
		Start sf = new Start();
		sf.setSize(200, 400);
		sf.setVisible(true);
		

	}

	/**
	 * importe toute les data de la BDD
	 */
	public static void start() {

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
			String sel = "Select nc from categories";
			ResultSet results = stmt.executeQuery(sel);
			while (results.next()) {
				Categorie cat;
				cat = new Categorie(results.getInt(1));
				catsMap.put(cat.getCle(), cat);

			}
			Statement stmt2 = connexion.createStatement();
			String sel2 = "Select nref from ref";
			ResultSet results2 = stmt2.executeQuery(sel2);
			while (results2.next()) {
				Reference ref;
				ref = new Reference(results2.getInt(1));
				refsMap.put(ref.getCle(), ref);
			}
			if (connexion != null) {
				connexion.close();
			}
		} catch (SQLException e) {
			System.out.println("Pas de connexion" + e.toString());
		}

		try {
			connexion = DriverManager.getConnection(url, utilisateur,
					motDePasse);
			Statement stmt = connexion.createStatement();
			String sel = "Select nr from recettes";
			ResultSet results = stmt.executeQuery(sel);
			while (results.next()) {
				Recette rec;
				rec = new Recette(results.getInt(1), refsMap, catsMap);
				recMaps.put(rec.getCle(), rec);

			}
		} catch (SQLException e) {
			System.out.println("Pas de connexion" + e.toString());
		}

	}

	/**
	 * permet de filtrer une liste par categories
	 * 
	 * @param entree
	 *            liste a filtrer
	 * @param cat
	 *            categorie a filtrer
	 * 
	 * @return ArrayList filtree
	 */
	public static ArrayList<Recette> filtreCat(ArrayList<Recette> entree,
			Categorie cat) {
		ArrayList<Recette> sortie = new ArrayList<>();
		for (Recette rec : entree) {
			if (rec.getCat() == cat) {
				sortie.add(rec);
			}
		}
		return sortie;
	}

	/**
	 * permet de filtrer une liste par categories
	 * 
	 * @param entree
	 * @param cat
	 * @return
	 */
	public static ArrayList<Recette> filtreCat(
			HashMap<Integer, Recette> entree, Categorie cat) {
		ArrayList<Recette> inter = new ArrayList<>(entree.values());
		return filtreCat(inter, cat);
	}

	public static void newCategorie(boolean sale, String nom) {
		Categorie cat = new Categorie(sale, nom);
		catsMap.put(cat.getCle(), cat);
	}
/**
 * supprime une categorie
 * @param cat Categorie a suprimmer
 */
	public static void delCategorie(Categorie cat) {
		if (cat.getCle() != 0) {
			ArrayList<Recette> li;
			li = filtreCat(recMaps, cat);
			for (Recette rec : li) {
				rec.setCat(catsMap.get(0));
				rec.bddUpdate();
			}

			catsMap.remove(cat.getCle());
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
						.prepareStatement("delete from categories where nc = ?");
				inject.setInt(1, cat.getCle());
				inject.executeUpdate();
				if (connexion != null) {
					connexion.close();
				}

			} catch (SQLException e) {
				System.out.println("Pas de connexion" + e.toString());
			}
		}
	}

	public static void newReference(String nom) {
		Reference ref = new Reference(nom);
		refsMap.put(ref.getCle(), ref);
	}

	public static void delReference(Reference ref) {
		if (ref.getCle() != 0) {
			refsMap.remove(ref.getCle());
			for (Recette r : recMaps.values()) {
				if (r.getRef() == ref) {
					r.setRef(refsMap.get(0));
					r.bddUpdate();
				}
			}
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
						.prepareStatement("delete from ref where nref = ?");
				inject.setInt(1, ref.getCle());
				inject.executeUpdate();
				if (connexion != null) {
					connexion.close();
				}

			} catch (SQLException e) {
				System.out.println("Pas de connexion" + e.toString());
			}

		}

	}

	public static void addRecettes(Recette rec) {
		recMaps.put(rec.getCle(), rec);
	}

	public static void delRecettes(Recette rec) {

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
			PreparedStatement inject1 = connexion
					.prepareStatement("delete from ingredients where nr = ?");
			inject1.setInt(1, rec.getCle());
			inject1.executeUpdate();
			PreparedStatement inject2 = connexion
					.prepareStatement("delete from recettes where nr =?");
			inject2.setInt(1, rec.getCle());
			inject2.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Pas de connexion" + e.toString());
		}
		recMaps.remove(rec.getCle());

	}

	public static ArrayList<Categorie> getCat() {
		ArrayList<Categorie> li = new ArrayList<>(catsMap.values());
		return li;

	}

	public static ArrayList<Recette> getRec() {
		ArrayList<Recette> li = new ArrayList<>(recMaps.values());
		return li;
	}

	public static ArrayList<Reference> getRef() {
		ArrayList<Reference> li = new ArrayList<>(refsMap.values());
		return li;
	}

	public static ArrayList<Recette> searchRec(ArrayList<Recette> entree,
			String mot) {
		ArrayList<Recette> sortie = new ArrayList<>();
		for (Recette i : entree) {
			if (i.getNom().contains(mot)) {
				sortie.add(i);
			}
		}

		return sortie;
	}

	public static Recette randomRec(ArrayList<Recette> entree) {
		Random randomGenerator = new Random();
		int randomIndex = randomGenerator.nextInt(entree.size());
		return entree.get(randomIndex);
	}

	public static ArrayList<Recette> filtreSale(ArrayList<Recette> entree,
			boolean sale, boolean sucre) {
		ArrayList<Recette> sortie;
		if (sucre && sale) {
			sortie = entree;
		} else if (sale) {
			sortie = new ArrayList<>();
			for (Recette i : entree) {
				if (i.getCat().getSale()) {
					sortie.add(i);
				}
			}
		} else if (sucre) {
			sortie = new ArrayList<>();
			for (Recette i : entree) {
				if (i.getCat().getSale() == false) {
					sortie.add(i);
				}
			}

		} else {
			sortie = new ArrayList<>();
		}
		return sortie;
	}
}
