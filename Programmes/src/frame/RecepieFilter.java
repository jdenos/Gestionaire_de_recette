package frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;

import GDR.Categorie;
import GDR.Recette;
import dsg.RecepieFilterDsg;

/**
 * Fenêtre de recherche des recettes
 * 
 * @author julien
 */
public class RecepieFilter extends JFrame {

	// ajout d'un serial par eclipse
	private static final long serialVersionUID = 1L;
	private RecepieFilterDsg dsg;
	private ArrayList<Categorie> catList = GDR.GDR.getCat();
	private DefaultListModel<Recette> recListModel = new DefaultListModel<>();
	private Recette rec;
	private ArrayList<Recette> workList;

	public RecepieFilter() {
		this.dsg = new RecepieFilterDsg();
		this.rootPane.getContentPane().add(dsg);
		this.workList = GDR.GDR.getRec();
		for (Recette i : workList) {
			recListModel.addElement(i);
		}
		dsg.getRecetteList().setModel(recListModel);

		for (Categorie i : catList) {
			dsg.getCatCombo().addItem(i);
		}
		dsg.getCatCombo().setSelectedIndex(-1);
		dsg.getSaltyChk().setSelected(true);
		dsg.getSweetChk().setSelected(true);

		this.dsg.getAddRecipeBtn().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				RecipeEditor re = new RecipeEditor();
				re.setSize(800, 600);
				re.setVisible(true);
				dispose();

			}
		});
		this.dsg.getEditBtn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				rec = dsg.getRecetteList().getSelectedValue();
				RecipeEditor re = new RecipeEditor(rec);
				re.setSize(800, 600);
				re.setVisible(true);
				dispose();

			}
		});
		this.dsg.getDelBtn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				java.util.List<Recette> selrec = dsg.getRecetteList()
						.getSelectedValuesList();
				for (Recette rec : selrec) {
					GDR.GDR.delRecettes(rec);
					workList.remove(rec);
				}

				refreshList();

			}
		});
		this.dsg.getRazBtn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				workList = GDR.GDR.getRec();
				dsg.getCatCombo().setSelectedIndex(-1);
				dsg.getSaltyChk().setSelected(true);
				dsg.getSweetChk().setSelected(true);
				dsg.getSearchTxt().setText("");
				refreshList();

			}
		});
		this.dsg.getSearchBtn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				workList = GDR.GDR.getRec();
				String str = dsg.getSearchTxt().getText();
				boolean sale = dsg.getSaltyChk().isSelected();
				boolean sucre = dsg.getSweetChk().isSelected();

				workList = GDR.GDR.filtreSale(workList, sale, sucre);
				if (dsg.getCatCombo().getSelectedIndex() != -1) {
					Categorie cat = (Categorie) dsg.getCatCombo()
							.getSelectedItem();
					workList = GDR.GDR.filtreCat(workList, cat);

				}
				if (str.equals("") == false) {
					workList = GDR.GDR.searchRec(workList, str);
				}
				refreshList();

			}
		});
		this.dsg.getRandomRecipeButton().addActionListener(
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						Recette randRec = GDR.GDR.randomRec(workList);
						RecipeEditor re = new RecipeEditor(randRec);
						re.setSize(800, 600);
						re.setVisible(true);
						dispose();

					}
				});

	}

	/**
	 * reactualise la liste en fonction des nouveaux parametres
	 */
	public void refreshList() {

		recListModel.clear();
		for (Recette i : workList) {
			recListModel.addElement(i);
		}
		dsg.getRecetteList().updateUI();

	}

}
