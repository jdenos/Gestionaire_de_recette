package dsg;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class IngredientEditorDsg extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel nomLbl = null;
	private JTextField nomTxt = null;
	private JLabel qteLbl = null;
	private JTextField qteTxt = null;
	private JLabel uniteLbl = null;
	private JTextField uniteTxt = null;
	private JButton okBtn = null;
	private JButton cancelBtn = null;
	


	/**
	 * Create the panel.
	 */
	public IngredientEditorDsg() {
		init();
	}
	
	public void init(){
		this.setLayout(new GridLayout(4,2,5,5));
		 
		this.add(getNomLbl());
		this.add(getNomTxt());
		this.add(getQteLbl());
		this.add(getQteTxt());
		this.add(getUnitLbl());
		this.add(getUniteTxt());
		this.add(getCancelBtn());
		this.add(getOKBtn());
		
	}
	
	public JLabel getNomLbl(){
		if (nomLbl == null){
			nomLbl = new JLabel("Nom",JLabel.CENTER);
		}
		
		return nomLbl;
	}
	
	public JLabel getQteLbl(){
		if (qteLbl == null){
			qteLbl = new JLabel("Qté",JLabel.CENTER);
		}
		
		return qteLbl;
	}
	public JLabel getUnitLbl(){
		if (uniteLbl == null){
			uniteLbl = new JLabel("Unité",JLabel.CENTER);
			
		}
		
		return uniteLbl;
	}
	public JTextField getNomTxt(){
		if (nomTxt==null){
			nomTxt = new JTextField();
		}
		
		return nomTxt;
	}
	public JTextField getQteTxt(){
		if(qteTxt == null){
			qteTxt = new JTextField();
		}
		
		return qteTxt;
	}
	public JTextField getUniteTxt(){
		if(uniteTxt==null){
			uniteTxt= new JTextField();
		}
		return uniteTxt;
	}
	public JButton getOKBtn(){
		if ( okBtn== null){
			okBtn = new JButton("Valider");
		}
		return okBtn;
	}
	public JButton getCancelBtn(){
		if (cancelBtn == null){
			cancelBtn = new JButton("Annuler");
		}
		
		return cancelBtn;
	}
}
