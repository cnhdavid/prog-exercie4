package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.controllers.MainController;
import at.ac.fhcampuswien.fhmdb.controllers.MyFactory;
import at.ac.fhcampuswien.fhmdb.controllers.WatchlistController;
import at.ac.fhcampuswien.fhmdb.database.DataBaseException;
import at.ac.fhcampuswien.fhmdb.database.WatchlistRepository;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

import static at.ac.fhcampuswien.fhmdb.database.WatchlistRepository.getInstance;

public class FhmdbApplication extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/home.fxml"));
            AnchorPane root = loader.load(); // Ensure the type matches the root element of the FXML
            Scene scene = new Scene(root, 800, 600);
            loader.setControllerFactory(new MyFactory());
            primaryStage.setScene(scene);
            primaryStage.show();
            MainController controller = loader.getController();
            getInstance().addObserver(controller);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to load FXML file.");
            System.err.println(e.getMessage());

        } catch (DataBaseException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
