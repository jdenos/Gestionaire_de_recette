package dsg;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import GDR.Reference;

public class RefMgmtDsg extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel refSelectionPnl;
	private JList<Reference> refList;

	// botons du bas
	private JPanel basPnl = null;
	private JButton delBtn = null;
	private JButton addBtn = null;
	private JButton editBtn = null;

	/**
	 * Create the panel.
	 */
	public RefMgmtDsg() {
		init();
	}

	public void init() {
		this.setLayout(new BorderLayout());
		this.add(getRefSelectPnl(), BorderLayout.CENTER);
		this.add(getBasPnl(), BorderLayout.SOUTH);
	}
	public JPanel getRefSelectPnl(){
		
		if(refSelectionPnl==null){
			refSelectionPnl = new JPanel();
			refSelectionPnl.setLayout(new BorderLayout());
			refSelectionPnl.add(new JScrollPane(getRefList()));
			refSelectionPnl.setBorder(new EmptyBorder(5, 5, 5, 5));
		}
		
		return refSelectionPnl;
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
	public JButton getAddBtn() {
		if (addBtn == null) {
			addBtn = new JButton("Nouvelle Reference");
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
	public JList<Reference> getRefList() {
		if (refList == null) {
			refList = new JList<>();
		}
		return refList;
	}

}

