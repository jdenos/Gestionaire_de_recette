package dsg;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class StartDsg extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton recBtn = null;
	private JButton catBtn = null;
	private JButton refBtn = null;
	private JButton quitBtn = null;

	/**
	 * Create the panel.
	 */
	public StartDsg() {
		this.setLayout(new GridLayout(4, 1, 5, 10));
		this.add(getRecBtn());
		this.add(getCatBtn());
		this.add(getRefBtn());
		this.add(getQuitBtn());
	}

	public JButton getRecBtn() {
		if (recBtn == null) {
			recBtn = new JButton("Gerer les recettes");
		}
		return recBtn;
	}

	public JButton getCatBtn() {
		if (catBtn == null) {
			catBtn = new JButton("Gerer les Categories");
		}
		return catBtn;
	}
	public JButton getRefBtn() {
		if (refBtn == null) {
			refBtn = new JButton("Gerer les References");
		}
		return refBtn;
	}
	public JButton getQuitBtn(){
		if (quitBtn==null){
			quitBtn = new JButton("Quitter");
		}
		return quitBtn;
	}

}
