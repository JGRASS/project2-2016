package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;


public class MainAppWindow {

	private JFrame frmTitle;
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
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainAppWindow window = new MainAppWindow();
					window.frmTitle.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		frmTitle = new JFrame();
		frmTitle.setTitle("Title");
		frmTitle.setBounds(100, 100, 503, 300);
		frmTitle.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTitle.setJMenuBar(getMenuBar());
		frmTitle.getContentPane().setLayout(new BorderLayout(0, 0));
		frmTitle.getContentPane().add(getScrollPane_1(), BorderLayout.CENTER);
	}

	private JMenuBar getMenuBar() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnMenu());
			menuBar.add(getMnAbout());
		}
		return menuBar;
	}
	private JMenu getMnMenu() {
		if (mnMenu == null) {
			mnMenu = new JMenu("Menu");
			mnMenu.add(getMntmDisplay());
			mnMenu.add(getMntmCaptureNew());
			mnMenu.add(getMntmDelete());
		}
		return mnMenu;
	}
	private JMenu getMnAbout() {
		if (mnAbout == null) {
			mnAbout = new JMenu("About");
			mnAbout.add(getMntmInfo());
			mnAbout.add(getMntmAuthors());
		}
		return mnAbout;
	}
	private JMenuItem getMntmDisplay() {
		if (mntmDisplay == null) {
			mntmDisplay = new JMenuItem("Display");
			mntmDisplay.setIcon(new ImageIcon(MainAppWindow.class.getResource("/com/sun/javafx/scene/control/skin/modena/HTMLEditor-Indent-Black-rtl.png")));
		}
		return mntmDisplay;
	}
	private JMenuItem getMntmCaptureNew() {
		if (mntmCaptureNew == null) {
			mntmCaptureNew = new JMenuItem("Capture new");
			mntmCaptureNew.setIcon(new ImageIcon(MainAppWindow.class.getResource("/javax/swing/plaf/metal/icons/ocean/iconify-pressed.gif")));
		}
		return mntmCaptureNew;
	}
	private JMenuItem getMntmInfo() {
		if (mntmInfo == null) {
			mntmInfo = new JMenuItem("Info");
			mntmInfo.setIcon(new ImageIcon(MainAppWindow.class.getResource("/com/sun/javafx/scene/control/skin/modena/HTMLEditor-Italic-Black.png")));
		}
		return mntmInfo;
	}
	private JMenuItem getMntmAuthors() {
		if (mntmAuthors == null) {
			mntmAuthors = new JMenuItem("Authors");
			mntmAuthors.setIcon(new ImageIcon(MainAppWindow.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
		}
		return mntmAuthors;
	}
	private JMenuItem getMntmDelete() {
		if (mntmDelete == null) {
			mntmDelete = new JMenuItem("Delete");
			mntmDelete.setIcon(new ImageIcon(MainAppWindow.class.getResource("/com/sun/javafx/scene/web/skin/DecreaseIndent_16x16_JFX.png")));
		}
		return mntmDelete;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getImgLbl());
		}
		return scrollPane;
	}
	private JLabel getImgLbl() {
		if (imgLbl == null) {
			imgLbl = new JLabel("");
			imgLbl.setIcon(new ImageIcon(MainAppWindow.class.getResource("/imgs/fon-logo.jpg")));
		}
		return imgLbl;
	}
}