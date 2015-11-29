package dsg;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * 
 * @author julien
 *
 */
public class CatEditorDsg extends JPanel {

	/**
	 * numero de serie
	 */
	private static final long serialVersionUID = 1L;
	// composants
	private JLabel saleLbl = null;
	private JCheckBox saleChk = null;
	private JLabel nomLbl = null;
	private JTextField nomTxt = null;
	private JButton okBtn = null;
	private JButton cancelBtn = null;

	/**
	 * Create the panel.
	 */
	public CatEditorDsg() {
		this.setLayout(new GridLayout(3, 2, 5, 5));
		this.add(getsaleLbl());
		this.add(getsaleChk());
		this.add(getNomLbl());
		this.add(getNomTxt());
		this.add(getCancelBtn());
		this.add(getOkBtn());
	}
/**
 * 
 * @return Label sale
 */
	public JLabel getsaleLbl() {
		if (saleLbl == null) {
			saleLbl = new JLabel("Sale ?", JLabel.CENTER);
		}
		return saleLbl;
	}
/**
 * 
 * @return CheckBox Sale
 */
	public JCheckBox getsaleChk() {
		if (saleChk == null) {
			saleChk = new JCheckBox();
		}
		return saleChk;
	}
/**
 * 
 * @return Label nom
 */
	public JLabel getNomLbl() {
		if (nomLbl == null) {
			nomLbl = new JLabel("Nom", JLabel.CENTER);
		}
		return nomLbl;
	}
/**
 * 
 * @return Jtextfiel du nom
 */
	public JTextField getNomTxt() {
		if (nomTxt == null) {
			nomTxt = new JTextField();
		}
		return nomTxt;
	}
/**
 * 
 * @return Bouton annuler
 */
	public JButton getCancelBtn() {
		if (cancelBtn == null) {
			cancelBtn = new JButton("Annuler");
		}
		return cancelBtn;
	}
/**
 * 
 * @return bouton OK
 */
	public JButton getOkBtn() {
		if (okBtn == null) {
			okBtn = new JButton("OK");
		}
		return okBtn;
	}
}
