package frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;

import GDR.Categorie;
import GDR.Ingredient;
import GDR.Preparation;
import GDR.Recette;
import GDR.Reference;

import dsg.RecipeEditordsg;

public class RecipeEditor extends JFrame {

	private static final long serialVersionUID = 1L;
	private RecipeEditordsg dsg;
	private Recette rec = null;
	private ArrayList<Categorie> catsList = GDR.GDR.getCat();
	private ArrayList<Reference> refsList = GDR.GDR.getRef();

	public RecipeEditor() {
		this.dsg = new RecipeEditordsg();
		this.rootPane.getContentPane().add(dsg);
		for (Categorie i : catsList) {
			dsg.getCatCombo().addItem(i);
		}

		for (Reference i : refsList) {
			dsg.getRefCombo().addItem(i);
		}

		dsg.getSaveBtn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Categorie cat = (Categorie) dsg.getCatCombo()
						.getSelectedItem();
				Reference ref = (Reference) dsg.getRefCombo()
						.getSelectedItem();
				String nom = dsg.getTitleTxt().getText();
				String instr = dsg.getInstructionTxt().getText();
				if (rec == null) {
					rec = new Recette(nom, ref, cat, instr);
					GDR.GDR.addRecettes(rec);
				} else {
					rec.setCat(cat);
					rec.setNom(nom);
					rec.setRef(ref);
					rec.setInstruction(instr);
					rec.bddUpdate();
				}
				RecepieFilter rf = new RecepieFilter();
				rf.setSize(800, 600);
				rf.setVisible(true);
				dispose();

			}
		});
		this.dsg.getQuitBtn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				RecepieFilter rf = new RecepieFilter();
				rf.setSize(800, 600);
				rf.setVisible(true);
				dispose();
				
			}
		});
		this.dsg.getDelIngr().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Ingredient ingr = dsg.getIngredientsList().getSelectedValue();
				rec.delIngredient(ingr);
				ArrayList<Ingredient> ingreList = rec.getIngredients();
				DefaultListModel<Ingredient> ingrListModel = new DefaultListModel<>();
				for (Ingredient i : ingreList) {
					ingrListModel.addElement(i);
				}
				dsg.getIngredientsList().setModel(ingrListModel);
				
			}
		});
		this.dsg.getAddIngr().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (rec == null){
					Categorie cat = (Categorie) dsg.getCatCombo()
							.getSelectedItem();
					Reference ref = (Reference) dsg.getRefCombo()
							.getSelectedItem();
					String nom = dsg.getTitleTxt().getText();
					String instr = dsg.getInstructionTxt().getText();
					rec = new Recette(nom, ref, cat, instr);
					GDR.GDR.addRecettes(rec);
					
				}
				dispose();
				IngredientEditor ie = new IngredientEditor(rec);
				ie.setSize(300,150);
				ie.setVisible(true);
				
			}
		});
		this.dsg.getDelPrepBtn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				Preparation prep = dsg.getPrepList().getSelectedValue();
				rec.delPreparation(prep);
				ArrayList<Preparation> prepList = rec.getPreparations();
				DefaultListModel<Preparation> prepListModel = new DefaultListModel<>();
				for (Preparation i : prepList) {
					prepListModel.addElement(i);
				}
				dsg.getPrepList().setModel(prepListModel);
				
			}
		});
		this.dsg.getAddPrepBtn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				PrepEditor pr = new PrepEditor(rec);
				pr.setSize(800, 400);
				pr.setVisible(true);

				
			}
		});
	}

	public RecipeEditor(Recette rec) {
		this();
		this.rec = rec;
		dsg.getCatCombo().setSelectedItem(rec.getCat());
		dsg.getRefCombo().setSelectedItem(rec.getRef());
		dsg.getTitleTxt().setText(rec.getNom());
		dsg.getInstructionTxt().setText(rec.getInstrctions());
		ArrayList<Ingredient> ingreList = rec.getIngredients();
		DefaultListModel<Ingredient> ingrListModel = new DefaultListModel<>();
		for (Ingredient i : ingreList) {
			ingrListModel.addElement(i);
		}
		dsg.getIngredientsList().setModel(ingrListModel);
		ArrayList<Preparation> prepList = rec.getPreparations();
		DefaultListModel<Preparation> prepListModel = new DefaultListModel<>();
		for (Preparation i : prepList){
			prepListModel.addElement(i);
		}
		dsg.getPrepList().setModel(prepListModel);
	}

}
