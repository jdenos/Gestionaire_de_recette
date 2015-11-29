package frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import GDR.Categorie;

import dsg.CatEditorDsg;

public class CatEditor extends JFrame {

	/**
	 * numero de serie
	 */
	private static final long serialVersionUID = 1L;
	private CatEditorDsg dsg;
	private Categorie cat = null;

	public CatEditor() {
		this.dsg = new dsg.CatEditorDsg();
		this.rootPane.getContentPane().add(dsg);
		this.dsg.getCancelBtn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				CatMgmt cm = new CatMgmt();
				cm.setSize(800, 600);
				cm.setVisible(true);

			}
		});
		this.dsg.getOkBtn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean sale = dsg.getsaleChk().isSelected();
				String nom = dsg.getNomTxt().getText();
				if (cat == null) {
					GDR.GDR.newCategorie(sale, nom);
				} else {
					cat.setSale(sale);
					cat.setSouscat(nom);
					cat.bddUpdate();
				}
				dispose();
				CatMgmt cm = new CatMgmt();
				cm.setSize(800, 600);
				cm.setVisible(true);

			}
		});

	}

	public CatEditor(Categorie cat) {
		this();
		this.cat = cat;
		dsg.getNomTxt().setText(cat.getSouscat());
		dsg.getsaleChk().setSelected(cat.getSale());
	}

}
