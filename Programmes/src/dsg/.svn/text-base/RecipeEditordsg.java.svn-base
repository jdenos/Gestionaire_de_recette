package dsg;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import GDR.Categorie;
import GDR.Ingredient;
import GDR.Preparation;
import GDR.Reference;

public class RecipeEditordsg extends JPanel {

	// SID cree par eclipse
	private static final long serialVersionUID = 1L;
	// panel des instructions
	private JPanel instructionPnl = null;
	// zone de txt
	private JTextArea instructionTxt = null;

	// panel ingredient
	private JPanel ingredientPnl = null;
	// liste des ingredients
	private JList<Ingredient> ingredientsList = null;
	// Pannel btn ingr
	private JPanel basIngrPnl = null;
	private JButton addIngr = null;
	private JButton delIngr = null;

	// Panel du haut titre cat
	private JPanel titrePnl = null;
	private JPanel comboPnl = null;

	private JLabel titreLbl = null;
	private JTextField titreTxt = null;
	private JComboBox<Categorie> catCombo = null;
	private JComboBox<Reference> refCombo = null;
	private JPanel topPnl = null;
	private JScrollPane instrScrollPnl = null;
	private JLabel ingredienLbl = null;
	
	private JPanel savePnl = null;
	private JButton saveBtn = null;
	private JButton quitBtn = null;
	
	private JPanel prepPnl;
	private JList<Preparation> prepList;
	private JButton addPrepBtn;
	private JButton delprepBtn;
	private JLabel prepLbl;
	private JPanel basPrepPnl;
	private JLabel instructionsLbl;

	/**
	 * Create the panel.
	 */
	public RecipeEditordsg() {
		init();
	}

	public void init() {
		this.setLayout(new BorderLayout());
		this.add(getTopPnl(), BorderLayout.NORTH);
		this.add(getInstrcutionPnl(), BorderLayout.CENTER);
		this.add(getIngredientPnl(), BorderLayout.WEST);
		this.add(getSavePnl(), BorderLayout.EAST);
		this.add(getPrepPnl(), BorderLayout.SOUTH);

	}

	public JPanel getInstrcutionPnl() {
		if (instructionPnl == null) {
			instructionPnl = new JPanel();
			instructionPnl.setLayout(new BorderLayout());
			instructionPnl.add(getInstrLbl(),BorderLayout.NORTH);
			instructionPnl.add(new JScrollPane(getInstructionTxt()),BorderLayout.CENTER);
			instructionPnl.setBorder(new EmptyBorder(5, 5, 5, 5));

		}
		return instructionPnl;
	}

	public JTextArea getInstructionTxt() {
		if (instructionTxt == null) {
			instructionTxt = new JTextArea();

		}
		return instructionTxt;
	}

	public JPanel getIngredientPnl() {
		if (ingredientPnl == null) {
			ingredientPnl = new JPanel();
			ingredientPnl.setLayout(new BorderLayout());
			ingredientPnl.setBorder(new EmptyBorder(5, 5, 5, 5));
			ingredientPnl.add(getIngredientLbl(),BorderLayout.NORTH);
			ingredientPnl.add(new JScrollPane(getIngredientsList()), BorderLayout.CENTER);
			ingredientPnl.add(getBasIngrPnl(), BorderLayout.SOUTH);
			
		}

		return ingredientPnl;
	}

	public JList<Ingredient> getIngredientsList() {
		if (ingredientsList == null) {
			ingredientsList = new JList<>();

		}

		return ingredientsList;
	}

	public JButton getAddIngr() {
		if (addIngr == null) {
			addIngr = new JButton("+");
		}
		return addIngr;
	}

	public JButton getDelIngr() {
		if (delIngr == null) {
			delIngr = new JButton("-");
		}

		return delIngr;
	}

	public JPanel getBasIngrPnl() {
		if (basIngrPnl == null) {
			basIngrPnl = new JPanel();
			basIngrPnl.setLayout(new BoxLayout(basIngrPnl, BoxLayout.X_AXIS));
			basIngrPnl.add(getDelIngr());
			basIngrPnl.add(Box.createRigidArea(new Dimension(5,0)));
			basIngrPnl.add(getAddIngr());
			basIngrPnl.setBorder(new EmptyBorder(5, 5, 5, 5));
		}

		return basIngrPnl;
	}

	public JLabel getTitreLbl() {
		if (titreLbl == null) {
			titreLbl = new JLabel("Titre");
		}
		return titreLbl;

	}

	public JTextField getTitleTxt() {
		if (titreTxt == null) {
			titreTxt = new JTextField();
		}
		return titreTxt;
	}

	public JComboBox<Categorie> getCatCombo() {
		if (catCombo == null) {
			catCombo = new JComboBox<>();
		}
		return catCombo;
	}

	public JComboBox<Reference> getRefCombo() {
		if (refCombo == null) {
			refCombo = new JComboBox<>();
		}
		return refCombo;
	}
	public JPanel getTitrePnl(){
		if (titrePnl==null){
			titrePnl = new JPanel();
			titrePnl.setLayout(new BorderLayout());
			titrePnl.add(getTitreLbl(),BorderLayout.WEST);
			titrePnl.add(getTitleTxt(),BorderLayout.CENTER);
			titrePnl.setBorder(new EmptyBorder(5, 5, 5, 5));
		}
		return titrePnl;
	}
	public JPanel getComboPnl(){
		if (comboPnl == null){
			comboPnl = new JPanel();
			comboPnl.setBorder(new EmptyBorder(5, 5, 5, 5));
			comboPnl.setLayout(new BoxLayout(comboPnl, BoxLayout.X_AXIS));
			comboPnl.add(getCatCombo());
			comboPnl.add(Box.createRigidArea(new Dimension(5,0)));
			comboPnl.add(getRefCombo());
		}
		return comboPnl;
	}
	public JPanel getTopPnl(){
		if (topPnl==null){
			topPnl = new JPanel();
			topPnl.setLayout(new BoxLayout(topPnl, BoxLayout.Y_AXIS));
			topPnl.add(getTitrePnl());
			topPnl.add(getComboPnl());
			topPnl.setBorder(new EmptyBorder(5, 5, 5, 5));
			
		}
		
		return topPnl;
	}
	public JScrollPane getInstrScrollPnl(){
		if (instrScrollPnl == null){
			instrScrollPnl = new JScrollPane(getInstructionTxt());
			
		}
		return instrScrollPnl;
	}
	public JButton getSaveBtn(){
		if (saveBtn == null){
			saveBtn = new JButton("Sauvegarder");
		}
		return saveBtn;
	}
	public JButton getQuitBtn(){
		if (quitBtn == null){
			quitBtn = new JButton("Fermer !");
		}
		return quitBtn;
	}
	public JPanel getSavePnl(){
		if (savePnl == null){
			savePnl = new JPanel();
			savePnl.setLayout(new BoxLayout(savePnl, BoxLayout.Y_AXIS));
			savePnl.setBorder(new EmptyBorder(5, 5, 5, 5));
			savePnl.add(getSaveBtn());
			savePnl.add(Box.createRigidArea(new Dimension(0,5)));
			savePnl.add(getQuitBtn());
		}
		return savePnl;
	}
	public JLabel getIngredientLbl(){
		if (ingredienLbl == null){
			ingredienLbl = new JLabel("Ingrédients",JLabel.CENTER);
		}
		return ingredienLbl;
	}
	public JButton getAddPrepBtn(){
		if (addPrepBtn == null){
			addPrepBtn = new JButton("+");
		}
		
		return addPrepBtn;
	}
	public JButton getDelPrepBtn(){
		if (delprepBtn==null){
			delprepBtn = new JButton("-");
		}
		return delprepBtn;
	}
	public JList<Preparation> getPrepList(){
		if (prepList == null){
			prepList = new JList<>();
		}
		return prepList;
	}
	public JLabel getPrepLabel(){
		if (prepLbl==null){
			prepLbl = new JLabel("Preparations");
		}
		return prepLbl;
	}
	public JPanel getPrepPnl(){
		if (prepPnl == null){
			prepPnl = new JPanel();
			prepPnl.setLayout(new BorderLayout());
			prepPnl.setBorder(new EmptyBorder(5, 5, 5, 5));
			prepPnl.add(getPrepLabel(),BorderLayout.NORTH);
			prepPnl.add(new JScrollPane(getPrepList()), BorderLayout.CENTER);
			prepPnl.add(getBasPrepPnl(), BorderLayout.SOUTH);
		}
		return prepPnl;
	}
	public JPanel getBasPrepPnl(){
		if (basPrepPnl==null){
			basPrepPnl = new JPanel();
			basPrepPnl.setLayout(new BoxLayout(basPrepPnl, BoxLayout.X_AXIS));
			basPrepPnl.add(getDelPrepBtn());
			basPrepPnl.add(Box.createRigidArea(new Dimension(5,0)));
			basPrepPnl.add(getAddPrepBtn());
			basPrepPnl.setBorder(new EmptyBorder(5, 5, 5, 5));
		}
		return basPrepPnl;
	}
	public JLabel getInstrLbl(){
		if (instructionsLbl == null){
			instructionsLbl = new JLabel("Marche à suivre");
		}
		
		return instructionsLbl;
	}
}
