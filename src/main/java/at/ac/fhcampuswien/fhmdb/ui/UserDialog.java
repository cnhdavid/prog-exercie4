package at.ac.fhcampuswien.fhmdb.ui;

import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;

public class UserDialog {
    Dialog<String> dialog; // Dialog object to display messages

    // Constructor to initialize the dialog with a title and message
    public UserDialog(String title, String msg){
        dialog = new Dialog<>();
        dialog.setTitle(title); // Set the dialog title
        dialog.setContentText(msg); // Set the dialog message

        // Create an "Ok" button and add it to the dialog
        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().add(type);
    }

    // Method to display the dialog and wait for user interaction
    public void show() {
        dialog.showAndWait();
    }
}
