package exam.scanner.view;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import exam.scanner.controller.gui.app.MainAppController;
import exam.scanner.view.models.TableModel;

public class MainAppWindow {

	private JFrame frmMain;
	private JMenuBar menuBar;
	private JMenu mnMenu;
	private JMenu mnAbout;
	private JMenuItem mntmDisplay;
	private JMenuItem mntmCaptureNew;
	private JMenuItem mntmInfo;
	private JMenuItem mntmAuthors;
	private JMenuItem mntmDelete;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JButton btnEditField;
	private JButton btnSaveChanges;
	private JTable table;

	/**
	 * Create the application.
	 */
	public MainAppWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMain = new JFrame();
		frmMain.setIconImage(
				Toolkit.getDefaultToolkit().getImage(MainAppWindow.class.getResource("/imgs/fon/fon-logo-png.png")));
		frmMain.setTitle("Entrance examination");
		frmMain.setBounds(100, 100, 503, 300);
		frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMain.setJMenuBar(getMenuBar());
		frmMain.setLocationRelativeTo(null);
		frmMain.getContentPane().setLayout(new BorderLayout(0, 0));
		frmMain.getContentPane().add(getPanel(), BorderLayout.SOUTH);
		frmMain.getContentPane().add(getScrollPane_1(), BorderLayout.CENTER);

		frmMain.setVisible(true);
	}

	public JMenuBar getMenuBar() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnMenu());
			menuBar.add(getMnAbout());
		}
		return menuBar;
	}

	public JMenu getMnMenu() {
		if (mnMenu == null) {
			mnMenu = new JMenu("Menu");
			mnMenu.add(getMntmDisplay());
			mnMenu.add(getMntmCaptureNew());
			mnMenu.add(getMntmDelete());
		}
		return mnMenu;
	}

	public JMenu getMnAbout() {
		if (mnAbout == null) {
			mnAbout = new JMenu("About");
			mnAbout.add(getMntmInfo());
			mnAbout.add(getMntmAuthors());
		}
		return mnAbout;
	}

	public JMenuItem getMntmDisplay() {
		if (mntmDisplay == null) {
			mntmDisplay = new JMenuItem("Display");
			mntmDisplay.setIcon(new ImageIcon(MainAppWindow.class
					.getResource("/com/sun/javafx/scene/control/skin/modena/HTMLEditor-Indent-Black-rtl.png")));
		}
		return mntmDisplay;
	}

	public JMenuItem getMntmCaptureNew() {
		if (mntmCaptureNew == null) {
			mntmCaptureNew = new JMenuItem("Capture new");
			mntmCaptureNew.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					MainAppController main = MainAppController.getInstance();
					main.captureNew();
				}
			});
			mntmCaptureNew.setIcon(new ImageIcon(
					MainAppWindow.class.getResource("/javax/swing/plaf/metal/icons/ocean/iconify-pressed.gif")));
		}
		return mntmCaptureNew;
	}

	public JMenuItem getMntmInfo() {
		if (mntmInfo == null) {
			mntmInfo = new JMenuItem("Info");
			mntmInfo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null,
							"This application is developed in order to review entrance exams in more appropriate way."
									+ '\n' + " To review new test go to Menu-Capture new." + '\n'
									+ " To dispal all reviewed tests go to Menu-Display. " + '\n'
									+ " To delete a reviewed test go to Menu-Delete.",
							"Application info", JOptionPane.PLAIN_MESSAGE);
				}
			});
			mntmInfo.setIcon(new ImageIcon(MainAppWindow.class
					.getResource("/com/sun/javafx/scene/control/skin/modena/HTMLEditor-Italic-Black.png")));
		}
		return mntmInfo;
	}

	public JMenuItem getMntmAuthors() {
		if (mntmAuthors == null) {
			mntmAuthors = new JMenuItem("Authors");
			mntmAuthors.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JOptionPane.showMessageDialog(null,
							"The application is developed by Lazar Davidovic , Aleksa Dencic and Luka Novakovic," + '\n'
									+ " young students from Faculty of Organizational Sciences at University of Belgrade. ",
							"About authors", JOptionPane.PLAIN_MESSAGE);
				}
			});
			mntmAuthors.setIcon(new ImageIcon(
					MainAppWindow.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
		}
		return mntmAuthors;
	}

	public JMenuItem getMntmDelete() {
		if (mntmDelete == null) {
			mntmDelete = new JMenuItem("Delete");
			mntmDelete.setIcon(new ImageIcon(
					MainAppWindow.class.getResource("/com/sun/javafx/scene/web/skin/DecreaseIndent_16x16_JFX.png")));
		}
		return mntmDelete;
	}

	public JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.add(getBtnEditField());
			panel.add(getBtnSaveChanges());
		}
		return panel;
	}

	public JScrollPane getScrollPane_1() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTable_1());
		}
		return scrollPane;
	}

	public JButton getBtnEditField() {
		if (btnEditField == null) {
			btnEditField = new JButton("Edit field");
		}
		return btnEditField;
	}

	public JButton getBtnSaveChanges() {
		if (btnSaveChanges == null) {
			btnSaveChanges = new JButton("Save changes");
		}
		return btnSaveChanges;
	}

	public JTable getTable_1() {
		if (table == null) {
			table = new JTable();
			TableModel model = new TableModel(null);
			table.setModel(model);
		}
		return table;
	}
}