package exam.scanner.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;

import exam.scanner.controller.gui.main.MainAppController;
import java.awt.Toolkit;


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
	private JScrollPane scrollPane;
	private JLabel imgLbl;


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
		frmMain.setIconImage(Toolkit.getDefaultToolkit().getImage(MainAppWindow.class.getResource("/imgs/fon-logo-png.png")));
		frmMain.setTitle("Entrance examination");
		frmMain.setBounds(100, 100, 503, 300);
		frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMain.setJMenuBar(getMenuBar());
		frmMain.getContentPane().setLayout(new BorderLayout(0, 0));
		frmMain.getContentPane().add(getScrollPane_1(), BorderLayout.CENTER);
		frmMain.setLocationRelativeTo(null);
		
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
			mntmDisplay.setIcon(new ImageIcon(MainAppWindow.class.getResource("/com/sun/javafx/scene/control/skin/modena/HTMLEditor-Indent-Black-rtl.png")));
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
			mntmCaptureNew.setIcon(new ImageIcon(MainAppWindow.class.getResource("/javax/swing/plaf/metal/icons/ocean/iconify-pressed.gif")));
		}
		return mntmCaptureNew;
	}
	public JMenuItem getMntmInfo() {
		if (mntmInfo == null) {
			mntmInfo = new JMenuItem("Info");
			mntmInfo.setIcon(new ImageIcon(MainAppWindow.class.getResource("/com/sun/javafx/scene/control/skin/modena/HTMLEditor-Italic-Black.png")));
		}
		return mntmInfo;
	}
	public JMenuItem getMntmAuthors() {
		if (mntmAuthors == null) {
			mntmAuthors = new JMenuItem("Authors");
			mntmAuthors.setIcon(new ImageIcon(MainAppWindow.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
		}
		return mntmAuthors;
	}
	public JMenuItem getMntmDelete() {
		if (mntmDelete == null) {
			mntmDelete = new JMenuItem("Delete");
			mntmDelete.setIcon(new ImageIcon(MainAppWindow.class.getResource("/com/sun/javafx/scene/web/skin/DecreaseIndent_16x16_JFX.png")));
		}
		return mntmDelete;
	}
	public JScrollPane getScrollPane_1() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getImgLbl());
		}
		return scrollPane;
	}
	public JLabel getImgLbl() {
		if (imgLbl == null) {
			imgLbl = new JLabel("");
			imgLbl.setIcon(new ImageIcon(MainAppWindow.class.getResource("/imgs/fon-logo.jpg")));
		}
		return imgLbl;
	}
}