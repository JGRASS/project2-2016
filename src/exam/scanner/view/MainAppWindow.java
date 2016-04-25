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
import exam.scanner.model.test.Candidate;
import exam.scanner.view.models.table.TableModel;

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
		frmMain.getContentPane().add(getScrollPane(), BorderLayout.CENTER);

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
			mntmDisplay.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MainAppController.displayTable();
				}
			});
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
					MainAppController.captureNew();
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
					MainAppController.showInfo();
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
					MainAppController.showAuthors();
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
			mntmDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int index = table.getSelectedRow();
					if (index == -1) {
						MainAppController.errorDeletingRow();
					} else {
						int option = JOptionPane.showConfirmDialog(null,
								"Are You sure?", "Confirm",
								JOptionPane.YES_NO_OPTION);
						if (option == JOptionPane.YES_OPTION) {
							TableModel model = (TableModel) table.getModel();
							Candidate ci = model.getKnjigaByIndex(index);
							MainAppController.deleteCandidate(ci);
						}
					}
				}
			});
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

	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTable());
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

	public JTable getTable() {
		if (table == null) {
			table = new JTable();

		}
		return table;
	}
}