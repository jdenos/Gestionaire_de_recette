package frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JFrame;

import GDR.Recette;

import dsg.PrepEditorDsg;

public class PrepEditor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PrepEditorDsg dsg;

	public PrepEditor(final Recette rec) {
		this.dsg = new PrepEditorDsg();
		this.rootPane.getContentPane().add(dsg);
		for (int i=1 ; i <6; i++){
			dsg.getNoteTxt().addItem(i);
		}
		
		dsg.getCancelBtn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				RecipeEditor re = new RecipeEditor(rec);
				re.setSize(800, 600);
				re.setVisible(true);

			}
		});
		dsg.getOKBtn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Date dateprep = dsg.getCal().getDate();
				Integer note = (Integer) dsg.getNoteTxt().getSelectedItem();
				String comment = dsg.getCommentTxt().getText();
				rec.newPreparation(dateprep, note, comment);
				
				dispose();
				RecipeEditor re = new RecipeEditor(rec);
				re.setSize(800, 600);
				re.setVisible(true);

			}
		});

	}

}
