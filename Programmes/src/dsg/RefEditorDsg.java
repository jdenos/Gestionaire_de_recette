package dsg;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RefEditorDsg extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nomTxt = null;
	private JLabel nomLbl = null;
	private JButton okBtn = null;
	private JButton cancelBtn = null;

	/**
	 * Create the panel.
	 */
	public RefEditorDsg() {
		this.setLayout(new GridLayout(2, 2, 5, 5));
		this.add(getNomLabel());
		this.add(getNomTxt());
		this.add(getCancelBtn());
		this.add(getOkBtn());
	}

	public JTextField getNomTxt() {
		if (nomTxt == null) {
			nomTxt = new JTextField();
		}
		return nomTxt;
	}

	public JLabel getNomLabel() {
		if (nomLbl == null) {
			nomLbl = new JLabel("nom",JLabel.CENTER);
			
		}
		return nomLbl;
	}
	public JButton getOkBtn(){
		if (okBtn==null){
			okBtn = new JButton("OK");
		}
		return okBtn;
	}
	public JButton getCancelBtn(){
		if (cancelBtn==null){
			cancelBtn = new JButton("Annuler");
		}
		return cancelBtn;
	}
}
