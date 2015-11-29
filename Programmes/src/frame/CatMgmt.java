package frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;

import GDR.Categorie;
import dsg.CatMgmtDsg;

public class CatMgmt extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CatMgmtDsg dsg;
	private ArrayList<Categorie> catList = GDR.GDR.getCat();
	private DefaultListModel<Categorie> catListModel = new DefaultListModel<>();

	public CatMgmt() {
		this.dsg = new CatMgmtDsg();
		this.rootPane.getContentPane().add(dsg);
		for (Categorie r : catList) {
			catListModel.addElement(r);
		}
		this.dsg.getCatList().setModel(catListModel);
		this.dsg.getAddBtn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				CatEditor ce = new CatEditor();
				ce.setSize(500, 150);
				ce.setVisible(true);
				
			}
		});
		this.dsg.getEditBtn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				CatEditor ce = new CatEditor(dsg.getCatList().getSelectedValue());
				ce.setSize(500, 150);
				ce.setVisible(true);
				
			}
		});
		this.dsg.getDelBtn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GDR.GDR.delCategorie(dsg.getCatList().getSelectedValue());
				catList = GDR.GDR.getCat();
				catListModel.clear();
				for (Categorie c : catList) {
					catListModel.addElement(c);
				}
				dsg.getCatList().updateUI();
				
			}
		});
	}

}
