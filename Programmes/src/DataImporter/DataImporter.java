package DataImporter;

import java.io.File;
import java.lang.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;



public class DataImporter{
	public static void main (String[] args){
	    	int nc=0;
    		int nr=0;

		File frefs=new File("index_livres.txt");
		File fsale=new File("sale.txt");
		File fsucre=new File("sucre.txt");
		String s="";
		/* Chargement du driver JDBC pour MySQL */
		try {
   			Class.forName( "com.mysql.jdbc.Driver" );
		} 
		catch ( ClassNotFoundException e ) {
    			System.out.println("ERREUR : "+e.toString());
		}
		
		try{
			InputStream ips=new FileInputStream(frefs); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			/* Connexion à la base de données */
			String url = "jdbc:mysql://localhost:3306/GDR";
			String utilisateur = "javalink";
			String motDePasse = "javalink";
			Connection connexion = null;
			try {
    				connexion = DriverManager.getConnection( url, utilisateur, motDePasse );
 				if (connexion != null){System.out.println("connexion reussie");} 
 
			} 
			catch ( SQLException e ) {
    				System.out.println("Pas de connexion" + e.toString());
    			}
    			PreparedStatement inject = connexion.prepareStatement( "Insert into ref(nref,nom) values (?,?)");
			while ((ligne=br.readLine())!=null){
				String[] str = ligne.split(".\t");
				
				inject.setInt(1,Integer.parseInt(str[0]));
				inject.setString(2,str[1]);
				inject.executeUpdate();
				
			}
			
			br.close(); 
			if (connexion != null){connexion.close();}
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
		
		
		
		try{
			InputStream ips=new FileInputStream(fsale); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			/* Connexion à la base de données */
			String url = "jdbc:mysql://localhost:3306/GDR";
			String utilisateur = "javalink";
			String motDePasse = "javalink";
			Connection connexion = null;
			try {
    				connexion = DriverManager.getConnection( url, utilisateur, motDePasse );
 		
 
			} catch ( SQLException e ) {
    				System.out.println("Pas de connexion (2°con)  " + e.toString());
    			}

    			PreparedStatement injectcat = connexion.prepareStatement( "Insert into categories(nc,sale,nomcat) values (?,1,?)");
    			PreparedStatement injectrec = connexion.prepareStatement( "Insert into recettes(nr,nom,nref,nc) values (?,?,?,?)");
    			String tiret="-";
			while ((ligne=br.readLine())!=null){
				if (ligne.startsWith("*")){
					nc +=1;
					String str=ligne;
					str = str.replace("* ", "");
					str = str.replace(":","");
					injectcat.setInt(1,nc);
					injectcat.setString(2,str);
					injectcat.executeUpdate();
				}
				else if (ligne.startsWith("-")){
					nr+=1;
					String[] str=ligne.split(" \\(");
					str[0]=str[0].replace("- ","");
					str[1]=str[1].replace(")","");
					str[1]=str[1].replaceAll(" ","");
					injectrec.setInt(1,nr);
					injectrec.setString(2,str[0]);
					injectrec.setInt(3,Integer.parseInt(str[1]));
					injectrec.setInt(4,nc);
					injectrec.executeUpdate();
				}
			}
			br.close(); 
			if (connexion != null){connexion.close();}
		}
		catch (Exception e){
			System.out.println(e.toString());
		}
		
		
		
		
		
		
		
		try{
			InputStream ips=new FileInputStream(fsucre); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			/* Connexion à la base de données */
			String url = "jdbc:mysql://localhost:3306/GDR";
			String utilisateur = "javalink";
			String motDePasse = "javalink";
			Connection connexion = null;
			try {
    				connexion = DriverManager.getConnection( url, utilisateur, motDePasse );
 		
 
			} catch ( SQLException e ) {
    				System.out.println("Pas de connexion (2°con)  " + e.toString());
    			}

    			PreparedStatement injectcat = connexion.prepareStatement( "Insert into categories(nc,sale,nomcat) values (?,0,?)");
    			PreparedStatement injectrec = connexion.prepareStatement( "Insert into recettes(nr,nom,nref,nc) values (?,?,?,?)");
    			String tiret="-";
			while ((ligne=br.readLine())!=null){
				if (ligne.startsWith("*")){
					nc +=1;
					String str=ligne;
					str = str.replace("* ", "");
					str = str.replace(":","");
					injectcat.setInt(1,nc);
					injectcat.setString(2,str);
					injectcat.executeUpdate();
				}
				else if (ligne.startsWith("-")){
					nr+=1;
					String[] str=ligne.split(" \\(");
					str[0]=str[0].replace("- ","");
					str[1]=str[1].replace(")","");
					str[1]=str[1].replaceAll(" ","");
					injectrec.setInt(1,nr);
					injectrec.setString(2,str[0]);
					injectrec.setInt(3,Integer.parseInt(str[1]));
					injectrec.setInt(4,nc);
					injectrec.executeUpdate();
				}
			}
			br.close(); 
			if (connexion != null){connexion.close();}
		}
		catch (Exception e){
			System.out.println(e.toString());
		}
				
		
	}


}
