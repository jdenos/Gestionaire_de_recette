package dsg;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JCalendar;

public class PrepEditorDsg extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JCalendar cal = null;
	private JComboBox<Integer> noteTxt = null;
	private JTextArea commentTxt = null;
	private JButton savBtn = null;
	private JButton cancelBtn = null;
	private JPanel leftPnl = null;
	private JPanel btnPnl = null;
	private JLabel noteLbl = null;
	private JLabel commentLbl = null;

	/**
	 * Create the panel.
	 */
	public PrepEditorDsg() {
		init();

	}

	public void init() {
		this.setLayout(new BorderLayout());
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.add(getCal(), BorderLayout.WEST);
		this.add(getLeftPnl(), BorderLayout.CENTER);
		this.add(getBtnPnl(), BorderLayout.SOUTH);
	}

	public JCalendar getCal() {
		if (cal == null) {
			cal = new JCalendar();
		}
		return cal;
	}

	public JComboBox<Integer> getNoteTxt() {
		if (noteTxt == null) {
			noteTxt = new JComboBox<Integer>();
		}
		return noteTxt;
	}

	public JTextArea getCommentTxt() {
		if (commentTxt == null) {
			commentTxt = new JTextArea();
		}
		return commentTxt;
	}

	public JButton getOKBtn() {
		if (savBtn == null) {
			savBtn = new JButton("Savegarder");
		}
		return savBtn;
	}

	public JButton getCancelBtn() {
		if (cancelBtn == null) {
			cancelBtn = new JButton("Fermer");
		}
		return cancelBtn;
	}

	public JPanel getLeftPnl() {
		if (leftPnl == null) {
			leftPnl = new JPanel();
			leftPnl.setBorder(new EmptyBorder(5, 5, 5, 5));
			leftPnl.setLayout(new BoxLayout(leftPnl, BoxLayout.Y_AXIS));
			leftPnl.add(getNoteLbl());
			leftPnl.add(getNoteTxt());
			leftPnl.add(getCommentLbl());
			leftPnl.add(new JScrollPane(getCommentTxt()));
		}
		return leftPnl;
	}

	public JLabel getNoteLbl() {
		if (noteLbl == null) {
			noteLbl = new JLabel("note", JLabel.CENTER);
		}
		return noteLbl;
	}

	public JLabel getCommentLbl() {
		if (commentLbl == null) {
			commentLbl = new JLabel("Commentaire", JLabel.CENTER);
		}
		return commentLbl;
	}

	public JPanel getBtnPnl() {
		if (btnPnl == null) {
			btnPnl = new JPanel();
			btnPnl.setBorder(new EmptyBorder(5, 5, 5, 5));
			btnPnl.setLayout(new BoxLayout(btnPnl, BoxLayout.X_AXIS));
			btnPnl.add(getCancelBtn());
			btnPnl.add(getOKBtn());
		}
		return btnPnl;
	}
}
