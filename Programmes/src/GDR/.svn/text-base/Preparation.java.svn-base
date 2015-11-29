package GDR;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
/**
 * 
 * @author julien
 *
 */
public class Preparation {

	private int cle;
	private int nr;
	private Date dateprep;
	private int note;
	private String comment;
	
	public Preparation(int nr, int cle){
		this.cle = cle;
		this.nr=nr;
		
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
					.prepareStatement("Select dateprep,note,commentaire from preparations where nr= ? and np= ?");
			stmt.setInt(1, nr);
			stmt.setInt(2, cle);
			ResultSet results = stmt.executeQuery();
			while (results.next()) {
				Date date = results.getDate(1);
				this.dateprep = date;
				this.note = results.getInt(2);
				this.comment = results.getString(3);
			}
		} catch (SQLException e) {
			System.out.println("Pas de connexion" + e.toString());
		}
	}
	
	public Preparation(int nr, Date dateprep,int note, String comment){
		this.nr = nr;
		this.dateprep = dateprep;
		this.note = note;
		this.comment = comment;
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
			String sel = "Select max(np) from preparations where nr = " + nr;
			ResultSet results = stmt.executeQuery(sel);
			while (results.next()) {
				this.cle = results.getInt(1) + 1;
			}

			PreparedStatement injectingr = connexion
					.prepareStatement("Insert into preparations(nr,np,dateprep,note,commentaire) values (?,?,?,?,?)");
			injectingr.setInt(1, nr);
			injectingr.setInt(2, cle);
			injectingr.setInt(4, note);
			injectingr.setDate(3, new java.sql.Date(dateprep.getTime()));
			injectingr.setString(5, comment);
			injectingr.executeUpdate();
			// fermeture de la connexion
			if (connexion != null) {
				connexion.close();
			}
		} catch (SQLException e) {
			System.out.println("Pas de connexion" + e.toString());
		}

	}
	
	
	public String toString(){
		String str = this.dateprep.toString()+" / "+this.note+" / "+comment ;
		return str;
	}
	
	public int getCle(){
		return this.cle;
	}
	public int getNR(){
		return nr;
	}
	public Date getDateprep(){
		return dateprep;
	}
	public int getNote(){
		return note;
	}
	public String getComment(){
		return comment;
	}
	public void setDateprep(Date dateprep){
		this.dateprep = dateprep;
	}
	public void setNote(int note){
		this.note = note;
	}
	public void setComment(String comment){
		this.comment=comment;
	}

}
