package frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import GDR.Recette;
import dsg.IngredientEditorDsg;

public class IngredientEditor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IngredientEditorDsg dsg;



	public IngredientEditor(final Recette rec){
		this.dsg = new IngredientEditorDsg();
		this.rootPane.getContentPane().add(dsg);
		this.dsg.getOKBtn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String nom = dsg.getNomTxt().getText();
				int qte = Integer.parseInt(dsg.getQteTxt().getText());
				String unite = dsg.getUniteTxt().getText();
				rec.newIngredients(nom, qte, unite);
				dispose();
				RecipeEditor re = new RecipeEditor(rec);
				re.setSize(800, 600);
				re.setVisible(true);
				
			}
		});
		this.dsg.getCancelBtn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				RecipeEditor re = new RecipeEditor(rec);
				re.setSize(800, 600);
				re.setVisible(true);
				
			}
		});
	}
	
}
