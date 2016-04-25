package exam.scanner;

import java.awt.EventQueue;

import javax.swing.UIManager;

import exam.scanner.controller.gui.app.MainAppController;
import exam.scanner.model.directories.MakeDefaultDirectories;

public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					MakeDefaultDirectories.programDirectoriesCreate();
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					new MainAppController();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
