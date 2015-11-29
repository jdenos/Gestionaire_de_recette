package frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;

import GDR.Reference;
import dsg.RefMgmtDsg;

public class RefMgmt extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private RefMgmtDsg dsg;
	private ArrayList<Reference> refList = GDR.GDR.getRef();
	private DefaultListModel<Reference> refListModel = new DefaultListModel<>();

	public RefMgmt() {
		this.dsg = new RefMgmtDsg();
		this.rootPane.getContentPane().add(dsg);
		for (Reference r : refList) {
			refListModel.addElement(r);
		}
		this.dsg.getRefList().setModel(refListModel);
		this.dsg.getAddBtn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				RefEditor re = new RefEditor();
				dispose();
				re.setSize(500, 100);
				re.setVisible(true);

			}
		});
		this.dsg.getEditBtn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				RefEditor re = new RefEditor(dsg.getRefList().getSelectedValue());
				dispose();
				re.setSize(500, 100);
				re.setVisible(true);

			}
		});
		this.dsg.getDelBtn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GDR.GDR.delReference(dsg.getRefList().getSelectedValue());
				refList = GDR.GDR.getRef();
				refListModel.clear();
				for (Reference r : refList) {
					refListModel.addElement(r);
				}
				dsg.getRefList().updateUI();

			}
		});
	}
}
