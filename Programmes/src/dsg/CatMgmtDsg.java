package dsg;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import GDR.Categorie;

public class CatMgmtDsg extends JPanel {
	// composants

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// List des cat
	private JPanel catSelectionPnl;
	private JList<Categorie> catList;
	

	// botons du bas
	private JPanel basPnl = null;
	private JButton delBtn = null;
	private JButton addBtn = null;
	private JButton editBtn = null;

	// panel
	/**
	 * Create the panel.
	 */
	public CatMgmtDsg() {
		init();
	}

	public void init() {
		this.setLayout(new BorderLayout());
		this.add(getCatSelectPnl(),BorderLayout.CENTER);
		this.add(getBasPnl(),BorderLayout.SOUTH);

	}
	public JPanel getCatSelectPnl(){
		
		if(catSelectionPnl==null){
			catSelectionPnl = new JPanel();
			catSelectionPnl.setLayout(new BorderLayout());
			catSelectionPnl.add(new JScrollPane(getCatList()));
			catSelectionPnl.setBorder(new EmptyBorder(5, 5, 5, 5));
		}
		
		return catSelectionPnl;
	}
	public JPanel getBasPnl(){
		if (basPnl==null){
			basPnl = new JPanel();
			basPnl.setLayout(new FlowLayout(FlowLayout.LEFT));
			basPnl.add(getDelBtn());
			basPnl.add(getEditBtn());
			basPnl.add(getAddBtn());
		}
		return basPnl;
	}

	// objets
	public JButton getAddBtn() {
		if (addBtn == null) {
			addBtn = new JButton("Nouvelle Categorie");
		}
		return addBtn;
	}

	public JButton getEditBtn() {
		if (editBtn == null) {
			editBtn = new JButton("Edit");
		}
		return editBtn;
	}

	public JButton getDelBtn() {
		if (delBtn == null) {
			delBtn= new JButton("Supprimer");
		}
		return delBtn;
	}

	public JList<Categorie> getCatList() {
		if (catList == null) {
			catList = new JList<>();
		}
		return catList;
	}

}
