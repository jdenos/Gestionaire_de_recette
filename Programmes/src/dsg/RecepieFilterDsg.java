package dsg;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import GDR.Categorie;
import GDR.Recette;

/**
 * Design de la fenêtre de recherche des recettes
 * 
 * @author julien
 */
public class RecepieFilterDsg extends JPanel {

	/*
	 * COMPOSANTS
	 */

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */

	// panel des filtres
	private JPanel filterPnl = null;

	// ligne du haut
	private JPanel filterCheckPnl = null;
	// ligne du milieu
	private JPanel filterTxtPnl = null;
	// ligne du bas (boutons)
	private JPanel filterBtnPnl = null;


	// checkBox salé
	private JCheckBox saltyChk = null;
	// checkBox sucré
	private JCheckBox sweetChk = null;
	// combobox selection sscat
	private JComboBox<Categorie> catCombo = null;
	// Label sscat pour combobox)
	private JLabel catLbl = null;
	// champs de recherche
	private JTextField searchTxt = null;
	// Label Recherche
	private JLabel searchLbl = null;
	// bouton RAZ
	private JButton razBtn = null;
	// bouton rechercher
	private JButton searchBtn = null;

	// panel de selection
	private JPanel selectPnl = null;
	// JList avec les recettes
	private JList<GDR.Recette> recetteList = null;

	// panel des boutons du bas
	private JPanel basPnl = null;
	// bouton add
	private JButton addRecipeBtn = null;
	// bouton edit
	private JButton editRecipeBtn = null;
	//delete rec
	private JButton delRecipeBtn = null;
	// random
	private JButton randomRecipeBtn = null;
	private JPanel randomPnl =null;
	
	
	/**
	 * Constructeur
	 */
	public RecepieFilterDsg() {
		// initialisation des composants
		init();
	}

	/**
	 * Methode pour initialiser les composants
	 */
	private void init() {
		this.setLayout(new BorderLayout());
		this.add(this.getFilterPnl(), BorderLayout.NORTH);
		this.add(this.getSelectPnl(), BorderLayout.CENTER);
		this.add(this.getBasPnl(), BorderLayout.SOUTH);
		this.add(this.getRandomPnl(), BorderLayout.EAST);
	}

	public JPanel getSelectPnl() {
		if (selectPnl == null) {
			selectPnl = new JPanel();
			selectPnl.setLayout(new BorderLayout());
			selectPnl.add(new JScrollPane(getRecetteList()));
			selectPnl.setBorder(new EmptyBorder(5, 5, 5, 5));
		}
		return selectPnl;

	}

	/**
	 * Récupération du panel contenant tous les filtres
	 * 
	 * @return JPanel
	 */
	private JPanel getFilterPnl() {
		if (filterPnl == null) {
			filterPnl = new JPanel();
			filterPnl.setLayout(new BoxLayout(filterPnl, BoxLayout.Y_AXIS));
			filterPnl.add(getFilterCheckPnl());
			filterPnl.add(getFilterTxtPnl());
			filterPnl.add(getFilterBtnPnl());
		}
		return filterPnl;
	}

	private JPanel getFilterCheckPnl() {
		if (filterCheckPnl == null) {
			filterCheckPnl = new JPanel();
			filterCheckPnl.setBorder(new EmptyBorder(5, 5, 5, 5));
			filterCheckPnl.setLayout(new BoxLayout(filterCheckPnl,
					BoxLayout.X_AXIS));
			filterCheckPnl.add(getCatLbl());
			filterCheckPnl.add(getCatCombo());
			filterCheckPnl.add(getSaltyChk());
			filterCheckPnl.add(getSweetChk());
		}
		return filterCheckPnl;
	}

	public JCheckBox getSaltyChk() {
		if (saltyChk == null) {
			saltyChk = new JCheckBox("Salé");
		}
		return saltyChk;
	}

	public JCheckBox getSweetChk() {
		if (sweetChk == null) {
			sweetChk = new JCheckBox("Sucré");
		}
		return sweetChk;
	}

	public JLabel getCatLbl() {
		if (catLbl == null) {
			catLbl = new JLabel("Sous-Catégorie ");
		}
		return catLbl;
	}

	public JComboBox<Categorie> getCatCombo() {
		if (catCombo == null) {
			catCombo = new JComboBox<Categorie>();
		}
		return catCombo;
	}

	private JPanel getFilterTxtPnl() {
		if (filterTxtPnl == null) {
			filterTxtPnl = new JPanel();
			filterTxtPnl.setBorder(new EmptyBorder(5, 5, 5, 5));
			filterTxtPnl.setLayout(new BorderLayout());
			filterTxtPnl.add(getSearchLbl(), BorderLayout.WEST);
			filterTxtPnl.add(getSearchTxt(), BorderLayout.CENTER);
		}
		return filterTxtPnl;
	}

	public JLabel getSearchLbl() {
		if (searchLbl == null) {
			searchLbl = new JLabel("Recherche ");
		}
		return searchLbl;
	}

	public JTextField getSearchTxt() {
		if (searchTxt == null) {
			searchTxt = new JTextField();
		}
		return searchTxt;
	}

	private JPanel getFilterBtnPnl() {
		if (filterBtnPnl == null) {
			filterBtnPnl = new JPanel();
			filterBtnPnl.setBorder(new EmptyBorder(5, 5, 5, 5));
			filterBtnPnl.setLayout(new FlowLayout(FlowLayout.RIGHT));
			filterBtnPnl.add(getRazBtn());
			filterBtnPnl.add(getSearchBtn());
		}
		return filterBtnPnl;
	}

	public JButton getRazBtn() {
		if (razBtn == null) {
			razBtn = new JButton("Reset");
		}
		return razBtn;
	}

	public JButton getSearchBtn() {
		if (searchBtn == null) {
			searchBtn = new JButton("Rechercher");
		}
		return searchBtn;
	}

	public JList<Recette> getRecetteList() {
		if (recetteList == null) {
			recetteList = new JList<>();
		}
		return recetteList;
	}

	public JPanel getBasPnl() {
		if (basPnl == null) {
			basPnl = new JPanel();
			basPnl.setLayout(new BoxLayout(basPnl, BoxLayout.X_AXIS));
			basPnl.setBorder(new EmptyBorder(5, 5, 5, 5));
			basPnl.add(getAddRecipeBtn());
			
			basPnl.add(getDelBtn());
			basPnl.add(Box.createRigidArea(new Dimension(5,5)));
			basPnl.add(getEditBtn());
			basPnl.add(Box.createRigidArea(new Dimension(5,5)));
			basPnl.add(getAddRecipeBtn());
			
			//basPnl.add(getRandomRecipeButton());

		}
		return basPnl;
	}

	public JButton getRandomRecipeButton() {
		if (randomRecipeBtn == null) {
			randomRecipeBtn = new JButton("Aleatoire");
		}

		return randomRecipeBtn;
	}

	public JButton getAddRecipeBtn() {
		if (addRecipeBtn == null) {
			addRecipeBtn = new JButton("Nouvelle Recette");
		}
		return addRecipeBtn;
	}

	public JButton getEditBtn() {
		if (editRecipeBtn == null) {
			editRecipeBtn = new JButton("Edit");
		}
		return editRecipeBtn;
	}
	public JButton getDelBtn(){
		if (delRecipeBtn==null){
			delRecipeBtn = new JButton("Supprimer");
		}
		return delRecipeBtn;
	}
	public JPanel getRandomPnl(){
		if (randomPnl==null){
			randomPnl = new JPanel();
			randomPnl.setLayout(new BoxLayout(randomPnl, BoxLayout.Y_AXIS));
			randomPnl.add(getRandomRecipeButton());
		}
		return randomPnl;
	}
}
