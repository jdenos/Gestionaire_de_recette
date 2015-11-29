package frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import GDR.Reference;

import dsg.RefEditorDsg;

public class RefEditor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private RefEditorDsg dsg;
	private Reference ref = null;

	/**
	 * Create the frame.
	 */
	public RefEditor() {
		this.dsg = new RefEditorDsg();
		this.rootPane.getContentPane().add(dsg);
		this.dsg.getCancelBtn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				RefMgmt rm = new RefMgmt();
				rm.setSize(800, 600);
				rm.setVisible(true);

			}
		});
		this.dsg.getOkBtn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String nom = dsg.getNomTxt().getText();
				if (ref == null) {
					GDR.GDR.newReference(nom);
				} else {
					ref.setNom(nom);
					ref.bddUpdate();
				}
				dispose();
				RefMgmt rm = new RefMgmt();
				rm.setSize(800, 600);
				rm.setVisible(true);

			}
		});
	}

	public RefEditor(Reference ref) {
		this();
		this.ref = ref;
		this.dsg.getNomTxt().setText(ref.getNom());
	}

}
