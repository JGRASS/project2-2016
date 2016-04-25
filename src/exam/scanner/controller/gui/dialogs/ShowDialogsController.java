package exam.scanner.controller.gui.dialogs;

import javax.swing.JOptionPane;

import exam.scanner.controller.gui.table.TableController;

public class ShowDialogsController {
	public static void showInfoDialog() {
		JOptionPane.showMessageDialog(null,
				"This application is developed in order to review entrance exams in more appropriate way." + '\n'
						+ " To review new test go to Menu-Capture new." + '\n'
						+ " To dispal all reviewed tests go to Menu-Display. " + '\n'
						+ " To delete a reviewed test go to Menu-Delete.",
				"Application info", JOptionPane.PLAIN_MESSAGE);
	}

	public static void showAuthorsDialog() {
		JOptionPane.showMessageDialog(null,
				"The application is developed by Lazar Davidovic , Aleksa Dencic and Luka Novakovic," + '\n'
						+ " young students from Faculty of Organizational Sciences at University of Belgrade. ",
				"About authors", JOptionPane.PLAIN_MESSAGE);

	}

	public static void showErrorDeletingRowDialog() {
		JOptionPane.showMessageDialog(null, "Please select a row to delete!", "Error!!!", JOptionPane.ERROR_MESSAGE);
	}

	public static void showSaveChangesDialog() {

		int option = JOptionPane.showConfirmDialog(null, "Do you want to save made changes?", "Confirm",
				JOptionPane.YES_NO_OPTION);
		if (option == JOptionPane.YES_OPTION) {
			TableController.saveTableChanges();
		}
	}
}
